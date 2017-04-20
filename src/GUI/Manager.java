package GUI;

import javax.swing.JFrame;

public class Manager  {
	
	private Window w;
	private JFrame f;
	private int x, y;
	private Input_Handler handler = new Input_Handler();
	
	public Manager(int x, int y, int[][][] pixels) {
		this.x = x;
		this.y = y;
	
		
		w = new Window(x, y, new Image(x, y, pixels));  
		
		f = new JFrame();  
		f.add(w);  
		w.addMouseListener(handler);

			        
		f.setSize(x, y);
		f.setVisible(true); 
	}
	
	public void updateWindow(int[][][] pixels) {
		w.drawImage(new Image(x, y, pixels));
	}
}
