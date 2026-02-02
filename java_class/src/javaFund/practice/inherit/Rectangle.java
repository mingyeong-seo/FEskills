package javaFund.practice.inherit;

public class Rectangle extends Shape {
	int width;
	int height;
	
	public Rectangle(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	@Override
	int getArea() {
		return width*height;
	}
}
