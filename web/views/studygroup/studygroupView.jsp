<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.members.model.vo.Studygroup" %>
<%@ page import="com.members.model.vo.Student" %>
<%@ page import="com.members.model.vo.StudyComment" %>
<%@ page import="com.members.model.vo.StudyMembers" %>
<%@ page import="java.util.List" %>

<%
Studygroup sg=(Studygroup)request.getAttribute("Studygroup");
Member m=(Member)request.getAttribute("Member");/* 모임장 */
Student s=(Student)request.getAttribute("Student");/*모임장  */

List<StudyComment> comments=(List<StudyComment>)request.getAttribute("comments");
List<StudyMembers> studyMembers=(List<StudyMembers>)request.getAttribute("studyMembers");

Student loginMemberStudent=(Student)session.getAttribute("loginMemberStudent"); 
Teacher loginMemberTeacher=(Teacher)session.getAttribute("loginMemberTeacher"); 


%>



<%@ include file="/views/commons/header.jsp" %>

<section id=study-enroll-container style="background-color:white">
      <form id="studyEnrollFrm" style="margin-bottom:10%;" onsubmit="return fn_update_validate();" enctype="multipart/form-data" method="post">
  
  
                <div id="title" style= "text-align:center; margin-top:6%; margin-bottom:4%;display:block; width:100%;">
			        <h2 style="width:inherit;">스터디 모집</h2>
			       			        
			    </div>
			    <table id="studyEnrollTable">
			   
			    <tr>
			        <th><h3>스터디분야</h3></th>
			        <th><h3>
			           <% String[] subjects=sg.getSubject().split(","); %>
			           <% for(String sg1: subjects){ %>
			              <%=sg1 %> &nbsp;&nbsp;&nbsp;
			          <% } %>
			         </h3>   
			        </th>			        
			        
			    </tr>
			    <tr>
			        <th><h3>스터디 그룹 이름</h3></th>			        
			        <th colspan="2"><h3>
			          <%=sg.getStudyGroupName() %>
			          </h3>
			        </th>			        
			    </tr>
			    <tr>
			        <th><h3>스터디 소개</h3></th>			        
			        <th colspan="2"><h3>
			           <%=sg.getGroupIntroduction() %>
			           </h3>
			        </th>
			       
			    </tr>
			    <tr>
			        		        
			        <th colspan="3" id="profilephoto2"> <!-- 스터디사진 -->
			         <%if(sg.getStudyPhotoRenamedFile()!=null){ %>
			          <img id="studyimg" src="<%=request.getContextPath()%>/upload/StudyInfo/<%=sg.getStudyPhotoRenamedFile() %>" alt=renamedFileName> <!--소개사진 -->
			          <%} %>
			        </th>		        
			    </tr>
			    <tr>
			      <th>
			      <h3>
			        모임장 <%=sg.getMemberId() %> 님 <!-- 사진 -->
			       </h3>
			      </th>
			    </tr>
			    <tr>
			      <th colspan="3" id="profilephoto2">
			          <%if(m.getRenamedFileName()!=null){ %>
			          <img id="teamleaderphoto" src="<%=request.getContextPath()%>/upload/profile/<%=m.getRenamedFileName() %>" alt=teamleaderphoto>
			          <%} %>
			       </th>
			    </tr>
			    <tr>
			      <th>
			      <h3>
			        모임장 평점
			        </h3>
			      </th>
			      <th colspan="2">
			        <%if(s.getTeamLeaderScore()!=0&&String.valueOf(s.getTeamLeaderScore())!=null ){ %>
			          <%=s.getTeamLeaderScore() %> 점입니다. 
			        <%}else{ %>
			         평점이 아직 없습니다.
			        <%} %>
			         
			      </th>
			    </tr>
			    
			    <tr>
			        <th><h3>스터디 레벨</h3></th>
			        <th colspan="2"><h3>
			           <%= sg.getLevel() %>
			           </h3>
			        </th>
			        
			        
			    </tr>
			    <tr>
			        <th><h3>스터디 횟수</h3></th> &nbsp;&nbsp;
			        <th colspan="2"><h3>&nbsp;<%=sg.getStudyHours() %>시간씩 &nbsp;
			          주&nbsp; <%=sg.getFrequency() %>회</h3> </th>			       
			    </tr>
			    <tr>
			        <th >
			        <h3>스터디 요일</h3></th>&nbsp;&nbsp;
			        <th colspan="2">
			        <h3>
			        <%String[] days=sg.getDay().split(","); %>
			        <%for(String day2:days){ %>
			        <%=day2 %>요일 
			         &nbsp;
			        <%} %>
			        </h3>
			        </th>
			        
			      
			    </tr>
			    <tr>
			       <th>
			       <%if(sg.getStudyStatus().equals("모임예정")) {%>
			          <h3>시작날짜 &nbsp;<% String str=sg.getStartDate().substring(0, 10); %> <%=str %></h3>
			           </th>
			        <th colspan="2"><h3>시작시간 : &nbsp;<%=sg.getStudyStartTime() %>&nbsp;&nbsp;&nbsp;&nbsp;<%=sg.getFixedTimeStatus() %></h3></th>
			        
			        <%} %>
			        
			    </tr>
			    <tr>
			        <th><h3>스터디 멤버 나이</h3></th>
			        <%String[] age=sg.getAge().split(","); %>
			        <th colspan="2"><h3><%=age[0] %>세 이상,	&nbsp;&nbsp;&nbsp;		        			  
			          <%=age[1] %>세 이하</h3></th>
			        
			    </tr>
			    <tr>
			        <th><h3>모집 인원</h3></th>
			        <%String[] num=sg.getTotalNumber().split(","); %>
			        <th colspan="2"><h3>최소 &nbsp;<%=num[0] %>명,&nbsp;&nbsp;&nbsp;&nbsp;
			        최대 &nbsp;<%=num[1] %>명</h3></th>
			       
			    </tr>
			    <tr>
			        <th><h3>모임방식</h3></th>
			        <th colspan="2">
			          <h3><%=sg.getGroupMeetingType() %></h3>
			           
			        </th>
			        
			      
			    </tr>
			    <tr>
			        <th><h3>모임가입현황</h3></th>
			        <th colspan="2">
			          <%if(studyMembers!=null){ %>
			          <h3><%=studyMembers.size() %>명이 가입하였습니다.</h3>
			           <%}else if(studyMembers==null||studyMembers.size()==0){ %>
			            아직 가입인원이 없습니다.
			           <%} %>
			        </th>
			      </tr>  
			      
			    <%if(sg.getStudyStatus().equals("모임시작")){ %>
			    <tr>
			      <th>현재 모임이 진행중입니다.  </th>
			      <%}else if(sg.getStudyStatus().equals("모임종료")){%>
			      <th>현재 모임이 종료되었습니다.  </th>
			     </tr>
			      <%} %>			      
			       
			  
			   
			</table>
  
    
       <table id="alarm">
         <tr style="line-height:200%">
			        <th colspan="3" rowspan="3" >
			            스터디 모임 가입시 모임의 레벨, 스터디 모임원 나이, 스터디 시작일 ,<br>
			            스터디 내용을 꼼꼼히 확인해주세요.<br> 
                        스터디 모임 가입후 스터디 모임 시작 이틀 전까지 취소가 가능하며<br>
                         그 이후 취소는 벌점이 부여됩니다.<br>
                        벌점 3점시 1개월 동안 스터디 모임 활동이 제한됩니다. 신중히 가입해주세요.<br>
                        스터디 모임 당일날 정확한 온라인 주소, 장소, 시간이 공지됩니다. 
			        </th>
			        
			        <th rowspan="3">
			         <%if(loginMember!=null ){ %>
				         <%if(sg.getStudyStatus().equals("모임예정")&&loginMember.getUserId().equals(sg.getMemberId()) ){ %>
				         <input id="study"  class="updateStudy" type="button" value="모임 수정" onclick="fn_updatestudy();"/><br><br><br>
				         <input id="study"  type="button" value="모임 취소" onclick="fn_cancelstudy();"/><br><br><br>
				         <input id="study"  class="studystart" type="button" value="모임 시작" onclick="fn_startstudy();"/>
				         <%} if(sg.getStudyStatus().equals("모임시작")&&loginMember.getUserId().equals(sg.getMemberId())){ %>
				              <input id="study" class="updateStudy" type="button" value="모임 수정" onclick="fn_updatestudy();"/><br><br><br>
				             <input id="study" type="button" value="모임 취소" onclick="fn_cancelstudy();"/><br><br><br>
				             <input id="study" type="button" value="모임 종료" onclick="fn_endstudy();"/>
				         <%} %>
			         
			          
			              <%if(loginMemberStudent!=null){ %>
			                         <%int size=studyMembers.size(); %>
				              <% if(loginMemberStudent.getEnrollStudy()==null&&!loginMember.getUserId().equals(sg.getMemberId())&&size<=Integer.parseInt(num[1]) ){%> 
				             <input id="study" class="enrollstudy" type="button" value="모임 가입" onclick="fn_joinstudy()"/>	             
				             <%}else if(loginMemberStudent.getEnrollStudy()!=null&&loginMemberStudent.getEnrollStudy().contains(String.valueOf(sg.getStudygroupNo()) )){ %>
				             <input id="study" class="cancelenroll" type="button" value="가입 취소" onclick="fn_canceljoinstudy();"/>	
				             <%} %>  
			             <%} %>
			         <%}else if(loginMember==null){ %>
			         스터디윗미 회원가입 후<br> 모임에 가입할 수 있습니다.
			         <%} %> 
			         
			         </th>
			        
			   
  
  </table> 
  
  
  
  
  
  
  </form>
  
  
      <div id="comment-container">
	    	<div class="comment-editor">
	    		<form action="<%=request.getContextPath() %>/studygroup/insertStudyComment" method="post">
	    			<textarea id="content" name="content" cols="55" rows="3" ></textarea>
		    			<input type="hidden" name="studyRef" value="<%=sg.getStudygroupNo() %>">
		    			<input type="hidden" name="commentWriter" value="<%=loginMember!=null?loginMember.getUserId():""%>">
		    			<input type="hidden" name="studyCommentLevel" value="1">
		    			<input type="hidden" name="studyCommentRef" value="0">
	    			<button type="submit" id="btn-insert">등록</button>
	    		</form>
	    	</div>
			<table id="tbl-comment">
				<%if(comments!=null){ 
					for(StudyComment sc : comments){
						
					   if(sc.getStudycommentLevel()==1){%>
					<tr class="level1">
						<td>
							<sub class="comment-writer"><%=sc.getCommentWriter() %></sub>
							<sub class="comment-date"><%=sc.getCommentDate() %></sub>
							<br>
							<%=sc.getCommentContent() %>
						</td>
						<td>
						    <%if(loginMember!=null){%>
							<button class="btn-reply" value="<%=sc.getCommentNo()%>">답글</button>
							<%} %>
							<%if(loginMember!=null&&(loginMember.getUserId().equals("admin")
									||loginMember.getUserId().equals(sc.getCommentWriter()))){ %>
							<button class="btn-delete" onClick="location.href='<%=request.getContextPath()%>/studygroup/deleteStudyComment?studyCommentNo=<%=sc.getCommentNo()%>&studygroupNo=<%=sc.getStudygroupNo()%>'">삭제</button>
							<%} %>
						</td>
					</tr>	
					
				      <%}else{%>
				        <tr class="level2">
						<td>
							<sub class="comment-writer"><%=sc.getCommentWriter() %></sub>
							<sub class="comment-date"><%=sc.getCommentDate() %></sub>
							<br>
							<%=sc.getCommentContent() %>
						</td>
						<td>
						<%if(loginMember!=null&&(loginMember.getUserId().equals("admin")
									||loginMember.getUserId().equals(sc.getCommentWriter()))){ %>
							<button class="btn-delete" onClick="location.href='<%=request.getContextPath()%>/studygroup/deleteStudyComment?studyCommentNo=<%=sc.getCommentNo()%>&studygroupNo=<%=sc.getStudygroupNo()%>'">삭제</button>
							<%} %>
						</td>
					</tr>
				   <% }
					}
				}%>
			</table>
	    </div> 
  
  
  

