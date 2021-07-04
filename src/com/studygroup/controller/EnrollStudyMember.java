package com.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.members.model.service.MemberService;
import com.members.model.service.StudygroupService;
import com.members.model.vo.Student;

/**
 * Servlet implementation class EnrollStudyMember
 */
@WebServlet("/enrollstudyMember")
public class EnrollStudyMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollStudyMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String studentId=request.getParameter("studentId");
	     int studyNo=Integer.parseInt(request.getParameter("studyNo"));
	     
	     int result=new StudygroupService().enrollstudyMember(studentId, studyNo);
	     int result2=new StudygroupService().insertEnrollStudy(studentId, studyNo);
	     
	     String msg="";
	     String loc="/studygroupView?studygroupNo="+studyNo;
	     if(result>0&& result2>0) {
				//등록성공
	    	 Student s=new MemberService().selectStudent(studentId);
				   
	    	        
	    	    HttpSession session=request.getSession();
				session.setAttribute("loginMemberStudent",s);
	    	 
	    	 
				msg="모임등록 성공";
				
			}else {
				//등록실패
				msg="모임등록 실패";
				
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/views/commons/msg.jsp")
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
