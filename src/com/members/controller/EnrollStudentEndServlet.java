package com.members.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.members.model.service.MemberService;
import com.members.model.vo.Member;
import com.members.model.vo.Student;

/**
 * Servlet implementation class EnrollStudentEndServlet
 */
@WebServlet("/studentenrollend.do")
public class EnrollStudentEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollStudentEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String[] subjects=request.getParameterValues("interestingSubject");
		Student s=new Student();
		s.setUserId(userId);
		s.setInterestingSubject(String.join(",", subjects));
		 
		int result=new MemberService().setSubjectMember(s);
		         //혹시 로그인 되있을경우
		
		        //1. session객체를 불러오기
				HttpSession session=request.getSession(false);
				
				//2. session이 있으면 삭제, 없으면 통과
				if(session!=null) {
					//세션삭제하기 -> session.invalidate();
					session.invalidate();
				}
				
		String msg="";
		String loc="";
			if(result>0) {
				msg="가입을 축하합니다. 로그인 해 주세요.";
				loc="/login/login";
				
			}else {
				msg="가입이 되지 않았습니다. 다시 가입해주세요.";
				loc="/enrollstudent";
			}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/commons/msg.jsp")
		.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
