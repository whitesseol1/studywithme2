package com.studygroup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.members.model.service.StudygroupService;
import com.members.model.vo.Studygroup;

/**
 * Servlet implementation class StudygroupSearchMemberServlet
 */
@WebServlet("/studygroup/searchMember")
public class StudygroupSearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudygroupSearchMemberServlet() {
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
		
		//클라이언트가 보낸 값 가져오기
		String searchType1=request.getParameter("searchType");
		String searchType="";
		if(searchType1.equals("teamLeader")) {
		 searchType="Member_Id";
		}else if(searchType1.equals("studyName")) {
			searchType="StudyGroupName";
		}else if(searchType1.equals("studySubject")) {
			searchType="Subject";
		}
		String keyword=request.getParameter("searchKeyword");
		
		//pageBar 만들기
		int totalData=new StudygroupService().searchStudygroupCount(searchType,keyword);
		   System.out.println(totalData+"data테스트");
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		
		String pageBar="";
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
			
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/studyList?cPage="+(pageNo-1)
					+"&numPerpage="+numPerpage
					+"&searchType="+searchType+"&searchKeyword="+keyword+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
				
			}else {
				pageBar+="<a href='"+request.getContextPath()+"/studyList?cPage="+pageNo
						+"&numPerpage="+numPerpage
						+"&searchType="+searchType+"&searchKeyword="+keyword+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else{
			pageBar+="<a href='"+request.getContextPath()+"/studyList?cPage="+pageNo
					+"&numPerpage="+numPerpage
					+"&searchType="+searchType+"&searchKeyword="+keyword+"'>[다음]</a>";
			
		}
		
		request.setAttribute("pageBar", pageBar);
		
		
		List<Studygroup> result=new StudygroupService().searchStudygroup(searchType,keyword,cPage,numPerpage);
		   System.out.println(result+"리스트결과테스트");
		request.setAttribute("list", result);
		
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
