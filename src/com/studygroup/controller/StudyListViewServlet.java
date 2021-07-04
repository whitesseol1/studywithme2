package com.studygroup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.members.model.service.StudygroupService;
import com.members.model.vo.Studygroup;




/**
 * Servlet implementation class StudyListViewServlet
 */
@WebServlet("/studyList")
public class StudyListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage;
		int numPerpage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
			
		}catch(NumberFormatException e) {
			cPage=1;
		}
		try {
			numPerpage=Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e) {
			numPerpage=9;
		}
		
		List<Studygroup> list=new StudygroupService().selectStudygroupList(cPage,numPerpage);
		List<Studygroup> list1=new ArrayList<Studygroup>();
		for(Studygroup s : list) {
		   if(!s.getStudyStatus().equals("모임종료")) {
			   list1.add(s);
		   }
		}
		request.setAttribute("list", list1);
		
		
		int totalData=new StudygroupService().selectStudygroupCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";
		
		if(pageNo==1) {
			pageBar="<span>[이전]</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
			+"/studyList?cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/studyList?cPage="+pageNo+"'>"+pageNo+"</a>";
				
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}
		else {
			pageBar+="<a href='"+request.getContextPath()
			+"/studyList?cPage="+pageNo+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/studygroup/studyList.jsp")
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
