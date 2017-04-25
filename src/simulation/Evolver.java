package simulation;

public class Evolver {

	public Ant breed(Ant a, Ant b) {
		Ant newAnt = new Ant ((a.getX() + b.getX())/2, (a.getY() + b.getY())/2, 0);
		
		int[] traits = new int[a.getTraits().length];
		for (int i = 0; i < traits.length; i++) {
			traits[i] = (a.getTraits()[i]/b.getFitness() + b.getTraits()[i]/a.getFitness())*(a.getFitness()+b.getFitness()); //TODO maybe modify equation
		}
		
		double[][][] newWeights = new double[a.getNet().synapses.length][a.getNet().synapses[0].synapses.length][a.getNet().synapses[0].synapses[0].length];
		for (int i = 0; i < newWeights.length; i++) {
			for (int x = 0; x < newWeights[i].length; x++) {
				for (int y = 0; y < newWeights[i][x].length; y++) {
					double aW = (a.getNet().getWeight(i, x, y) + (b.getNet().getWeight(i, x, y) - a.getNet().getWeight(i, x, y)*Math.random()));
					double bW = (b.getNet().getWeight(i, x, y) + (a.getNet().getWeight(i, x, y) - b.getNet().getWeight(i, x, y)*Math.random()));
					newWeights[i][x][y] = Math.random() > 100/b.getFitness() ? aW : bW;
				}
			}
		}
		
		newAnt.getNet().update_weights(newWeights);
		
		return newAnt;
	}
	
}
