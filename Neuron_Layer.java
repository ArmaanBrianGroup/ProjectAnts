package neural_network;

public class Neuron_Layer {
	public Neuron[] neurons;
	public int num;
	private boolean sigmoid;
	
	public Neuron_Layer(int size, int num, boolean sigmoid) {
		this.num = num;
		this.sigmoid = sigmoid;
	
		neurons = new Neuron[size];
		
		for (int i = 0; i < neurons.length; i++) {
			neurons[i] = new Neuron();
		}
	}
	
	public double[] push(double[] input, Network network) {
		for(int i = 0; i < neurons.length; i++) {
			neurons[i].output(input[i], false); //input neurons
		}
		
		return network.synapses[num].push(network);
	} 
	
	public double[] push(Network network) {
		if (num < network.synapses.length) { //hidden layer neurons
			for(int i = 0; i < neurons.length; i++) {
				neurons[i].output(network.synapses[num-1].synapses[i], sigmoid);
			}
			
			return network.synapses[num].push(network);
		} else { //output neurons
			double[] out = new double[neurons.length];
			
			
			for(int i = 0; i < neurons.length; i++) {
				out[i] = neurons[i].output(network.synapses[num-1].synapses[i], sigmoid);
			}
			
			return out;
		}
	}
}
