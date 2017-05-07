package simulation;

import java.awt.Color;

import com.sun.javafx.geom.Shape;

public abstract class Sim_Object {
	protected Color color;
	protected int x, y, num, radius;
	protected boolean circle = true;
	protected int type; // 0 = food, 1 = ant ...
	
	public Sim_Object(int x, int y, int radius, Color color, int type) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
		this.type = type;
	}
	

	public abstract void update();
	
	public boolean withinBounds(int x, int y) {
		return Math.sqrt( Math.pow(x-getCenterX(), 2) + Math.pow(y-getCenterY(), 2) ) <= radius;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
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
	
	public Color getColor() {
		return color;
	}
	
	public abstract void checkCollision(Sim_Object object);
	
	public int getType () {
		return type;
	}
}
