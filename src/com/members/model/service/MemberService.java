package com.members.model.service;



import static com.commons.JDBCTemplate.close;
import static com.commons.JDBCTemplate.commit;
import static com.commons.JDBCTemplate.getConnection;
import static com.commons.JDBCTemplate.rollback;


import java.sql.Connection;

import com.members.model.vo.Lecture;
import com.members.model.vo.Member;
import com.members.model.vo.Student;
import com.members.model.vo.Studygroup;
import com.members.model.vo.Teacher;
import com.members.model.dao.MemberDao;

public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	
	public Member checkDuplicateId(String userId) {
		Connection conn=getConnection();
		Member m=dao.checkDuplicateId(conn,userId);
		close(conn);
		return m;
		
	}
	
       public int insertMember(Member m) {
		
		Connection conn=getConnection();
		int result=dao.insertMember(conn,m);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
       
       public int setSubjectMember(Student s) {
   		Connection conn=getConnection();
   		int result=dao.setSubjectMember(conn,s);
   		if(result>0) commit(conn);
   		else rollback(conn);
   		close(conn);
   		return result;
   		
   	}
       
       public int setTeacher(Teacher t) {
    	   Connection conn=getConnection();
      		int result=dao.setTeacher(conn,t);
      		if(result>0) commit(conn);
      		else rollback(conn);
      		close(conn);
      		return result;
    	   
       }
       
       
       public Member login(String userId, String pw) {
   		Connection conn=getConnection();
   		Member m=dao.login(conn,userId,pw);
   		close(conn);
   		return m;
   	}
       
       public int updatePassword(String userId, String newPw) {
   		Connection conn=getConnection();
   		int result=dao.updatePassword(conn,userId,newPw);
   		if(result>0) commit(conn);
   		else rollback(conn);
   		close(conn);
   		return result;
   		
   	}
       
       public int updateMember(Member m) {
   		Connection conn=getConnection();
   		int result=dao.updateMember(conn,m);
   		
   		
   		if(result>0) commit(conn);
   		else rollback(conn);
   		close(conn);
  		
   		return result;
   		
   	}
       
       public int updateFile(Member m) {
      		Connection conn=getConnection();
      		int result=dao.updateFile(conn,m);
  		
      		if(result>0) commit(conn);
      		else rollback(conn);
      		close(conn);
    		
      		return result;
      		
      	}
       
       public Student selectStudent(String userId) {
      		Connection conn=getConnection();
      		Student s=dao.selectStudent(conn,userId);
      		close(conn);
      		return s;
      		
      	}
       
       public Teacher selectTeacher(String userId) {
     		Connection conn=getConnection();
     		Teacher t=dao.selectTeacher(conn,userId);
     		close(conn);
     		return t;
     		
     	}
       
       public int updateStudent(Student s) {
      		Connection conn=getConnection();
      		int result=dao.updateStudent(conn,s);
      		if(result>0) commit(conn);
      		else rollback(conn);
      		close(conn);
      		return result;
      		
      	}
       
	public int deleteMember(String userId,String type) {
		
		Connection conn=getConnection();
		int result=dao.deleteMember(conn, userId);
		if(result>0) {
			if(type.equals("student")) {
				result=dao.deleteStudentMember(conn, userId);
			}else {
				result=dao.deleteTeacherMember(conn, userId);
			}
			if(result>0) commit(conn);
			else rollback(conn);
		}else {
			rollback(conn);
		}
		
	
		close(conn);
		return result;
		
		
	}
	
	public Studygroup selectStudygroup(String enrollStudy) {
 		Connection conn=getConnection();
 		Studygroup sg=dao.selectStudygroup(conn,enrollStudy);
 		close(conn);
 		return sg;
 		
 	}
	
	public Studygroup selectStudygroup2(String userId) {
 		Connection conn=getConnection();
 		Studygroup sg=dao.selectStudygroup2(conn,userId);
 		close(conn);
 		return sg;
 		
 	}
	
	
	public Lecture selectLecture(String enrollLecture) {
 		Connection conn=getConnection();
 		Lecture lt=dao.selectLecture(conn,enrollLecture);
 		close(conn);
 		return lt;
 		
 	}
	
	public Lecture selectLecture2(String userId) {
 		Connection conn=getConnection();
 		Lecture lt=dao.selectLecture(conn,userId);
 		close(conn);
 		return lt;
 		
 	}
	
	 public int insertStudygroup(Studygroup sg) {
	   		Connection conn=getConnection();
	   		int result=dao.insertStudygroup(conn,sg);
	   		if(result>0) commit(conn);
	   		else rollback(conn);
	   		close(conn);
	   		return result;
	 }
	 
	 public int insertteamLeaderStatus(String userId) {
	   		Connection conn=getConnection();
	   		int result=dao.insertteamLeaderStatus(conn,userId);
	   		if(result>0) commit(conn);
	   		else rollback(conn);
	   		close(conn);
	   		return result;
	 }
       

}
