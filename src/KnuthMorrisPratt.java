/**

 ** Java Program to implement Knuth Morris Pratt Algorithm

 **/


import java.io.BufferedReader;

import java.io.File;
import java.io.InputStreamReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/** Class KnuthMorrisPratt **/

public class KnuthMorrisPratt
{
  /**
   * Failure array
   **/

  private int[] failure;

  /**
   * Constructor
   **/

  public KnuthMorrisPratt(String string, String pattern)
  {
    /** pre construct failure array for a pattern **/

    int index = 0;
    int pos = 0;
    int arraySize = pattern.length();
    failure = new int[arraySize];
    ArrayList<Integer> matches = new ArrayList<>();

    fail(pattern, arraySize);

    /** find match **/

    while (true)
    {
      pos = posMatch(string, pattern, index);
      index = pos + 1;
      
      if (pos == -1)
      {
        break;
      }

      else
      {
        matches.add(pos);
      }
    }

    if (!matches.isEmpty())
    {
      System.out.println("Matches found at position/s: ");
      for(int idx: matches)
      {
        System.out.print(idx + " ");
      }
    }
    else
    {
      System.out.println("No matches found.");
    }

  }



  /** Failure function for a pattern **/

  private void fail(String pattern, int arraySize)
  {
    failure[0] = -1;

    for (int j = 1; j < arraySize; j++)
    {
      int i = failure[j - 1];

      while ((pattern.charAt(j) != pattern.charAt(i + 1)) && (i >= 0))

        i = failure[i];

      if (pattern.charAt(j) == pattern.charAt(i + 1))

        failure[j] = i + 1;

      else

        failure[j] = -1;
    }
  }

  /** Function to find match for a pattern **/

  private int posMatch(String string, String pattern, int index)
  {
    int i = index;
    int j = 0;
    int stringLength = string.length();
    int patternLength = pattern.length();

    while (i < stringLength && j < patternLength)
    {
      if (string.charAt(i) == pattern.charAt(j))
      {
        i++;
        j++;
      }

      else if (j == 0) {i++;}

      else {j = failure[j - 1] + 1;}
    }

    return ((j == patternLength) ? (i - patternLength) : -1);
  }

  /** Main Function **/

  public static void main(String[] args) throws IOException
  {
    System.out.println("Knuth Morris Pratt");

    Scanner scanner = new Scanner(new File(args[0]));
    String string = scanner.nextLine();

    scanner = new Scanner(new File(args[1]));
    String pattern = scanner.nextLine();

    for(int i = 0; i < 10; i++)
    {
      long startTime = System.nanoTime();

      KnuthMorrisPratt kmp = new KnuthMorrisPratt(string, pattern);

      final long endTime = System.nanoTime();

      System.out.println("\nTotal execution time: " + (endTime - startTime));
    }
  }
}
