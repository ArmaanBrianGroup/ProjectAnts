package simulation;

import java.awt.Color;

import javafx.scene.shape.Circle;

public class Food extends Sim_Object {

	private double food; 
	
	
	public void decrease(int n) {
		food = food - n;
	}
	
	public double getFood() {
		return food;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getRadius(){
		return radius;
	}
	
	public Food(int x, int y, int radius, Color c) {

		super(x, y, radius, c, 0);
	}
	public Food(int x, int y, int radius){
		
		super(x, y, radius, Color.green, 0); //TODO change radius
		food = radius * radius / 100;
	}
	public Food(int x, int y, int radius, double food, Color c){
		
		super(x, y, radius, c, 0); //TODO change radius
		this.food = food;
	}
	@Override
	public void checkCollision(Sim_Object object) {
		// TODO make this work
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}

