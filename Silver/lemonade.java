import java.util.*;
import java.io.*;

public class lemonade {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("lemonade.in"));
    PrintWriter output = new PrintWriter(new File("lemonade.out"));

    // Start code here
    List<Integer> cows = new ArrayList<>();
    int n = input.nextInt();

    for(int i = 0; i < n; i++) {
      cows.add(input.nextInt());
    }

    Collections.sort(cows);
    Collections.reverse(cows);

    int ans = -1;

    for(int i = 0; i < n; i++) {
      if(!(cows.get(i) >= i)) {
        break;
      }

      ans = i;
    }

    output.println(ans + 1);
    output.close();

  }
}
