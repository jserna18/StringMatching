/**

 ** Java Program to implement Knuth Morris Pratt Algorithm

 **/



import java.io.BufferedReader;

import java.io.File;
import java.io.InputStreamReader;

import java.io.IOException;
import java.util.Scanner;


/** Class KnuthMorrisPratt **/

public class KnuthMorrisPratt

{

  /** Failure array **/

  private int[] failure;

  /** Constructor **/

  public KnuthMorrisPratt(String string, String pattern)

  {
    /** pre construct failure array for a pattern **/

    int arraySize = pattern.length();
    failure = new int[arraySize];

    fail(pattern, arraySize);

    /** find match **/

    int pos = posMatch(string, pattern);

    if (pos == -1)

      System.out.println("\nNo match found");

    else

      System.out.println("\nMatch found at index "+ pos);

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
    System.out.println("Failure table "+ failure.length);
    for(int i = 0; i < failure.length;i++)
    {
      System.out.println(failure[i]);
    }
  }

  /** Function to find match for a pattern **/

  private int posMatch(String string, String pattern)
  {
    int i = 0, j = 0;
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

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Scanner scanner = new Scanner(new File(args[0]));
    String string = scanner.nextLine();

    scanner = new Scanner(new File(args[1]));
    String pattern = scanner.nextLine();

    KnuthMorrisPratt kmp = new KnuthMorrisPratt(string, pattern);

  }

}
