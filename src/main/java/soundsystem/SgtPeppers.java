package soundsystem;

import org.springframework.stereotype.Component;

@Component("lonelyHeartsClub")	// ComponentScan에 의해 자동으로 등록되는 현재 빈의 이름을 lonelyHeartsClub으로 명명.
public class SgtPeppers implements CompactDisc{
	
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";
	
	@Override
	public void play() {
		System.out.println("Playing "+title+" by "+artist);
	}

}
