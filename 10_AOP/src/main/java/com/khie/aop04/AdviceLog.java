package com.khie.aop04;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceLog {
	
	// ProceedingJoinPoint 객체는 핵심 기능을 대행하는 객체
	public Object profile(ProceedingJoinPoint jp) throws Throwable {
		
		// getSignature() : 호출되는 메서드에 대한 정보를 알려주는 메서드
		String signStr = jp.getSignature().toString();
		
		System.out.println(signStr + "is start!!");
		
		long startTime = System.currentTimeMillis();
		
		Object obj = jp.proceed(); // 핵심 기능을 실행시키는 메서드
		
		System.out.println(signStr + "is End!!");
		System.out.println("경과 시간 >> " + (System.currentTimeMillis() - startTime) + 5);
		
		return obj;
	}
}
