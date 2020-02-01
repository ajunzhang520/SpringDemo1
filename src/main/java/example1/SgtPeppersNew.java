package example1;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppersNew implements CompactDisc {
	private String title = "SgtPeppersNew";
	private String artist = "NewPlayer";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}
