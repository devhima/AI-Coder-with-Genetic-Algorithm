/**
 * AI Coder (with Genetic Algorithm) - Generate Brain Fuck apps with Genetic Algorithm
 * 		by Ibrahim Said Elsharawy.
 * Copyright (c) 2018 DevHima. < http://devhima.tk/ >
 *
 * The MIT License
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/*
* The MIT License
* 
* Copyright (c) 2011 John Svazic
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/
package aicoder.GA;
import java.io.*;
import aicoder.*;
import aicoder.BrainJuck.*;

/**
 * Driver class for the genetic algorithm simulation.
 * 
 * This class is strictly used for an entry point into the simulation itself,
 * it has no other functionality.
 * 
 * @author John Svazic
 * @version 1.0
 */
 
/*
 * Modified by Ibrahim Said 13-06-2018 http://www.devhima.tk/
 */
 
public class GAMain {

	/**
	 * The main method used for execution of the application.
	 * 
	 * @param args Command-line arguments (ignored).
	 */
	public static void run(String targetGeneFilePath, String outputFile) {
		//Set target gene
		Chromosome.TARGET_GENE = RWFiles.readFile(new File(targetGeneFilePath)).toCharArray();
		
		// The size of the simulation population
		final int populationSize = 2048;
		
		// The maximum number of generations for the simulation.
		final int maxGenerations = 16384;
		
		// The probability of crossover for any member of the population,
		// where 0.0 <= crossoverRatio <= 1.0
		final float crossoverRatio = 0.8f;
		
		// The portion of the population that will be retained without change
		// between evolutions, where 0.0 <= elitismRatio < 1.0
		final float elitismRatio = 0.1f;
		
		// The probability of mutation for any member of the population,
		// where 0.0 <= mutationRatio <= 1.0
		final float mutationRatio = 0.03f;
	
		// Get the current run time.  Not very accurate, but useful for 
		// some simple reporting.
		long startTime = System.currentTimeMillis();
		
		// Create the initial population
		Population pop = new Population(populationSize, crossoverRatio, 
				elitismRatio, mutationRatio);

		// Start evolving the population, stopping when the maximum number of
		// generations is reached, or when we find a solution.
		int i = 0;
		Chromosome best = pop.getPopulation()[0];
		
		while ((i++ <= maxGenerations) && (best.getFitness() != 0)) {
			System.out.println("Generation (" + i + "), Fitness=" + best.getFitness() + " :\n" + best.getGene());
			pop.evolve();
			best = pop.getPopulation()[0];
		}
		
		// Get the end time for the simulation.
		long endTime = System.currentTimeMillis();
		
		// Print out some information to the console.
		System.out.println("Generation (" + i + "), Fitness=" + best.getFitness() + " :\n" + best.getGene());
		System.out.println("Total execution time: " + (endTime - startTime) + 
				"ms");
				
		// Writing best gene to output file.
		System.out.println("\n\nWriting best gene to the output file:\n\t " + outputFile + "\n\n");
		RWFiles.writeFile(new File(outputFile),best.getGene());
		
		// Executing output file on Brain Juck interpreter
		System.out.println("\n\nExecuting output file on Brain Juck interpreter:\n\n");
		BJMain bj = new BJMain();
		bj.run("interpreter " + outputFile);
		System.out.println("\n\n");
	}
}
