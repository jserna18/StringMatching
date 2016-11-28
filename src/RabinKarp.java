/**
 * Created by huynh on 11/28/2016.
 */
public class RabinKarp
{

  public RabinKarp(String bigString,String pattern)
  {
    int q = 13;
    int M = pattern.length();
    int N = bigString.length();
    int i, j;
    int p = 0; // hash value for pattern
    int t = 0; // hash value for txt
    int h = 1;
    int d = 256;// keyboard characters
    System.out.println("RabinKarp");
    System.out.println("Pattern: "+pattern+" bigString: "+bigString);

    // The value of h would be "pow(d, M-1)%q"
    for (i = 0; i < M-1; i++)
      h = (h*d)%q;


    // Calculate the hash value of pattern and first
    // window of text
    for (i = 0; i < M; i++)
    {
      p = (d*p + pattern.charAt(i))%q;
      t = (d*t + bigString.charAt(i))%q;
    }


    // Slide the pattern over text one by one
    for (i = 0; i <= N - M; i++)
    {


      // Check the hash values of current window of text
      // and pattern. If the hash values match then only
      // check for characters on by one
      if ( p == t )
      {
      /* Check for characters one by one */
        for (j = 0; j < M; j++)
        {
          if (bigString.charAt(i+j) != pattern.charAt(j))
          {
            j= M+1;
          }
          if (j==M-1)
          {

          }
//            return true;
        }
      }


      // Calculate hash value for next window of text: Remove
      // leading digit, add trailing digit
      if ( i < N-M )
      {
        t = (d*(t - bigString.charAt(i)*h) + bigString.charAt(i+M))%q;
        // We might get negative value of t, converting it
        // to positive
        if (t < 0) t = (t + q);
      }
    }
//    return false;
  }
}
