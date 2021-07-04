<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/commons/header.jsp" %>

<%
    Member m=(Member)request.getAttribute("member");
 %>
 
 <style>
    section#enroll-container input[readonly]{background-color:#ffa089;}
  #enrolltable{width:35%;}
  #enrolltable td{width:50%; margin-left:0;}
  #enrolltable th{width:30%}
 </style>
 

<section id=enroll-container style="background-color:white; font-family: 'Nanum Gothic Coding', monospace;">
        <h2 style="margin-top:10%;">회원 가입 정보 수정</h2>
       
        <form id="memberFrm" method="post" enctype="multipart/form-data" onsubmit="return fn_update_validate();" >
        <table id="enrolltable" >
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="userId" id="userId_" value="<%=m.getUserId() %>" readonly>
				
				</td>
			</tr>
			<!-- <tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="password" id="password_" ><br>
				</td>
			</tr>
			<tr>
				<th>패스워드확인</th>
				<td>	
					<input type="password" id="password_2" ><br>
				</td>
			</tr>   -->
			
			<tr>
				<th>이름</th>
				<td>	
				<input type="text"  name="userName" id="userName" value="<%=m.getUserName() %>" required ><br>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>	
				<input type="number" name="age" id="age" value="<%=m.getAge() %>" required><br>
				</td>
			</tr> 
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%=m.getEmail() %>" required><br>
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%=m.getPhone() %>" required><br>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>	
					<input type="text" placeholder="" name="address" id="address" value="<%=m.getAddress() %>"><br>
				</td>
			</tr>
			<tr>
				<th>성별 </th>
				<td>
					<input type="radio" name="gender" value="M" id="gender0" 
					<%=m.getGender().trim().equals("M")?"checked":"" %> > 
					<label for="gender0">남</label>
					<input type="radio" name="gender" value="F" id="gender1"
					<%=m.getGender().trim().equals("F")?"checked":"" %>>
					<label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<th>프로필사진 </th>
				<td style="position:relative">
				  <%if(m.getRenamedFileName()!=null){ %>
				  <input type="file" id="profilephoto" name="profilephoto"  value="">
				     <input type="hidden" id="profilephoto" name="oriProfilePhoto" value="<%=m.getRenamedFileName() %>">
                 <span style="position:absolute; top:15px; left:120px; background-color:white" id="fname"><%=m.getRenamedFileName() %></span>
                 <%} else{ %>
                 <input type="file" name="profilephoto">
                 <%} %>
				</td>
			</tr>
			<tr>
			   <th id="profilePhoto2">
			    <%if(m.getRenamedFileName()!=null){ %>
			     <img id="profileimg" src="<%=request.getContextPath()%>/upload/profile/<%=m.getRenamedFileName() %>" alt=renamedFileName>
			      <%}else{ %>
			       <img id="profileimg" src="https://www.gravatar.com/avatar/7629227fbea5620ccc50ad380b71627d?size=192&d=mm" alt=renamedFileName>
			       <%} %>
			   </th>			
			</tr>
			<tr>
				<th colspan="3">스터디윗미의
				<input type="radio" name="teacherstudent" value="teacher" id="teacher" 
				<%=m.getStudentTeacherStatus().contains("teacher")?"checked":"" %> >
					<label for="teacher">선생님</label>
					<input type="radio" name="teacherstudent" value="student" id="student"
					<%=m.getStudentTeacherStatus().contains("student")?"checked":"" %>>
					<label for="student">학생</label>
				으로 등록
				  </th>				
			</tr>
		</table>
		
		    <input id="button" type="button" value="정보수정" onclick="fn_update_member();"/>
		    &nbsp;&nbsp;&nbsp;
			<!-- <button type="button">정보수정btn</button> -->
			<button id="button" type="button" onclick="fn_password_update();">비밀번호변경</button>&nbsp;&nbsp;&nbsp;
			<!-- <input type="button" value="탈퇴" onclick="fn_delete_member();"/> -->
			<input id="button" class="updatenext" type="button" value="다음페이지수정하기" onclick="fn_update_next();"/>
        </form>
    </section>
   
    
    <style>
    #profileimg:hover{cursor:pointer;}
       th#profilePhoto2{position:relative;}
     th#profilePhoto2>img{width:120px; height:120px;margin-right:0%; margin-left:80%;}
     /*  #profileimg{width:50px; height:50px;margin-right:0%; margin-left:80%;} */
    
     form#memberEnrollFrm{margin-top:5%;margin-bottom:5%;}
     
      #button{background-color:#ffa089; border:none; height:30px; margin-top:5%;}
      #button:hover{color:white;}
    
    </style>
    
    <script>

    
    	    $("#profileimg").click(e=>{
    	    	 $("#profilephoto").click();
    	    });
    	         $("#profilephoto").change(e=>{
    	        	console.dir(e.target);
    	        	//미리보기처리하기
    	        	if(e.target.files[0].type.includes("image")){
    	        		 let reader=new FileReader();
    	        		reader.onload=function(e){
    	        			const img=$("<img>").attr({
    	        				"src":e.target.result,
    	        				"width":"120px",
    	        				"height":"120px"
    	        			});
    	        			 
    	        			 $("#profileimg").attr("src",e.target.result); 
    	        		}
    	        		reader.readAsDataURL(e.target.files[0]);
    	        	}
    	        	
    	        }); 
    
    
    $(function(){
    	$("input[name=profilephoto]").change(e => {
    		if($(e.target).val()==""){
    			$("#fname").show();
    		}else{
    			$("#fname").hide();
    		}
    	});
    });
    const fn_password_update=()=>{
		  const url="<%=request.getContextPath()%>/updatePassword?userId=<%=m.getUserId()%>";
	    	const status="left=500px, top=200px, width=400px, height=210px";
	    	
	    	
	    	open(url,"_blank", status);
	    	
	    	
		  
		  
	  }
	
	
	   const fn_delete_member=()=>{
		   if(confirm("정말로 탈퇴하시겠습니까?")){
			   //탈퇴로직 진행
			   location.replace("<%=request.getContextPath()%>/deleteMember.do?userId="+'<%=loginMember.getUserId()%>');
			   //location.replace("/06_HelloMVC/deleteMember?userId="+'user04')
			   
		   }
	   }
	
	
	
	
	
	   const fn_update_member=()=>{
		   const frm=$("#memberFrm");
		   console.log(frm);
		   //form태그에 action속성이 설정되어 있지 않아 설정하고 submit함수 호출하면 됨.
		   //동적으로 form으로 전송되는 servlet을 변경할 수 있다.
		   
		   frm.attr("action", "<%=request.getContextPath()%>/memberUpdate.do");
		   frm.submit();
		   
	   }
	   
	   const fn_update_validate=()=>{
		   
		   
		   return true;
	   }
    
    
     <%--   const fn_update_next=()=>{
    	   
    	   location.replace("<%=request.getContextPath()%>/nextupdate.do?userId=<%=loginMember.getUserId()%>");
    	   
       } --%>
       
       
       $(".updatenext").on("click", function(){
			
    	   location.replace("<%=request.getContextPath()%>/nextupdate.do?userId=<%=loginMember.getUserId()%>");
   	}); 
   	
    
    
    
    </script>













<%@ include file="/views/commons/footer.jsp" %></html>