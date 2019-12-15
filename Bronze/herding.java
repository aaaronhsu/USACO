import java.util.*;
import java.io.*;

public class herding {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("herding.in"));
    PrintWriter output = new PrintWriter(new File("herding.out"));

    // Start code here
    int[] cows = new int[3];

    for(int i = 0; i < 3; i++) {
      cows[i] = input.nextInt();
    }

    Arrays.sort(cows);

    int max = 0;
    int min = 2;

    if(cows[2] - cows[1] > cows[1] - cows[0]) {
      max = cows[2] - cows[1] - 1;
    }
    else {
      max = cows[1] - cows[0] - 1;
    }

    if(cows[2] - cows[1] == 2 || cows[1] - cows[0] == 2) {
      min = 1;
    }
    if(cows[2] - cows[1] == 1 && cows[1] - cows[0] == 1) {
      min = 0;
    }

    output.println(Integer.toString(min));
    output.println(Integer.toString(max));
    output.close();


  }
}
