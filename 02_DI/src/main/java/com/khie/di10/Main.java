package com.khie.di10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config.class);
		
		Player player1 = (Player) ctx.getBean("player1");
		Player player2 = (Player) ctx.getBean("player2");
		Player player3 = (Player) ctx.getBean("player3");
		
		System.out.println("선수 이름 >> " + player1.getName());
		System.out.println("선수 나이 >> " + player1.getAge());
		System.out.println("선수 포지션 >> " + player1.getPosition());
		System.out.println("선수 체중 >> " + player1.getWeight());
		System.out.println("선수 신장 >> " + player1.getHeight());
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		System.out.println("선수 이름 >> " + player2.getName());
		System.out.println("선수 나이 >> " + player2.getAge());
		System.out.println("선수 포지션 >> " + player2.getPosition());
		System.out.println("선수 체중 >> " + player2.getWeight());
		System.out.println("선수 신장 >> " + player2.getHeight());
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		System.out.println("선수 이름 >> " + player3.getName());
		System.out.println("선수 나이 >> " + player3.getAge());
		System.out.println("선수 포지션 >> " + player3.getPosition());
		System.out.println("선수 체중 >> " + player3.getWeight());
		System.out.println("선수 신장 >> " + player3.getHeight());
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		ctx.close();
	}

}
