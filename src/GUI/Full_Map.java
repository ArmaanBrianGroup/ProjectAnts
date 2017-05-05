package GUI;

import java.awt.Color;
import java.util.ArrayList;

public class Full_Map {
	
	public Map_Section[][] map;
	int displayX, displayY, subX, subY;
	private int Map_SectionX;
	private int Map_SectionY;
	private Image image;
	private int xPos, yPos;
		
	public Full_Map(int displayX, int displayY, int Map_SectionX, int Map_SectionY, int sectionsX, int sectionsY) {
		this.displayX = displayX;
		this.displayY = displayY;
		subX = sectionsX;
		subY = sectionsY;
		this.Map_SectionX = Map_SectionX;
		this.Map_SectionY = Map_SectionY;
		Map_Section.map = this;
		map = new Map_Section[sectionsY][sectionsX];
		for (int i = 0; i < map.length; i++) {
			for (int x = 0; x < map[i].length; x++) {
				map[i][x] = new Map_Section(Map_SectionX, Map_SectionY, i, x);
			}
		}	
		
		image = new Image(displayX, displayY);
		
		xPos = displayX*map.length/2;
		yPos = displayY*map[0].length/2;
	}
	
	public int getSectionsX() {
		return map[0].length;
	}
	
	public int getSectionsY() {
		return map.length;
	}
	public void refresh() {
		updateObjects();
		image.resetImage();
	}
	
	public void updateXY(ArrayList<Integer> keys) {
		for (int i = 0; i < keys.size(); i++) {
			int k = keys.get(i);
			if (k == 1) yPos+=50;
			else if (k == 2) yPos-=50;
			else if (k == 3) xPos+=50;
			else if (k == 4) xPos-=50;
			keys.remove(i);
		}
	}
	
	public Image render() {
		if (xPos <= 0) xPos = 0; else if (xPos >= displayX*map[0].length-Map_SectionX) xPos = displayX*map[0].length-Map_SectionX;
		if (yPos <= 0) yPos = 0; else if (yPos >= displayY*map.length-Map_SectionY) yPos = displayY*map.length-Map_SectionY;

		int x = xPos/Map_SectionX, i = yPos/Map_SectionY;
		
		/*map[i][x].drawToImage(image, xPos - x*Map_SectionX, yPos - i*Map_SectionY);
		map[i+1][x].drawToImage(image, xPos - x*Map_SectionX, yPos - (i+1)*Map_SectionY);
		map[i][x+1].drawToImage(image, xPos - (x+1)*Map_SectionX, yPos - i*Map_SectionY);
		map[i+1][x+1].drawToImage(image, xPos - (x+1)*Map_SectionX, yPos - (i+1)*Map_SectionY);	*/
		 
		for (int a = 0; a < 2 * (displayY/Map_SectionY) && i+a < map.length; a++) {
			for (int b = 0; b < 2 * (displayX/Map_SectionX) && x+b < map[i+a].length; b++) {
				map[i+a][x+b].drawToImage(image, xPos - (x+b)*Map_SectionX, yPos - (i+a)*Map_SectionY);
			}
		}
		
		image.drawLine(Color.red, 0, Map_SectionY, yPos%Map_SectionY, yPos%Map_SectionY);
		image.drawLine(Color.red, xPos%Map_SectionX, xPos%Map_SectionX, 0, Map_SectionX);

		
		return image;
	}
	
	public void updateObjects() {
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[0].length; c++) {
				map[r][c].updateSection();
			}
		}
	}
	public Map_Section getSection(int i, int x) {
		return map[i][x];
	}
	
	public void clickOnObject(int mouseX, int mouseY, int xPos, int yPos) {
		int i = (yPos+mouseY)/Map_SectionY;
		int x = (xPos+mouseX)/Map_SectionX;
		//System.out.println((yPos+mouseY)%Map_SectionY + " " + x);
		map[i][x].clickOnObject(mouseX - xPos%Map_SectionX, mouseY - yPos%Map_SectionY);
	}
	
	public int getX() {
		return xPos;
	} 
	
	public int getY() {
		return yPos;
	}
	
	//public void moveTo
	
}
