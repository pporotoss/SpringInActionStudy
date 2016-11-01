package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy	// @Aspect 가 있는 빈의 내용을 바탕으로 자동으로 프록시를 생성을 활성화한다.
@ComponentScan
public class ConcertConfig {
	
	@Bean
	public AroundAudience audience() {
		return new AroundAudience();
	}
	
	@Bean
	public Performance failPerformance() {
		return new PerformanceTest.FailPerformance();
	}
}
