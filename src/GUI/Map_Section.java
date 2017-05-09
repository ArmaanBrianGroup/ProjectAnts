package GUI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import simulation.Ant;
import simulation.Food;
import simulation.Sim_Object;

public class Map_Section {
	private int x, y;
	private int sectionX, sectionY;
	private ArrayList<Sim_Object> objects;
	private Random r = new Random();
	private Image image;
	public static Full_Map map;
	
	Map_Section (int x, int y, int sectionX, int sectionY) {
		this.x = x;
		this.y = y;
		this.sectionX = sectionX;
		this.sectionY = sectionY;
		
		objects = new ArrayList<Sim_Object>();
		
		image = new Image(x,y);
	}
	
	public void addObject(Sim_Object newObj) {
		objects.add(newObj);
		
	}
	
	public void clearObjects() {
		objects.removeAll(objects);
	}
	
	public void addAnt(int x, int y) {
		objects.add(new Ant(x,y, this));
	}
	
	public void addAnt(Ant a) {
		objects.add(a);
	}
	
	public void addAnt() {
		objects.add(new Ant((int)(Math.random()*x), (int)Math.random()*y, this));
	}

	public void moveSection() {
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).getX() > map.displayX && sectionX == map.subX - 1) objects.get(i).setX(map.displayX);
			if(objects.get(i).getY() > map.displayY && sectionY == map.subY - 1) objects.get(i).setY(map.displayY);
			if(objects.get(i).getX() < 0 && sectionX == 0) objects.get(i).setX(0);
			if(objects.get(i).getY() < 0 && sectionY == 0) {objects.get(i).setY(0);
			
			}
			if(objects.get(i).getX() < 0) {
				objects.get(i).setX(objects.get(i).getX() + map.displayX);
				map.getSection(sectionX - 1, sectionY).objects.add(objects.remove(i));
			}
			else if(objects.get(i).getY() < 0) {
				objects.get(i).setY(objects.get(i).getY() + map.displayY);
				map.getSection(sectionX, sectionY - 1).objects.add(objects.remove(i));
			}
			else if(objects.get(i).getX() > map.displayX) {
				objects.get(i).setX(objects.get(i).getX() - map.displayX);

				map.getSection(sectionX + 1, sectionY).objects.add(objects.remove(i)); 
			}
			else if(objects.get(i).getY() > map.displayY) {
				objects.get(i).setY(objects.get(i).getY() - map.displayY);
				map.getSection(sectionX, sectionY + 1).objects.add(objects.remove(i));
			}
			
		}
	}
	public void addFoodClump(int x, int y, int num, int max_obj_radius, int radius) {
			
		for (int i = 0; i < num; i++){
				int obj_x = (int) (r.nextGaussian()*(radius/3) + x);
					obj_x = obj_x > this.x ? this.x : (obj_x < 0 ? 0 : obj_x);
				
				int obj_y = (int) (r.nextGaussian()*(radius/3) + y);
					obj_y = obj_y > this.y ? this.y : (obj_y < 0 ? 0 : obj_y);
						
				int obj_radius = 
					(obj_x+max_obj_radius*2 > this.x)  || (obj_y+max_obj_radius*2 > this.y) ? 
					r.nextInt(Math.max(Math.min((this.x-obj_x)/2, (this.y-obj_y)/2), 1)) : r.nextInt(max_obj_radius);
				Color c = new Color((int) (Math.random()*150), (int) (Math.random()*56 + 200), ((int) (Math.random()*150)));
				objects.add(new Food(obj_x, obj_y, obj_radius, c));
			}
		
	}
	
//	@Deprecated
//	public Image updateImage() {
//		image.resetImage();
//		for (int i = 0; i < objects.size(); i++) {
//			if (objects.get(i).isCircle()) {
//				image.drawCircle(objects.get(i).getColor(), objects.get(i).getX(), objects.get(i).getY(), objects.get(i).getRadius());
//			} else {
//			//	image.drawRect(objects.get(i).getColor(), objects.get(i).getX(), objects.get(i).getY(), objects.get(i).getWidth(), objects.get(i).getHeight());
//			}
//		}
//
//		for(int i = 0; i < ants.size(); i++) {
//			ants.get(i).update();
//			image.drawCircle(ants.get(i).getColor(), ants.get(i).getX(), ants.get(i).getY(), 100);
//		}
//		return image;
//	}
	
	public void updateSection() {
		moveSection();
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).update();
		}
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
		System.out.println(0);
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).withinBounds(x, y)) {
				System.out.println(x + " " + y + " " + objects.get(i).getCenterX() + " " + objects.get(i).getBottomY() + " " + objects.get(i).getRadius());
			}
		}
	}
	
	public void checkCollisions() {
		for (int i = 0; i < objects.size(); i++) {
			for (int x = 0; x < objects.size(); x++) {
				if (objects.get(i).getType() == 1) objects.get(i).checkCollision(objects.get(x));
			}
		}
	}
	
	
	
	
}
