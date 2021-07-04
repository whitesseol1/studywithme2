package com.studygroup.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.commons.MyRename;
import com.members.model.service.MemberService;
import com.members.model.service.StudygroupService;
import com.members.model.vo.Studygroup;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateStudyEndServlet
 */
@WebServlet("/updatestudy.do")
public class UpdateStudyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudyEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			
			
			/*
			 * String[] subjects=mr.getParameterValues("subject");
			 * sg.setSubject(String.join(",", subjects));
			 */
			sg.setStudyGroupName(mr.getParameter("groupname"));
			sg.setGroupIntroduction(mr.getParameter("studyintroduction"));
			
			String filePath=mr.getFilesystemName("profilephoto");
			    System.out.println(filePath+"업데이트값테스트");
			//파일이 있는지 없는지 확인
					//File객체를 이용해서 확인함
			        
					File f=mr.getFile("profilephoto");
					        
					//f가 null이면 파일이 없음, file.length()값이 0이면 없는것
					/*if(f.exists()) {*/
			         
					         
					if(f!=null&&f.length()>0) { 
						//새로추가된 파일이 있음.
						//이전파일을 지워줌
						File deleteFile=new File(path+mr.getParameter("oriProfilePhoto"));
						//if(deleteFile.exists()) {
							System.out.println(deleteFile.delete());
							sg.setStudyPhotoOriginalFile(mr.getOriginalFileName("profilephoto"));
							sg.setStudyPhotoRenamedFile(filePath);
						//}
					}else {
						filePath=mr.getParameter("oriProfilePhoto");
						
						 System.out.println(mr.getOriginalFileName("oriProfilePhoto"));
						 System.out.println(mr.getParameter("oriProfilePhoto"));
						 
						 sg.setStudyPhotoOriginalFile(mr.getParameter("oriProfilePhoto"));
						 sg.setStudyPhotoRenamedFile(mr.getParameter("reProfilePhoto"));
					}
				
			
				/*
				 * sg.setStudyPhotoOriginalFile(mr.getOriginalFileName("profilephoto"));
				 * sg.setStudyPhotoRenamedFile(mr.getFilesystemName("profilephoto"));
				 */
			
			
			sg.setLevel(mr.getParameter("level"));
			sg.setStudyHours(mr.getParameter("studyhour"));
			sg.setFrequency(mr.getParameter("frequency"));
			 String[] days=mr.getParameterValues("day");
			sg.setDay(String.join(",", days));
			 
			/* sg.setStartDate(mr.getParameter("startDate")); */
			sg.setStudyStartTime(mr.getParameter("startTime"));
			  System.out.println(mr.getParameter("time"));
			sg.setFixedTimeStatus(mr.getParameter("fixtime"));
			 String[] age=mr.getParameterValues("age");
			sg.setAge(String.join(",", age));
			 String[] totalnum=mr.getParameterValues("totalnum");
			sg.setTotalNumber(String.join(",", totalnum));
			sg.setGroupMeetingType(mr.getParameter("online"));
			
			String studyNo=request.getParameter("studyNo");
			sg.setStudygroupNo(Integer.valueOf(studyNo));
			
			Studygroup s=new MemberService().selectStudygroup(studyNo);
		
	    //int studyNo=Integer.parseInt(request.getParameter("studyNo"));
	    
	    
	    int result=new StudygroupService().updateStudy(sg);
	    int result2=new StudygroupService().updateFile2(sg);
	
	    String msg="";
		String loc="";
		
		/*
		 * HttpSession session=request.getSession();
		 * session.setAttribute("loginMemberStudent",s);
		 */
			
		 //String loc="/studygroupView?studygroupNo="+studyNo;
		if(result>0||result2>0) {
			msg="스터디 정보 수정 성공";
			loc="/studygroupView?studygroupNo="+studyNo;
		
		}else {
			msg="스터디 정보 수정 실패, 다시 시도해주세요";
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
