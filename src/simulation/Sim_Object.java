package simulation;

import java.awt.Color;

import com.sun.javafx.geom.Shape;

public abstract class Sim_Object {
	protected Color color;
	protected int x, y, num, radius, width, height;
	protected boolean circle;
	
	public Sim_Object(int x, int y, int num, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.radius = radius;
		this.color = color;
		circle = true;
	}
	
	public Sim_Object(int x, int y, int num, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.width = width;
		this.height = height;
		this.color = color;
		circle = true;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean isCircle() {
		return circle;
	}
	
	public int getRadius() {
		return circle ? radius : null;
	}
	
	public int getWidth() {
		return !circle ? width : null;
	}
	
	public int getHeight() {
		return !circle ? height : null;
	}
	
	public Color getColor() {
		return color;
	}
}
