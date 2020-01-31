import java.util.*;
import java.io.*;

public class word {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("word.in"));
    PrintWriter output = new PrintWriter(new File("word.out"));

    // Start code here
    int n = input.nextInt();
    int k = input.nextInt();

    String[] words = new String[n];

    for(int i = 0; i < n; i++) {
      words[i] = input.next();
    }

    int count = 0;

    for(int i = 0; i < n; i++) {
      count += words[i].length();
      if(count > k) {
        output.println("");

        count = words[i].length();
      }

      if(i == n - 1) {
        output.println(words[i]);
      }
      else {
        output.print(words[i]);
      }

    }

    output.close();

  }
}
