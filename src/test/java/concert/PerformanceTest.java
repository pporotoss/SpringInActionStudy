package concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConcertConfig.class)
public class PerformanceTest {
	
	@Autowired
	Performance performance;
	
	@Autowired
	Performance failPerformance;
	
	@Test
	public void success_PerformanceTest() {
		performance.perform();
	}
	
	@Test(expected=RuntimeException.class)
	public void fail_PerformanceTest() {
		failPerformance.perform();
	}
	
	
	static class FailPerformance implements Performance {
		@Override
		public void perform() {
			System.out.println("Performance...");
			throw new RuntimeException();
		}
	}
	
}
