package neural_network;

import java.math.BigInteger;

public class Network {
	
	public Neuron_Layer[] neurons;
	public Synapse_Layer[] synapses;
	public String synaptic_weights = "";
	
	public Network(int[] layout, boolean sigmoid) {
		neurons = new Neuron_Layer[layout.length];
		synapses = new Synapse_Layer[layout.length-1];
		
		for (int i = 0; i < neurons.length-1; i++) {
			neurons[i] = new Neuron_Layer(layout[i], i, sigmoid);
			synapses[i] = new Synapse_Layer(layout[i+1], layout[i], i);
		}
		neurons[layout.length-1] = new Neuron_Layer(layout[layout.length-1], layout.length-1, sigmoid);
	}
	
	public Network(int[] layout, double[][][] synapse_weights, boolean sigmoid) {
		neurons = new Neuron_Layer[layout.length];
		synapses = new Synapse_Layer[layout.length-1];
		
		for (int i = 0; i < neurons.length-1; i++) {
			neurons[i] = new Neuron_Layer(layout[i], i, sigmoid);
			synapses[i] = new Synapse_Layer(layout[i+1], layout[i], i, synapse_weights[i]);
		}
		
		neurons[layout.length-1] = new Neuron_Layer(layout[layout.length-1], layout.length-1, sigmoid);
	}
	
	public Network(int[] layout, String synapse_weights, boolean sigmoid) {
		neurons = new Neuron_Layer[layout.length];
		synapses = new Synapse_Layer[layout.length-1];
		
		int curr_bit = 0;
		for (int i = 0; i < neurons.length-1; i++) {
			neurons[i] = new Neuron_Layer(layout[i], i, sigmoid);
			
			String weights = synapse_weights.substring(curr_bit, curr_bit + layout[i+1]*layout[i]*64);
			synapses[i] = new Synapse_Layer(layout[i+1], layout[i], i, weights);
			
			curr_bit = layout[i+1]*layout[i]*64;
		}
		
		neurons[layout.length-1] = new Neuron_Layer(layout[layout.length-1], layout.length-1, sigmoid);
	}
	
	
	
	public void update_weights(double[][][] synapse_weights) {
		for (int i = 0; i < synapse_weights.length; i++) {
			synapses[i].update_weights(synapse_weights[i]);
		}
	}
	
	public double[] getOutput(double[] input) {
		double[] a =  neurons[0].push(input, this);
		return a;
	}
	
	public int getMaxOutputIndex(double[] input) {
		double[] output = getOutput(input);
		double max = -1;
		int maxIndex = 0;
		for (int i = 0; i < output.length; i++) {
			if (max < output[i]) {
				max = output[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	public double getMaxOutputValue(double[] input) {
		double[] output = getOutput(input);
		double max = -1;
		for (int i = 0; i < output.length; i++) {
			if (max < output[i]) {
				max = output[i];
			}
		}
		return max;
	}
	
	public double getWeight(int layer, int a, int b) {
		return synapses[layer].getWeight(a, b);
	}
	
	public String getBianaryForWeights() {
		if (synaptic_weights.equals("")) {
			for (int i = 0; i < synapses.length; i++) {
				for (int a = 0; a < synapses[i].synapses.length; a++) {
					for (int b = 0; b < synapses[i].synapses[a].length; b++) {
						System.out.println(i + " " + a + " " + b);
						double w = getWeight(i, a, b);
						synaptic_weights += Long.toBinaryString(Double.doubleToRawLongBits(w));
					}
				}
			}
			
			return synaptic_weights;
		} else {
			return synaptic_weights;
		}
	}
}
