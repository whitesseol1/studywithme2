package com.members.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.model.service.MemberService;
import com.members.model.vo.Student;
import com.members.model.vo.Teacher;

/**
 * Servlet implementation class TeacherUpdateServlet
 */
@WebServlet("/teacherupdate.do")
public class TeacherUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String academicCareer=request.getParameter("academicCareer");
		String collegeName=request.getParameter("collegeName");
		String major=request.getParameter("major");
		String[] certificate=request.getParameterValues("certificate");
		String career=request.getParameter("career");
		String selfIntroduction=request.getParameter("selfIntroduction");
		
		Teacher t=new Teacher();
		t.setUserId(userId);
		t.setAcademicCareer(academicCareer);
		t.setCollegeName(collegeName);
		t.setMajor(major);
		t.setCertificate(String.join(",", certificate));
		t.setCareer(career);
		t.setSelfIntroduction(selfIntroduction);
				
		int result=new MemberService().setTeacher(t);		
		
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
