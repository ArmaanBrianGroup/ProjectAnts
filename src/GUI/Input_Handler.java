package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;





public class Input_Handler implements ActionListener, MouseListener, KeyListener {
	
	private Full_Map map;
	private ArrayList<Integer> keys = new ArrayList();
	
	public Input_Handler(Full_Map map) {
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
		//map.clickOnObject(e.getX(), e.getY(), map.getX(), map.getY());
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
		
		map.updateXY(keys);
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
}
