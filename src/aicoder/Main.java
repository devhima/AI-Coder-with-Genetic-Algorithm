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

package aicoder;

import java.util.*;
import java.io.*;
import aicoder.BrainJuck.*;
import aicoder.GA.*;
import java.util.regex.*;

public class Main
{
	public static void main(String[] args)
	{
		BJMain bj = new BJMain();
		GAMain ga = new GAMain();
		
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("\n\nWelcome to AI Coder with Genetic Algorithm Project.\n\tBy Dev.Ibrahim Said (DevHima)");
			System.out.println("Copyright (c) 2018 DevHima. < http://devhima.tk/ >\n");
			System.out.println("Choose one of these options, by entering it's number: \n [1] Brain Juck (Brain Fuck Framework). \n [2] Generate apps with Genetic Algorithm.");
			System.out.print(">>> ");
			int input = in.nextInt();
			switch(input){
				case 1:
					boolean condA = true;
					while(condA){
						Scanner bjin = new Scanner(System.in);
						System.out.println("\n\nWelcome to Brain Juck (Brain Fuck Framework).\n\t please enter any of BrainJuck commands\n\t or help to get help of how to use BrainJuck\n\t or back to get back to the main list. \n");
						System.out.print(">>> ");
						String cmd = bjin.nextLine();
						if(cmd.toLowerCase().equals("back")){
							condA = false;
							break;
						}else{
							bj.run(cmd);
						}
					}
					
					break;
					
				case 2:
					boolean condB = true;
					while(condB){
						Scanner gain = new Scanner(System.in);
						System.out.println("\n\nPlease enter the path of target source code file of brain fuck to generate it with genetic algorithm\n& the path of output file. (seerated by space)\n\t or back to get back to the main list. \n");
						System.out.print(">>> ");
						String cmd = gain.nextLine();
						if(cmd.toLowerCase().equals("back")){
							condB = false;
							break;
						}else{
							final Pattern SPACE = Pattern.compile(" ");
							String[] arg = SPACE.split(cmd);
							ga.run(arg[0], arg[1]);
						}
					}
					
					break;
					
				default:
				System.out.println("\n\nError: Your choose is wrong!\n\n");
				break;
			}
		}
	}
}
