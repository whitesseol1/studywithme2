package com.members.model.vo;

public class StudyMembers {

	private int studyGroupNo;
	private String Member_Id;
	
	public StudyMembers() {
		// TODO Auto-generated constructor stub
	}

	public StudyMembers(int studyGroupNo, String member_Id) {
		super();
		this.studyGroupNo = studyGroupNo;
		Member_Id = member_Id;
	}

	public int getStudyGroupNo() {
		return studyGroupNo;
	}

	public void setStudyGroupNo(int studyGroupNo) {
		this.studyGroupNo = studyGroupNo;
	}

	public String getMember_Id() {
		return Member_Id;
	}

	public void setMember_Id(String member_Id) {
		Member_Id = member_Id;
	}

	@Override
	public String toString() {
		return "StudyMembers [studyGroupNo=" + studyGroupNo + ", Member_Id=" + Member_Id + "]";
	}
	
	
	
	
}
