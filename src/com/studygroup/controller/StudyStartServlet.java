package com.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.model.service.StudygroupService;

/**
 * Servlet implementation class StudyStartServlet
 */
@WebServlet("/studystart")
public class StudyStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyStartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studyNo=request.getParameter("studyNo");
		int result=0;
		result=new StudygroupService().studyStart(studyNo);
		String msg="";
		String loc="";
		
		if(result>0) {
			msg="스터디가 시작되었습니다";
			loc="/studygroupView?studygroupNo="+studyNo;
		
		}else {
			msg="스터디 시작을 다시 시도해주세요";
			loc="/studygroupView?studygroupNo="+studyNo;
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
