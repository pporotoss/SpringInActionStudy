package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class AroundAudienceXML {
	
	public void watchPerformance(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("sliencing cell phones");
			System.out.println("Taking seats");
			joinPoint.proceed();	// Aspect 적용대상 메서드를 실행.
			System.out.println("CLAP CLAP CLAP!!!");
		} catch (Throwable e) {
			System.out.println("Demanding a refund");
			throw new RuntimeException(e);
		}
	}
}
