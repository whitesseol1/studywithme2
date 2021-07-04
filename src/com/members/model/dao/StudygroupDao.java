package com.members.model.dao;




import static com.commons.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Date;

import com.members.model.service.MemberService;
import com.members.model.vo.Student;
import com.members.model.vo.StudyComment;
import com.members.model.vo.StudyMembers;
import com.members.model.vo.Studygroup;



public class StudygroupDao {
	
	private Properties prop=new Properties();
	
	public StudygroupDao() {
		try {
			String path=StudygroupDao.class.getResource("/sql/member_sql.properties1").getPath();
			prop.load(new FileReader(path));
			System.out.println(prop);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public List<Studygroup> selectStudygroupList(Connection conn, int cPage, int numPerpage){
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Studygroup> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudygroupList"));
			pstmt.setInt(1,  (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			 
			while(rs.next()) {
				Studygroup sg= new Studygroup();
				sg.setStudygroupNo(rs.getInt("StudyGroupNo"));
				sg.setMemberId(rs.getString("Member_Id"));
				sg.setSubject(rs.getString("Subject"));
				sg.setStudyGroupName(rs.getString("StudyGroupName"));
				sg.setGroupIntroduction(rs.getString("GroupIntroduction"));
				sg.setStudyPhotoOriginalFile(rs.getString("StudyPhotoOriginalFileName"));
				sg.setStudyPhotoRenamedFile(rs.getString("StudyPhotoRenamedFileName"));
				sg.setLevel(rs.getString("Level"));
				sg.setFrequency(rs.getString("Frequency"));
				sg.setStudyHours(rs.getString("StudyHours"));
								
				sg.setStartDate(rs.getString("StartDate"));
				
				sg.setStudyStartTime(rs.getString("StudyStartTime"));
				sg.setDay(rs.getString("Day"));
				sg.setFixedTimeStatus(rs.getString("FixedTimeStatus"));
				sg.setAge(rs.getString("Age"));
				sg.setTotalNumber(rs.getString("TotalNumber"));
				sg.setStudyNotice(rs.getString("StudyNotice"));
				sg.setNoticeOriginalFile(rs.getString("NoticeOriginalFileName"));
				sg.setNoticeRenamedFile(rs.getString("NoticeRenamedFileName"));
				sg.setGroupMeetingType(rs.getString("GroupMeetingType"));
				sg.setStudyStatus(rs.getString("StudyStatus"));
				sg.setStudyEndDate(rs.getString("StudyEndDate"));
				list.add(sg);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return list;
		
		
		
		
	}
	
	public int selectStudygroupCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudyCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			   
		}return result;
	}
	
	
	
	public List<Studygroup> searchStudygroup(Connection conn, String searchType, String keyword, int cPage, int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Studygroup> list=new ArrayList();
		String sql=prop.getProperty("searchStudygroup");
//		switch(searchType) {
//		case "userId" : sql="searchMemberId";break;
//		case "userName" : sql="searchMemberName";break;
//		case "gender" : sql="searchMemberGender";break;
//		}
		try {
			pstmt=conn.prepareStatement(sql.replace("@", searchType));
			
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Studygroup sg=new Studygroup();
				sg.setStudygroupNo(rs.getInt("StudyGroupNo"));
				sg.setMemberId(rs.getString("Member_Id"));
				sg.setSubject(rs.getString("Subject"));
				sg.setStudyGroupName(rs.getString("StudyGroupName"));
				sg.setGroupIntroduction(rs.getString("GroupIntroduction"));
				sg.setStudyPhotoOriginalFile(rs.getString("StudyPhotoOriginalFileName"));
				sg.setStudyPhotoRenamedFile(rs.getString("StudyPhotoRenamedFileName"));
				sg.setLevel(rs.getString("Level"));
				sg.setFrequency(rs.getString("Frequency"));
				sg.setStudyHours(rs.getString("StudyHours"));
								
				sg.setStartDate(rs.getString("StartDate"));
				
				sg.setStudyStartTime(rs.getString("StudyStartTime"));
				sg.setDay(rs.getString("Day"));
				sg.setFixedTimeStatus(rs.getString("FixedTimeStatus"));
				sg.setAge(rs.getString("Age"));
				sg.setTotalNumber(rs.getString("TotalNumber"));
				sg.setStudyNotice(rs.getString("StudyNotice"));
				sg.setNoticeOriginalFile(rs.getString("NoticeOriginalFileName"));
				sg.setNoticeRenamedFile(rs.getString("NoticeRenamedFileName"));
				sg.setGroupMeetingType(rs.getString("GroupMeetingType"));
				sg.setStudyStatus(rs.getString("StudyStatus"));
				sg.setStudyEndDate(rs.getString("StudyEndDate"));
                list.add(sg);
		     }
				
			}catch(SQLException e) {
				e.printStackTrace();
			
			}finally {
			close(rs);
			close(pstmt);
			}return list;
		
		
	}
	
	public int searchStudygroupCount(Connection conn, String searchType, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String sql=prop.getProperty("searchStudygroupCount");
		try {
			pstmt=conn.prepareStatement(sql.replace("@", searchType));
			pstmt.setString(1, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}return result;
		
	}
	
	public int insertStudyComment(Connection conn,StudyComment sc) {
		PreparedStatement pstmt=null;
		
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertStudyComment"));
			pstmt.setInt(1,sc.getStudygroupNo());
			pstmt.setInt(2,sc.getStudycommentLevel());
			pstmt.setString(3,sc.getCommentWriter());
			pstmt.setString(4, sc.getCommentContent());
			pstmt.setString(5, sc.getCommentReference()==0?null:String.valueOf(sc.getCommentReference()) );
			//pstmt.setInt(5, (bc.getBoardCommentRef()==0?null:bc.getBoardCommentRef()));
			result=pstmt.executeUpdate();
		
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	
	public int deleteStudyComment(Connection conn, int studyCommentNo) {
		
      PreparedStatement pstmt=null;
		
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteStudyComment"));
			pstmt.setInt(1,studyCommentNo);
			
			result=pstmt.executeUpdate();
			
			 System.out.println(result+"결과int값");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
		
		
	}
	
	
	
	
	
	
	
	
	public List<StudyComment> selectStudyComment(Connection conn, int studygroupNo){
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudyComment> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudyComment"));
			pstmt.setInt(1, studygroupNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StudyComment sc=new StudyComment();
				sc.setCommentNo(rs.getInt("StudyCommentNo"));
				sc.setStudycommentLevel(rs.getInt("StudyCommentLevel"));
				sc.setCommentWriter(rs.getString("CommentWriter"));
				sc.setCommentContent(rs.getString("CommentContent"));
				sc.setStudygroupNo(rs.getInt("StudyGroupNo"));
				sc.setCommentReference(rs.getInt("CommentReference"));
				sc.setCommentDate(rs.getDate("CommentDate"));
				list.add(sc);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}return list;
	}
	
   public List<StudyMembers> selectStudyMembers(Connection conn, int studygroupNo){
	   
	   PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudyMembers> list=new ArrayList();
	   
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudyMembers"));
			pstmt.setInt(1, studygroupNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StudyMembers sm=new StudyMembers();
				sm.setMember_Id(rs.getString("Member_Id"));
				sm.setStudyGroupNo(rs.getInt("StudyGroupNo"));
				
				
				list.add(sm);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}return list;
		
		
	   
   }
   
   public int insertstudyMember(Connection conn, String studentId, int StudyNo) {
	   
	   
	   PreparedStatement pstmt=null;
		
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertStudyMember"));
			pstmt.setInt(1,StudyNo);
			pstmt.setString(2,studentId);
			
			result=pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
   }
   
   
   
		
		public int insertEnrollStudy(Connection conn, String studentId, int StudyNo) {
			
			
			 PreparedStatement pstmt=null;
				
				int result=0;
				try {
					pstmt=conn.prepareStatement(prop.getProperty("insertEnrollStudy"));
					pstmt.setString(1,String.valueOf(StudyNo)+",");
					pstmt.setString(2,studentId);
					
					result=pstmt.executeUpdate();
					
					
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
				
				
				return result;
			
			
			
			
			
		}
	   
	   
	   
	   public int cancelEnrollStudy(Connection conn, String studentId, int studyNo) {
		   
		   
		   PreparedStatement pstmt=null;
		   int result=0;
		   Student student=new MemberService().selectStudent(studentId);
		   String enrollStudy2=student.getEnrollStudy();
		     //System.out.println(enrollStudy2 +"test");
		   String enrollStudy3=enrollStudy2.replace(String.valueOf(studyNo)+',' , "");
		   //System.out.println(enrollStudy3+"enrollstudy3테스트");
		   try {
			   pstmt=conn.prepareStatement(prop.getProperty("cancelEnrollStudy"));
			   pstmt.setString(1, enrollStudy3);
			   pstmt.setString(2, studentId);
			   
			   result=pstmt.executeUpdate();
			   
		   }catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			return result;

		   
	   }
	   
	   
	   public int cancelstudyMember(Connection conn, String studentId, int studyNo) {
		   
		   PreparedStatement pstmt=null;
		   
		   int result=0;
		   
		   try {
			   pstmt=conn.prepareStatement(prop.getProperty("cancelstudyMember"));
			   pstmt.setInt(1, studyNo);
			   pstmt.setString(2, studentId);
			   
			   result=pstmt.executeUpdate();
			   
		   }catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			return result;
		   
		   
		   
	   }
	   
	   public int updateStudy(Connection conn, Studygroup sg) {
		   
		   
		   PreparedStatement pstmt=null;
			int result=0;
			String sql=prop.getProperty("updateStudy");
			try {
				pstmt=conn.prepareStatement(prop.getProperty("updateStudy"));
				
				//pstmt.setString(1, sg.getMemberId());
				//pstmt.setString(1, sg.getSubject());
				pstmt.setString(1, sg.getStudyGroupName());
				pstmt.setString(2, sg.getGroupIntroduction());
				//pstmt.setString(3, sg.getStudyPhotoOriginalFile());
				//pstmt.setString(4, sg.getStudyPhotoRenamedFile());
				pstmt.setString(3, sg.getLevel());
				pstmt.setString(4, sg.getStudyHours());
				pstmt.setString(5, sg.getFrequency());
				//java.sql.Date d=java.sql.Date.valueOf(sg.getStartDate());
				//pstmt.setDate(9, d);
				//pstmt.setString(9, sg.getStartDate());
				pstmt.setString(6, sg.getDay());
				pstmt.setString(7, sg.getStudyStartTime());
				pstmt.setString(8, sg.getFixedTimeStatus());
				pstmt.setString(9, sg.getAge().trim());
				pstmt.setString(10, sg.getTotalNumber());
				pstmt.setString(11, sg.getGroupMeetingType());
				
				pstmt.setInt(12, sg.getStudygroupNo());
				System.out.println(sg+"dao테스트");
				result=pstmt.executeUpdate();
				System.out.println(result+"result테스트");
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		   
		   
		   
		   
	   }
	   
	   public int updateFile2(Connection conn, Studygroup sg) {
		   
		   PreparedStatement pstmt=null;
			int result=0;
			String sql=prop.getProperty("updateFile2");
			try {
				//if(sg.getStudyPhotoRenamedFile()!=null) {
					pstmt=conn.prepareStatement(prop.getProperty("updateFile2"));
				
				    pstmt.setString(1, sg.getStudyPhotoOriginalFile());
				    pstmt.setString(2, sg.getStudyPhotoRenamedFile());
				    pstmt.setInt(3, sg.getStudygroupNo());
				    result=pstmt.executeUpdate();
				//}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		   
		   
		   
		   
	   }
  
	   
	   public int studyStart(Connection conn, String studyNo) {
		   
		   
		   PreparedStatement pstmt=null;
			int result=0;
			System.out.println(studyNo+"dao studyNo테스트");
			try {
				pstmt=conn.prepareStatement(prop.getProperty("studyStart"));
				System.out.println(pstmt+"pstmt테스트");
				
				    pstmt.setInt(1, Integer.parseInt(studyNo));
				    
				
				result=pstmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		   
		   
		   
		   
		   
	   }
	
}
