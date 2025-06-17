package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect //
public class LogAdvice {
	
	//* 반환형 ; 반환타입이 어떤 것이든 상관 없음
	//org.zerock.service.SampleService* 클래스
	//*(..) 메소드
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.nanoTime();
		log.info("Target: " + pjp.getTarget());
		log.info("Param:" + Arrays.toString(pjp.getArgs()));
		Object result = null;
		
		try {
			result = pjp.proceed(); //실제 함수 호출
		}catch(Throwable e) {
			e.printStackTrace();
		}
		long end = System.nanoTime();
		
		log.info("Time: " + (end-start));
		return result;
	}
}
