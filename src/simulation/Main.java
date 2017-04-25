package simulation;



import GUI.Manager;

public class Main {
	private static Manager m = new Manager(500, 500, 16, 16);
	private static Ant a = new Ant(150, 150, 100, 0);


	public static void main(String[] args) {		
		for (int i = 0; i < m.getMap().map.length; i++) {
			for (int x = 0; x < m.getMap().map[0].length; x++) {
				m.getMap().getSection(i, x).addObjectClump((int) (Math.random()*500), (int) (Math.random()*500), 25, 50, 100, Sim_Object.Type.FOOD);
			}
		}
		
		Timer t = new Timer(60);
		t.run();
		
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
	
	public static void update() {
		m.update();
	}
	
}
