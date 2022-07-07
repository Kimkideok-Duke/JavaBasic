package a01_diexp.z10_vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("note01")
public class Note {
	private String size;
	@Autowired(required = false)
	private Pen pen;
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Note(String size, Pen pen) {
		super();
		this.size = size;
		this.pen = pen;
	}
	public Note(String size) {
		super();
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Pen getPen() {
		return pen;
	}
	public void setPen(Pen pen) {
		this.pen = pen;
	}
	public void notepenInfo() {
		System.out.println("펜의 이름은 "+pen.getPname());
		System.out.println("펜의 제조사는 "+pen.getCompany()+"로 노트와 같은 제조사이다.");
		System.out.println("노트의 크기는 "+size);
	}
}
