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


/**
 * BrainJuck - Rapid Application Development with only 3 bits!
 * 
 * Converter - Brainfuck Code Converter
 * 
 * Copyright (c) 2016 Anar Software LLC. < http://anars.com >
 * 
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with 
 * this program.  If not, see < http://www.gnu.org/licenses/ >
 * 
 */
 
/*
 * Modified by Ibrahim Said 13-06-2018 http://www.devhima.tk/
 */
 
package aicoder.BrainJuck;
import aicoder.BrainJuck.Languages.*;
import java.io.File;

public class Converter
  extends Submodule
{
	
	public static enum toLanguage{
		ASCIIArt,Blub,C,DotDash,Goal,Java,Ook,Pikalang,Pogaack,ReverseFuck,Triplet,Trollscript,XMLfuck
	}
	
	public Converter(File sourceFile, File outputFile, toLanguage lang)
	{
		super();
		String OriginalSourceCode = stripEverything(readFile(sourceFile));
		if(!checkForBrackets(OriginalSourceCode)) 
			errorExit("Mismatched command " + Instructions.LOOP_START.getCommand() + " " + Instructions.LOOP_END.getCommand());
		
		StringBuilder newsource = new StringBuilder();
		if(lang == toLanguage.ASCIIArt){
			ASCIIArt cnv = new ASCIIArt();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.Blub){
			Blub cnv = new Blub();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.C){
			C cnv = new C();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.DotDash){
			DotDash cnv = new DotDash();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.Goal){
			Goal cnv = new Goal();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.Java){
			Java cnv = new Java();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.Ook){
			Ook cnv = new Ook();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.Pikalang){
			Pikalang cnv = new Pikalang();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.Pogaack){
			Pogaack cnv = new Pogaack();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.ReverseFuck){
			ReverseFuck cnv = new ReverseFuck();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.Triplet){
			Triplet cnv = new Triplet();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.Trollscript){
			Trollscript cnv = new Trollscript();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		else if(lang == toLanguage.XMLfuck){
			XMLfuck cnv = new XMLfuck();
			newsource.append(cnv.getHeader());
			for(int index = 0; index < OriginalSourceCode.length(); index++)
			{
				char command = OriginalSourceCode.charAt(index);
				newsource.append(cnv.concert(command));
			}
			newsource.append(cnv.getFooter());
		}
		
		writeFile(outputFile,newsource.toString());
	}
}
