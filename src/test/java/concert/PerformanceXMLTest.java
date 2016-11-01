package concert;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/concertconfig.xml")
public class PerformanceXMLTest {

	@Autowired
	private Performance performance;
	
	
	@Test
	public void beanInjectionTest() {
		assertNotNull(performance);
	}
	
	@Test
	public void aopTest() {
		performance.perform();
	}
	
	@Test
	@DirtiesContext
	public void aroundAspectTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/aroundconcertconfig.xml");
		performance = (Performance) context.getBean("performance");
		performance.perform();
	}

}
