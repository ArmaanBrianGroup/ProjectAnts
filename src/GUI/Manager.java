package GUI;


import javax.swing.JFrame;
import simulation.Sim_Object;

public class Manager  {
	
	private Window w;
	private JFrame f;
	private int x, y;
	private Input_Handler handler = new Input_Handler();
	private Map_Section map;
	
	public Manager(int x, int y, int[][][] pixels) {
		this.x = x;
		this.y = y;
	
		
		w = new Window(x, y, new Image(x, y, pixels));  
		
		f = new JFrame();  
		f.add(w);  
		w.addMouseListener(handler);

		map = new Map_Section(x, y);
			        
		f.setSize(x, y);
		f.setVisible(true); 
	}
	
	public Manager(int x, int y) {
		this.x = x;
		this.y = y;
	
		w = new Window(x, y, new Image(x, y));  

		
		f = new JFrame();  
		f.add(w);  
		w.addMouseListener(handler);

		map = new Map_Section(x, y);
			        
		f.setSize(x, y);
		f.setVisible(true); 
		
	}
	
	public void updateWindow(int[][][] pixels) {
		w.drawImage(new Image(x, y, pixels));
	}
	
	public Map_Section getMap() {
		return map;
	}
	
	public void update() {
		w.drawImage(map.updateImage());
	}
}
