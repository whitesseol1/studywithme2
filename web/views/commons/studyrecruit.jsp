<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/commons/header.jsp" %>


  <% 
String userId=(String)request.getAttribute("userId");

  %>
<!-- <head><script src="js/jquery-3.6.0.min.js"></script></head -->

   <section id=study-enroll-container style="background-color:white; font-family: 'Nanum Gothic Coding', monospace;">
      <form id="studyEnrollFrm" style="margin-bottom:10%;" onsubmit="return fn_update_validate();" enctype="multipart/form-data" method="post">
  
			    <table id="studyEnrollTable">
			    <tr id="title" style="text-align:center;">
			        <th colspan="3" ><h2>스터디 모집하기</h2></th>
			       
			        
			    </tr>
			    <tr>
			        <th><h3>스터디분야</h3></th>
			        <th>
			            <select name="subject" id="select1" onchange="itemChange()" style="width:120px" required>
			              <option value="음악">음악</option>
			              <option value="외국어">외국어</option>
			              <option value="교양">교양</option>
			              <option value="시사">시사</option>
			              <option value="자격증">자격증</option>
			              <option value="취미">취미</option>
			              <option value="기타">기타</option>
			            </select>
			            <select id="select2" name="subject" style="width:120px" required></select>
			        </th>			        
			        <th>
			           <input type="text" name="subject" placeholder="분야를 입력해 주세요." required>
			        </th>
			    </tr>
			    <tr>
			        <th><h3>스터디 그룹 이름</h3></th>			        
			        <th colspan="2">
			          <input type="text" name="groupname" placeholder="그룹이름을 입력하세요." required>
			        </th>			        
			    </tr>
			    <tr>
			        <th><h3>스터디 소개</h3></th>			        
			        <th colspan="2">
			           <textarea name="studyintroduction" cols="55" rows="3" placeholder="내용을 입력해주세요." required></textarea>
			        </th>
			       
			    </tr>
			    <tr>
			        <th><h3>스터디 소개 사진</h3></th>
			        
			        <th colspan="2">
			          <input type="file" id="profilephoto" name="profilephoto">
			        </th>		        
			    </tr>
			    <tr>
			        <th colspan="3" id="profilephoto2">
			           <img id="profileimg" src="https://www.gravatar.com/avatar/7629227fbea5620ccc50ad380b71627d?size=192&d=mm" alt=renamedFileName>
			        </th>
				    
			    </tr>
			    <tr>
			        <th><h3>스터디 레벨</h3></th>
			        <th>
			           <select name="level" id="levelselect" style="width:120px" required>
			             <option value="초급">초급</option>
			             <option value="초·중급">초·중급</option>
			             <option value="중급">중급</option>
			             <option value="중·고급">중·고급</option>
			             <option value="고급">고급</option>
			           </select>
			        </th>
			        
			        
			    </tr>
			    <tr>
			        <th><h3>스터디 횟수</h3></th>&nbsp;
			        <th>
			          <input type="text" name="studyhour" placeholder="숫자입력" required>시간씩
			        </th>
			        <th>주&nbsp; <input type="text" name="frequency" placeholder="숫자입력" required>회 </th>
			        
			       
			    </tr>
			    <tr>
			        <th colspan="3">
			        <h3>스터디 요일</h3>
			          <input type="checkbox" name="day" value="월" id="day"  >
					   <label for="monday">월</label>&nbsp;&nbsp;&nbsp;
					   <input type="checkbox" name="day" value="화" id="day"  >
					   <label for="tueseday">화</label>&nbsp;&nbsp;&nbsp;
					   <input type="checkbox" name="day" value="수" id="day"  >
					   <label for="wednesday">수</label>&nbsp;&nbsp;&nbsp;
					   <input type="checkbox" name="day" value="목" id="day"  >
					   <label for="thursday">목</label>&nbsp;&nbsp;&nbsp;
					   <input type="checkbox" name="day" value="금" id="day"  >
					   <label for="friday">금</label>&nbsp;&nbsp;&nbsp;
					   <input type="checkbox" name="day" value="토" id="day"  >
					   <label for="saturday">토</label>&nbsp;&nbsp;&nbsp;
					   <input type="checkbox" name="day" value="일" id="day"  >
					   <label for="sunday">일</label>&nbsp;&nbsp;&nbsp;
			        </th>
			        
			      
			    </tr>
			    <tr>
			       <th>&nbsp;&nbsp;&nbsp;시작날짜 &nbsp;<input type="date" name="startDate" required></th>
			        <th>&nbsp;&nbsp;&nbsp;시작시간 &nbsp;<input type="time" name="startTime"></th>
			        <th >
			           <input type="radio" name="fixtime" value="시간고정">
			           <label for="timefixed">시간고정</label>
			           <input type="radio" name="fixtime" value="주로 이시간">
			           <label for="timenotfixed">주로 이시간</label>
			          </th>
			        
			        
			    </tr>
			    <tr>
			        <th><h3>스터디 멤버 나이</h3></th>
			        <th><input type="text" name="age" placeholder="숫자입력" required>&nbsp;세 이상</th>
			        <th><input type="text" name="age" placeholder="숫자입력">&nbsp;세 이하</th>
			        
			    </tr>
			    <tr>
			        <th><h3>모집 인원</h3></th>
			        <th>최소 &nbsp;<input type="text" name="totalnum" placeholder="숫자입력" required>명,</th>
			        <th>최대 &nbsp;<input type="text" name="totalnum" placeholder="숫자입력" required>명</th>
			       
			    </tr>
			    <tr>
			        <th><h3>모임방식</h3></th>
			        <th>
			          <input type="radio" name="online" value="온라인">
			           <label for="online">온라인</label>
			           
			        </th>
			        <th>
			          <input type="radio" name="online" value="오프라인">
			           <label for="offline">오프라인</label>
			        </th>
			      
			    </tr>
			    <tr style="line-height:200%">
			        <th colspan="3" rowspan="2" >
			            !온라인 스터디의 경우 스터디 모임장이 수업에 활용할 매체, 프로그램을 준비하고 <br>
			            스터디 모임이 준비되도록 모임원을 도우며 오프라인 모임의 경우 장소 준비는 직접 해야 합니다.  <br>
						등록 내용 수정은 등록한 수업 시작일 3일 전까지 가능하며 그 이후에는 불가합니다. <br>
						등록한 모임을 부득이하게 취소하면 시작일 3일 전은 벌점 1점, 그 이후에는 벌점 3점입니다. <br>
						벌점 3점이 누적되면 1개월간 스터디 모임 등록, 참여가 제한되므로 신중히 등록해주세요.	 <br>					
						만약 모임을 잘 운영하여 좋아요를 10점 이상 받으면 포인트 1000점이 지급됩니다. 	 <br>					
						강의 수강시 포인트만큼 할인 받을 수 있습니다. <br>					
						모임장에 대한 불만족 신고가 3번이상 접수될 경우 모임 중단, 운영 1개월 정지가 발생할 수 있습니다. 
			        </th>
			        
			        <th rowspan="3"> <input id="enrollstudy" type="button" value="모임 등록" onclick="fn_enrollstudy();"/></th>
			        
			    </tr>
			   
			</table>
  
  
  
  
  
  
  
  
  
  
  
  
  </form>

