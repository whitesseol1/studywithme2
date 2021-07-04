package com.members.model.vo;

public class Studygroup {

	private int studygroupNo;
	private String memberId;
	private String subject;
	private String studyGroupName;
	private String groupIntroduction;
	private String studyPhotoOriginalFile;
	private String studyPhotoRenamedFile;
	private String level;
	private String studyHours;
	private String Frequency;
	private String startDate;
	private String day;
	private String studyStartTime;
	private String fixedTimeStatus;
	private String age;
	private String totalNumber;
	private String studyNotice;
	private String noticeOriginalFile;
	private String noticeRenamedFile;
	private String groupMeetingType;
	private String studyStatus;
	private String studyEndDate;
	
	public Studygroup() {
		// TODO Auto-generated constructor stub
	}

	public Studygroup(int studygroupNo, String memberId, String subject, String studyGroupName,
			String groupIntroduction, String studyPhotoOriginalFile, String studyPhotoRenamedFile, String level,
			String studyHours, String frequency, String startDate, String day, String studyStartTime,
			String fixedTimeStatus, String age, String totalNumber, String studyNotice, String noticeOriginalFile,
			String noticeRenamedFile, String groupMeetingType, String studyStatus, String studyEndDate) {
		super();
		this.studygroupNo = studygroupNo;
		this.memberId = memberId;
		this.subject = subject;
		this.studyGroupName = studyGroupName;
		this.groupIntroduction = groupIntroduction;
		this.studyPhotoOriginalFile = studyPhotoOriginalFile;
		this.studyPhotoRenamedFile = studyPhotoRenamedFile;
		this.level = level;
		this.studyHours = studyHours;
		Frequency = frequency;
		this.startDate = startDate;
		this.day = day;
		this.studyStartTime = studyStartTime;
		this.fixedTimeStatus = fixedTimeStatus;
		this.age = age;
		this.totalNumber = totalNumber;
		this.studyNotice = studyNotice;
		this.noticeOriginalFile = noticeOriginalFile;
		this.noticeRenamedFile = noticeRenamedFile;
		this.groupMeetingType = groupMeetingType;
		this.studyStatus = studyStatus;
		this.studyEndDate = studyEndDate;
	}

	public int getStudygroupNo() {
		return studygroupNo;
	}

	public void setStudygroupNo(int studygroupNo) {
		this.studygroupNo = studygroupNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStudyGroupName() {
		return studyGroupName;
	}

	public void setStudyGroupName(String studyGroupName) {
		this.studyGroupName = studyGroupName;
	}

	public String getGroupIntroduction() {
		return groupIntroduction;
	}

	public void setGroupIntroduction(String groupIntroduction) {
		this.groupIntroduction = groupIntroduction;
	}

	public String getStudyPhotoOriginalFile() {
		return studyPhotoOriginalFile;
	}

	public void setStudyPhotoOriginalFile(String studyPhotoOriginalFile) {
		this.studyPhotoOriginalFile = studyPhotoOriginalFile;
	}

	public String getStudyPhotoRenamedFile() {
		return studyPhotoRenamedFile;
	}

	public void setStudyPhotoRenamedFile(String studyPhotoRenamedFile) {
		this.studyPhotoRenamedFile = studyPhotoRenamedFile;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getStudyHours() {
		return studyHours;
	}

	public void setStudyHours(String studyHours) {
		this.studyHours = studyHours;
	}

	public String getFrequency() {
		return Frequency;
	}

	public void setFrequency(String frequency) {
		Frequency = frequency;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStudyStartTime() {
		return studyStartTime;
	}

	public void setStudyStartTime(String studyStartTime) {
		this.studyStartTime = studyStartTime;
	}

	public String getFixedTimeStatus() {
		return fixedTimeStatus;
	}

	public void setFixedTimeStatus(String fixedTimeStatus) {
		this.fixedTimeStatus = fixedTimeStatus;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getStudyNotice() {
		return studyNotice;
	}

	public void setStudyNotice(String studyNotice) {
		this.studyNotice = studyNotice;
	}

	public String getNoticeOriginalFile() {
		return noticeOriginalFile;
	}

	public void setNoticeOriginalFile(String noticeOriginalFile) {
		this.noticeOriginalFile = noticeOriginalFile;
	}

	public String getNoticeRenamedFile() {
		return noticeRenamedFile;
	}

	public void setNoticeRenamedFile(String noticeRenamedFile) {
		this.noticeRenamedFile = noticeRenamedFile;
	}

	public String getGroupMeetingType() {
		return groupMeetingType;
	}

	public void setGroupMeetingType(String groupMeetingType) {
		this.groupMeetingType = groupMeetingType;
	}

	public String getStudyStatus() {
		return studyStatus;
	}

	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}

	public String getStudyEndDate() {
		return studyEndDate;
	}

	public void setStudyEndDate(String studyEndDate) {
		this.studyEndDate = studyEndDate;
	}

	@Override
	public String toString() {
		return "Studygroup [studygroupNo=" + studygroupNo + ", memberId=" + memberId + ", subject=" + subject
				+ ", studyGroupName=" + studyGroupName + ", groupIntroduction=" + groupIntroduction
				+ ", studyPhotoOriginalFile=" + studyPhotoOriginalFile + ", studyPhotoRenamedFile="
				+ studyPhotoRenamedFile + ", level=" + level + ", studyHours=" + studyHours + ", Frequency=" + Frequency
				+ ", startDate=" + startDate + ", day=" + day + ", studyStartTime=" + studyStartTime
				+ ", fixedTimeStatus=" + fixedTimeStatus + ", age=" + age + ", totalNumber=" + totalNumber
				+ ", studyNotice=" + studyNotice + ", noticeOriginalFile=" + noticeOriginalFile + ", noticeRenamedFile="
				+ noticeRenamedFile + ", groupMeetingType=" + groupMeetingType + ", studyStatus=" + studyStatus
				+ ", studyEndDate=" + studyEndDate + "]";
	}

	
	
	
}
