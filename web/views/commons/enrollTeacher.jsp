<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/commons/header.jsp" %>
<% String userId=(String)request.getAttribute("userId"); %>

<section id=teacher-enroll-container style="background-color:white; font-family: 'Nanum Gothic Coding', monospace;">
<h2 style="margin-top:10%;">
        <%if(userId!=null){%>
        <%=userId%>님의 
        <%}%>
        정보를 입력해주세요</h2><br>
        
        <h3>선생님 프로필 등록</h3><br>        
        <h5>선생님 프로필을 허위 입력시 강제탈퇴 조치 및 불이익이 있을 수 있습니다.</h5>

   <form id="teacherEnrollFrm" action="<%=request.getContextPath() %>/teacherenrollend.do?userId=<%=userId %>" method="post" >
        <table id="teacherEnrolltable" style="margin-bottom:10%;">						
			<tr>
				<th>
				   학력
				    <select name="academicCareer">
				       <option value="고등학교 졸업">고등학교 졸업</option>
				       <option value="대학교 졸업">대학교 졸업</option>
				       <option value="석사">석사</option>
				       <option value="박사">박사</option>
				       <option value="기타">기타</option>
				    </select>&nbsp;&nbsp;&nbsp;&nbsp;
				    학교이름
				    <input type="text" name="collegeName" placeholder="학교이름입력">
				    &nbsp;&nbsp;&nbsp;&nbsp;
				    전공
				    <input type="text" name="major" placeholder="전공입력">
				</th>
			</tr>		
			<tr class="certificateTr">
				<th>
				   보유자격증
				   <input type="text" name="certificate" placeholder="보유자격증입력">
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
			      <textarea name="career" cols="55" rows="3"></textarea>			  
			  </th>						
			</tr>
			<tr>
			  <th>
			   선생님에 대해 소개해주세요.
			   </th>
			</tr>
			<tr>
			  <th>			     
			      <textarea name="selfIntroduction" cols="55" rows="3"></textarea>
			  
			  </th>						
			</tr>
			
			
		</table>
		
		<input id="submit" type="submit" value="가입하기" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="reset" type="reset" value="취소">
		
        </form>


</section>

<style>
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

</script>






<%@ include file="/views/commons/footer.jsp" %></html>