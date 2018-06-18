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
 * Generator - Brainfuck Code Generator
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

public class Generator
  extends Submodule
{
  public Generator(File inputFile, File outputFile)
  {
    super();
    String text = readFile(inputFile);
    StringBuilder stringBuilder = new StringBuilder();
    int previousChar = 0;
    for(int index = 0; index < text.length(); index++)
    {
      int character = 0xFF & text.charAt(index);
      int difference = previousChar - character;
      char command = (difference < 0 ? Instructions.INCREASE_VALUE.getCommand() : Instructions.DECREASE_VALUE.getCommand());
      difference = Math.abs(difference);
      if(difference > 0 && difference < 8)
      {
        stringBuilder.append(repeatChar(difference, "" + command));
      }
      else if(difference >= 8)
      {
        int loopCount = (int)Math.sqrt(difference);
        int multiplier = loopCount;
        while(loopCount * (multiplier + 1) <= difference)
          multiplier++;
        int remainder = difference - (loopCount * multiplier);
        stringBuilder.append(Instructions.MOVE_POINTER_RIGHT.getCommand());
        stringBuilder.append(repeatChar(loopCount, "" + Instructions.INCREASE_VALUE.getCommand()));
        stringBuilder.append(Instructions.LOOP_START.getCommand());
        stringBuilder.append(Instructions.MOVE_POINTER_LEFT.getCommand());
        stringBuilder.append(repeatChar(multiplier, "" + command));
        stringBuilder.append(Instructions.MOVE_POINTER_RIGHT.getCommand());
        stringBuilder.append(Instructions.DECREASE_VALUE.getCommand());
        stringBuilder.append(Instructions.LOOP_END.getCommand());
        stringBuilder.append(Instructions.MOVE_POINTER_LEFT.getCommand());
        if(remainder > 0)
          stringBuilder.append(repeatChar(remainder, "" + command));
      }
      stringBuilder.append(Instructions.OUTPUT_VALUE.getCommand());
      previousChar = character;
    }
    writeFile(outputFile, stringBuilder.toString());
  }
}
