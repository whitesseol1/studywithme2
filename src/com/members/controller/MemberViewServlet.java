package com.members.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.commons.AESCryptor1;
import com.members.model.service.MemberService;
import com.members.model.vo.Member;

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet("/memberView.do")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub			
			String userId=request.getParameter("userId");
			
			Member m=new MemberService().checkDuplicateId(userId);
			System.out.println(m);
			/*
			 * try { m.setPhone(AESCryptor1.decrypt(m.getPhone()));
			 * m.setEmail(AESCryptor1.decrypt(m.getEmail()));
			 * 
			 * 
			 * }catch(Exception e) { e.printStackTrace(); }
			 */
			
			//m이 null이면 회원정보 수정불가(일치하는 회원없음)
			// msg페이지로 이동 알람메세지를 출력하고 로그인을 취소하고 메인화면으로 이동.
			//m이 null이 아니면 회원정보 수정으로 돌아감.
			// 회원수정 페이지로 이동시킴
			
			String view="";
			String loc="/logout";
			String msg="";
			if(m != null) {
				view="/views/commons/memberView.jsp";
				request.setAttribute("userId", userId);
			}else {
				view="/views/commons/msg.jsp";
				msg="가입된 회원이 아닙니다.";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.setAttribute("member", m);
			
			request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
