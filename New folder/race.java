import java.util.*;
import java.io.*;

public class race {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("race.in"));
    PrintWriter output = new PrintWriter(new File("race.out"));

    // Start code here
    int maxLength = input.nextInt();
    int n = input.nextInt();

    int[] races = new int[n];
    for(int i = 0; i < n; i++) {
      races[i] = input.nextInt();
    }

    int length = 0;
    int counter = 0;

    for(int i = 0; i < n; i++) {

      length = 0;
      counter = 0;
      for(int a = 1; length < races[i]; a++) {
        length += 2 * a;
        counter++;
      }

      System.out.println(counter);


    }

  }
}
