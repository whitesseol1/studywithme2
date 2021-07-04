package com.members.model.dao;




import static com.commons.JDBCTemplate.close;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.members.model.dao.MemberDao;
import com.members.model.vo.Lecture;
import com.members.model.vo.Member;
import com.members.model.vo.Student;
import com.members.model.vo.Studygroup;
import com.members.model.vo.Teacher;

public class MemberDao {

	private Properties prop=new Properties();
	
	public MemberDao() {
		try {
			String filePath=MemberDao.class.getResource("/sql/member_sql.properties1").getPath();
			prop.load(new FileReader(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Member checkDuplicateId(Connection conn, String userId  ) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberId"));
			pstmt.setString(1,userId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				//조회된 row가 있다
				m=new Member();
				m.setUserId(rs.getString("Member_Id"));
				m.setPassword(rs.getString("Password"));
				m.setUserName(rs.getString("UserName"));
				m.setAge(rs.getInt("Age"));
				//char형으로 데이터를 받을때 사용
				//m.setGender(rs.getString("gender").charAt(0));
				m.setGender(rs.getString("Gender").trim());
				m.setEmail(rs.getString("Email"));
				m.setPhone(rs.getString("Phone"));
				m.setAddress(rs.getString("Address"));				
				m.setEnrollDate(rs.getDate("EnrollDate"));
				m.setOriginalFileName(rs.getString("ProfileOriginalFileName"));
				m.setRenamedFileName(rs.getString("ProfileRenamedFileName"));				
				m.setStudentTeacherStatus(rs.getString("StudentTeacherStatus"));
				System.out.println(m);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender().trim());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getOriginalFileName());
			pstmt.setString(10, m.getRenamedFileName());
			pstmt.setString(11, m.getStudentTeacherStatus());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int setSubjectMember(Connection conn, Student s) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("setSubjectMember"));

			pstmt.setString(1, s.getUserId());
			pstmt.setString(2, s.getInterestingSubject());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Member login(Connection conn, String userId, String pw) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loginMemberId"));
			pstmt.setString(1, userId);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			   
			
			if(rs.next()) {
				//조회된 row가 있다
				m=new Member();
				
				m.setUserId(rs.getString("Member_Id"));
				m.setPassword(rs.getString("Password"));
				m.setUserName(rs.getString("UserName"));
				m.setAge(rs.getInt("Age"));
				//char형으로 데이터를 받을때 사용
				//m.setGender(rs.getString("gender").charAt(0));
				m.setGender(rs.getString("Gender").trim());
				System.out.println(rs.getString("Gender"));
				m.setEmail(rs.getString("Email"));
				m.setPhone(rs.getString("Phone"));
				m.setAddress(rs.getString("Address"));				
				m.setEnrollDate(rs.getDate("EnrollDate"));	
				m.setOriginalFileName(rs.getString("ProfileOriginalFileName"));
				m.setRenamedFileName(rs.getString("ProfileRenamedFileName"));
				m.setStudentTeacherStatus(rs.getString("StudentTeacherStatus"));				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
		
	}
	
	public int setTeacher(Connection conn, Teacher t) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("setTeacher"));

			pstmt.setString(1, t.getUserId());
			pstmt.setString(2, t.getAcademicCareer());
			pstmt.setString(3, t.getCollegeName());
			pstmt.setString(4, t.getMajor());
			pstmt.setString(5, t.getCertificate());
			pstmt.setString(6, t.getCareer());
			pstmt.setString(7, t.getSelfIntroduction());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updatePassword(Connection conn, String userId, String newPw) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updatePassword"));
			pstmt.setString(1, newPw);
			pstmt.setString(2,  userId);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateMember"));
//			pstmt.setString(1, m.getPassword());
			pstmt.setString(1, m.getUserName());
			     System.out.println(m.getGender());
			     System.out.println(m.getOriginalFileName());
			     System.out.println(m.getRenamedFileName());
			pstmt.setString(2, m.getGender().trim());
			pstmt.setInt(3,  m.getAge());
			pstmt.setString(4,  m.getEmail());
			pstmt.setString(5,  m.getPhone());
			pstmt.setString(6,  m.getAddress());			
			/*
			 * pstmt.setString(7, m.getOriginalFileName());
			 *  pstmt.setString(8,
			 * m.getRenamedFileName());
			 */		
			pstmt.setString(7, m.getStudentTeacherStatus());
			pstmt.setString(8, m.getUserId());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result+"확인");
		return result;
	}
	
	public int updateFile(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateFile"));
			
			if(m.getRenamedFileName()!=null) {
			    pstmt.setString(1, m.getOriginalFileName());
			    pstmt.setString(2,m.getRenamedFileName());
			    pstmt.setString(3, m.getUserId());
			}
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public Student selectStudent (Connection conn, String userId) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student s=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudent"));
			pstmt.setString(1, userId);			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//조회된 row가 있다
				s=new Student();
				
				s.setUserId(userId);
				s.setStudentTeacherStatus(rs.getString("StudentTeacherStatus"));
				s.setPoint(rs.getInt("ModelStudentPoint"));	
				s.setPenaltyPoint(rs.getInt("PenaltyPoint"));
				s.setReportStatus(rs.getInt("ReportStatus"));
				s.setInterestingSubject(rs.getString("InterestingSubject"));
				s.setTeamLeaderStatus(rs.getString("TeamLeaderStatus"));
				s.setTeamLeaderScore(rs.getInt("TeamLeaderScore"));
				s.setEnrollStudy(rs.getString("EnrollStudy"));
				  System.out.println(rs.getString("EnrollStudy")+"dao테스트");
				s.setEnrollLecture(rs.getString("EnrollLecture"));
				s.setLastLecture(rs.getString("LastLecture"));
				s.setLastStudy(rs.getString("LastStudy"));
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return s;
		
		
		
		
	}
	
	public Teacher selectTeacher (Connection conn, String userId) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Teacher t=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectTeacher"));
			pstmt.setString(1, userId);			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//조회된 row가 있다
				t=new Teacher();
				
				t.setUserId(userId);
				t.setStudentTeacherStatus(rs.getString("StudentTeacherStatus"));
				t.setAcademicCareer(rs.getString("AcademicCareer"));
				t.setCollegeName(rs.getString("CollegeName"));
				t.setMajor(rs.getString("Major"));
				t.setCertificate(rs.getString("Certificate"));
				t.setCareer(rs.getString("Career"));
				t.setSelfIntroduction(rs.getString("Self_Introduction"));
				t.setTeacherEvaluation(rs.getInt("TeacherEvaluation"));
				t.setOpenLecture(rs.getString("OpenLecture"));
				t.setPenalty(rs.getInt("Penalty"));
				t.setLastLecture(rs.getString("LastLecture"));
				
			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return t;
		
	
	
	}
	
	public int updateStudent(Connection conn, Student s) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateStudent"));
			
			pstmt.setString(1,s.getInterestingSubject());
			pstmt.setString(2,s.getUserId());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Connection conn, String userId) {
	PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteMember"));
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
			
				
				
			}
	
	
	
	public int deleteStudentMember(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteStudentMember"));
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int deleteTeacherMember(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteTeacherMember"));
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	
	public Studygroup selectStudygroup (Connection conn, String enrollStudy) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Studygroup sg=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudygroup"));
			int enrollStudyNo=Integer.parseInt(enrollStudy); //스터디그룹번호 인트형으로바꿔서
			pstmt.setInt(1, enrollStudyNo);			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//조회된 row가 있다
				sg=new Studygroup();
				
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
			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return sg;
		
	
	
	}
	
	
public Studygroup selectStudygroup2 (Connection conn, String userId) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Studygroup sg=null;
		System.out.println(prop.getProperty("selectStudygroup2"));
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectStudygroup2"));
			pstmt.setString(1, userId);	
			  System.out.println(userId);
			  
			rs=pstmt.executeQuery();
			 
			if(rs.next()) {
				//조회된 row가 있다
				sg=new Studygroup();
				
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
			 System.out.println(sg);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return sg;
		
	
	
	}
	
public Lecture selectLecture (Connection conn, String enrollLecture) {
	
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Lecture lt=null;
	try {
		pstmt=conn.prepareStatement(prop.getProperty("selectLecture"));
		int enrollLectureNo=Integer.parseInt(enrollLecture);
		pstmt.setInt(1, enrollLectureNo);			
		rs=pstmt.executeQuery();
		if(rs.next()) {
			//조회된 row가 있다
			lt=new Lecture();
			
			lt.setLectureNo(rs.getInt("LectureNo"));
			lt.setMemberId(rs.getString("Member_Id"));
			lt.setSubject(rs.getString("Subject"));
			lt.setLectureName(rs.getString("LectureName"));
			lt.setLectureIntroduction(rs.getString("LectureIntroduction"));
			lt.setLecIntroPhoto(rs.getString("Lec_Intro_PhotoOriginal"));
			lt.setLecPhotoRenamed(rs.getString("LecturePhotoRenamed"));
			lt.setLevel(rs.getString("Level"));
			lt.setLectureHours(rs.getString("LectureHours"));
			lt.setTotalTimes(rs.getString("TotalTimes"));
			lt.setFrequency(rs.getString("Frequency"));
			lt.setStartDate(rs.getString("StartDate"));
			lt.setDay(rs.getString("Day"));
			lt.setLectureStartTime(rs.getString("LectureStartTime"));
			lt.setFixedTimeStatus(rs.getString("FixedTimeStatus"));
			lt.setAge(rs.getString("Age"));
			lt.setTotalNumber(rs.getString("TotalNumber"));
			lt.setLectureNotice(rs.getString("LectureNotice"));
			lt.setNoticeOriFile(rs.getString("NoticeOriginalFile"));
			lt.setNoticeRenamed(rs.getString("NoticeRenamedFile"));
			lt.setLectureType(rs.getString("LectureMeetingType"));
			lt.setLectureStatus(rs.getString("LectureStatus"));
			lt.setPrice(rs.getInt("Price"));
		
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	return lt;
	


}


public Lecture selectLecture2 (Connection conn, String userId) {
	
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Lecture lt=null;
	try {
		pstmt=conn.prepareStatement(prop.getProperty("selectLecture2"));
		
		pstmt.setString(1, userId);			
		rs=pstmt.executeQuery();
		if(rs.next()) {
			//조회된 row가 있다
			lt=new Lecture();
			
			lt.setLectureNo(rs.getInt("LectureNo"));
			lt.setMemberId(rs.getString("Member_Id"));
			lt.setSubject(rs.getString("Subject"));
			lt.setLectureName(rs.getString("LectureName"));
			lt.setLectureIntroduction(rs.getString("LectureIntroduction"));
			lt.setLecIntroPhoto(rs.getString("Lec_Intro_PhotoOriginal"));
			lt.setLecPhotoRenamed(rs.getString("LecturePhotoRenamed"));
			lt.setLevel(rs.getString("Level"));
			lt.setLectureHours(rs.getString("LectureHours"));
			lt.setTotalTimes(rs.getString("TotalTimes"));
			lt.setFrequency(rs.getString("Frequency"));
			lt.setStartDate(rs.getString("StartDate"));
			lt.setDay(rs.getString("Day"));
			lt.setLectureStartTime(rs.getString("LectureStartTime"));
			lt.setFixedTimeStatus(rs.getString("FixedTimeStatus"));
			lt.setAge(rs.getString("Age"));
			lt.setTotalNumber(rs.getString("TotalNumber"));
			lt.setLectureNotice(rs.getString("LectureNotice"));
			lt.setNoticeOriFile(rs.getString("NoticeOriginalFile"));
			lt.setNoticeRenamed(rs.getString("NoticeRenamedFile"));
			lt.setLectureType(rs.getString("LectureMeetingType"));
			lt.setLectureStatus(rs.getString("LectureStatus"));
			lt.setPrice(rs.getInt("Price"));
		
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	return lt;
	


}

public int insertStudygroup(Connection conn, Studygroup sg) {
	PreparedStatement pstmt=null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(prop.getProperty("insertStudygroup"));
		
		pstmt.setString(1, sg.getMemberId());
		pstmt.setString(2, sg.getSubject());
		pstmt.setString(3, sg.getStudyGroupName());
		pstmt.setString(4, sg.getGroupIntroduction());
		pstmt.setString(5, sg.getStudyPhotoOriginalFile());
		pstmt.setString(6, sg.getStudyPhotoRenamedFile());
		pstmt.setString(7, sg.getLevel());
		pstmt.setString(8, sg.getStudyHours());
		pstmt.setString(9, sg.getFrequency());
		pstmt.setString(10, sg.getStartDate());
		pstmt.setString(11, sg.getDay());
		pstmt.setString(12, sg.getStudyStartTime());
		pstmt.setString(13, sg.getFixedTimeStatus());
		pstmt.setString(14, sg.getAge());
		pstmt.setString(15, sg.getTotalNumber());
		pstmt.setString(16, sg.getGroupMeetingType());
		
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	
	return result;
	
}

public int insertteamLeaderStatus(Connection conn, String userId) {
	PreparedStatement pstmt=null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(prop.getProperty("insertteamLeaderStatus"));
		
		pstmt.setString(1, userId);
		
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	
	return result;
	
}



	
	
	
	
}
