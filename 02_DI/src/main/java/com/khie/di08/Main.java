package com.khie.di08;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx =
				// 클래스 이름
				new AnnotationConfigApplicationContext(Config.class);
		
		// 메서드 이름
		Player player1 = (Player) ctx.getBean("player1");
		
		System.out.println("선수 이름 >> " + player1.getName());
		System.out.println("선수 나이 >> " + player1.getAge());
		System.out.println("선수 포지션 >> " + player1.getPosition());
		System.out.println("선수 체중 >> " + player1.getWeight());
		System.out.println("선수 신장 >> " + player1.getHeight());
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		Player player2 = (Player) ctx.getBean("player2");
		
		System.out.println("선수 이름 >> " + player2.getName());
		System.out.println("선수 나이 >> " + player2.getAge());
		System.out.println("선수 포지션 >> " + player2.getPosition());
		System.out.println("선수 체중 >> " + player2.getWeight());
		System.out.println("선수 신장 >> " + player2.getHeight());
		
		ctx.close();
	}

}
