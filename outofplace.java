import java.util.*;
import java.io.*;

public class outofplace {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("outofplace.in"));
    PrintWriter output = new PrintWriter(new File("outofplace.out"));

    // Start code here

    int[] mixed = new int[input.nextInt()];
    for(int i = 0; i < mixed.length; i++) {
      mixed[i] = input.nextInt();
    }

    int[] sorted = mixed.clone();
    Arrays.sort(sorted);

    System.out.println(Arrays.toString(mixed));
    System.out.println(Arrays.toString(sorted));

    int finalPosition = -1;
    for(int i = 0; i < mixed.length; i++) {
      if(mixed[i] != sorted[i]) {
        finalPosition = i;
        i = mixed.length;
      }
    }

    int position = -1;
    for(int i = 0; i < mixed.length; i++) {
      if(mixed[i] == sorted[finalPosition]) {
        position = i;
      }
    }

    int previous = mixed[finalPosition];
    int duplicates = 0;

    if(finalPosition < position) {
      for(int i = finalPosition + 1; i < position; i++) {
        if(previous == mixed[i]) {
          duplicates++;
        }
        previous = mixed[i];
      }
    }
    else {
      for(int i = finalPosition + 1; i > position; i--) {
        if(previous == mixed[i]) {
          duplicates++;
        }
        previous = mixed[i];
      }
    }

    int moves = position - finalPosition - duplicates;

    output.write(Integer.toString(moves));
    output.close();


  }
}
