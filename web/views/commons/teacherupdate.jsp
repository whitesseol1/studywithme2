<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.members.model.vo.Lecture" %>
<%@ page import="com.members.model.vo.Teacher" %>
<%@ include file="/views/commons/header.jsp" %>

<% 
String userId=(String)request.getAttribute("userId"); 
Teacher t=(Teacher)request.getAttribute("Teacher");
Lecture expectlecture=(Lecture)request.getAttribute("expectlecture");
Lecture lecture=(Lecture)request.getAttribute("lecture");
Lecture lastlecture=(Lecture)request.getAttribute("lastlecture");
%>

<section id=teacher-enroll-container style="background-color:white; font-family: 'Nanum Gothic Coding', monospace; ">
<h2 style="margin-top:10%;">
        <%if(userId!=null){%>
        <%=userId%>님의 
        <%}%>
        정보를 입력해주세요</h2><br>
        
        <h3>선생님 프로필 등록</h3><br>        
        <h5>선생님 프로필을 허위 입력시 강제탈퇴 조치 및 불이익이 있을 수 있습니다.</h5>

   <form id="teacherEnrollFrm" action="<%=request.getContextPath() %>/teacherupdate.do?userId=<%=userId %>" method="post" >
        <table id="teacherEnrolltable" style="margin-bottom:10%;">						
			<tr>
				<th>
				   학력
				    <select name="academicCareer">
				       <option value="고등학교 졸업" <%=t.getAcademicCareer().contains("고등학교 졸업")?"checked":"" %>>고등학교 졸업</option>
				       <option value="대학교 졸업"<%=t.getAcademicCareer().contains("대학교 졸업")?"checked":"" %>>대학교 졸업</option>
				       <option value="석사" <%=t.getAcademicCareer().contains("석사")?"checked":"" %>>석사</option>
				       <option value="박사"<%=t.getAcademicCareer().contains("박사")?"checked":"" %>>박사</option>
				       <option value="기타"<%=t.getAcademicCareer().contains("기타")?"checked":"" %>>기타</option>
				    </select>&nbsp;&nbsp;&nbsp;&nbsp;
				    학교이름
				    <input type="text" name="collegeName" placeholder="학교이름입력" value=<%=t.getCollegeName() %>>
				    &nbsp;&nbsp;&nbsp;&nbsp;
				    전공
				    <input type="text" name="major" placeholder="전공입력" value=<%=t.getMajor() %>>
				</th>
			</tr>		
			<tr class="certificateTr">
				<th>
				   보유자격증
				   <input type="text" name="certificate" placeholder="보유자격증입력" value=<%=t.getCertificate() %>>
				   <input type="button" class="btn-add-certificate" value="+더추가하기" onclick="addCertificate()">
				</th>
			</tr>
			<tr>
			  <th>
			   경력이나 이력을 작성해주세요
			   </th>
			</tr>
			<tr>
			  <th>			     
			      <textarea name="career" cols="55" rows="3"><%=t.getCareer() %></textarea>			  
			  </th>						
			</tr>
			<tr>
			  <th>
			   선생님에 대해 소개해주세요.
			   </th>
			</tr>
			<tr>
			  <th>			     
			      <textarea name="selfIntroduction" cols="55" rows="3"><%=t.getSelfIntroduction() %></textarea>
			  
			  </th>						
			</tr>
			
			
		</table>
		
		<input id="submit" type="submit" value="수정하기" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		
        </form>
        
        
        <table id="extrainfo">
        <tbody >
        <tr>
            <th colspan="2"> 
            <h2><%if(userId!=null){%>
               <%=userId%>님의 
                 <%}%>지난강의 </h2></th>
            <th></th>
        </tr>
        <tr>
            <th id="enrollLectureInfo" colspan="2">
                <%if(t.getLastLecture()!=null){ %>
                                    
                    <img src="<%=request.getContextPath()%>/upload/LectureInfo/<%=lastlecture.getLecPhotoRenamed() %>" alt=lectureinfo>
                    
                <%}else{ %>
                지난강의가 없습니다.
                <%} %>	
            </th>
            <th>
                                    
            </th>
        </tr>
        <tr>
            <th colspan="2"> <h2>예정중인 강의</h2> </th>
            <th></th>
        </tr>
        <tr>
            <th id="enrollLecctureInfo1" >
                <%if(expectlecture!=null){ %>
                  
                    <img src="<%=request.getContextPath()%>/upload/LectureInfo/<%=expectlecture.getLecPhotoRenamed() %>" alt=studyinfo>
                    
                <%}else{ %>
                예정중인 강의가 없습니다.
                <%} %>
            </th>
            <th>
               <%if(expectlecture!=null){ %>
                    <input id="" type="button" value="나의 강의 결제 정보" onclick="lecturePayInfo()"/>
                    <%} %>
            </th>
        </tr>
        <tr>
            <th colspan="2"><h2>진행중인 강의</h2></th>
            <th></th>
        </tr>
        <tr>
            <th id="currentLectureInfo" colspan="2" >
			      <%if(lecture!=null){ %>			      				      
				      <img src="<%=request.getContextPath()%>/upload/LectureInfo/<%=lecture.getLecPhotoRenamed()%>" alt=lastlectureinfo>
				     
			      <%}else{ %>
			     &nbsp; 진행중인 강의가 없습니다.
			      <%} %>
			      </th>	            
        </tr>
       
        <tr>
            <th colspan="2"> <h2>강의개설하기</h2>
			       <input id="submit" type="button" value="강의 개설하기" onclick="fn_lecturerecruit();"/></th>
           
        </tr>
        <tr style="line-height:200%";text-align=left">
            <th>선생님 평점 :&nbsp;
			     <%if(t.getTeacherEvaluation()!=0) {%>
			    <%=t.getTeacherEvaluation() %>점
			    <%}else{ %>
			    아직 평점이 없습니다.
			    <%} %></th>
            <th style="width:50%"; rowspan="3";">!   지난 강의에서 학생들로부터 받은 별점이 선생님 평점에 반영됩니다. <br>

													다음 강의에서 선생님 소개에 반영되므로 좋은 후기를 받을 수 있도록 노력해주세요.<br>
													
													등록한 강의을 부득이하게 취소할 경우 시작일 3일 전은 벌점 1점, 그 이후에는 벌점 3점입니다. <br>
													
													3회 강의날짜 변경시 벌점 1점이 부여됩니다.<br>
													
													벌점 3점이면 1개월간 강의를 개설할 수 없습니다. 
													</th>
        </tr>
      
        <tr>
            <th>  페널티 : &nbsp;
			     <%if(t.getPenalty()!=0) {%>
			    <%=t.getPenalty() %>점
			    <%}else{ %>
			    페널티가 없습니다.
			    <%} %></th>
            <th></th>
        </tr>

    </tbody>
    </table>
        
        
        
        
        
        <div id="buttoncontainer">
		<input id="submit" type="button" value="이전페이지" onclick="fn_update_previous()"/>
		&nbsp;&nbsp;&nbsp;
		<input id="submit" type="button" value="탈퇴" onclick="fn_delete_member();"/>
		&nbsp;&nbsp;&nbsp;
		<input id="submit" type="button" value="메인으로" onclick="fn_main();"/>
		</div>