</section>
<script>
$(function(){	
	$(".btn-reply").click(e=>{
		if(<%=loginMember==null%>){
			alert("로그인 후 이용하실 수 있습니다.");
			$(".btn-reply").attr("type","reset");
			
		}
			
	});
	$("#btn-insert").click(e=>{
		if(<%=loginMember==null%>){
			alert("로그인 후 이용하실 수 있습니다.");
			$(e.target).off("click");
			$("#btn-insert").attr("type","reset");
		}
			
	});
	
 <%-- 	function fn_joinstudy(){
				
   location.replace("<%=request.getContextPath()%>/enrollstudyMember?studentId=<%=loginMemberStudent.getUserId() %>&studyNo=<%=sg.getStudygroupNo() %>");		
	
	}  --%>
	
 	$(".enrollstudy").on("click", function(){
 		
 		<%if(studyMembers.size()==Integer.parseInt(num[1])){ %>
 		  alarm("정원이 차서 현재 대기만 가능! 댓글로 대기 달아주세요.");
 		<%}  %>
			
		if(confirm("스터디에 가입하시겠습니까?")){	
			
		<%if(loginMemberStudent!=null){%>	
		   location.replace("<%=request.getContextPath()%>/enrollstudyMember?studentId="+'<%=loginMemberStudent.getUserId() %>'+"&studyNo="+'<%=sg.getStudygroupNo() %>');
		<%}%>
		}
	}); 
	
  
    $(".cancelenroll").on("click", function(){
    	
    	
    	if(confirm("가입을 취소하시겠습니까?")){
			
    		<%if(loginMemberStudent!=null){%>	
    		   location.replace("<%=request.getContextPath()%>/cancelstudyMember?studentId="+'<%=loginMemberStudent.getUserId() %>'+"&studyNo="+'<%=sg.getStudygroupNo() %>');
    		<%}%>
    		}

    	
    });
    
    $(".studystart").on("click",function(){
    	
    	location.replace("<%=request.getContextPath()%>/studystart?studyNo="+'<%=sg.getStudygroupNo() %>');
    });
    
    
    $(".updateStudy").on("click",function(){
    	
    	
    	location.replace("<%=request.getContextPath()%>/updateStudy?studyNo="+'<%=sg.getStudygroupNo() %>');
    	
    });
    
    
 	
 
	
	$(".btn-reply").click(e=>{
		const tr=$("<tr>")
		const form=$(".comment-editor>form").clone(); //태그복사함
		form.find("textarea").attr("rows","1");
		form.find("[name=studyCommentLevel]").val("2");
		form.find("[name=studyCommentRef]").val($(e.target).val());
		form.find("button").removeAttr("id").addClass("btn-insert2");
		
		const td=$("<td>").attr("colspan","2");
		tr.append(td.append(form));
		tr.find("td").css("display","none");
		
		tr.insertAfter($(e.target).parents("tr")).children("td").slideDown(800); //slideDown
		$(e.target).off("click");
	});
	
	

	
	
	
	
	


});
</script>


