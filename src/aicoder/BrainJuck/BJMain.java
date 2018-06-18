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

import java.io.File;

import java.util.Calendar;
import java.util.regex.Pattern;

public class BJMain
{
  public static final double VERSION = 1.1;
  
  public BJMain()
  {
    super();
  }

  public static void run(String arg)
  {
	  final Pattern SPACE = Pattern.compile(" ");
	  String[] args = SPACE.split(arg);
    String submodule = (args.length > 0 ? args[0].toLowerCase() : "");
    if(submodule.equals("interpreter"))
    {
      boolean debug = false;
      File sourceFile = null;
      if(args.length == 2)
      {
        sourceFile = new File(args[1]);
      }
      else if(args.length == 3)
      {
        if(args[1].equalsIgnoreCase("-debug"))
          debug = true;
        else
          help();
        sourceFile = new File(args[2]);
      }
      else
      {
        help();
      }
      new Interpreter(sourceFile, debug);
    }
	  else if(submodule.equals("converter"))
	{
		File sourceFile = null;
		File outputFile = null;
		Converter.toLanguage toLang = null;
		String LangTxt = "";
		if(args.length == 4){
			sourceFile = new File(args[1]);
			outputFile = new File(args[2]);
			LangTxt = args[3];
			LangTxt = LangTxt.toLowerCase();
			switch(LangTxt){
				case "asciiart":
					toLang = Converter.toLanguage.ASCIIArt;
					break;
				case "blub":
					toLang = Converter.toLanguage.Blub;
					break;
				case "c":
					toLang = Converter.toLanguage.C;
					break;
				case "dotdash":
					toLang = Converter.toLanguage.DotDash;
					break;
				case "goal":
					toLang = Converter.toLanguage.Goal;
					break;
				case "java":
					toLang = Converter.toLanguage.Java;
					break;
				case "ook":
					toLang = Converter.toLanguage.Ook;
					break;
				case "pikalang":
					toLang = Converter.toLanguage.Pikalang;
					break;
				case "pogaack":
					toLang = Converter.toLanguage.Pogaack;
					break;
				case "reversefuck":
					toLang = Converter.toLanguage.ReverseFuck;
					break;
				case "triplet":
					toLang = Converter.toLanguage.Triplet;
					break;
				case "trollscript":
					toLang = Converter.toLanguage.Trollscript;
					break;
				case "xmlfuck":
					toLang = Converter.toLanguage.XMLfuck;
					break;
				default:
				toLang = null;
				break;
			}
			new Converter(sourceFile,outputFile,toLang);
		}else{
			help();
		}
	}
    else if(submodule.equals("optimizer"))
    {
      int lineWrap = 80;
      File inputFile = null;
      File outputFile = null;
      if(args.length == 3)
      {
        inputFile = new File(args[1]);
        outputFile = new File(args[2]);
      }
      else if(args.length == 4)
      {
        if(args[1].toLowerCase().startsWith("-lineWrap="))
        {
          try
          {
            lineWrap = Integer.parseInt(args[1].substring(args[1].lastIndexOf("=") + 1));
            if(lineWrap < 0)
              errorExit("Invalid -lineWrap value.", -1);
          }
          catch(Exception exception)
          {
            errorExit("Invalid -lineWrap value.", -1);
          }
        }
        else
        {
          help();
        }
        inputFile = new File(args[2]);
        outputFile = new File(args[3]);
      }
      else
      {
        help();
      }
      new Optimizer(inputFile, outputFile, lineWrap);
    }
    else if(submodule.equals("formatter"))
    {
      int tabSize = 0;
      File inputFile = null;
      File outputFile = null;
      if(args.length == 3)
      {
        inputFile = new File(args[1]);
        outputFile = new File(args[2]);
      }
      else if(args.length == 4)
      {
        if(args[1].toLowerCase().startsWith("-tabSize="))
        {
          try
          {
            tabSize = Integer.parseInt(args[1].substring(args[1].lastIndexOf("=") + 1));
            if(tabSize < 0)
              errorExit("Invalid -tabSize value.", -1);
          }
          catch(Exception exception)
          {
            errorExit("Invalid -tabSize value.", -1);
          }
        }
        else
        {
          help();
        }
        inputFile = new File(args[2]);
        outputFile = new File(args[3]);
      }
      else
      {
        help();
      }
      new Formatter(inputFile, outputFile, tabSize);
    }
    else if(submodule.equals("generator"))
    {
      File inputFile = null;
      File outputFile = null;
      if(args.length == 3)
      {
        inputFile = new File(args[1]);
        outputFile = new File(args[2]);
      }
      else
      {
        help();
      }
      new Generator(inputFile, outputFile);
    }
    else
    {
      help();
    }
  }

  private static void errorExit(String message, int errorCode)
  {
    System.err.println(message + ". Please type -help for details.");
    //System.exit(errorCode);
  }

  private static void help()
  {
    System.out.println("\nBrainJuck Version " + VERSION + " - Rapid Application Development with only 3 bits!\n" + //
      "Copyright (c) 2016 Anar Software LLC. < http://anars.com >\n\n" + //
	  "This program has been modified by Ibrahim Said on 13-06-2018, Web: http://www.devhima.tk/ \n\n" + //
      "This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.\n\n" + //
      "This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.\n" + //
      "See the GNU General Public License for more details at http://www.gnu.org/licenses\n\n" + //
      "USAGE:\n" + //
      "\t(interpreter|optimizer|formatter|generator|converter) [PARAMETERS...]\n\n" + //
      "SUBMODULES:\n" + //
      "\ninterpreter\n" + //
      "\tInterprets Brainfuck source code.\n\n" + //
      "\tUSAGE:\n" + //
      "\tinterpreter [-debug] source_file\n" + //
      "\n\tDESCRIPTION:\n" + //
      "\t-debug   Enables debug command (#).\n" + //
      //
      "\noptimizer\n" + //
      "\tStrips and optimizes Brainfuck source code.\n\n" + //
      "\tUSAGE:\n" + //
      "\toptimizer [-lineWrap=#] input_source_file output_source_file\n" + //
      "\n\tDESCRIPTION:\n" + //
      "\t-lineWrap=#   Wrap lines after #th characters.\n" + //
      //
      "\nformatter\n" + //
      "\tIndents and formats Brainfuck source code.\n\n" + //
      "\tUSAGE:\n" + //
      "\tformatter [-tabSize=#] input_source_file output_source_file\n" + //
      "\n\tDESCRIPTION:\n" + //
      "\t-tabSize=#   Number (#) of whitespaces for each indentation. if # is zero (0), uses tab character (\\t).\n" + //
      //
      "\ngenerator\n" + //
      "\tConverts text file to Brainfuck source code.\n\n" + //
      "\tUSAGE:\n" + //
      "\tgenerator input_text_file output_source_file\n" + //
	  //
	  "\nconverter\n" + //
	  "\tConverts Brainfuck file to one of these languages: \n\tASCIIArt,Blub,C,DotDash,Goal,Java,Ook,\n\tPikalang,Pogaack,ReverseFuck,Triplet,Trollscript,XMLfuck.\n\n" + //
	  "\tUSAGE:\n" + //
	  "\tconverter input_source_file output_source_file to_language\n" + //
	  "\n\tDESCRIPTION:\n" + //
	  "\tto_language   The language to convert to, choose one of the languages above.\n");
    //System.exit(0);
  }
}
