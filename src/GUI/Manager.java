package GUI;


import javax.swing.JFrame;
import simulation.Sim_Object;

public class Manager  {
	
	private Window w;
	private JFrame f;
	public int displayX, displayY;
	private Input_Handler handler;
	private Full_Map map;
	public int subX, subY;
	public Manager(int x, int y, int[][][] pixels) {
		this.displayX = x;
		this.displayY = y;
	
		
		w = new Window(x, y, new Image(x, y, pixels));  
		
		f = new JFrame();  
		f.add(w);  
		w.addMouseListener(handler);

		map = new Full_Map(x, y, x, y, 16, 16);
			        
		f.setSize(x, y);
		f.setVisible(true); 
	}
	
	public Manager(int displayX, int displayY, int subX, int subY) {
		this.displayX = displayX;
		this.displayY = displayY;
		this.subX = subX;
		this.subY = subY;
		
		w = new Window(displayX, displayY, new Image(displayX, displayY)); 
		map = new Full_Map(displayX, displayY, displayX, displayY, subX, subY);
		handler = new Input_Handler(map);
		
		f = new JFrame();  
		f.add(w);  
		w.addMouseListener(handler);
		f.addKeyListener(handler);

			        
		f.setSize(displayX, displayY);
		f.setVisible(true); 
		
	}
	
	public void updateWindow(int[][][] pixels) {
		w.drawImage(new Image(displayX, displayY, pixels));
	}
	
	public Full_Map getMap() {
		return map;
	}
	
	//TODO will not update screen if objects move independently!!!!
	public void update() {
		map.refresh();
		w.drawImage(map.render());
	}
	
	public int getDisplayX() {
		return displayX;
	}
	public int getDisplayY(){
		return displayY;
	}
	public int getSubX() {
		return subX;
	}
	public int getSubY() {
		return subY;
	}
}