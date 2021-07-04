<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/commons/header.jsp" %>
<% String userId=(String)request.getAttribute("userId"); %>

<section id=student-enroll-container style="background-color:white; font-family: 'Nanum Gothic Coding', monospace;">
        <h2 style="margin-top:10%;">
        <%if(userId!=null){%>
        <%=userId%>님이 
        <%}%>
        배우고 싶은 분야에 체크하세요</h2>
       
        <form id="studentEnrollFrm" action="<%=request.getContextPath() %>/studentenrollend.do?userId=<%=userId %>" method="post" >
        <table id="studentEnrolltable" style="margin-bottom:10%;">			
			<tr>
				<th><h2>음악</h2></th>	
			</tr>
			<tr>
				<th>
				    <input type="checkbox" name="interestingSubject" value="피아노/바이올린 등 악기" id="instrument"  >
					<label for="instrument">피아노/바이올린 등 악기</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="미디/작곡" id="midi/composing"  >
					<label for="midi/composing">미디/작곡</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="보컬" id="vocal"  >
					<label for="vocal">보컬</label>&nbsp;&nbsp;&nbsp;
				</th>
			</tr>
			<tr>
				<th><h2>외국어</h2></th>	
			</tr>
			<tr>
				<th>
				    <input type="checkbox" name="interestingSubject" value="영어" id="english"  >
					<label for="english">영어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="일어" id="japanese"  >
					<label for="japanese">일어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="중국어" id="chinese"  >
					<label for="chinese">중국어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="스페인어" id="spanish"  >
					<label for="spanish">스페인어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="독일어" id="german"  >
					<label for="german">독일어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="러시아어" id="russian"  >
					<label for="russian">러시아어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="기타언어" id="etc"  >
					<label for="etc">기타언어</label>
				</th>
			</tr>
			<tr>
				<th><h2>교양/시사</h2></th>	
			</tr>
			<tr>
			    <th>
			       <input type="checkbox" name="interestingSubject" value="글쓰기" id="writing"  >
					<label for="writing">글쓰기</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="독서모임" id="reading"  >
					<label for="reading">독서모임</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="철학/토론" id="discussion"  >
					<label for="discussion">철학/토론</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="주식" id="share"  >
					<label for="share">주식</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="부동산" id="realestate"  >
					<label for="realestate">부동산</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="재태크/경매" id="auction"  >
					<label for="auction">재테크/경매</label>
				</th>
			</tr>
			<tr>
				<th><h2>자격증</h2></th>	
			</tr>
			<tr>
			    <th>
			       <input type="checkbox" name="interestingSubject" value="회계" id="accounting"  >
					<label for="accounting">회계</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공인중개사" id="realestateagent"  >
					<label for="realestateagent">공인중개사</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공무원/영어" id="publicofficialEnglish"  >
					<label for="publicofficialEnglish">공무원/영어</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공무원/국사" id="publicofficialHistory"  >
					<label for="publicofficialHistory">공무원/국사</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="정보처리기사" id="dataProcessingEngineer"  >
					<label for="dataProcessingEngineer">정보처리기사</label>					
				</th>
			</tr>
			<tr>
				<th><h2>취미</h2></th>	
			</tr>
			<tr>
			    <th>
			       <input type="checkbox" name="interestingSubject" value="베이킹/쿠킹클래스" id="baking"  >
					<label for="baking">베이킹/쿠킹클래스</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="양식/한식쿠킹클래스" id="westernKoreanCooking"  >
					<label for="westernKoreanCooking">양식/한식 쿠킹클래스</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공예/꽃꽂이식물관리" id="flowerArrangement"  >
					<label for="flowerArrangement">공예/꽃꽂이 식물관리</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="공예/목공예" id="woodcraft"  >
					<label for="woodcraft">공예/목공예</label>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="interestingSubject" value="영화감상/토론" id="movieAppreciation"  >
					<label for="movieAppreciation">영화감상/토론</label>					
				</th>
			</tr>
			
		</table>
		
		<input id="submit" type="submit" value="가입하기" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="reset" type="reset" value="취소">
		
        </form>
    </section>
    <style>
    
    table#studentEnrolltable{margin-left:auto; margin-right:auto; margin-top:5%;}
    section#student-enroll-container{text-align:center;}
    form#studentEnrollFrm{margin-bottom:5%;}
    #studentEnrolltable th, td{padding:15px;}
    
    input#submit{width:100px; height:50px; background-color:#ffa089;}
    input#reset{width:100px; height:50px; background-color:#ffa089;}
  
     input#submit:hover{background-color:#ffcba4;}
    input#reset:hover{background-color:#ffcba4;}
    
    
    
    </style>






<%@ include file="/views/commons/footer.jsp" %></html>