import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by juaker505 on 11/22/2016.
 */
public class BruteForce
{
  private String string;
  private String pattern;

  public BruteForce(String string, String pattern)
  {
    this.string = string;
    this.pattern = pattern;
    findMatch();
  }

  private void findMatch()
  {
    ArrayList match = comparePattern();

    if(match.isEmpty())
    {
      System.out.println("No match found...");
    }
    else
    {
      System.out.println("Matches found at index: ");

      for(int i = 0; i < match.size(); i++)
      {
        System.out.print(match.get(i) + ", ");
      }
    }

  }

  private ArrayList comparePattern()
  {
    int patternIdx = 0;
    int indexOfMatch = 0;
    ArrayList<Integer> matchArray = new ArrayList();
    for(int i = 0; i < string.length(); i++)
    {
      if(string.charAt(i) != pattern.charAt(patternIdx))
      {
        patternIdx = 0;
        continue;
      }
      else
      {
        if(patternIdx == 0)
        {
          indexOfMatch = i;
        }
        if(patternIdx == pattern.length()-1)
        {
          matchArray.add(indexOfMatch);
          patternIdx = 0;
        }
        patternIdx++;
      }
    }
    return matchArray;
  }

  public static void main(String[] args) throws IOException

  {
    long startTime = System.currentTimeMillis();

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Scanner scanner = new Scanner(new File(args[0]));

    String string = scanner.nextLine();
    System.out.println(string);

    scanner = new Scanner(new File(args[1]));
    String pattern = scanner.nextLine();
    System.out.println(pattern);

    BruteForce brute = new BruteForce(string, pattern);

    final long endTime = System.currentTimeMillis();

    System.out.println("\nTotal execution time: " + (endTime - startTime) );

  }
}
