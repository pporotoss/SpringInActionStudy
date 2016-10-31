package soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)	// 스프링 설정파일 지정. xml의 경우에는 문자열로 해당 경로 주면 된다.
public class CDPlayerTest {
	
	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();
	
	@Autowired
	private CompactDisc compactDisc;
	
	@Autowired
	private MediaPlayer player;
	
	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(compactDisc);
	}
	
	@Test
	public void play() {
		player.play();
		assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles", log.getLog().trim());
	}

}
