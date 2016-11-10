package spittr.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
//@ComponentScan("spittr.web")	// spittr.web 패키지 안의 컴포넌트를 자동으로 빈으로 등록.
@ComponentScan(basePackages="spittr", includeFilters=@Filter(Controller.class))	// controller 어노테이션만 검색.
public class WebConfig extends WebMvcConfigurerAdapter{	// WebMvc 설정용 클래스. 반드시 상속 받아야 한다.
	
	@Bean
	public TilesConfigurer tilesConfigurer() {	// 타일즈 설정하기. 패키지 버전 확인 하고 임포트 해야함.
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[]{	// 설정파일 위치 설정.
				"/WEB-INF/layout/tiles.xml"
		});
		return tiles;
	}
	
	@Bean
	public ViewResolver viewResolver(TemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();	// 뷰이름으로 타임리프 템플릿 뷰를 결정.
		viewResolver.setTemplateEngine(templateEngine);	// ThymeleafViewResolver에 SpringTemplateEngine 설정.
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
	
	@Bean
	public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();	// 템플릿을 처리하고 결과를 렌더링 해준다.
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}
	
	
	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();	// 해당 위치의 템플릿을 불러온다.
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		
		return templateResolver;
	}
	
	@Bean
	public MultipartResolver mulitpartResolver() throws IOException {
		StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();	// 서블릿 3.0 이상 지원.
		//CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();	// CommonsFileUpload 이용.
		//multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/uploads"));	// 임시저장 폴더. 
																																	// 서블릿 컨테이너의 임시디렉토리가 기본값.
		//**  FileSystemResource : 프로젝트 폴더 최상위가 루트폴더.
		//**  ClassPathResource : src 폴더가 루트 폴더.
		//multipartResolver.setMaxUploadSize(2097152);
		//multipartResolver.setMaxInMemorySize(0);
		
		return multipartResolver;
	}
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {	// 정적 콘텐츠 처리 설정.
		configurer.enable();		// 정적 리소스의 처리를 직접하지 않고 서블릿 컨테이너에게 위임한다.
	}
	
	
	/*@Bean
	public ViewResolver viewResolver() {
		return new TilesViewResolver();	// 아파치 타일즈용 뷰 리졸버 설정.
	}*/
	
	/*@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); // jsp 처리용 뷰 리졸버 생성. 
																																	// 리졸버마다 기능이 다르므로 직접생성.	
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}*/
	
	
}
