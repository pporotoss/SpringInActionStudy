package spittr.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/* web.xml 대신에 DispatcherServlet관련 설정하는 클래스. 설정 클래스 하나가 DispatcherServlet 하나를 생성.
 * 다수의 DispatcherServlet 생성시  getServletName() 메서드를 통해 중복되지 않는 이름을 지정해야 한다.
 * servlet-api 3.0 이상에서만 지원. 
 * 스프링 버전 3.2 부터 지원.
 * 스프링 3.1은 WebApplicationInitializer 구현해서 사용.*/
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected String[] getServletMappings() {	// 서블릿 주소 매핑.
		return new String[] {"/"};
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {	// Context 관련 설정파일.
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {	// DispatcherServlet 관련 설정파일
		return new Class<?>[] { WebConfig.class };
	}
	
	@Override
	protected Filter[] getServletFilters() {	// 필터 설정.
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8");
		//encodingFilter.setForceEncoding(true);	// 요청이나 응답에 설정해준 인코딩과 관계없이 무조껀 인코딩 적용. 기본값:false
		
		return new Filter[] {
				encodingFilter
		};
	}
	
	@Override
	protected String getServletName() {	// DispatcherServlet의 이름 설정.
		return super.getServletName();	// 기본값은 dispatcherServlet 반환.
	}

}
