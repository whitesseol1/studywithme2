package com.members.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.model.service.MemberService;
import com.members.model.vo.Member;

/**
 * Servlet implementation class PasswordUpdateEndServlet
 */
@WebServlet(name="updatePasswordEnd", urlPatterns = "/updatePasswordEnd")
public class PasswordUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String curPw=request.getParameter("password");
		String newPw=request.getParameter("password_new");
		
		//1. 아이디 있는지여부, 현재 패스워드가 일치한지 여부
		Member m=new MemberService().login(userId,curPw);
		String msg="";
		String loc="";
		String script="";
		if(m!=null) {
			//비밀번호 수정로직실행
			int result=new MemberService().updatePassword(userId,newPw);
			msg=result>0?"비밀번호수정완료!":"비밀번호수정실패";
			loc="/";
			script="window.close();";
			
			
			
			
		}else {
			//다시 돌아감.. 비밀번호 수정페이지로
			msg="현재 비밀번호가 일치하지 않아 비밀번호를 수정할 수 없습니다.";
			loc="/updatePassword?userId="+userId; //이걸 넣어야 id가 나옴
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc", loc);
		request.setAttribute("script", script);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
