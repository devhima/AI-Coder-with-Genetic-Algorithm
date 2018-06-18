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
 * C Converter - Brainfuck Code Generator
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
 
package aicoder.BrainJuck.Languages;

import aicoder.BrainJuck.Instructions;

public class C
  implements Language
{
  private int _indentation = 1;
  private String _tabChars = "\t";
  private int _heapSize = 3000;

  @Override public String concert(char command)
  {
    String output = (command == Instructions.LOOP_END.getCommand() ? "" : intend());
    if(command == Instructions.MOVE_POINTER_RIGHT.getCommand())
    {
      output += "++ptr;\n";
    }
    else if(command == Instructions.MOVE_POINTER_LEFT.getCommand())
    {
      output += "--ptr;\n";
    }
    else if(command == Instructions.INCREASE_VALUE.getCommand())
    {
      output += "++*ptr;\n";
    }
    else if(command == Instructions.DECREASE_VALUE.getCommand())
    {
      output += "--*ptr;\n";
    }
    else if(command == Instructions.OUTPUT_VALUE.getCommand())
    {
      output += "putchar(*ptr);\n";
    }
    else if(command == Instructions.INPUT_VALUE.getCommand())
    {
      output += "*ptr=getchar();\n";
    }
    else if(command == Instructions.LOOP_START.getCommand())
    {
      output += "while (*ptr)\n";
      output += "{\n";
      _indentation++;
    }
    else if(command == Instructions.LOOP_END.getCommand())
    {
      _indentation--;
      output += intend();
      output += "}\n";
    }
    return (output);
  }

  @Override public String getFooter()
  {
    return ("}");
  }

  @Override public String getHeader()
  {
    String header = "#include <stdio.h>\n\n";
    header += "int main(void)\n";
    header += "{\n";
    header += intend() + "char array[" + _heapSize + "] = {0};\n;";
    header += intend() + "char *ptr=array;\n\n";
    return (header);
  }

  private String intend()
  {
    String indentation = "";
    for(int index = 0; index < _indentation; index++)
      indentation += _tabChars;
    return (indentation);
  }
  public void setTabChars(String tabChars)
  {
    _tabChars = tabChars;
  }

  public String getTabChars()
  {
    return (_tabChars);
  }

  public void setHeapSize(int heapSize)
  {
    _heapSize = heapSize;
  }

  public int getHeapSize()
  {
    return (_heapSize);
  }
}
