package com.members.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.commons.MyRename;
import com.members.model.service.MemberService;
import com.members.model.vo.Studygroup;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class EnrollStudyServlet
 */
@WebServlet("/enrollstudy.do")
public class EnrollStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollStudyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "잘못된 방식으로 요청되었습니다.");
			request.setAttribute("loc", "/signup/signup");
			request.getRequestDispatcher("/views/commons/msg.jsp")
			.forward(request, response);
			return;
		}
		
     String path=getServletContext().getRealPath("/upload/StudyInfo/");
		
		MultipartRequest mr=new MultipartRequest(request,path,(1024*1024*10),
				"UTF-8",new MyRename());
		
		Studygroup sg=new Studygroup();
		
		sg.setMemberId(mr.getParameter("userId"));
		String[] subjects=mr.getParameterValues("subject");
		sg.setSubject(String.join(",", subjects));
		sg.setStudyGroupName(mr.getParameter("groupname"));
		sg.setGroupIntroduction(mr.getParameter("studyintroduction"));
		sg.setStudyPhotoOriginalFile(mr.getOriginalFileName("profilephoto"));
		sg.setStudyPhotoRenamedFile(mr.getFilesystemName("profilephoto"));
		sg.setLevel(mr.getParameter("level"));
		sg.setStudyHours(mr.getParameter("studyhour"));
		sg.setFrequency(mr.getParameter("frequency"));
		 String[] days=mr.getParameterValues("day");
		sg.setDay(String.join(",", days));
		sg.setStartDate(mr.getParameter("startDate"));
		sg.setStudyStartTime(mr.getParameter("startTime"));
		  System.out.println(mr.getParameter("time"));
		sg.setFixedTimeStatus(mr.getParameter("fixtime"));
		 String[] age=mr.getParameterValues("age");
		sg.setAge(String.join(",", age));
		 String[] totalnum=mr.getParameterValues("totalnum");
		sg.setTotalNumber(String.join(",", totalnum));
		sg.setGroupMeetingType(mr.getParameter("online"));
		
		 System.out.println(sg);
		 
		 String userId=mr.getParameter("userId");
		
		 int result=new MemberService().insertStudygroup(sg);
		 int result2=new MemberService().insertteamLeaderStatus(userId);
		 
			String msg="";
			String loc="";
			
			
			if(result>0) {
				
				request.setAttribute("userId", userId);
				
					msg="스터디모임 공지가 등록되었습니다.";
					loc="/studyList";
				
				
			}else {
				msg="등록에 실패하였습니다. 다시 입력해주세요";
				loc="/studyrecruit.do";
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
