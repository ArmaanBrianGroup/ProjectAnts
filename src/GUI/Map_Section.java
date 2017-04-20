package GUI;

import java.util.ArrayList;

import simulation.Sim_Object;

public class Map_Section {
	private int x, y;
	private ArrayList<Sim_Object> objects;
	private Image image;
	
	Map_Section (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void addObject(Sim_Object newObj) {
		objects.add(newObj);
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
