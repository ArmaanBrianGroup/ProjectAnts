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
	
	public double[] vision_dist;
	public Sim_Object[] vision;
	
	public int[] traits; //TODO set this up
 	
	public Ant(int x, int y) {
		super(x, y, 5, Color.red, 1);
		
		vision = new Sim_Object[sight];
		vision_dist = new double[sight];
		
		int[] layout = new int[]{3*sight, 5, 2};
		
		String s = "";
		for (int i = 0; i < (layout[0]*layout[1] + layout[1]*layout[2]) * 64; i++) {
			s += Math.random() > .5 ? "1" : "0";
		}
		
		brain = new Network(layout, s, true);
		
		traits = new int[4];
		for (int i = 0; i < traits.length; i++) {
			traits[i] = (int) (Math.random()*10 + 1);
		}
		
		health = traits[0];
		strength = traits[1];
		speed = traits[2];
		sight = traits[3];
	}
	
	
	public void setTraits(int[] traits) {
		this.traits = traits;
	}
	
	public void withinViewingDistance(double distance) {
		
	}
	
	public void move () { 
		double vision[] = new double[this.vision.length * 3];
		
		int index = 0;
		for (int i = 0; i < this.vision.length; i+=4) {
			vision[i] = (double) this.vision[i].getX();
			vision[i+1] = (double) this.vision[i].getY();
			vision[i+2] = (double) this.vision[i].getType();		
		}
		
		double[] out = brain.getOutput(vision);
		 x += out[0]*speed;
		 y += out[1]*speed;
	}
	
	public void update() {
		move();
		energy--;
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
	public void checkCollision(Sim_Object object) {
		int deltaX = getCenterX() - object.getCenterX();
		int deltaY = getCenterY() - object.getCenterY();
		double distance = deltaX*deltaX + deltaY*deltaY;
		int sumRadii = getRadius()+object.getRadius();
		
		if (distance <= sumRadii*sumRadii) {
			if (object.getType() == 0) {
				energy += object.getRadius();
			} else if (object.getType() == 1){
				
			}
			
		} else if (distance <= (double) sight) {
			
			for (int i = 0; i < vision.length; i++) {
				if (vision_dist[i] < distance) {
					Sim_Object last = object;
					double dist = distance;
					for (int x = i; x < vision.length; x++) {
						double distTemp = vision_dist[i];
						Sim_Object temp = vision[i];
					
						vision[i] = object;
						vision_dist[i] = dist;
						
						dist = distTemp;
						last = temp;
					}
				}
			}
		}
	}
	
	
	
}
