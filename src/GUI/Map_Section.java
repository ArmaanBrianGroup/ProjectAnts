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
					int obj_x = Math.max((int) (r.nextGaussian()*(radius/3) + x), 0);
					int obj_y = Math.max((int) (r.nextGaussian()*(radius/3) + y), 0);
					objects.add(new Ant(obj_x, obj_y, objects.size()));
				}
				
			case FOOD:
				for (int i = 0; i < num; i++){
					int obj_x = (int) (r.nextGaussian()*(radius/3) + x);
						obj_x = obj_x > this.x ? this.x : (obj_x < 0 ? 0 : obj_x);
					
					int obj_y = (int) (r.nextGaussian()*(radius/3) + y);
						obj_y = obj_y > this.y ? this.y : (obj_y < 0 ? 0 : obj_y);
						
					int obj_radius = 
							(obj_x+max_obj_radius*2 > this.x)  || (obj_y+max_obj_radius*2 > this.y) ? 
							r.nextInt(Math.max(Math.min(this.x-obj_x, this.y-obj_y), 1)) : r.nextInt(max_obj_radius);
					Color c = new Color((int) (Math.random()*150), (int) (Math.random()*56 + 200), ((int) (Math.random()*150)));
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
	
	public void drawToImage(Image image, int xOffset, int yOffset) {
		for (int i = 0; i < objects.size(); i++) {

			if (objects.get(i).isCircle() && isWithinDrawingBounds(xOffset, yOffset, i)) {			
				image.drawCircle(objects.get(i).getColor(), objects.get(i).getX() + xOffset, objects.get(i).getY() + yOffset, objects.get(i).getRadius());
			}
		}
	}
	

	public boolean isWithinDrawingBounds(int xOffset, int yOffset, int index) { 
		Sim_Object o = objects.get(index);
		return o.getBottomY() + yOffset >= 0 && o.getTopY() + yOffset <= y && o.getRightX() + xOffset >= 0 && o.getLeftX() + xOffset <= x;
		//return true;
	}
	
	public void clickOnObject(int x, int y) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).withinBounds(x, y)) {
				System.out.println(x + " " + y + " " + objects.get(i).getCenterX() + " " + objects.get(i).getBottomY() + " " + objects.get(i).getRadius());
			}
		}
	}
	
}
