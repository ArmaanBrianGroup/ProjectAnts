package GUI;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends Canvas{

	private int win_x, win_y;
	public  int x, y; 
	private int vel_x = (int) (Math.random() *11) - 1, vel_y = (int) (Math.random() *11) - 1;
	
	public Window(int win_x, int win_y) {
		this.win_x = win_x;
		this.win_y = win_y;
	}
	
	public void paint(Graphics g) { 
		g.setColor(Color.black);
		System.out.println(x + " " + y);
		g.fillRect(x, y, 100, 100);
		x += vel_x;
        y += vel_y;
        
        if (x > win_x - 100 || x < 0) vel_x *= -1;
        if (y > win_y - 100 || y < 0) vel_y *= -1;
    }  
}
