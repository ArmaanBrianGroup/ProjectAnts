package neural_network;

import java.math.BigInteger;

public class Synapse {
	private double weight;
	private double lastOut;
	private double input;
	
	public Synapse(double weight) {
		this.weight = weight;
	}
	
	public Synapse(String weight) {
		this.weight = Double.longBitsToDouble(new BigInteger(weight, 2).longValue());
	}
	
	public Synapse() {
		weight = Math.random()*2 - 1;
		//System.out.println(weight);
	}
	
	public void randWeight() {
		weight = Math.random();
	}
	
	public void adjustWeight(double adjustment) {
		weight += adjustment;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double newWeight) {
		weight = newWeight;
	}
	
	public double getOutput(Neuron input) {
		return getOutput(input.getLastOut());
	}
	
	public double getOutput (double input) {
		this.input = input;
		lastOut = input * weight;
		return lastOut;
	}
	
	public double getInput() {
		return input;
	}
	
	public double getLastOut() {
		return lastOut;
	}
}
