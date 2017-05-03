package simulation;

import java.awt.Color;

import com.sun.javafx.geom.Shape;

public abstract class Sim_Object {
	protected Color color;
	protected int x, y, num, radius;
	boolean circle = true;
	public Sim_Object(int x, int y, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
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
	
	public abstract boolean actOnCollision(Sim_Object collidedWith);
}
