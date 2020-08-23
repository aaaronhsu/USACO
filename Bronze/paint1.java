import java.util.*;
import java.io.*;

public class paint1 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("paint.in"));
    PrintWriter output = new PrintWriter(new File("paint.out"));

    // Start code here
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();
    int d = input.nextInt();

    int highest = 0;
    if (b > d) {
        highest = b;
    }
    else {
        highest = d;
    }

    int[] paint = new int[highest];
    
    // paints from a to b
    for (int i = a; i < b; i++) {
        paint[i] = paint[i] + 1;
    }

    // paints from c to d
    for (int i = c; i < d; i++) {
        paint[i] = paint[i] + 1;
    }

    int ans = 0;
    // counts up the number of painted indexes (not 0)
    for (int i = 0; i < paint.length; i++) {
        if (paint[i] != 0) {
            ans++;
        }
    }

    output.println(ans);
    output.close();
  }
}
