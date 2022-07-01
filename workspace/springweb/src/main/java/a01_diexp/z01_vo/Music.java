package a01_diexp.z01_vo;

public class Music {
	private String song;
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
