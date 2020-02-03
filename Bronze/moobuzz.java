import java.util.*;
import java.io.*;

public class moobuzz {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("moobuzz.in"));
    PrintWriter output = new PrintWriter(new File("moobuzz.out"));

    // Start code here
    int n = input.nextInt();
    int ans = 0;

    for (int i = 0; i <= n; i++){
      if (i % 3 == 0 || i % 5 == 0) ans += 2;
      else ans++;
    }


    output.println(ans);
    output.close();
  }
}
