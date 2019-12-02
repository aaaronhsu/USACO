import java.util.*;
import java.io.*;

public class pails {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("pails.in"));
    PrintWriter output = new PrintWriter(new File("pails.out"));

    // Start code here
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();

    int minimum = c;

    for(int i = 0; i < c/a; i++) {
      if((c - (a * i)) % b < minimum) {
        minimum = (c - (a * i)) % b;
      }
    }

    for(int i = 0; i < c/b; i++) {
      if((c - (b * i)) % a < minimum) {
        minimum = (c - (b * i)) % a;
      }
    }

    output.write(Integer.toString(c - minimum));
    output.close();

  }
}
