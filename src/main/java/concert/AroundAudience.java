package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AroundAudience {
	
	@Pointcut("execution(* concert.Performance.perform(..))")	// 현재 클래스 안에서 공통으로 적용되는 포인트컷을 정의.
	public void performance() {	// 포인트컷을 제공하기위한 빈 메서드.
	}
	
	@Around("performance()")
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
