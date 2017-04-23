package GUI;

public class Full_Map {
	
	private Map_Section[][] map;
	private int displayX, displayY, Map_SectionX, Map_SectionY;
	private Image image;
		
	public Full_Map(int displayX, int displayY, int Map_SectionX, int Map_SectionY, int sectionsX, int sectionsY) {
		this.displayX = displayX;
		this.displayY = displayY;
		this.Map_SectionX = Map_SectionX;
		this.Map_SectionY = Map_SectionY;
		
		map = new Map_Section[sectionsY][sectionsX];
		for (int i = 0; i < map.length; i++) {
			for (int x = 0; x < map[i].length; x++) {
				map[i][x] = new Map_Section(Map_SectionX, Map_SectionY);
			}
		}	
		
		image = new Image(displayX, displayY);
	}
	
	public void refresh() {
		image.resetImage();
	}
	
	public Image update(int xPos, int yPos) {
		if (xPos < 0) xPos = 0; else if (xPos > displayX*map[0].length) xPos = displayX*map[0].length-Map_SectionX;
		if (yPos < 0) yPos = 0; else if (yPos > displayY*map.length) yPos = displayY*map.length-Map_SectionY;

		int x = xPos/Map_SectionX, i = yPos/Map_SectionY;

		map[i][x].drawToImage(image, xPos - x*Map_SectionX, yPos - i*Map_SectionY);
		map[i+1][x].drawToImage(image, xPos - x*Map_SectionX, yPos - (i+1)*Map_SectionY);
		map[i][x+1].drawToImage(image, xPos - (x+1)*Map_SectionX, yPos - i*Map_SectionY);
		map[i+1][x+1].drawToImage(image, xPos - (x+1)*Map_SectionX, yPos - (i+1)*Map_SectionY);	
		
		System.out.println("");

		return image;
	}
	
	public Map_Section getSection(int i, int x) {
		return map[i][x];
	}
	
}
