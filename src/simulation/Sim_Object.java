package simulation;

import java.awt.Color;

import com.sun.javafx.geom.Shape;

public abstract class Sim_Object {
	protected Color color;
	protected int x, y, num, radius, width, height;
	protected boolean circle;
	public static enum Type {
		ANT, FOOD;
	}
	
	//TODO make code work if object is not a rectangle
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
	
	public boolean withinBounds(int x, int y) {
		return Math.sqrt( Math.pow(x-getCenterX(), 2) + Math.pow(y-getCenterY(), 2) ) <= radius;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getCenterX() {
		return x+radius;
	}
	
	public int getCenterY() {
		return y+radius;
	}
	
	public int getTopY() {
		return getCenterY()-radius;
	}
	
	public int getBottomY() {
		return getCenterY()+radius;
	}
	
	public int getLeftX() {
		return getCenterX()-radius;
	}
	
	public int getRightX() {
		return getCenterX()+radius;
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