</section>


<style>
section#study-enroll-container{text-align:center;}


 th#profilephoto2{position:relative;}
     th#profilephoto2>img{width:120px; height:120px;margin-right:0%;}
     table#studyEnrollTable:not(#title){margin-left:auto;margin-right:auto;text-align:left;}
table#studyEnrollTable th{padding:20px 20px 20px 20px}

table#studyEnrollTable tr{padding:20px 20px 20px 20px}

table#studyEnrollTable{}

input#enrollstudy{width:100px; height:50px; background-color:#ffa089;border-style:none;}
input#enrollstudy:hover{background-color:#ffcba4;}
</style>









<script>
const fn_enrollstudy=()=>{
	   const frm=$("#studyEnrollFrm");
	   console.log(frm);
	   //form태그에 action속성이 설정되어 있지 않아 설정하고 submit함수 호출하면 됨.
	   //동적으로 form으로 전송되는 servlet을 변경할 수 있다.
	   
	   frm.attr("action", "<%=request.getContextPath()%>/enrollstudy.do?userId=<%=loginMember.getUserId()%>");
	   frm.submit();
	   
}

const fn_update_validate=()=>{
	   
	   
	   return true;
}

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


function itemChange(){
	 
	var music = ["악기","미디/작곡","보컬","기타"];
	var language = ["영어","일어","중국어","스페인어","독일어","기타언어"];
	var liberalArts = ["글쓰기","독서모임","철학/토론","기타"];
	var currentEvent = ["주식","부동산","기타"]
	var certificate = ["회계","공인중개사","공무원/영어","공무원/국사","정보처리기사","기타"]	
	var hobby = ["쿠킹클래스","공예/꽃꽂이","공예/목공예","영화감상/토론","기타"]
	var theOthers= ["기타"]
	 
	var selectItem = $("#select1").val();
	 
	var changeItem;
	  
	if(selectItem == "음악"){
	  changeItem = music;
	}
	else if(selectItem == "외국어"){
	  changeItem = language;
	}
	else if(selectItem == "교양"){
	  changeItem =  liberalArts;
	}else if(selectItem == "시사"){
		changeItem = currentEvent;
	}else if(selectItem == "자격증"){
		changeItem = certificate;
	}else if(selectItem == "취미"){
		changeItem = hobby;
	}else if(selectItem == "기타"){
		changeItem = theOthers;
	}
	 
	$('#select2 option').remove()
	 
	for(var count = 0; count < changeItem.length; count++){                
	                var option = $("<option>"+changeItem[count]+"</option>");
	                $('#select2').append(option);
	            }
	 
	}













</script>













<%@ include file="/views/commons/footer.jsp" %></html>