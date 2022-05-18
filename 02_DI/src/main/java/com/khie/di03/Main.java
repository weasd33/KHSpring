package com.khie.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:exam.xml");
		
		Exam exam = ctx.getBean(Exam.class);
		
		exam.output();
		
		ctx.close();
	}

}
