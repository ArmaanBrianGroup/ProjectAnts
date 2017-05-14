package simulation;

import java.awt.Color;

import com.sun.xml.internal.bind.v2.TODO;

import GUI.Map_Section;
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
	
	private Map_Section section;
	
	public double[] vision_dist;
	public Sim_Object[] vision;
	
	public int[] traits; //TODO set this up
 	
	public Ant(int x, int y, Map_Section section) {
		super(x, y, 5, Color.red, 1);
		this.section = section;

		vision = new Sim_Object[4];
		vision_dist = new double[4];
		
		int[] layout = new int[]{3*sight, 5, 2};
		
		String s = "";
		for (int i = 0; i < (layout[0]*layout[1] + layout[1]*layout[2]) * 64; i++) {
			s += Math.random() > .5 ? "1" : "0";
		}
		
		brain = new Network(layout, true);
		
		traits = new int[4];
		for (int i = 0; i < traits.length; i++) {
			traits[i] = (int) (Math.random()*100 + 1);
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
		
		for (int i = 0; i < this.vision.length; i+=3) {
			//System.out.println(this.vision);
			double a = 0, b = 0, c = -1;
			
			if (this.vision[i] != null){
			  a = this.vision[i].getX();
			  b = this.vision[i].getY();
			  c = this.vision[i].getType();
			}
			
			vision[i] = a;
			vision[i+1] = b;
			vision[i+2] = c;		
		}
		double[] out = brain.getOutput(vision);
		
		//System.out.println(vision[0] + " " + vision[1] + " " +  vision[2]);
		
		int xD = (int) ((out[0] - 0.5)*speed);
		int yD = (int) ((out[1] - 0.5)*speed);
				
		x += xD;
		y += yD;
	}
	
	public void update() {
		move();
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

		if (object != this) {
			double distance = Math.pow(getX() - object.getX(), 2) + Math.pow(getY() - object.getY(), 2);
			double sumRadii = (double) (getRadius() + object.getRadius());
			
			
			//System.out.println(distance + " " + (sumRadii*sumRadii));
			
			if (distance <= sumRadii*sumRadii) {
				if (object.getType() == 0) {
					energy += object.getRadius();
				} else if (object.getType() == 1){
					section.addAnt(Evolver.breedN(this, (Ant) object));
				}
			} else if (distance <= (double) sight*sight) {
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
	
	
	public Map_Section getSection() {
		return section;
	}
	
	
	
}
