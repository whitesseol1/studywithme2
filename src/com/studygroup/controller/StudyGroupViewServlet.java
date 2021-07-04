package com.studygroup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.members.model.service.MemberService;
import com.members.model.service.StudygroupService;
import com.members.model.vo.Member;
import com.members.model.vo.Student;
import com.members.model.vo.StudyComment;
import com.members.model.vo.StudyMembers;
import com.members.model.vo.Studygroup;

/**
 * Servlet implementation class StudyGroupViewServlet
 */
@WebServlet("/studygroupView")
public class StudyGroupViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyGroupViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studygroupNo=Integer.parseInt(request.getParameter("studygroupNo"));
		
		String studygroupNo1=request.getParameter("studygroupNo");
		Studygroup sg=new MemberService().selectStudygroup(studygroupNo1);
		
		
		String view="";
		String loc="";
		String msg="";
		if(sg!= null) {
			Member m=new MemberService().checkDuplicateId(sg.getMemberId());
			Student s=new MemberService().selectStudent(sg.getMemberId());
			System.out.println(s.getEnrollStudy() +"studyview 테스트");
			
			//댓글도 가져오자
			List<StudyComment> comments=new StudygroupService().selectStudyComment(studygroupNo);
			List<StudyMembers> studyMembers=new StudygroupService().selectStudyMembers(studygroupNo);
			
			if(comments!=null) {
			  request.setAttribute("comments", comments);
			}
			
			if(studyMembers!=null) {
				request.setAttribute("studyMembers", studyMembers);
			}
			
			
			
			view="/views/studygroup/studygroupView.jsp";
			request.setAttribute("userId", sg.getMemberId());
			request.setAttribute("Studygroup", sg);
			request.setAttribute("Member", m);
			request.setAttribute("Student", s);
		}else {
			view="/views/commons/msg.jsp";
			msg="잘못된 경로입니다.";
			loc="/index.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		
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
