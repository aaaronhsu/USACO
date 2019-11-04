import java.util.*;
import java.io.*;

public class billboard {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("billboard.in"));
    PrintWriter output = new PrintWriter(new File("billboard.out"));

    // Start code here
    int[] lawnmower = new int[4];
    int[] cowFeed = new int[4];

    for(int i = 0; i < 4; i++) {
      lawnmower[i] = input.nextInt() + 1000;
    }
    for(int i = 0; i < 4; i++) {
      cowFeed[i] = input.nextInt() + 1000;
    }

    



  }
}
