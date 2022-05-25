package com.khie.aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//Advice ==> 스프링 AOP에서 공통 관심 사항이 있는 코드들의 묶음
//@Component => 자동으로 xml에 빈으로 등록
@Component
@Aspect
public class MyAspect {
	
	// 클래스 상관 없이 doSomething() 기준
	@Pointcut("execution(* doSomething())")
	public void myPointCut() { }
	
	@Before("myPointCut()")
	public void before() {
		System.out.println("학교 수업 후 집에 와서 문을 열고 집에 들어갑니다.");
	}
	
	@After("myPointCut()")
	public void after() {
		System.out.println("아침에 일어나서 문을 열고 집을 나옵니다.");
	}
	
	@AfterReturning("myPointCut()")
	public void after_returning() {
		System.out.println("잠을 잡니다.");
	}
	
	@AfterThrowing("myPointCut()")
	public void after_throwing() {
		System.out.println("화재 발생 : 119에 신고");
	}
}
