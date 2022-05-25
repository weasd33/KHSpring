package com.khie.aop04;

import lombok.Data;

@Data
public class Student {

	private String name;
	private String hakbun;
	private int age;
	private int grade;
	
	// Student에 대한 정보를 가져오는 메서드
	public void getStudentInfo() {
		System.out.println("학생 이름 : " + getName());
		System.out.println("학생 학번 : " + getHakbun());
		System.out.println("학생 나이 : " + getAge());
		System.out.println("학생 학년 : " + getGrade());
	}
}
