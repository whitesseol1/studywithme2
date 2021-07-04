package com.members.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.model.service.MemberService;
import com.members.model.vo.Member;

/**
 * Servlet implementation class CheckDuplicatedServlet
 */
@WebServlet("/checkDuplicateId")
public class CheckDuplicatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDuplicatedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트가 전송한 id값이 DB에 있는지 없는지 확인해주는 서비스
				String userId=request.getParameter("userId");
				
				Member m=new MemberService().checkDuplicateId(userId);
				
				//결과에서 m이 null이면 중복되지 않음 / m이 null이 아니면 중복됨.
				request.setAttribute("result", m);
				
				request.getRequestDispatcher("/views/commons/checkDuplicateId.jsp")
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
