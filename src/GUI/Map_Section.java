package GUI;

import java.util.ArrayList;

import simulation.Sim_Object;

public class Map_Section {
	private int x, y;
	private ArrayList<Sim_Object> objects;
	
	Map_Section (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void addObject(Sim_Object newObj) {
		objects.add(newObj);
	}
	
	
}
