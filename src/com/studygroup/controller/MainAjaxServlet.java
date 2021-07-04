package com.studygroup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.members.model.service.StudygroupService;
import com.members.model.vo.Studygroup;

/**
 * Servlet implementation class MainAjaxServlet
 */
@WebServlet("/ajax/main.do")
public class MainAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Studygroup> list=new StudygroupService().selectStudygroupList(1,100);
		List<Studygroup> list1=new ArrayList<Studygroup>();
		for(Studygroup s : list) {
		   if(!s.getStudyStatus().equals("모임종료")) {
			   list1.add(s);
		   }
		}
		//request.setAttribute("list", list1);
		
		String csv="";
//		for(int i=0;i<list1.size();i++) {
//			if(i!=0) csv+="\n";
//			csv+=list1.get(i);
//			
//			
//		}
		ObjectMapper mapper=new ObjectMapper();
		//System.out.println(csv);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(mapper.writeValueAsString(list1));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
