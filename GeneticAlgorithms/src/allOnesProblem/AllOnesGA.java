/**
 * 
 */
package allOnesProblem;

/**
 * @author William - BASIC
 *
 */
public class AllOnesGA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create GA object
		GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.95, 2);
		
		// initialise population
		Population population = ga.initPopulation(50);
		
		//evaluate population
		ga.evalPopulation(population);
		
		//keep track of current population
		int generation = 1;
		
		while (ga.isTerminationConditionMet(population) == false) {
			// print fittest individual from population
			System.out.println("Best solution: " + population.getFittest(0).toString());
			
			//Apply crossover
			population = ga.crossoverPopulation(population);
			
			//Apply mutation
			population = ga.mutatePopulation(population);
			
			//Evaluate popu;ation
			ga.evalPopulation(population);
			
			//increment the current generation
			generation++;
		}
		
		System.out.println("Found solution in " +generation + " generation");
		System.out.println("Best solution " + population.getFittest(0).toString());
	}
}
