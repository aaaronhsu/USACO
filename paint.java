import java.util.*;
import java.io.*;

public class paint {
  public static void main(String[] args) throws FileNotFoundException {
    boolean[] fence = new boolean[101];
    int a;
    int b;
    int c;
    int d;

    Scanner in = new Scanner(new File("paint.in"));
    PrintWriter out = new PrintWriter(new File("paint.out"));

    a = 0;
    b = 100;
    c = 0;
    d = 100;
    // a = in.nextInt();
    // b = in.nextInt();
    // c = in.nextInt();
    // d = in.nextInt();

    for(int i = a; i <= b; i++) {
      fence[i] = true;
    }
    for(int i = c; i <= d; i++) {
      fence[i] = true;
    }

    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17

    int start = -1;
    int end = -1;

    int sum = 0;

    for(int i = 0; i < 101; i++) {
      if(fence[i] && (start == -1)) {
        start = i;
      }
      if(!(fence[i]) && !(start == -1) || (fence[i] && i == 100) && fence[i - 1]) {
        end = i - 1;

        sum += end - start;

        start = -1;
        end = -1;
      }
    }

    out.write(Integer.toString(sum));

    out.close();
  }
}
