package GUI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import simulation.Ant;
import simulation.Food;
import simulation.Sim_Object;

public class Map_Section {
	private int x, y;
	private ArrayList<Sim_Object> objects;
	private Random r = new Random();
	private Image image;
	
	Map_Section (int x, int y) {
		this.x = x;
		this.y = y;
		
		objects = new ArrayList<Sim_Object>();
		
		image = new Image(x,y);
	}
	
	public void addObject(Sim_Object newObj) {
		objects.add(newObj);
		
	}
	
	public void clearObjects() {
		objects.removeAll(objects);
	}
	
	public void addObjectClump(int x, int y, int num, int max_obj_radius, int radius, Sim_Object.Type type) {
		switch (type) {
			case ANT:
				for (int i = 0; i < num; i++){
					int obj_x = (int) (r.nextGaussian()*(radius/3) + x);
					int obj_y = (int) (r.nextGaussian()*(radius/3) + y);
					objects.add(new Ant(obj_x, obj_y, objects.size()));
				}
				
			case FOOD:
				for (int i = 0; i < num; i++){
					int obj_x = (int) (r.nextGaussian()*(radius/3) + x);
					int obj_y = (int) (r.nextGaussian()*(radius/3) + y);
					int obj_radius = r.nextInt(max_obj_radius) +1;
					Color c = new Color((int) (Math.random()*50), (int) (Math.random()*56 + 200), ((int) (Math.random()*100)));
					objects.add(new Food(obj_x, obj_y, obj_radius, objects.size(), c));
				}
		}
	}
	
	public Image updateImage() {
		image.resetImage();
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).isCircle()) {
				image.drawCircle(objects.get(i).getColor(), objects.get(i).getX(), objects.get(i).getY(), objects.get(i).getRadius());
			} else {
				image.drawRect(objects.get(i).getColor(), objects.get(i).getX(), objects.get(i).getY(), objects.get(i).getWidth(), objects.get(i).getHeight());
			}
		}

		return image;
	}
	
}
