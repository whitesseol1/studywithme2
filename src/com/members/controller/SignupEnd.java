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
import com.commons.AESCryptor1;
import com.members.model.service.MemberService;
import com.members.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class SignupEnd
 */
@WebServlet(name = "signupend", urlPatterns = "/signupend.do")
public class SignupEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupEnd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "잘못된 방식으로 요청되었습니다.");
			request.setAttribute("loc", "/signup/signup");
			request.getRequestDispatcher("/views/commons/msg.jsp").forward(request, response);
			return;
		}

		String path = getServletContext().getRealPath("/upload/profile/");

		MultipartRequest mr = new MultipartRequest(request, path, (1024 * 1024 * 10), "UTF-8", new MyRename());

		Member m = new Member();
		m.setUserId(mr.getParameter("userId"));
		m.setPassword(mr.getParameter("password"));
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

		m.setEmail(mr.getParameter("email"));
		m.setPhone(mr.getParameter("phone"));

		m.setAddress(mr.getParameter("address"));
		m.setGender(mr.getParameter("gender"));
		
		String filePath=mr.getFilesystemName("profilephoto");
		File f=mr.getFile("profilephoto");
		
			
			
			
			  m.setOriginalFileName(mr.getOriginalFileName("profilephoto"));
			  
			  m.setRenamedFileName(mr.getFilesystemName("profilephoto"));
	
				
				
				 System.out.println(mr.getOriginalFileName("profilephoto"));
				 System.out.println(mr.getParameter("profilephoto"));
				 
				 
			
			/*
			 * m.setOriginalFileName(mr.getParameter("profilephoto"));
			 * m.setRenamedFileName(mr.getParameter(path));
			 */
		

		System.out.println(mr.getFilesystemName("profilephoto") + "사진값test");
		m.setStudentTeacherStatus(mr.getParameter("teacherstudent"));

		System.out.println(m);
		int result = new MemberService().insertMember(m);
		String msg = "";
		String loc = "";
		String userId = "";

		if (result > 0) {
			userId = m.getUserId();
			request.setAttribute("userId", userId);
			if (m.getStudentTeacherStatus().equals("student")) {
				msg = "다음 사항을 입력해주세요";
				loc = "/enrollstudent";
			} else {
				msg = "다음 사항을 입력해주세요";
				loc = "/enrollteacher";
			}

		} else {
			msg = "등록에 실패하였습니다. 다시 입력해주세요";
			loc = "/signup/signup";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);

		request.getRequestDispatcher("/views/commons/msg.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
