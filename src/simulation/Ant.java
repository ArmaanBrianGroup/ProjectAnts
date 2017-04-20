package simulation;

import java.awt.Color;

import com.sun.xml.internal.bind.v2.TODO;

import neural_network.Network;

public class Ant extends Sim_Object {
	public Network brain;
	public int hive;
	public int lastMove;
	public int energy;
	
	public int strength;
	public int health;
	public int speed;
	public int sight;
	
	public Ant(int x, int y, int num) {
		super(x, y, num, 1, Color.red); //TODO change radius
		
		
		int[] layout = new int[]{5, 5, 5};
		
		String s = "";
		for (int i = 0; i < (layout[0]*layout[1] + layout[1]*layout[2]) * 64; i++) {
			s += Math.random() > .5 ? "1" : "0";
		}
		
		brain = new Network(layout, s, true);		
	}
	
	public void move (double[] boardInfo) { 
		lastMove = brain.getMaxOutputIndex(boardInfo);
	}
	
	public int getXChange() {
		if (lastMove == 0) return 1;
		else if (lastMove == 1) return -1;
		else if (lastMove == 2) return 0;
		else if (lastMove == 3) return 0;
		else return 0;
	}
	
	public int getYChange() {
		if (lastMove == 0) return 0;
		else if (lastMove == 1) return 0;
		else if (lastMove == 2) return 1;
		else if (lastMove == 3) return -1;
		else return 0;
	}
	
	
	
}
