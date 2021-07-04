<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.members.model.vo.Student" %>
<%@ page import="com.members.model.vo.Studygroup" %>
<%@ page import="com.members.model.vo.Lecture" %>
<%@ page import="java.util.List" %>
<%@ include file="/views/commons/header.jsp" %>

<!--nextupdate에서 넘어온 값   -->
  <% 
String userId=(String)request.getAttribute("userId");
Student s=(Student)request.getAttribute("Student");

List<Studygroup> studygroups=(List<Studygroup>)request.getAttribute("EnrollStudy");
Studygroup teamleadersg=(Studygroup)request.getAttribute("TeamleaderGroup");
List<Lecture> lectures=(List<Lecture>)request.getAttribute("lectures");
List<Lecture> lastlectures=(List<Lecture>)request.getAttribute("lastlectures");
  %>

<section id=student-enroll-container style="background-color:white; font-family: 'Nanum Gothic Coding', monospace;">
        <h2 style="margin-top:10%;">
        <%if(userId!=null){%>
        <%=userId%>님이 
        <%}%>
        배우고 싶은 분야에 체크하세요</h2>
       
        <form id="studentEnrollFrm" action="<%=request.getContextPath() %>/studentupdate.do?userId=<%=userId %>" method="post" >
        <table id="studentEnrolltable" style="margin-bottom:10%;">	
          <tbody>		
			<tr>
				<th><h2>음악</h2></th>	
			</tr>
			<tr>
				<th>
				    <input type="checkbox" name="interestingSubject" value="피아노/바이올린 등 악기" id="instrument" <%=s.getInterestingSubject().contains("피아노/바이올린 등 악기")?"checked":"" %> >
					<label for="instrument">피아노/바이올린 등 악기</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="미디/작곡" id="midi/composing" <%=s.getInterestingSubject().contains("미디/작곡")?"checked":"" %>  >
					<label for="midi/composing">미디/작곡</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="보컬" id="vocal" <%=s.getInterestingSubject().contains("보컬")?"checked":"" %>  >
					<label for="vocal">보컬</label>&nbsp;&nbsp;&nbsp;
				</th>
			</tr>
			<tr>
				<th><h2>외국어</h2></th>	
			</tr>
			<tr>
				<th>
				    <input type="checkbox" name="interestingSubject" value="영어" id="english" <%=s.getInterestingSubject().contains("영어")?"checked":"" %> >
					<label for="english">영어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="일어" id="japanese" <%=s.getInterestingSubject().contains("일어")?"checked":"" %> >
					<label for="japanese">일어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="중국어" id="chinese" <%=s.getInterestingSubject().contains("중국어")?"checked":"" %> >
					<label for="chinese">중국어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="스페인어" id="spanish" <%=s.getInterestingSubject().contains("스페인어")?"checked":"" %> >
					<label for="spanish">스페인어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="독일어" id="german" <%=s.getInterestingSubject().contains("독일어")?"checked":"" %> >
					<label for="german">독일어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="러시아어" id="russian" <%=s.getInterestingSubject().contains("러시아어")?"checked":"" %>  >
					<label for="russian">러시아어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="기타언어" id="etc" <%=s.getInterestingSubject().contains("기타언어")?"checked":"" %>  >
					<label for="etc">기타언어</label>
				</th>
			</tr>
			<tr>
				<th><h2>교양/시사</h2></th>	
			</tr>
			<tr>
			    <th>
			       <input type="checkbox" name="interestingSubject" value="글쓰기" id="writing" <%=s.getInterestingSubject().contains("글쓰기")?"checked":"" %> >
					<label for="writing">글쓰기</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="독서모임" id="reading" <%=s.getInterestingSubject().contains("독서모임")?"checked":"" %> >
					<label for="reading">독서모임</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="철학/토론" id="discussion" <%=s.getInterestingSubject().contains("철학/토론")?"checked":"" %> >
					<label for="discussion">철학/토론</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="주식" id="share" <%=s.getInterestingSubject().contains("주식")?"checked":"" %> >
					<label for="share">주식</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="부동산" id="realestate" <%=s.getInterestingSubject().contains("부동산")?"checked":"" %> >
					<label for="realestate">부동산</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="재태크/경매" id="auction" <%=s.getInterestingSubject().contains("재태크/경매")?"checked":"" %> >
					<label for="auction">재테크/경매</label>
				</th>
			</tr>
			<tr>
				<th><h2>자격증</h2></th>	
			</tr>
			<tr>
			    <th>
			       <input type="checkbox" name="interestingSubject" value="회계" id="accounting" <%=s.getInterestingSubject().contains("회계")?"checked":"" %> >
					<label for="accounting">회계</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공인중개사" id="realestateagent" <%=s.getInterestingSubject().contains("공인중개사")?"checked":"" %> >
					<label for="realestateagent">공인중개사</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공무원/영어" id="publicofficialEnglish" <%=s.getInterestingSubject().contains("공무원/영어")?"checked":"" %> >
					<label for="publicofficialEnglish">공무원/영어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공무원/국사" id="publicofficialHistory" <%=s.getInterestingSubject().contains("공무원/국사")?"checked":"" %> >
					<label for="publicofficialHistory">공무원/국사</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="정보처리기사" id="dataProcessingEngineer" <%=s.getInterestingSubject().contains("정보처리기사")?"checked":"" %> >
					<label for="dataProcessingEngineer">정보처리기사</label>					
				</th>
			</tr>
			<tr>
				<th><h2>취미</h2></th>	
			</tr>
			<tr>
			    <th>
			       <input type="checkbox" name="interestingSubject" value="베이킹/쿠킹클래스" id="baking" <%=s.getInterestingSubject().contains("베이킹/쿠킹클래스")?"checked":"" %> >
					<label for="baking">베이킹/쿠킹클래스</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="양식/한식쿠킹클래스" id="westernKoreanCooking" <%=s.getInterestingSubject().contains("양식/한식쿠킹클래스")?"checked":"" %> >
					<label for="westernKoreanCooking">양식/한식 쿠킹클래스</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공예/꽃꽂이식물관리" id="flowerArrangement" <%=s.getInterestingSubject().contains("공예/꽃꽂이식물관리")?"checked":"" %> >
					<label for="flowerArrangement">공예/꽃꽂이 식물관리</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공예/목공예" id="woodcraft" <%=s.getInterestingSubject().contains("공예/목공예")?"checked":"" %> >
					<label for="woodcraft">공예/목공예</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="영화감상/토론" id="movieAppreciation" <%=s.getInterestingSubject().contains("영화감상/토론")?"checked":"" %> >
					<label for="movieAppreciation">영화감상/토론</label>					
				</th>
			</tr>
			
		  </tbody>
			
		 </table>
		 <input id="submit" type="submit" value="수정하기" >
		</form>
		
		<table id="extrainfo">
        <tbody >
        <tr>
            <th colspan="2"> <h2>나의 수강 강의</h2></th>
            <th></th>
        </tr>
        <tr>
            <th id="enrollLectureInfo" >
                <%if(s.getEnrollLecture()!=null){ %>
                
                    <%for(int i=0; i<lectures.size();i++) {%>
                    <div id="mystudy"><img id="lecturephoto" src="<%=request.getContextPath()%>/upload/LectureInfo/<%=lectures.get(i).getLecPhotoRenamed() %>" alt=lectureinfo></div>
                    <div id="textcontainer"><a id="lecturephototext" href="<%=request.getContextPath()%>/lectureView?lectureNo=<%=lectures.get(i).getLectureNo() %>"><%=lectures.get(i).getLectureName() %></a></div>
                    <%} %>
                <%}else{ %>
                강의가 없습니다. 강의를 등록하세요.
                <%} %>	 
            </th>
            <th>
                <%if(s.getEnrollLecture()!=null){ %>
                    <input id="" type="button" value="나의 강의 결제 정보" onclick="lecturePayInfo()"/>
                    <%} %>
                     <input id="" type="button" value="강의찾기" onclick="lectureInfo()"/>

            </th>
        </tr>
        <tr>
            <th colspan="2"> <h2>나의 스터디</h2> </th>
            <th></th>
        </tr>
        <tr>
            <th id="enrollStudyInfo" >
                 <%if(s.getEnrollStudy()!=null){ %>
                
                    <%for(int i=0;i<studygroups.size();i++) {%>
                       <div id="mystudy"><img id="studyphoto" src="<%=request.getContextPath()%>/upload/StudyInfo/<%=studygroups.get(i).getStudyPhotoRenamedFile() %>" alt=studyinfo></div>
                    <div id="textcontainer"><a id="studyphototext" href="<%=request.getContextPath()%>/studygroupView?studygroupNo=<%=studygroups.get(i).getStudygroupNo() %>"><%=studygroups.get(i).getStudyGroupName() %></a></div> 
                    <%} %> 
                <%}else{ %> 
                스터디가 없습니다. 스터디를 등록하세요.
                <%} %>   
            </th>
            <th><input id="" type="button" value="스터디 찾기" class="studyinfo" onclick="studyInfo()"/></th>
        </tr>
        <tr>
            <th colspan="2"><h2>지난 강의</h2></th>
            <th></th>
        </tr>
        <tr>
            <th id="lastLectureInfo" colspan="2" >
			      <%if(s.getLastLecture()!=null){ %>
			      
				      <%for( int i=0;i<lastlectures.size();i++) {%>
				      <div id="mystudy"><img id="lecturephoto2" src="<%=request.getContextPath()%>/upload/LectureInfo/<%=lastlectures.get(i).getLecPhotoRenamed()%>" alt=lastlectureinfo></div>
				      <div id="textcontainer"><a id="lecturephoto2text" href="<%=request.getContextPath()%>/lectureView?lectureNo=<%=lastlectures.get(i).getLectureNo() %>"><%=lastlectures.get(i).getLectureName() %>/후기쓰기</a></div>
				      <%} %>
			      <%}else{ %>
			     &nbsp; 지난 강의가 없습니다.
			      <%} %>
			      </th>	
            
        </tr>
        <tr>
            <th colspan="2"><h2>내가 운영하는 스터디모임</h2></th>
            <th></th>
        </tr>
        <tr>
             <th colspan="3" id=mystudycontainer>
			      <%if(s.getTeamLeaderStatus()!=null){ %>			      				      
				      <div id="mystudy"><img id="img" src="<%=request.getContextPath()%>/upload/StudyInfo/<%=teamleadersg.getStudyPhotoRenamedFile() %>" alt=studyinfo></div>
				      <div id="textcontainer"><a id="text" href="<%=request.getContextPath()%>/studygroupView?studygroupNo=<%=teamleadersg.getStudygroupNo() %>" ><%=teamleadersg.getStudyGroupName() %></a></div>
			      <%}else{ %>
			      운영하는 스터디가 없습니다.
			      <%} %>
			      
			      </th>	
            
        </tr>
        <tr>
            <th colspan="2"> <h2>스터디 모임을 직접 만들어요</h2>
			       <input id="submit" type="button" value="스터디 모집하기" onclick="fn_studyrecruit()"/></th>
           
        </tr>
        <tr style="line-height:200%";text-align=left">
            <th>모범생 포인트 :
			     <%if(s.getPoint()!=0) {%>
			    <%=s.getPoint() %>
			    <%}else{ %>
			    아직 포인트가 없습니다.
			    <%} %></th>
            <th style="width:50%"; rowspan="3";">!  스터디 모임이나 수강신청한 강의에서 전부 출석하면 모범생 포인트 1000점 자동 획득됩니다.<br>
                   다음 강의 결제시 포인트만큼 할인 받을 수 있습니다.<br>
                   본인이 개설한 스터디 모임을 잘 수행할 경우 모임원들에게 좋은 평점을 받을 수 있습니다.<br>
                   수강 이틀 전 후 가입 취소 및 수강 취소 시 벌점 1점 부여되며 스터디 모임이나 수강 중인 강의에 3회 결근시 벌점 1점이 부여됩니다.<br>
                   벌점 3점이면 1개월간 스터디를 열거나 가입할 수 없습니다. </th>
        </tr>
        <tr>
            <th>  모임장 평점 :&nbsp;
			     <%if(s.getTeamLeaderScore()!=0) {%>
			    <%=s.getPoint() %>점/10점
			    <%}else{ %>
			    아직 평점이 없습니다.
			    <%} %></th>
            <th></th>
        </tr>
        <tr>
            <th>  벌점 : &nbsp;
			     <%if(s.getPenaltyPoint()!=0) {%>
			    <%=s.getPoint() %>점
			    <%}else{ %>
			    벌점이 없습니다.
			    <%} %></th>
            <th></th>
        </tr>

    </tbody>
    </table>
		
	
		
		
		<div id="buttoncontainer">
		<input id="submit" type="button" value="이전페이지" onclick="fn_update_previous();"/>
		  &nbsp;&nbsp;&nbsp;
		
		<input id="submit" type="button" value="탈퇴" onclick="fn_delete_member();"/>
		&nbsp;&nbsp;&nbsp;
		<input id="submit" type="button" value="메인으로" onclick="fn_main();"/>
		</div>
		
        
    </section>
    <style>
     th#mystudycontainer{position:relative;}
     #textcontainer{position:relative;}
     #text{z-index:100; position:absolute; color:black; text-align:center; left:5%; top:30%; transform: translate( -5%, -30%);}
     div#mystudy>img{width:200px; height:200px;margin-right:auto; margin-left:auto;  position:relative;}
    
    
    #buttoncontainer{margin-top:10%;}
    #buttoncontainer>input{float:left; position: relative; left:30%;margin-left:30px;}
    /* table#extrainfo>tbody>th{margin-left:auto; margin-right:auto;} */
    #extrainfo{ margin-left:auto; margin-right:auto;text-align:center;position:relative;}
    
    th#enrollLectureInfo>img{width:120px; height:120px;margin-right:0%; margin-left:80%;}
    
    table#studentEnrolltable{margin-left:auto; margin-right:auto; margin-top:5%;} 
    
    table#extrainfo{text-align:left;width:70%}
     table#extrainfo th{padding:50px 30px;}
     table#extrainfo td{padding:50px 30px;}
    
    /* section#student-enroll-container{text-align:center;} */
    section#student-enroll-container{text-align:center;}
    
    form#studentEnrollFrm{margin-bottom:5%; text-align:center;}
    #studentEnrolltable th, td{padding:15px;}
    
    input#submit{width:130px; height:30px; background-color:#ffa089; border:none;}    
  
     input#submit:hover{color:white;}
    input#reset:hover{color:white;}
    
    #img:hover{cursor:pointer;}
    #lecturephoto:hover{cursor:pointer;}
    #studyphoto:hover{cursor:pointer;}
    #lecturephoto2:hover{cursor:pointer;}
    
    </style>

   <script>
   $("#img").click(e=>{
	   $("#text").get(0).click();
  	<%-- location.replace("<%=request.getContextPath()%>/studygroupView?studygroupNo=<%=teamleadersg.getStudygroupNo() %>"); --%>
  });
   
   $("#lecturephoto").click(e=>{
	   $("#lecturephototext").get(0).click();
	  	
	  });
   $("#studyphoto").click(e=>{
	   $("#studyphototext").get(0).click();
	  	
	  });
   $("#lecturephoto2").click(e=>{
	   $("#lecturephoto2text").get(0).click();
	  	
	  });
   
   const fn_delete_member=()=>{
	   if(confirm("정말로 탈퇴하시겠습니까?")){
		   //탈퇴로직 진행
		   location.replace("<%=request.getContextPath()%>/deleteMember.do?userId=<%=loginMember.getUserId()%>&type=student");
		   //location.replace("/06_HelloMVC/deleteMember?userId="+'user04')
		   
	   }
   }
   
   const fn_update_previous=()=>{
	   
	   location.replace("<%=request.getContextPath()%>/memberView.do?userId=<%=loginMember.getUserId()%>");
	   
   } 
   
   const fn_main=()=>{
	   
	   location.replace("<%=request.getContextPath()%>/");
	   
	   
   }
   
   const fn_studyrecruit=()=>{
	   
	   location.replace("<%=request.getContextPath()%>/studyrecruit.do?userId=<%=loginMember.getUserId()%>");
   }
   
  $(".studyinfo").on("click", function(){
	  
	  location.replace("<%=request.getContextPath()%>/studyList");
	  
	  
  });
   
   
   
   
   
   </script>




<%@ include file="/views/commons/footer.jsp" %></html>