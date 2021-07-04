<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.members.model.vo.Studygroup" %>
<%@ page import="java.util.List" %>

<%
List<Studygroup> list=(List<Studygroup>)request.getAttribute("list");
String pagebar=(String)request.getAttribute("pagebar");

String searchType=request.getParameter("searchType")==null?"":request.getParameter("searchType");
String keyword=request.getParameter("searchKeyword")==null?"":request.getParameter("searchKeyword");


%>

<%@ include file="/views/commons/header.jsp" %>
<style type="text/css">
 section#listcontainer {text-align:center;}

 div#search-container {margin:0 0 10px 0; padding:3px; }
    
    div#search-teamLeader{display:inline-block;}
    div#search-studyName{display:none;}
    div#search-studySubject{display:none;}
button{border-style: none; background-color:#ffa089; width:50px; height:25px;margin-left:10px;}
button:hover{cursor:pointer; color:white;}
</style>



<section id="listcontainer" >
       <h3 style="margin-top:100px;">나에게 맞는 스터디모임을 찾아보세요</h3>
       <div id="search-container">
         <select id="searchType">           
           <option value="teamLeader" <%=searchType.equals("teamLeader")?"selected":"" %>>모임장 검색</option>
           <option value="studyName" <%=searchType.equals("studyName")?"selected":"" %>>스터디이름 검색</option>
           <option value="studySubject" <%=searchType.equals("studySubject")?"selected":"" %>>스터디과목 검색</option>        
         </select>
         <div id="search-teamLeader">
           <form action="<%=request.getContextPath()%>/studygroup/searchMember">
        			<input type="hidden" name="searchType" value="teamLeader" >
        			<input type="text" name="searchKeyword" size="25" 
        			placeholder="검색할 모임장아이디" value='<%=searchType.equals("teamLeader")?keyword:"" %>'>
        			<button type="submit">검색</button>
        		</form>      
         </div>
         <div id="search-studyName">
        		<form action="<%=request.getContextPath()%>/studygroup/searchMember">
        			<input type="hidden" name="searchType" value="studyName">
        			<input type="text" name="searchKeyword" size="25" 
        			placeholder="검색할 스터디이름" value='<%=searchType.equals("studyName")?keyword:"" %>'>
        			<button type="submit">검색</button>
        		</form>
        	</div>
        	 <div id="search-studySubject">
        		<form action="<%=request.getContextPath()%>/studygroup/searchMember">
        			<input type="hidden" name="searchType" value="studySubject">
        			<input type="text" name="searchKeyword" size="25" 
        			placeholder="검색할 스터디과목" value='<%=searchType.equals("studySubject")?keyword:"" %>'>
        			<button type="submit">검색</button>
        		</form>
        	</div>
            <div>
              <form id="numPerFrm" action="" style="display:none;">
              </form>
            </div>
	   </div>
	   
	   
     <div id="photocontainer" style="display:flex">
	     <%for(int i=0;i<list.size();i++){%>
	    	
	     		<div id="photocontainer1">
	     		<img id="studyphoto" onclick="javascript:location.href='<%=request.getContextPath()%>/studygroupView?studygroupNo=<%=list.get(i).getStudygroupNo()%>';" src="<%=request.getContextPath()%>/upload/StudyInfo/<%=list.get(i).getStudyPhotoRenamedFile() %>" alt=renamedFileName>
	     		<p ><a id="a" href="<%=request.getContextPath()%>/studygroupView?studygroupNo=<%=list.get(i).getStudygroupNo()%>"><%=list.get(i).getStudyGroupName() %>/<br>시작일:<%=list.get(i).getStartDate().substring(5, 7) %>월 <%=list.get(i).getStartDate().substring(8,10) %>일 </a></p>
	     		</div>
      <% if(i!=0&&i%3!=0&& i%3!=1){%>
               </div>
	     		<br>
	     		<div id="photocontainer" style="display:flex">
	     	<%} %>
	  
        <%} %>
	     
      </div>
      
   
  

       <div id="pageBar">
        	<%=request.getAttribute("pageBar")%>
        </div>


</section>



<style>
#studyphoto:hover{cursor:pointer;}

/* 페이지바 */
div#pageBar{margin-top:5px; margin-right:20px; text-align:center; background-color:white;}
	div#pageBar span{color: #841b2d; margin-left:10px; }

#photocontainer1{margin-left:12%;}
/* #photocontainer ul li {float:left; width:200px; height:200px; margin-left:12%;} */


#studyphoto{width:200px; height:200px;}
div#pageBar{display:block; margin-top:5%;margin-bottom:5%; }


section#listcontainer{
	background-color:white;/* float:left; */width:inherit; min-height:400px;
	vertical-align: middle;

}
</style>

<script>

$("#searchType").change(e => {
	const teamLeader=$("#search-teamLeader");
	const studyName=$("#search-studyName");
	const studySubject=$("#search-studySubject");
	const value=$(e.target).val();//userId OR userName OR gender
	
	teamLeader.css("display","none");
	studyName.css("display","none");
	studySubject.css("display","none");
	
	
	$("#search-"+value).css("display","inline-block");
	
});



<%-- $(function(){   		

	
	if(<%=keyword.equals("")%>){
		//검색을 안했음
		$("#numPerFrm").attr("action","<%=request.getContextPath()%>/studyList");
		$("#numPerFrm").append($("<input>").attr({
			type:"hidden",name:"cPage",value:"<%=request.getParameter("cPage")%>"
		}));
		$("#numPerFrm").append($("<input>").attr({
			type:"hidden",name:"numPepage",value:"<%=request.getParameter("numPerpage")%>"
		}));
	}else{ 
		//검색을 했음
		$("#numPerFrm").attr("action","<%=request.getContextPath()%>/studygroup/searchMember");
		$("#numPerFrm").append($("<input>").attr({
			type:"hidden",name:"cPage",value:"<%=request.getParameter("cPage")%>"
		}));
		$("#numPerFrm").append($("<input>").attr({
			type:"hidden",name:"searchType",value:"<%=searchType%>"
		}));
		$("#numPerFrm").append($("<input>").attr({
			type:"hidden",name:"searchKeyword",value:"<%=keyword%>"
		}));
	}
	
	
	$("#numPerFrm").submit();//제출하기
	
	
} --%>



function fn(){
$("#studyphoto").get(0).click(e=>{
<%-- 	for(var i=0;i<<%=list.size()%>;i++){
	   $("#a").get(i).click();
	     } --%>
	     $("#a").get(0).click();
	  });
}
</script>








<%@ include file="/views/commons/footer.jsp" %></html>