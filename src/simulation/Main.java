package simulation;



import GUI.Manager;

public class Main {
	private static Manager m = new Manager(500, 500);
	private static Ant a = new Ant(150, 150, 100, 0);


	public static void main(String[] args) {		
		m.getMap().getSection(0,0).addObject(a);
		m.getMap().getSection(1,0).addObject(a);
		m.getMap().getSection(0,1).addObject(a);
		m.getMap().getSection(1,1).addObject(a);
		m.update();
		
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
