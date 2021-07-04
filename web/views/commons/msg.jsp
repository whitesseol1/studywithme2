<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
       String msg=(String)request.getAttribute("msg");
       String script=(String)request.getAttribute("script");
       String userId=(String)request.getAttribute("userId");
    
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시스템메세지</title>
</head>
<body style="font-family: 'Nanum Gothic Coding', monospace;">
    <script>
        alert('<%=msg%>');  
        //페이지를 닫아주기
        <%=script!=null?script:""%>
        /*  '나 "이 있어야 메세지 인식, 아니면 변수로..*/
        //페이지전환하는 로직구성
        <%if(userId==null){  %>
        location.replace('<%=request.getContextPath()%><%=request.getAttribute("loc")%>');
        <% }else{%>
        location.replace('<%=request.getContextPath()%><%=request.getAttribute("loc")%>?userId=<%=userId%>');
        <%}%>
        
    
    </script>



</body>
</html>