package neural_network;

public class Synapse_Layer {
	public Synapse[][] synapses;
	public int num;
	
	public Synapse_Layer (int a, int b, int num) {
		this.num = num;
		
		synapses = new Synapse[a][b];

		for (int i = 0; i < a; i++) { 
			for (int x = 0; x < b; x++) {
				synapses[i][x] = new Synapse();
			}
		}
	}
	
	public Synapse_Layer (int a, int b, int num, double[][] synapse_weights) {
		this.num = num;
		
		synapses = new Synapse[a][b];

		for (int i = 0; i < a; i++) { 
			for (int x = 0; x < b; x++) {
				synapses[i][x] = new Synapse(synapse_weights[i][x]);
			}
		}
	}
	
	public Synapse_Layer (int a, int b, int num, String synapse_weights) {
		this.num = num;
		
		synapses = new Synapse[a][b];

		int index = 0;
		
		for (int i = 0; i < a; i++) { 
			for (int x = 0; x < b; x++) {
				synapses[i][x] = new Synapse(synapse_weights.substring(index, index+64));
				index += 64;
			}
		}
	}
	
	
	public void update_weights(double[][] synapse_weights) {
		for (int i = 0; i < synapses.length; i++) { 
			for (int x = 0; x < synapses[i].length; x++) {
				synapses[i][x].setWeight(synapse_weights[i][x]);
			}
		}
	}
	
	public double[] push(Network network) {
		for (int i = 0; i < synapses.length; i++) {
			for (int x = 0; x < synapses[i].length; x++) {
				synapses[i][x].getOutput(network.neurons[num].neurons[x]);
			}
		}
		
		return network.neurons[num+1].push(network);
	}
	
	public double getWeight(int a, int b) {
		return synapses[a][b].getWeight();
	}
}
