package com.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.model.service.StudygroupService;

/**
 * Servlet implementation class DeleteStudyComment
 */
@WebServlet("/studygroup/deleteStudyComment")
public class DeleteStudyComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudyComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studyCommentNo=Integer.parseInt(request.getParameter("studyCommentNo"));
		
		int result=new StudygroupService().deleteStudyComment(studyCommentNo);
		  
		int studyGroupNo=Integer.parseInt(request.getParameter("studygroupNo"));
		String msg="";
		if(result>0) {
			msg="댓글삭제성공";
		}else {
			msg="댓글삭제실패";
		}
		
		
		String loc="/studygroupView?studygroupNo="+studyGroupNo;
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
