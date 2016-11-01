package soundsystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TrackCounterConfig.class)
public class TrackCounterTest {

	@Autowired
	private CompactDisc compactDisc;
	
	@Autowired
	private TrackCounter trackCounter;

	
	@Test
	public void testTrackCounter() {
		compactDisc.playTrack(1);
		compactDisc.playTrack(2);
		compactDisc.playTrack(3);
		compactDisc.playTrack(3);
		compactDisc.playTrack(3);
		compactDisc.playTrack(3);
		compactDisc.playTrack(7);
		compactDisc.playTrack(7);
		
		assertEquals(1, trackCounter.getPlayCount(1));
		assertEquals(1, trackCounter.getPlayCount(2));
		assertEquals(4, trackCounter.getPlayCount(3));
		assertEquals(0, trackCounter.getPlayCount(4));
		assertEquals(0, trackCounter.getPlayCount(5));
		assertEquals(0, trackCounter.getPlayCount(6));
		assertEquals(2, trackCounter.getPlayCount(7));
	}
}
