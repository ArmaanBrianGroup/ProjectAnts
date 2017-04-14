package main_package;


import neural_network.Network;
import GUI.Manager;

public class Main {

	public static void main(String[] args) {
		
		Manager m = new Manager(500, 500, 100);
		m.animate();
		
		int[] layout = new int[]{5, 5, 5};
		double[] input = new double[]{1, 1, 1, 1, 1};
		
		String s = "";
		for (int i = 0; i < 50*64; i++) {
			s += Math.random() > .5 ? "1" : "0";
		}
		
		
		
		Network net = new Network(layout, s, true);
		input = net.getOutput(input);
		
		for (double i : input) {
			System.out.println(i);
		}
		
	}

}
