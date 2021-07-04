package com.members.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.model.service.MemberService;
import com.members.model.vo.Student;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/studentupdate.do")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
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
		
		int result=new MemberService().updateStudent(s);
		String msg="";
		String loc="";
		if(result>0) {
			msg="수정이 성공적으로 완료되었습니다";
			loc="/nextupdate.do?userId="+userId;
			
		}else {
			msg="수정이 되지 않았습니다. 다시 시도해주세요.";
			loc="/nextupdate.do?userId="+userId;
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
