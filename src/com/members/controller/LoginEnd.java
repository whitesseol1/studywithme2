package com.members.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.members.model.service.MemberService;
import com.members.model.vo.Member;
import com.members.model.vo.Student;
import com.members.model.vo.Teacher;

/**
 * Servlet implementation class LoginEnd
 */
@WebServlet(name="loginservlet", urlPatterns = "/login")
public class LoginEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//로그인 처리 로직
		// client가 보낸 id값과 패스워드 값을 받아와 DB에 id와 패스워드가 일치하는 row가 있는지 확인
		//있으면 그 해당 ROW데이터를 가져오고 없으면 null값을 반환한다.
		//1. client가 보낸 값 가져오기 -> request.getParameter()매소드를 이용
		String userId=request.getParameter("userId");
		String pw=request.getParameter("password");
		//2. 가져온 값이 DB(web계정의 member테이블)에 있는지 확인
		Member m=new MemberService().login(userId,pw);
		System.out.println("login로직실행");
		
		//로그인을 했을때 아이디 저장을 체크한경우 전송된 아이디값을 유지하는 로직
		//아이디값을 유지하려면 session,(context),cookie 중 하나에 보관
		//Cookie에 저장해서 관리하자.
		//1. client가 아이디 저장항목을 체크했는지 확인
		
		//checkbox에 대한 값을 가져오는 것을 확인해보자
		String saveId=request.getParameter("saveId");
		System.out.println("체크박스 : "+saveId);
		//check했으면 "on" 안했으면 null 
		if(saveId!=null) {
			 Cookie c = new Cookie("saveId",userId);
			//쿠키에 설정 -> 7일
			 c.setMaxAge(60*60*24*7);
			 response.addCookie(c);
		}else {
			 Cookie c = new Cookie("saveId","");
			 c.setMaxAge(0);
			 response.addCookie(c);
		}
		
		
		
		
		
		//3. DB에서 반환받은 결과를 가지고 응답할 페이지를 선정
		// m변수가 null이면 로그인 실패, m값이 null이 아니면 로그인 성공
		if(m!=null) {
			//로그인 성공
			//로그인 성공에 대한 데이터를 유지하기 위해서 그 정보를 보관
			//보관 객체는 request, session, context 3가지 객체가 있음
			//request.setAttribute("loginMember", m);  //이걸로 저장하면 유지가 안됨, 요청이 들어올때 데이터가 사라짐
			HttpSession session=request.getSession();
			session.setAttribute("loginMember", m);
			
			Student s=new MemberService().selectStudent(userId);
			if(s!=null) {
				session.setAttribute("loginMemberStudent",s);
			}
			Teacher t=new MemberService().selectTeacher(userId);
			if(t!=null) {
				session.setAttribute("loginMemberTeacher", t);
			}
			
			//session객체에 대한 설정 및 정보를 가져오는 매소드가 있음
			//getCreateTime() -> 세션생성시간
			//getLastAccessedTime() -> 마지막 요청시간
			//getMaxInactiveInterval() -> 최대허용시간
			
			System.out.println("최대유지시간 : "+session.getMaxInactiveInterval());
			
			//setMaxInactiveInterval() -> 최대허용시간을 설정(초)
			//session.setMaxInactiveInterval(10);
			
			System.out.println("최대유지시간 : "+session.getMaxInactiveInterval());
			
		
			
			
			//페이지 전환하기 ->로그인 성공, 실패 -> 메인페이지로 이동하자
			//RequestDispatcher / sendRedirect  
			
			
//			RequestDispatcher rd=request.getRequestDispatcher("");
//			rd.forward(request, response);
			
			response.sendRedirect(request.getContextPath()+"/index.jsp"); //계속 /login페이지 불러오지않게
		}else {
			//로그인 실패
			//로그인 실패에 대한 에러메세지를 띄워주고 메인화면으로 이동
			//1. 에러메세지를 출력해주는 별도의 msg출력전용 page(jsp)를 구성
			//로그인 실패에 대한 에러메세지는 요청에 대한 응답으로 종료되는 데이터 -> request객체
			request.setAttribute("msg", "로그인실패, 아이디/패스워드를 확인하세요" );
			//2. 에러메세지출력 후 메인화면으로 전환
			//페이지에 전환할 주소값도 같이 전달을 한다.
			request.setAttribute("loc", "/login/login");
			
			
			
			RequestDispatcher rd=request.getRequestDispatcher("/views/commons/msg.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
