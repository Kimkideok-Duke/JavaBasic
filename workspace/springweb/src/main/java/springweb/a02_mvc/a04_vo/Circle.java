package springweb.a02_mvc.a04_vo;

public class Circle {
	private double radius;
	private double dimension;
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Circle(double radius, double dimension) {
		super();
		this.radius = radius;
		this.dimension = dimension;
	}
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getDimension() {
		return dimension;
	}
	public void setDimension(double dimension) {
		this.dimension = dimension;
	}
	public double calcDimension(double radius) {
		return radius*radius*3.141592;
	}
	
}
