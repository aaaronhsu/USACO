import java.util.*;
import java.io.*;

// COMPLETE 10/10

public class paint2 {
  public static void main(String[] args) throws FileNotFoundException {

    Scanner in = new Scanner(new File("paint.in"));
    PrintWriter out = new PrintWriter(new File("paint.out"));

    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();

    HashSet<Integer> dup = new HashSet<>();

    for(int i = a; i < b; i++) {
      dup.add(i);
    }
    for(int i = c; i < d; i++) {
      dup.add(i);
    }


    out.write(Integer.toString(dup.size()));
    out.close();
  }
}
