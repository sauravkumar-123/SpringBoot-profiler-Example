package com.student.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "STUDENT_NO",length = 3)
	private int studentId;
	
	@Column(name = "STUDENT_NAME",length = 30)
	private String studentName;
	
	@Column(name = "STUDENT_DOB")
	private Date studentdob;
	
	@Column(name = "STUDENT_DOJ")
	private Date studentdoj;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String studentName, Date studentdob, Date studentdoj) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentdob = studentdob;
		this.studentdoj = studentdoj;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStudentdob() {
		return studentdob;
	}

	public void setStudentdob(Date studentdob) {
		this.studentdob = studentdob;
	}

	public Date getStudentdoj() {
		return studentdoj;
	}

	public void setStudentdoj(Date studentdoj) {
		this.studentdoj = studentdoj;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentdob=" + studentdob
				+ ", studentdoj=" + studentdoj + "]";
	}
}