<style>
 /*댓글테이블*/

 div.comment-editor{width:100%;}
 
    table#tbl-comment{width:650px; margin:0 auto; border-collapse:collapse; clear:both; } 
    table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-reply{display:none;}
    table#tbl-comment button.btn-delete{display:none;}
    table#tbl-comment tr:hover {background:lightgray;}
    table#tbl-comment tr:hover button.btn-reply{display:inline;}
    table#tbl-comment tr:hover button.btn-delete{display:inline;}
    table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
    table#tbl-comment tr.level2 td:first-of-type{padding-left:100px;}
    table#tbl-comment tr.level2 sub.comment-writer {color:#8e8eff; font-size:14px}
    table#tbl-comment tr.level2 sub.comment-date {color:#ff9c8a; font-size:10px}
    /*답글관련*/
    table#tbl-comment textarea{margin: 4px 0 0 0;}
    table#tbl-comment button.btn-insert2{width:60px; height:23px; color:white; background:#3300ff; position:relative; top:-5px; left:10px;} 

div#comment-container button#btn-insert{width:60px;height:50px; color:white;
    background-color:#ffa089;position:relative;top:-20px;border-style:none;}
 div#comment-container button#btn-insert:hover{background-color:#ffcba4;}   
 
   	div#comment-container{text-align:center;}


#alarm{margin-left:auto;margin-right:auto;text-align:left;}
#alarm th{padding:20px 20px 40px 60px}


th#profilephoto2>img{width:30%; height:30%;margin-right:0%;}


section#study-enroll-container{font-family: 'Nanum Gothic Coding', monospace;}


 th#profilephoto2{position:relative;}
     th#profilephoto2>img{width:120px; height:120px;margin-right:0%;}
     table#studyEnrollTable:not(#title){margin-left:30%;margin-right:auto;text-align:left;}
table#studyEnrollTable th{padding:20px 20px 40px 20px}

table#studyEnrollTable tr{padding:20px 20px 40px 20px}

table#studyEnrollTable{width:60%;}

input#study{width:100px; height:50px; background-color:#ffa089;border-style:none;}
input#study:hover{background-color:#ffcba4;}
</style>




























<%@ include file="/views/commons/footer.jsp" %></html>