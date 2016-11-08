package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/* web.xml 대신에 servlet관련 설정하는 클래스. servlet 3.0 이상에서만 지원. */
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

}
