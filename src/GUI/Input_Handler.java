package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;





public class Input_Handler implements ActionListener, MouseListener, KeyListener {
	private int x, y;
	private Full_Map map;
	private ArrayList<Integer> keys = new ArrayList();
	
	public Input_Handler(int x, int y, Full_Map map) {
		this.x = x;
		this.y = y;
		this.map = map;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {


	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		map.clickOnObject(e.getX(), e.getY(), x, y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) keys.add(1);
		if (e.getKeyCode() == KeyEvent.VK_DOWN) keys.add(2);
		if (e.getKeyCode() == KeyEvent.VK_LEFT) keys.add(3);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) keys.add(4);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public int getX() {
		
		for (int i = 0; i < keys.size(); i++) {
			int k = keys.get(i);
			if (k == 1) y-=10;
			else if (k == 2) y+=10;
			else if (k == 3) x-=10;
			else if (k == 4) x+=10;
			keys.remove(i);
		}
		
		return x;
	}
	
	public int getY() {
		return y;
	}

}
