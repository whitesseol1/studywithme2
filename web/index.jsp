<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="views/commons/header.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%-- <script src="<%=request.getContextPath()%>/js/jquery.bxslider.min.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/css/jquery.bxslider.min.css"></script> --%>

<style>

  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
    width: 70%;
    
    margin: auto;
  }
   .img{
   margin-top:50px;
  } 
  .img:hover{
  cursor:pointer;
  }
  a{
  color:white;
  text-decoration:none;
  
  -webkit-transition: 0.5s;
    -moz-transition: 0.5s;
    -o-transition: 0.5s;
    -ms-transition: 0.5s;
    transition: 0.5s;
  }
  
  a:hover{
  color:#ffa089;
  text-decoration:none;
  
  -webkit-transform: scale(1.2,1.2);
    -moz-transform: scale(1.2,1.2);
    -o-transform: scale(1.2,1.2);
    -ms-transform: scale(1.2,1.2);
    transform: scale(1.2,1.2);
 
  }
  
  #link{
  color:#e2725b;
  text-decoration:none;
  }
 
  </style>
  
<section id="content">


<div class="img">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="1"></li>
			    <li data-target="#myCarousel" data-slide-to="2"></li>
			    <li data-target="#myCarousel" data-slide-to="3"></li>
			  </ol>
			
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" role="listbox">
			    <!-- <div class="item active">
			      <img src="img_chania.jpg" alt="Chania">
			      <div class="carousel-caption">
			        <h3>Chania</h3>
			        <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
			      </div>
			    </div> -->
			
			   
			    </div>
			  
			
			  <!-- Left and right controls -->
			  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
  <!--   <div class="content">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
		
		  Indicators
		  <ul class="carousel-indicators">
		    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		    <li data-target="#myCarousel" data-slide-to="1"></li>
		    <li data-target="#myCarousel" data-slide-to="2"></li>
		  </ul>
		  
		  The slideshow
		  <div class="carousel-inner">
		   
		    
		  </div>
		  
		  Left and right controls
		  <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
		    <span class="carousel-control-prev-icon"></span>
		  </a>
		  <a class="carousel-control-next" href="#myCarousel" data-slide="next">
		    <span class="carousel-control-next-icon"></span>
		  </a>
		  
		</div>
		
		</div> -->
       <%--  <div id="imgcontainer"><img onclick="javascript:location.href='<%=request.getContextPath() %>';"  id="mainimg" src="<%=request.getContextPath() %>/upload/header/onlinestudy.jpg" > </div> --%>
        <%-- <div id="imgcontainer"><img onclick="javascript:location.href='<%=request.getContextPath() %>';"  id="mainimg2" src="<%=request.getContextPath() %>/upload/header/onlinestudy2.jpg" > </div> --%>
    </div>
    <br><br>
    
    <div class="img-cover"></div>
    <div id="text">
        <h2>스터디</h2>
        <h3>이젠 집에서 온라인으로 즐기세요!</h3><br>
        <h3>다양한 온라인 스터디모임과 강의가</h3>
        <h3>여러분을 기다립니다</h3>
        <br><br><br><br>       
        <a id="link" href="<%=request.getContextPath()%>/studyList">스터디모임 바로가기 ></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="link" href="<%=request.getContextPath()%>/logout">강의 바로가기 ></a>
        <br><br><br><br>
     </div>
</div> 







</section>

<style>
 img#mainimg{
    position: relative;
                                                                
    left-margin:0;
    width:70%;
    height:100%;
    /* top:-32px; */
    
    
 display:none;
    
  }


  
   img#mainimg2{
    position: relative;
                                                                
    left-margin:0;
    width:70%;
    height:100%;
    /* top:-32px; */
    left:-12%;
    
   display:none;
    
  }
  


  .content{display:inline-flex; margin-left:6%;}

  #text{text-align:center; font-family: 'Nanum Gothic Coding', monospace;}

</style>




<script>


	
	
	
	

      
       ﻿$(document).ready(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/ajax/main.do",
				dataType:"json",
				success:data=>{
					console.log(data);
					//const table=$("<table>");
					//const list=data.split("\n");
					//console.log(list);
					for(let i=0;i<data.length;i++){
						/* let div=$("<div>").attr("class","carousel-item "+(i==0?"active":"")); */
						let div=$("<div>").attr("class","item "+(i==0?"active":""));
						 let a=$("<a>").attr("href","<%=request.getContextPath()%>/studygroupView?studygroupNo="+data[i]['studygroupNo']); 
						let img=$("<img>").attr({
							"src":"<%=request.getContextPath()%>/upload/StudyInfo/"+data[i]['studyPhotoRenamedFile'],
							"width":"250",
							"height":"150"
							 <%-- "onclick":"javascript:location.href='<%=request.getContextPath()%>/studygroupView?studygroupNo='"+data[i]['studygroupNo'] --%>
									 
							    });
						let div2=$("<div>").attr("class","carousel-caption");
						/* let h3=$("<h3>").html(data[i]['studyGroupName']); */
						let h3=$("<h3>");
						a2=$("<a>").attr("href","<%=request.getContextPath()%>/studygroupView?studygroupNo="+data[i]['studygroupNo']).html(data[i]['studyGroupName']);
						h3.append(a2);
						
						/* let p=$("<p>").html(data[i]['startDate'].substring(5,7)+"월 "+data[i]['startDate'].substring(8,10)+"일 시작"); */
						let p=$("<p>");
						a3=$("<a>").attr("href","<%=request.getContextPath()%>/studygroupView?studygroupNo="+data[i]['studygroupNo']).html(data[i]['startDate'].substring(5,7)+"월 "+data[i]['startDate'].substring(8,10)+"일 시작");
						p.append(a3);
						
						
						
						 a.append(img);
						div.append(a);  
					     /* div.append(img);  */
					     
					     
					    div2.append(h3).append(p);
					    div.append(div2);
					    
					    console.log(div);
					    $(".carousel-inner").append(div);
						//let data=list[i].split(",");
						<%-- console.log(data);
						let li=$("<li>");
						let subject=$("<div>").html(data[i]['subject]']);
						//let phone=$("<td>").html(data[1]);
						let img=$("<img>").attr({"src":"<%=request.getContextPath()%>/upload/StudyInfo/"+data[i]['studyPhotoRenamedFile'],"onclick":"<%=request.getContextPath()%>/studygroupView?studygroupNo="+data[0],"width":"100px","height":"100px"});
						li.append(subject).append(img);
						//table.append(tr);
						$("#mainimg").append(li); --%>
						 };
						 
					}
				});
			});
		/* ); */


</script>








<%@ include file="views/commons/footer.jsp" %>