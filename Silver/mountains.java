import java.util.*;
import java.io.*;

public class mountains {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("mountains.in"));
    PrintWriter output = new PrintWriter(new File("mountains.out"));

    // Start code here
    int n = input.nextInt();

    int mountains[][] = new int[n][2];

    for(int i = 0; i < n; i++) {
      for(int coord = 0; coord < 2; coord++) {
        mountains[i][coord] = input.nextInt();
      }
    }

    List<Integer> maxX = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      maxX.add(mountains)
    }
  }
}
