package GUI;


import javax.swing.JFrame;
import simulation.Sim_Object;

public class Manager  {
	
	private Window w;
	private JFrame f;
	private int x, y;
	private Input_Handler handler;
	private Full_Map map;
	private int lastX = 0, lastY = 0;
	
	public Manager(int x, int y, int[][][] pixels) {
		this.x = x;
		this.y = y;
	
		
		w = new Window(x, y, new Image(x, y, pixels));  
		
		f = new JFrame();  
		f.add(w);  
		w.addMouseListener(handler);

		map = new Full_Map(x, y, x, y, 16, 16);
			        
		f.setSize(x, y);
		f.setVisible(true); 
	}
	
	public Manager(int x, int y) {
		this.x = x;
		this.y = y;
	
		
		w = new Window(x, y, new Image(x, y)); 
		map = new Full_Map(x, y, x, y, 16, 16);
		handler = new Input_Handler((x*16)/2, (y*16)/2, map);
		
		f = new JFrame();  
		f.add(w);  
		w.addMouseListener(handler);
		f.addKeyListener(handler);

			        
		f.setSize(x, y);
		f.setVisible(true); 
		
	}
	
	public void updateWindow(int[][][] pixels) {
		w.drawImage(new Image(x, y, pixels));
	}
	
	public Full_Map getMap() {
		return map;
	}
	
	//TODO will not update screen if objects move independently!!!!
	public void update() {
		if (lastX != handler.getX() || lastY != handler.getY()) {
			lastX = handler.getX();
			lastY = handler.getY();
			map.refresh();
			w.drawImage(map.update(handler.getX(), handler.getY()));
		}
	}
}
