package com.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.members.model.service.StudygroupService;
import com.members.model.vo.StudyComment;

/**
 * Servlet implementation class InsertStudyCommentServlet
 */
@WebServlet("/studygroup/insertStudyComment")
public class InsertStudyCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudyCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studyRef=Integer.parseInt(request.getParameter("studyRef"));
		int studyCommentRef=Integer.parseInt(request.getParameter("studyCommentRef"));
		int studyCommentLevel=Integer.parseInt(request.getParameter("studyCommentLevel"));
		String comment=request.getParameter("content");
		String commentWriter=request.getParameter("commentWriter");
		
		StudyComment sc=new StudyComment();
		sc.setCommentReference(studyCommentRef);
		sc.setStudycommentLevel(studyCommentLevel);
		sc.setStudygroupNo(studyRef);
		sc.setCommentWriter(commentWriter);
		sc.setCommentContent(comment);
		
		int result=new StudygroupService().insertStudyComment(sc);
		String msg="";
		String loc="";
		loc="/studygroupView?studygroupNo="+studyRef;
		
		if(result>0) {
			//등록성공
			msg="댓글등록 성공";
			
		}else {
			//등록실패
			msg="댓글등록 실패";
			
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
