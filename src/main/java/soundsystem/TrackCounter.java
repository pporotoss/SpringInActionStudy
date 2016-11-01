package soundsystem;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
	
	private Map<Integer, Integer> trackCounts = new HashMap<>();	// 트랙 재생여부와 재생 횟수를 저장할 해시맵.
	
	@Pointcut("execution(* soundsystem.CompactDisc.playTrack(int))"	// 메서드 이름이 playTrack()이면서 매개변수의 자료형이 int형이고, 
					+" && args(trackNumber)") 											// 매개변수의 이름이 trackNumber인 메서드.
	
	public void trackPlayed(int trackNumber) {}
	
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber) {
		int currentCount = getPlayCount(trackNumber);
		trackCounts.put(trackNumber, currentCount+1);	// 해시맵의 경우 중복 키가 입력되면, 키의 중복을 허용하지 않기 때문에 덮어쓴다.
	}
	
	public int getPlayCount(int trackNumber) {
		return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;	// 이전에 해당 트랙을 재생했으면, 재생횟수를 반환. 아니면 0을 반환. 
	}
}
