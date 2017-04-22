package simulation;



import GUI.Manager;

public class Main {
	private static Manager m = new Manager(500, 500);
	private static Ant a = new Ant(100, 200, 0);


	public static void main(String[] args) {		
		start(4);
		
		
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
	
	public static void start(int FPS) {
		while (true) {
			try {
				Thread.sleep(1000/FPS);
				m.getMap().addObjectClump(250, 250, 25, 50, 100, Sim_Object.Type.FOOD);;
				m.update();
				m.getMap().clearObjects();
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}
	}
	
}
