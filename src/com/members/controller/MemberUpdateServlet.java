package com.members.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.commons.MyRename;
import com.members.model.service.MemberService;
import com.members.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet(name="memberupdateservlet", urlPatterns = "/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
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
			request.setAttribute("loc", "/memberView.do");
			request.getRequestDispatcher("/views/commons/msg.jsp")
			.forward(request, response);
			return;
		}
		
		String path=getServletContext().getRealPath("/upload/profile/");
		
		MultipartRequest mr=new MultipartRequest(request,path,(1024*1024*10),
				"UTF-8",new MyRename());
		
		Member m=new Member();
		m.setUserId(mr.getParameter("userId"));
		
		m.setUserName(mr.getParameter("userName"));
		m.setAge(Integer.parseInt(mr.getParameter("age")));
				
		
		/*
		 * String email=""; String phone="";
		 * 
		 * 
		 * try { email=AESCryptor1.encrypt(mr.getParameter("email"));//암호화처리
		 * phone=AESCryptor1.encrypt(mr.getParameter("phone")); }catch(Exception e) {
		 * e.printStackTrace(); } m.setEmail(email); m.setPhone(phone);
		 */
		 				
		
		  m.setEmail(mr.getParameter("email")); m.setPhone(mr.getParameter("phone"));
		 
		
		m.setAddress(mr.getParameter("address"));
		m.setGender(mr.getParameter("gender"));
		//m.setOriginalFileName(mr.getOriginalFileName("profilephoto"));
		
		String filePath=mr.getFilesystemName("profilephoto");
		System.out.println(filePath+"업데이트값테스트");
		//파일이 있는지 없는지 확인
				//File객체를 이용해서 확인함
		        
				File f=mr.getFile("profilephoto");
				        
				//f가 null이면 파일이 없음, file.length()값이 0이면 없는것
				/*if(f.exists()) {*/
			try {	         
				         
				if(f!=null&f.length()>0) { 
					//새로추가된 파일이 있음.
					//이전파일을 지워줌
					File deleteFile=new File(path+mr.getParameter("oriProfilePhoto"));
					//if(deleteFile.exists()) {
						System.out.println(deleteFile.delete());
						m.setOriginalFileName(mr.getOriginalFileName("profilephoto"));
						m.setRenamedFileName(filePath);
					//}
				}else {
					filePath=mr.getParameter("oriProfilePhoto");
					m.setOriginalFileName(mr.getOriginalFileName("oriProfilePhoto"));
					
					 System.out.println(mr.getOriginalFileName("oriProfilePhoto"));
					 System.out.println(mr.getParameter("oriProfilePhoto"));
					 
					 m.setRenamedFileName(mr.getParameter("oriProfilePhoto"));
				}
			}catch(NullPointerException e) {
				System.out.println(f);
				
			}
		
		
		
		m.setStudentTeacherStatus(mr.getParameter("teacherstudent"));
		
		System.out.println(m);
		
		int result= new MemberService().updateMember(m);
		int result2= new MemberService().updateFile(m);
		
		String msg="";
		String loc="";
		System.out.println(result>0);
		if(result>0||result2>0) {
			msg="회원 정보 수정 성공";
			loc="/memberView.do";
			request.setAttribute("userId", mr.getParameter("userId"));
		}else {
			msg="회원 정보 수정 실패, 다시 시도해주세요";
			loc="/memberView.do";
		}
		
		request.setAttribute("userId", mr.getParameter("userId"));
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
