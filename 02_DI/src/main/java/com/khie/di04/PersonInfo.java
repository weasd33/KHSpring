package com.khie.di04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfo {
	
	private Person person;
	
	// 비지니스 로직
	public void getPersonInfo() {
		if(person != null) {
			System.out.println("이 름 >> " + person.getName());
			System.out.println("성 별 >> " + person.getGender());
			System.out.println("나 이 >> " + person.getAge());
			System.out.println("주민번호 >> " + person.getJuminNo());
		}
	}
}
