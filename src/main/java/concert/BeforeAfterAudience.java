package concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeforeAfterAudience {
	
	@Pointcut("execution(* concert.Performance.perform(..))")	// 현재 클래스 안에서 공통으로 적용되는 포인트컷을 정의.
	public void performance() {	// 포인트컷을 제공하기위한 빈 메서드.
	}
	
	@Before("performance()")	// 메서드 시작전에 실행.
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones");
	}
	
	@Before("performance()")
	public void takeSeats() {
		System.out.println("Taking seats");
	}
	
	@AfterReturning("performance()")	// 메서드 성공적으로 실행 후
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}
	
	@AfterThrowing("performance()")	// 메서드 실행중 오류 발생시.
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}
}
