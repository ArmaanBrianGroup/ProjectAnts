package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends Canvas{

	private int win_x, win_y;
	private Image image;
	
	
	public Window(int win_x, int win_y, Image image) {
		this.win_x = win_x;
		this.win_y = win_y;
		this.image = image;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image.getImage(), 0, 0, image.getImage().getWidth(), image.getImage().getHeight(), null);
	}
	
	public void drawImage(Image image) {
		this.image = image;
		repaint();
	}
}
