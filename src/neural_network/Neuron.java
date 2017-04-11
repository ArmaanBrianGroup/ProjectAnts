package neural_network;


public class Neuron {
	private double sum;
	private double output;
	
	public double output (Synapse[] input, boolean sigmoid) {
		sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i].getLastOut();
		}
		
		output = sigmoid ? 1 / (1 + Math.pow(2.7182818284590452353602874713527, -sum)) : sum;
		return output;
	}
	
	public double output (double input, boolean sigmoid) {
		sum = input;
		
		output = sigmoid ? 1 / (1 + Math.pow(2.7182818284590452353602874713527, -sum)) : sum;
		return output;
	}
	
	
	public double output (double[] input, boolean sigmoid) {
		sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		
		output = sigmoid ? 1 / (1 + Math.pow(2.7182818284590452353602874713527, -sum)) : sum;
		return output;
	}
	
	public double output (Synapse[][] input, boolean sigmoid) {
		sum = 0;
		for (int i = 0; i < input.length; i++) {
			for (int x = 0; x < input[i].length; x++) {
				sum += input[i][x].getLastOut();
			}
		}
		
		output = sigmoid ? 1 / (1 + Math.pow(2.7182818284590452353602874713527, -sum)) : sum;
		return output;
	}
	
	public double getLastSum() {
		return sum;
	}
	public double getLastOut() {
		return output;
	}
}
