import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jserna18 on 11/17/16.
 */
public class StringGenerator
{
  BufferedWriter writer;
  File logFile;
  Random rand;

  private void generateString()
  {
    rand = new Random();


    try {
      //create a temporary file
      logFile = new File("Medium");

      // This will output the full path where the file will be written to...
      System.out.println(logFile.getCanonicalPath());

      writer = new BufferedWriter(new FileWriter(logFile));

      for (int i = 0; i < 100_000; i++)
      {

        int ascii = rand.nextInt(122 - 97 + 1) + 97;

        try
        {
          writer.write((char)ascii);
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        // Close the writer regardless of what happens...
        writer.close();
      } catch (Exception e) {

      }
    }
  }

  private void generatePattern()
  {
    try
    {
      Scanner scan = new Scanner(logFile);
      String string = scan.nextLine();
      int maxPatternLength = 3;
      int maxLocation = string.length() - maxPatternLength;


      int patternLocation = rand.nextInt(maxLocation - 1 + 1) + 1;
      String pattern = string.substring(patternLocation, patternLocation+maxPatternLength);

      logFile = new File("MediumPattern");
      try
      {
        writer = new BufferedWriter(new FileWriter(logFile));

        writer.write(pattern);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    finally {
      try {
        // Close the writer regardless of what happens...
        writer.close();
      } catch (Exception e) {

      }
    }

  }


  public static void main(String[] args)
  {
   StringGenerator str = new StringGenerator();

    str.generateString();
    str.generatePattern();

  }
}