</section>

<style>
   #buttoncontainer{margin-top:10%;}
   #buttoncontainer>input{float:left; position: relative; left:34%;margin-left:30px; width:60%;}
   
    #extrainfo{ margin-left:auto; margin-right:auto;text-align:center;position:relative;}
    
     th#enrollLectureInfo>img{width:120px; height:120px;margin-right:0%; margin-left:80%;}
     th#enrollLecctureInfo1>img{width:120px; height:120px;margin-right:0%; margin-left:80%;}
     th#currentLectureInfo>img{width:120px; height:120px;margin-right:0%; margin-left:80%;}
     
      table#extrainfo{text-align:left;width:70%}
     table#extrainfo th{padding:50px 30px;}
     table#extrainfo td{padding:50px 30px;}
     
  section#teacher-enroll-container{text-align:center;color:#cd5c5c;}
  input{border-color: #cd5c5c;border-style: solid; border-radius: 5px;  }
  textarea{border-color: #cd5c5c;border-style: solid; border-radius: 5px; }
  table#teacherEnrolltable{margin-left:auto; margin-right:auto; margin-top:5%;}

  form#teacherEnrollFrm{margin-bottom:5%;}
    #teacherEnrolltable th, td{padding:15px;}
    
    input#submit{width:100px; height:50px; background-color:#ffa089;}
    input#reset{width:100px; height:50px; background-color:#ffa089;}
  
     input#submit:hover{background-color:#ffcba4;}
    input#reset:hover{background-color:#ffcba4;}
    


</style>




<script>
          addCertificate=()=>{
				const tr=$("<tr>")
				const form=$(".certificateTr>th").clone(); //태그복사함
				
				form.innerHTML("");
				
				//const td=$("<td>").attr("colspan","2");
				tr.append(form);
				//tr.find("td").css("display","none");
				
				tr.insertAfter($(e.target).parents("tr")).children("th");
				$(e.target).off("click");
			};

			   const fn_delete_member=()=>{
				   if(confirm("정말로 탈퇴하시겠습니까?")){
					   //탈퇴로직 진행
					   location.replace("<%=request.getContextPath()%>/deleteMember.do?userId="+'<%=loginMember.getUserId()%>'+"&type=student");
					   //location.replace("/06_HelloMVC/deleteMember?userId="+'user04')
					   
				   }
			   }
			   
			   const fn_update_previous=()=>{
				   
				   location.replace("<%=request.getContextPath()%>/memberView.do?userId="+'<%=loginMember.getUserId()%>');
				   
			   } 
			   
			   const fn_main=()=>{
				   
				   location.replace("<%=request.getContextPath()%>/");
				   
				   
			   }		
			
			
			
</script>






<%@ include file="/views/commons/footer.jsp" %></html>