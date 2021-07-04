package com.members.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.model.service.MemberService;
import com.members.model.vo.Lecture;
import com.members.model.vo.Member;
import com.members.model.vo.Student;
import com.members.model.vo.Studygroup;
import com.members.model.vo.Teacher;

/**
 * Servlet implementation class NextUpdate
 */
@WebServlet("/nextupdate.do")
public class NextUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		Member m=new MemberService().checkDuplicateId(userId);
		
		String msg="";
		String loc="";
		
		if(m!=null) {
		
		String studentTeacherStatus=m.getStudentTeacherStatus();
		
		
			 msg="";
			loc="";
			
			if(studentTeacherStatus.equals("student")) {				
				Student s=new MemberService().selectStudent(userId);
				if(s!=null) {
				request.setAttribute("Student", s);
						     if(s.getEnrollStudy()!=null) {
						    	 //System.out.println(s.getEnrollStudy()+"student enrollstudy테스트");
							String enrollStudy[]=s.getEnrollStudy().split(",");
							  
							    
							   List<Studygroup> sg1=new ArrayList();
								 for (int i=0;i<enrollStudy.length;i++) {
								  Studygroup sg=new MemberService().selectStudygroup(enrollStudy[i]);
								      //System.out.println(enrollStudy[i]+"배열i번째 테스트");
								   sg1.add(sg);
								   
								   
								   }
								 request.setAttribute("EnrollStudy", sg1); //sg배열저장
								   
						     }
							     if(s.getTeamLeaderStatus()!=null) {
									Studygroup sg=new MemberService().selectStudygroup2(userId);
									  System.out.println(sg + "teamleader테스트 sg");
									request.setAttribute("TeamleaderGroup", sg);
									  
							    }
							    
							    if(s.getEnrollLecture()!=null) {
							    	String enrollLecture[]=s.getEnrollLecture().split(",");
							    	
							    	List<Lecture> lectures=new ArrayList();
							    	
							    	for (int i=0; i<enrollLecture.length;i++) {
									Lecture lecture=new MemberService().selectLecture(enrollLecture[i]);
									lectures.add(lecture);
									
							    	}
							    	
							    	request.setAttribute("lectures", lectures); //lecture배열저장
							    }
							    
							    if(s.getLastLecture()!=null) {
							    	
							    	String lastlecture[]=s.getLastLecture().split(",");
							    	
							    	List<Lecture> lastlectures=new ArrayList();
							    	
							    	for(int i=0; i<lastlecture.length;i++) {
							    		Lecture lecture=new MemberService().selectLecture(lastlecture[i]);
							    		lastlectures.add(lecture);
							    		
							    	}
							    	
							    	request.setAttribute("lastlectures", lastlectures);
							    	
							    	
							    	
							    }
							    
							    
				
				request.setAttribute("userId", userId);
				System.out.println(s);
				loc="/views/commons/studentupdate.jsp";
				}else {
					loc="/views/commons/enrollStudent.jsp";
				}
			//student	
			}else {
				
				Teacher t=new MemberService().selectTeacher(userId);
			if(t!=null) {
				request.setAttribute("Teacher", t);
				
						if(t.getOpenLecture()!=null) {
							Lecture lecture=new MemberService().selectLecture2(userId);
							if(lecture.getLectureStatus().equals("강의예정")) {
							request.setAttribute("expectlecture", lecture);
							}else if(lecture.getLectureStatus().equals("강의중")){
								request.setAttribute("lecture", lecture);
							}
						}
				
				
							if(t.getLastLecture()!=null) {
								Lecture lastLecture=new MemberService().selectLecture2(userId);
								request.setAttribute("lastlecture", lastLecture);
							}
				
				request.setAttribute("userId", userId);
				loc="/views/commons/teacherupdate.jsp";
			
			
			
				}else {
					loc="/views/commons/enrollTeacher.jsp";
				}//teacher
			}
	}else {
			msg="잘못된 경로입니다.";
			loc="/memberView.do";
				
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/views/commons/msg.jsp")
			.forward(request, response);
		}
		
		request.getRequestDispatcher(loc)
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
