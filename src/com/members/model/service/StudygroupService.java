package com.members.model.service;



import java.sql.Connection;
import java.util.List;

import com.members.model.dao.StudygroupDao;
import com.members.model.vo.StudyComment;
import com.members.model.vo.StudyMembers;
import com.members.model.vo.Studygroup;

import static com.commons.JDBCTemplate.close;
import static com.commons.JDBCTemplate.commit;
import static com.commons.JDBCTemplate.getConnection;
import static com.commons.JDBCTemplate.rollback;

public class StudygroupService {
	
	private StudygroupDao dao=new StudygroupDao();

	public List<Studygroup> selectStudygroupList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Studygroup> list=dao.selectStudygroupList(conn, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	public int selectStudygroupCount() {
		Connection conn=getConnection();
		int result=dao.selectStudygroupCount(conn);
		close(conn);
		return result;
		
	}	
	
	public int searchStudygroupCount(String searchType, String keyword) {
		Connection conn=getConnection();
		int result=dao.searchStudygroupCount(conn,searchType, keyword);
		close(conn);
		return result;
		
	}	
	
	
	public List<Studygroup> searchStudygroup(String searchType, String keyword, int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Studygroup> list=dao.searchStudygroup(conn, searchType, keyword, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	public int insertStudyComment(StudyComment sc) {
		
		Connection conn=getConnection();
		int result=dao.insertStudyComment(conn,sc);
		close(conn);
		return result;
		
	}
	

	public int deleteStudyComment(int studyCommentNo) {
		
		Connection conn=getConnection();
		int result=dao.deleteStudyComment(conn,studyCommentNo);
		close(conn);
		return result;
		
	}
	
	
	public List<StudyComment> selectStudyComment(int studygroupNo){
		
		Connection conn=getConnection();
		List<StudyComment> list=dao.selectStudyComment(conn,studygroupNo);
		close(conn);
		return list;
		
	}
	
	
	public List<StudyMembers> selectStudyMembers(int studygroupNo){
		
		Connection conn=getConnection();
		List<StudyMembers> list=dao.selectStudyMembers(conn,studygroupNo);
		close(conn);
		return list;
		
	}
	
	public int enrollstudyMember(String studentId, int studyNo) {
		
		Connection conn=getConnection();
		int result=dao.insertstudyMember(conn,studentId, studyNo);
		close(conn);
		return result;
	}
	
	public int insertEnrollStudy(String studentId, int studyNo) {
		
		Connection conn=getConnection();
		int result=dao.insertEnrollStudy(conn, studentId, studyNo);
		close(conn);
		return result;
	}
		
	public int cancelstudyMember(String studentId, int studyNo) {
		
		Connection conn=getConnection();
		int result=dao.cancelstudyMember(conn, studentId, studyNo);
		close(conn);
		return result;
		
	}
	
	
	public int cancelEnrollStudy(String studentId, int studyNo) {
		
		
		Connection conn=getConnection();
		int result=dao.cancelEnrollStudy(conn, studentId, studyNo);
		close(conn);
		return result;
		
		
	}
	
	
	public int updateStudy(Studygroup sg) {
		Connection conn=getConnection();
		int result=dao.updateStudy(conn, sg);
		close(conn);
		return result;
		
		
		
	}
	
	public int updateFile2(Studygroup sg) {
		Connection conn=getConnection();
		int result=dao.updateFile2(conn, sg);
		close(conn);
		return result;
		
		
		
	}
	
	
	public int studyStart(String studyNo) {
		Connection conn=getConnection();
		int result=dao.studyStart(conn, studyNo);
		close(conn);
		return result;
		
		
	}
	
	
	
}
