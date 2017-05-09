package simulation;

public class Evolver {


//	public static Ant breed(Ant a, Ant b) {
//		Ant newAnt = new Ant ((a.getX() + b.getX())/2, (a.getY() + b.getY())/2, a.getSection());
//		
//		int[] traits = new int[a.getTraits().length];
//		for (int i = 0; i < traits.length; i++) {
//			double aPercent = 100*(a.getFitness()/(a.getFitness()+b.getFitness()));
//			double bPercent = 100*(b.getFitness()/(a.getFitness()+b.getFitness()));
//			
//			int newTrait = (int) ((a.getTraits()[i]*aPercent + b.getTraits()[i]*bPercent)/100); //TODO maybe modify equation
//			newTrait = (int) (newTrait + (Math.random()*(((a.getTraits()[i]+b.getTraits()[i])/2)+1) - (a.getTraits()[i]+b.getTraits()[i])/4));
//		}
//		
//		double[][][] newWeights = new double[a.getNet().synapses.length][a.getNet().synapses[0].synapses.length][a.getNet().synapses[0].synapses[0].length];
//		for (int i = 0; i < newWeights.length; i++) {
//			for (int x = 0; x < newWeights[i].length; x++) {
//				for (int y = 0; y < newWeights[i][x].length; y++) {
//					double aW = a.getNet().getWeight(i, x, y), bW = b.getNet().getWeight(i, x, y);
//					double aPercent = 100*(a.getFitness()/(a.getFitness()+b.getFitness()));
//					double bPercent = 100*(b.getFitness()/(a.getFitness()+b.getFitness()));
//					
//					double newW = (aW*aPercent + bW*bPercent)/100; //TODO maybe modify equation
//					newW = newW + Math.random()*(aW+bW)/2 - (aW+bW)/4;
//					
//					newWeights[i][x][y] = newW;
//				}
//			}
//		}
//		
//		newAnt.getNet().update_weights(newWeights);
//		
//		return newAnt;
//	}
	
	public static Ant breedN(Ant a, Ant b) {
		Ant newAnt = new Ant ((a.getX() + b.getX())/2, (a.getY() + b.getY())/2, a.getSection());
		
		int[] traits = new int[a.getTraits().length];
		for (int i = 0; i < traits.length; i++) {
			
						
			int newTrait = (int) ((a.getTraits()[i] + b.getTraits()[i])/2);
			traits[i] = newTrait;
		}
		
		double[][][] newWeights = new double[a.getNet().synapses.length][a.getNet().synapses[0].synapses.length][a.getNet().synapses[0].synapses[0].length];
		for (int i = 0; i < newWeights.length; i++) {
			for (int x = 0; x < newWeights[i].length; x++) {
				for (int y = 0; y < newWeights[i][x].length; y++) {
					double aW = a.getNet().getWeight(i, x, y), bW = b.getNet().getWeight(i, x, y);
					
					
					double newW = (aW + bW)/2; //TODO maybe modify equation
					
					newWeights[i][x][y] = newW;
				}
			}
		}
		
		newAnt.getNet().update_weights(newWeights);
		
		return newAnt;
	}
}
