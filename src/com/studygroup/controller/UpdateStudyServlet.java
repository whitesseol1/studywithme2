package com.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.model.service.MemberService;
import com.members.model.service.StudygroupService;
import com.members.model.vo.Studygroup;

/**
 * Servlet implementation class UpdateStudyServlet
 */
@WebServlet("/updateStudy")
public class UpdateStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studyNo=Integer.parseInt(request.getParameter("studyNo"));
		Studygroup sg=new MemberService().selectStudygroup(String.valueOf(studyNo));
		
		
		String view="/views/studygroup/studygroupUpdate.jsp";
		
		request.setAttribute("Studygroup", sg);
	
	
	
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
