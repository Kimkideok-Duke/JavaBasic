package a01_diexp.z10_vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("music01")
public class Music {
	@Value("${m.song}")
	private String song;
	@Value("${m.singer}")
	private String singer;

	public Music() {
	}

	public Music(String song, String singer) {
		this.song = song;
		this.singer = singer;
	}

	public String getSong() {
		return this.song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getSinger() {
		return this.singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
