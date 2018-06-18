
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RWFiles
{
  public static String readFile(File file)
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
	sourceCode = sourceCode.substring(0,sourceCode.length()-1);
    return (sourceCode);
  }

  public static void writeFile(File file, String string)
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


  public static void errorExit(String message)
  {
    System.err.println("Error: " + message + ".");
    //System.exit(-1);
  }

  public static String repeatChar(int times, String characters)
  {
    StringBuilder stringBuilder = new StringBuilder();
    for(int index = 0; index < times; index++)
      stringBuilder.append(characters);
    return (stringBuilder.toString());
  }
}
