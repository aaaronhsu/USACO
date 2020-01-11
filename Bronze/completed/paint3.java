import java.util.*;
import java.io.*;

// 10/10

public class paint3 {
  public static void main(String[] args) throws FileNotFoundException {

    Scanner in = new Scanner(new File("paint.in"));
    PrintWriter out = new PrintWriter(new File("paint.out"));
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();

    Set<Integer> painted = new HashSet<>();

    for(int i = a; i < b; i++) {
      painted.add(i);
    }

    for(int i = c; i < d; i++) {
      painted.add(i);
    }

    out.println(painted.size());
    out.close();
  }
}
