package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CDConfig.class)	// 다른 설정파일의 빈을 참조.
//@ComponentScan(basePackages={"soundsystem", "video"}) //	soundsystem 패키지와 video 패키지에 있는 컴포넌트를 스캔한다.
//@ComponentScan(basePackageClasses=CDPlayer.class)	// 해당 클래스가 있는 패키지와 하위패키지를 스캔한다.
//@ComponentScan(basePackageClasses={CDPlayer.class, DVDPlayer.class})	// 해당 클래스가 있는 패키지와 하위패키지를 스캔한다.
public class CDPlayerConfig {
	
	/*@Bean(name="lonleyHeartsClubBand")	// sgtPeppers 빈의 이름을 lonleyHeartsClubBand 라는 이름으로 명시.
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}*/
	
	
	/*@Bean
	public CDPlayer cdPlayer() {
		return new CDPlayer(sgtPeppers());	 // sgtPeppers 빈을 반환하는 sgtPeppers 메서드를 호출하여 CDPlayer 객체의 생성자 매개변수로 입력.
	}*/
	
	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {	// 스프링에 의해 빈으로 등록된 CompactDisc와 동일한 자료형의 빈을 매개변수로 자동으로 주입(@Autowired)해준다. 
																					// 매개변수로 필요한 빈과 동일한 자료형의 빈이 스프링에 의해 등록되어 있지 않으면 주입할 수 없다. 
		return new CDPlayer(compactDisc);
	}
	
}
