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
 * Optimizer - Brainfuck Optimizer
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

public class Optimizer
  extends Submodule
{
  public Optimizer(File inputFile, File outputFile, int lineWrap)
  {
    super();
    String sourceCode = stripEverything(readFile(inputFile));
    if(!checkForBrackets(sourceCode))
      errorExit("Mismatched command " + Instructions.LOOP_START.getCommand() + " " + Instructions.LOOP_END.getCommand());
    int lastIndexOfBracket = sourceCode.lastIndexOf(Instructions.LOOP_END.getCommand());
    int lastIndexOfDot = sourceCode.lastIndexOf(Instructions.OUTPUT_VALUE.getCommand());
    sourceCode = sourceCode.substring(0, Math.max(lastIndexOfBracket, lastIndexOfDot) + 1).replaceAll("[\\" + Instructions.LOOP_START.getCommand() + "][\\" + Instructions.LOOP_END.getCommand() + "]", "" + Instructions.LOOP_START.getCommand() + "~" + Instructions.LOOP_END.getCommand());
    StringBuilder stringBuilder = null;
    int sourceLength = 0;
    do
    {
      if(stringBuilder != null)
        sourceCode = stringBuilder.toString().replaceAll("[\\" + Instructions.LOOP_START.getCommand() + "][\\" + Instructions.LOOP_END.getCommand() + "]", "");
      stringBuilder = new StringBuilder();
      sourceLength = sourceCode.length();
      int index = 0;
      int count = 0;
      int repateType = 0;
      while(index < sourceLength)
      {
        char command = sourceCode.charAt(index);
        if((repateType == 0 || repateType == 1) && (command == Instructions.INCREASE_VALUE.getCommand() || command == Instructions.DECREASE_VALUE.getCommand()))
        {
          repateType = 1;
          count += (command == Instructions.INCREASE_VALUE.getCommand() ? 1 : -1);
        }
        else if(repateType == 1)
        {
          char newCommand = count > 0 ? Instructions.INCREASE_VALUE.getCommand() : Instructions.DECREASE_VALUE.getCommand();
          for(int quantity = 0; quantity < Math.abs(count); quantity++)
            stringBuilder.append(newCommand);
          count = 0;
          repateType = 0;
          index--;
        }
        else if((repateType == 0 || repateType == 2) && (command == Instructions.MOVE_POINTER_RIGHT.getCommand() || command == Instructions.MOVE_POINTER_LEFT.getCommand()))
        {
          repateType = 2;
          count += (command == Instructions.MOVE_POINTER_RIGHT.getCommand() ? 1 : -1);
        }
        else if(repateType == 2)
        {
          char newCommand = count > 0 ? Instructions.MOVE_POINTER_RIGHT.getCommand() : Instructions.MOVE_POINTER_LEFT.getCommand();
          for(int quantity = 0; quantity < Math.abs(count); quantity++)
            stringBuilder.append(newCommand);
          count = 0;
          repateType = 0;
          index--;
        }
        else
        {
          stringBuilder.append(command);
        }
        index++;
      }
    }
    while(stringBuilder.length() != sourceLength);
    sourceCode = stringBuilder.toString().replaceAll("[\\" + Instructions.LOOP_START.getCommand() + "][\\" + Instructions.LOOP_END.getCommand() + "]", "").replaceAll("[\\" + Instructions.LOOP_START.getCommand() + "]~[\\" + Instructions.LOOP_END.getCommand() + "]", "" + Instructions.LOOP_START.getCommand() + Instructions.LOOP_END.getCommand());
    stringBuilder = new StringBuilder();
    sourceLength = sourceCode.length();
    if(lineWrap != 0)
      for(int index = 0; index < sourceLength; index += lineWrap)
        stringBuilder.append(sourceCode.substring(index, index + lineWrap > sourceLength ? sourceLength : index + lineWrap) + "\n");
    else
      stringBuilder.append(sourceCode);
    writeFile(outputFile, stringBuilder.toString());
  }
}
