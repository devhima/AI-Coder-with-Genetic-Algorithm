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

public class BF
{
	public static char GeneToInstruction(float gene){
		char i='#';
		if(gene >= 0 && gene < 0.125){
			i = '>';
		} else if(gene >= 0.125 && gene < 0.25){
			i = '<';
		} else if(gene >= 0.25 && gene < 0.375){
			i = '+';
		} else if(gene >= 0.375 && gene < 0.5){
			i = '-';
		} else if(gene >= 0.5 && gene < 0.625){
			i = '.';
		} else if(gene >= 0.625 && gene < 0.75){
			i = ',';
		} else if(gene >= 0.75 && gene < 0.875){
			i = '[';
		} else if(gene >= 0.875 && gene < 1.0){
			i = ']';
		}
		return i;
	}
}
