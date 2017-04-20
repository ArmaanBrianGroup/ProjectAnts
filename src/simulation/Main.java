package simulation;



import GUI.Manager;

public class Main {

	public static void main(String[] args) {
		
		int image[][][] = new int[500][500][3];
		for (int i = 0; i < image.length; i++) {
			for (int x = 0; x < image[i].length; x++) {
				for (int y = 0; y < image[i][x].length; y++) {
					image[i][x][y] = (int) (Math.random()*256);
				}
			}
		}
		
		Manager m = new Manager(500, 500, image);
		
		
		/*int[] layout = new int[]{5, 5, 5};
		double[] input = new double[]{1, 1, 1, 1, 1};
		
		String s = "";
		for (int i = 0; i < 50*64; i++) {
			s += Math.random() > .5 ? "1" : "0";
		}
		
		
		
		Network net = new Network(layout, s, true);
		input = net.getOutput(input);
		
		for (double i : input) {
			System.out.println(i);
		}*/
		
	}
	
}
