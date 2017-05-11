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

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getRightX() {
		return x+radius*2;
	}
	public int getBottomY() {
		return y+radius*2;
	}
	public int getCenterX() {
		return x+radius;
	}
	public int getCenterY() {
		return y+radius;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
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
	
	public boolean withinBounds(int x, int y) {
		boolean isX = x <= getRightX() && x >= getX();
		boolean isY = y <= getBottomY() && y >= getY();
		return isX && isY;
	}
	
	public int getType () {
		return type;
	}
}
