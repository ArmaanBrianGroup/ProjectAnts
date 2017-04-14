package GUI;

import javax.swing.JFrame;

public class Manager {
	
	private Window w;
	private double delay;
	public Manager(int x, int y, double delay) {
		w = new Window(x, y);  
		this.delay = delay;
		
		JFrame f = new JFrame();  
		f.add(w);  
			        
		f.setSize(x, y);
		f.setVisible(true); 
	}
	
	public void animate() {
		new Animator().start(w, delay);
	}
}
