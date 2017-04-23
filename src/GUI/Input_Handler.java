package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;





public class Input_Handler implements ActionListener, MouseListener, KeyListener {
	private int x, y;
	private Full_Map map;
	
	
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
		if (e.getKeyCode() == KeyEvent.VK_UP && e.getKeyCode() == KeyEvent.VK_LEFT) {
			y+=5;
			x+=5;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && e.getKeyCode() == KeyEvent.VK_LEFT) {
			y-=5;
			x+=5;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && e.getKeyCode() == KeyEvent.VK_RIGHT) {
			y+=5;
			x-=5;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && e.getKeyCode() == KeyEvent.VK_RIGHT) {
			y-=5;
			x-=5;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) y+=5;
		if (e.getKeyCode() == KeyEvent.VK_DOWN) y-=5;
		if (e.getKeyCode() == KeyEvent.VK_LEFT) x+=5;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) x-=5;
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
		return x;
	}
	
	public int getY() {
		return y;
	}

}
