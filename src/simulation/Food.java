package simulation;

import java.awt.Color;

import javafx.scene.shape.Circle;

public class Food extends Sim_Object {

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getRadius(){
		return radius;
	}
	
	public Food(int x, int y, int radius, int num){
		
		super(x, y, num, radius, Color.green); //TODO change radius
	}
	public Food(int x, int y, int radius, int num, Color c){
		
		super(x, y, num, radius, c); //TODO change radius
	}
}

