<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="com.members.model.vo.Member, com.commons.listener.loginCheckListener" %> 
<%@ page import="com.members.model.vo.Student, com.members.model.vo.Teacher" %>
 

 <%
    
    //Member loginMember=(Member)request.getAttribute("loginMember"); ->데이터 유지가 안됨
    //HttpSession객체에 저장된 loginMember가져오기 
    
  Member loginMember=(Member)session.getAttribute("loginMember"); 
    
  
    Cookie[] cookies=request.getCookies();
    String saveId=null;
    if(cookies!=null){
    	for(Cookie c:cookies){
    		if(c.getName().equals("saveId")){
    			saveId=c.getValue();
    			break;
    		}
    		
    	}
    }
    
  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudyWithMe</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style1.css">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

</head>

<body>
   <div id="container"  style="background-color:white;">
       <header id="header" style="background-color:white;">
            <div id="imgcontainer"><img onclick="javascript:location.href='<%=request.getContextPath() %>';" id="title" src="<%=request.getContextPath()%>/upload/header/title.png">  </div>
            <div class="login-container" >
             <%if(loginMember==null){ %> 
                    <table style="float:right; margin-right:10px;">
                        <tr>
                            <td>                           
                              <a style="text-decoration:none;color:#c32148;" href="<%=request.getContextPath()%>/login/login">로그인</a>                              
                              </td>
                              <td>
                              |
                              </td>
                              <td>
                              <a style="text-decoration:none;color:#c32148" href="<%=request.getContextPath()%>/signup/signup">회원가입</a>
                              </td>
                        </tr>                        
                    </table>
               
                 <%} else{ %> 
                	<table style=" width:100%; float:right;  margin-right:10px;" id="logged-in">
                	    <%-- <tr>
                	       <td colspan="2">
                	        <%=loginMember.getUserId() %>님, 환영합니다.
                	       </td>
                	    </tr>
                	    <tr>
                	       <td colspan="2">
                	       현재접속자수 : <%=loginCheckListener.getCount() %>
                	       </td>
                	    </tr> --%>
                	    <tr>
                	      <td>
                	      <a href="<%=request.getContextPath()%>/memberView.do?userId=<%=loginMember.getUserId()%>">내정보보기</a>
                	        <%--  <input type="button" value="내정보보기"
                	          onclick="location.assign('<%=request.getContextPath()%>/memberView.do?userId=<%=loginMember.getUserId()%>')"> --%>
                	      </td>
                	      <td>
                	      |
                	      </td>
                	      <td>
                	      <a href="<%=request.getContextPath()%>/logout">로그아웃</a>
                	         <%-- <input type="button" value="로그아웃"
                	         onclick="location.replace('<%=request.getContextPath()%>/logout');"> --%>
                	      </td>
                	    </tr>
                	</table>
          	<% }%> 
                
            </div>
            <nav id="menucontainer">
                <ul class="main-nav">
                   <li class="home"><a href="<%=request.getContextPath()%>">Home</a></li>
                   <li id="level"><a href="<%=request.getContextPath()%>/level/leveltest">레벨테스트</a></li>
                   <li id="study"><a href="<%=request.getContextPath()%>/studyList">스터디모임</a></li>
                   <li id="lecture"><a href="<%=request.getContextPath()%>/lecture/recruit">모집중인강의</a></li>
                   <li id="review"><a href="<%=request.getContextPath()%>/review/review">리뷰보기</a></li>
                   <%if(loginMember!=null&&loginMember.getUserId().equals("admin")){ %> 
                   <li id="admin-member">
                   <a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a>
                   </li>  
                    <%} %>           
                </ul> 
            </nav>
       </header>
      </div>
      
       <style>
       
       
       /* 메뉴관련스타일 */
	header nav {background:#ffa089; width:100%; margin-top:60px;}
	#menucontainer{margin-top:20px; margin-left:0px; height:2em;text-align:center;}
	/* ul태그의 가운데정렬 */
	ul.main-nav{
		/* width:80%; */
		display:table;
		padding:0px;
		margin:auto;
	}
	ul.main-nav li { 
		list-style-type: none; 
		width: 8em; 
		height: 2em;
		float: left; 
		text-align: center; 
		font-family: 'Nanum Gothic Coding', monospace;
		border-left: 1px #ff7f50 solid;
		background-color: #ffa089; 
	}
	ul.main-nav li:last-of-type{border-right:1px #ff7f50 solid;;}
	ul.main-nav li a {
		display: block;
		padding:.5em;
		text-decoration: none;
		color: #292929;
	}
       
       
   div#container{
	color:#cd5c5c;
	background-color:rgb(255, 255, 255);
	width:100%;
	height:130px;
	/* width:1366px; */
	
}

header{
	background-color:white;
	height:130px;
	position:relative;
	padding:0px 0 0 0;
	
}
       
       
       #title:hover{cursor:pointer;}
       
       a:link {color:#9b111e;}
       #imgcontainer{text-align:center; margin-top:3%;}
       #title{width:240px; height:70px;}
       header div.login-container
      div.login-container table#logged-in{}
       #container{}
    
      /*  #menucontainer{margin-top:0px; margin-left:0px; height:2em;text-align:center;} */
       
       
       
       </style>
    