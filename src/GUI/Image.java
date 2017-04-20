package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Image {
	
	private BufferedImage image;
	private Graphics2D g;
	private int winx, winy;
	
	public Image(int winx, int winy, int[][][] pixels) {
		this.winx = winx;
		this.winy = winy;
		resetImage(pixels);
		g = image.createGraphics();
	}
	
	public Image(int winx, int winy) {
		this.winx = winx;
		this.winy = winy;
		resetImage();
		g = image.createGraphics();
	}
	
	public void resetImage() {
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
	}
	
	public void resetImage(int[][][] pixels) {
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
		
		for (int i = 0; i < winx; i++) {
			for (int j = 0; j < winy; j++) {
				Color color = new Color(pixels[i][j][0], pixels[i][j][1], pixels[i][j][2]); // Color white
				image.setRGB(i, j, color.getRGB());
			}
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void drawCircle(int red, int green, int blue, int x, int y, int r) {
        g.setColor(new Color(red, green, blue));
        g.fillOval(x, y, r, r);
	}
	
	public void drawCircle(Color c, int x, int y, int r) {
        g.setColor(c);
        g.fillOval(x, y, r, r);
	}
}
