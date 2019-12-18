import java.util.*;
import java.io.*;

public class angry {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("angry.in"));
    PrintWriter output = new PrintWriter(new File("angry.out"));

    // Start code here
    int n = input.nextInt();
    List<Integer> potential = new ArrayList<Integer>();

    int[] bales = new int[n];
    
    for(int i = 0; i < n; i++) {
      bales[i] = input.nextInt();
    }
    Arrays.sort(bales);

    for(int radius = 1; potential.size() != 1; radius++) {
      for(int i = 1; i < bales.length - 1; i++) {
        if(bales[i] - bales[i - 1] < 1 && bales[i + 1] - bales[i] < 1) {
          potential.add(bales[i])
        }
      }
    }

  }
}
