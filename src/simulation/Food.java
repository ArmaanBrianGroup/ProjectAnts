package simulation;

import java.awt.Color;

import javafx.scene.shape.Circle;

public class Food extends Sim_Object {

	Color color;
	private int radius;
	private int food;

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getRadius(){
		return radius;
	}
	
	public Food(int x, int y, int food, int num){
		
		super(x, y, num);
		
		this.radius = (int) Math.sqrt(food) * 2;
		this.food = food;
		color = color.green;
	}
}

