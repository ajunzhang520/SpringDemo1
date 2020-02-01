package javaconfig;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
	private String title = "SgtPeppers";
	private String artist = "Player";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
