<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/commons/header.jsp" %>

<section id=enroll-container style="background-color:white; font-family: 'Nanum Gothic Coding', monospace;">
        <h2 style="margin-top:10%;">회원 가입 정보 입력</h2>
       
        <form id="memberEnrollFrm" action="<%=request.getContextPath() %>/signupend.do" method="post" enctype="multipart/form-data" onsubmit="return fn_enroll_validate();" >
        <table id="enrolltable">
			<tr>
				<th>아이디</th>
				<td style="position:absolute; padding-left:54px; bottom:inherit">
					<input "type="text" placeholder="4글자이상" name="userId" id="userId_" >
					<input type="button" value="중복검사" onclick="fn_id_duplicate();"> <!-- form안에 button쓰면 제출됨으로 인풋에.. 주의 -->
				</td>
			</tr>
			<tr>
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
			</tr>  
			<tr>
				<th>이름</th>
				<td>	
				<input type="text"  name="userName" id="userName" required ><br>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>	
				<input type="number" name="age" id="age" required><br>
				</td>
			</tr> 
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" required><br>
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" required><br>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>	
					<input type="text" placeholder="" name="address" id="address"><br>
				</td>
			</tr>
			<tr>
				<th>성별 </th>
				<td>
					<input type="radio" name="gender" value="M" id="gender0"  >
					<label for="gender0">남</label>
					<input type="radio" name="gender" value="F" id="gender1">
					<label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<th>프로필사진 </th>
				<td>
				  <input type="file" name="profilephoto" id="profilephoto">
				</td>
			</tr>
			<tr>
			  <th id="profilephoto2">
			     <img id="profileimg" src="https://www.gravatar.com/avatar/7629227fbea5620ccc50ad380b71627d?size=192&d=mm" alt=renamedFileName>
			  </th>		
			</tr>
			<tr>
				<th colspan="3">스터디윗미의
				<input type="radio" name="teacherstudent" value="teacher" id="teacher"  >
					<label for="teacher">선생님</label>
					<input type="radio" name="teacherstudent" value="student" id="student">
					<label for="student">학생</label>
				으로 등록
				  </th>				
			</tr>
		</table>
		
		<input type="submit" value="다음으로" >
		<input type="reset" value="취소">
        </form>
    </section>
    <form action="" name="checkDuplicateId">
        <input type="hidden"  name="userId">
 
    </form>
    <style>
    #profileimg:hover{cursor:pointer;}
    
     form#memberEnrollFrm{margin-top:5%;margin-bottom:5%;}
      
      th#profilephoto2{position:relative;}
     th#profilephoto2>img{width:120px; height:120px;margin-right:0%; margin-left:80%;}
     
     #profileimg:hover{cursor:pointer;}
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
    	//비밀번호와 비밀번호확인의 값이 일치하는지 check,  header에 password변수 써서 _씀.
    	$("#password_2").blur((e)=>{
    		const pwck=$(e.target).val();
    		const pw=$("#password_").val();
    		if(pwck!=pw){
    			alert("패스워드가 일치하지 않습니다.");
    			$("#password_").focus();
    		}
    		
    	});
    	
    });
    
    //입력한 아이디값이 4글자 이상이 아니면 전송금지
    const fn_enroll_validate=()=>{
    	const userId=$("#userId_");
    	if(userId.val().length<4){
    		alert("아이디는 최소 4자리 이상이여야 합니다.");
    		userId.focus();
    		return false;
    	}
    	
    }
    
    const fn_id_duplicate=()=>{
    	//1. 연결할 주소
    	const url="<%=request.getContextPath()%>/checkDuplicateId";
    	const title="checkDuplicateId";
    	const status="left=500px, top=100px, width=300px, height=200px";
    	
    	open("",title,status);
    	
    	//form에 있는 input의 값을 채우고 윈도우(새창)에서 그 결과를 받는 로직으로 설정
    	//form태그는 name속성을 설정하면 그 name속성으로 직접접근이 가능함
    	console.log(checkDuplicateId);
    	//form의 name속성으로 필요한 데이터 세팅하기     //window객체 window.checkDuplicateId 이런식으로 생략되있음
    	checkDuplicateId.userId.value=$("#userId_").val();
    	checkDuplicateId.method="post";
    	checkDuplicateId.action=url;
    	
    	//이 form태그가 제출(submit)되는 윈도우를 지정 , 새로운 윈도우target
    	checkDuplicateId.target=title;
    	
    	//제출
    	checkDuplicateId.submit();
    	
    	
    }
   
    
    
    
    </script>













<%@ include file="/views/commons/footer.jsp" %></html>