package simulation;

import java.awt.Color;

import com.sun.xml.internal.bind.v2.TODO;

import neural_network.Network;

public class Ant extends Sim_Object {
	public Network brain;
	public int hive;
	public int lastMove;
	public int energy;
	public int healthPoints;
	
	public int fitness;
	
	public int health; //genetic lifetime
	public int strength;
	public int speed;
	public int sight;
	
	public int[] traits; //TODO set this up
 	
	public Ant(int x, int y) {
		super(x, y, 5, Color.red);
		
		
		/*int[] layout = new int[]{5, 5, 5};
		
		String s = "";
		for (int i = 0; i < (layout[0]*layout[1] + layout[1]*layout[2]) * 64; i++) {
			s += Math.random() > .5 ? "1" : "0";
		}
		
		brain = new Network(layout, s, true);	*/	
	}
	
	public Ant(int x, int y, int[] traits) {
		super(x, y, 100, Color.red); //TODO change radius
		this.traits = traits;
		
		/* int[] layout = new int[]{5, 5, 5};
		
		String s = "";
		for (int i = 0; i < (layout[0]*layout[1] + layout[1]*layout[2]) * 64; i++) {
			s += Math.random() > .5 ? "1" : "0";
		}
		
		brain = new Network(layout, s, true);		*/
	}
	
	public void setTraits(int[] traits) {
		this.traits = traits;
	}
	
	public void move (double[] boardInfo) { 
		//lastMove = brain.getMaxOutputIndex(boardInfo);
		
		
	}
	
	public void update() {

		x--; y--;
		
		
		
	}

	public void moveSection () {

	}
	
	public int getXChange() {

		return 0;
	}
	
	public int getYChange() {

		return 0;
	}
	
	public int getFitness() {
		return fitness;
	}
	public int[] getTraits() {
		return traits;
	}
	
	public Network getNet() {
		return brain;
	}

	@Override
	public boolean actOnCollision(Sim_Object collidedWith) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
