<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/commons/header.jsp" %>
<section id="content" style="font-family: 'Nanum Gothic Coding', monospace;">
<div id="login-container2">
            <%-- <%if(loginMember==null){ %> --%>
                <form id="loginFrm" action="<%=request.getContextPath() %>/login" method="post" 
                onsubmit="return fn_login_validate();">
                    <table>
                        <tr>
                            <td>
                              <input type="text" name="userId" id="userId" placeholder="아이디"
                              value="<%=saveId!=null?saveId:""%>">
                              </td>
                              <td rowspan="2">
                                 <input type="submit" value="로그인">
                              </td>
                        </tr>
                        <tr>
                          <td>
                             <input type="password" id="password" name="password" placeholder="비밀번호">
                          </td>
                          
                        </tr>
                        <tr>
                           <td>
                             <input type="checkbox" name="saveId" id="saveId" <%=saveId!=null?"checked" : "" %>>
                             <label for="saveId">아이디저장</label>
                             <%-- <input type="button" value="회원가입" onclick="location.replace('<%=request.getContextPath()%>/memberenroll.do')"> --%>
                             </td>
                        </tr>
                    </table>
                </form>
     </section>
<%@ include file="/views/commons/footer.jsp" %></html>