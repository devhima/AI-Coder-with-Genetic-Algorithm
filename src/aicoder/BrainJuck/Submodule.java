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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Submodule
{
  protected String readFile(File file)
  {
    String sourceCode = null;
    BufferedReader bufferedReader = null;
    try
    {
      bufferedReader = new BufferedReader(new FileReader(file));
      StringBuilder stringBuilder = new StringBuilder();
      String line = bufferedReader.readLine();
      while(line != null)
      {
        stringBuilder.append(line);
        stringBuilder.append("\n");
        line = bufferedReader.readLine();
      }
      sourceCode = stringBuilder.toString();
    }
    catch(Exception exception)
    {
      errorExit("Error occurred while reading file " + file.toString());
    }
    finally
    {
      try
      {
        bufferedReader.close();
      }
      catch(IOException ioException)
      {
        // Ignore
      }
    }
    return (sourceCode);
  }

  protected void writeFile(File file, String string)
  {
    BufferedWriter bufferedWriter = null;
    try
    {
      bufferedWriter = new BufferedWriter(new FileWriter(file));
      bufferedWriter.write(string);
    }
    catch(Exception exception)
    {
      errorExit("Error occurred while writing file " + file.toString());
    }
    finally
    {
      try
      {
        bufferedWriter.close();
      }
      catch(IOException ioException)
      {
        // Ignore
      }
    }
  }

  protected boolean checkForBrackets(String sourceCode)
  {
    String brackets = sourceCode.replaceAll("[^\\" + Instructions.LOOP_START.getCommand() + "\\" + Instructions.LOOP_END.getCommand() + "]", "");
    int count = 0;
    for(int index = 0; index < brackets.length(); index++)
      count += (brackets.charAt(index) == Instructions.LOOP_START.getCommand() ? 1 : -1);
    return (count == 0);
  }

  protected String stripEverything(String sourceCode)
  {
    return (stripEverything(sourceCode, false));
  }

  protected String stripEverything(String sourceCode, boolean debug)
  {
    return (sourceCode.replaceAll("[^" + //
    "\\" + Instructions.LOOP_START.getCommand() + //
    "\\" + Instructions.LOOP_END.getCommand() + //
    "\\" + Instructions.INCREASE_VALUE.getCommand() + //
    "\\" + Instructions.DECREASE_VALUE.getCommand() + //
    "\\" + Instructions.MOVE_POINTER_RIGHT.getCommand() + //
    "\\" + Instructions.MOVE_POINTER_LEFT.getCommand() + //
    "\\" + Instructions.OUTPUT_VALUE.getCommand() + //
    "\\" + Instructions.INPUT_VALUE.getCommand() + //
    (debug ? "\\" + Instructions.DUMP_MEMORY.getCommand() : "") + //
    "]", ""));
  }

  protected void errorExit(String message)
  {
    System.err.println("Error: " + message + ".");
    System.exit(-1);
  }

  protected String repeatChar(int times, String characters)
  {
    StringBuilder stringBuilder = new StringBuilder();
    for(int index = 0; index < times; index++)
      stringBuilder.append(characters);
    return (stringBuilder.toString());
  }
}
