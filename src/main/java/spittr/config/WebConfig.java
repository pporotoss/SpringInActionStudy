package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")	// spittr.web 패키지 안의 컴포넌트를 자동으로 빈으로 등록.
public class WebConfig extends WebMvcConfigurerAdapter{	// WebMvc 설정용 클래스. 반드시 상속 받아야 한다.
	
	@Bean
	public ViewResolver viewResolver() {
		// jsp 처리용 뷰 리졸버 생성.
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); // 리졸버마다 기능이 다르므로 직접생성.	
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeContextBeansAsAttributes(true);
		
		return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {	// 정적 콘텐츠 처리 설정.
		configurer.enable();		// 정적 리소스의 처리를 직접하지 않고 서블릿 컨테이너에게 위임한다.
	}
}
