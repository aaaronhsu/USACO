import java.util.*;
import java.io.*;

public class cowsignal {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("cowsignal.in"));
    PrintWriter output = new PrintWriter(new File("cowsignal.out"));

    // Start code here

    int m = input.nextInt();
    int n = input.nextInt();
    int k = input.nextInt();

    char[][] before = new char[m][n];

    for(int i = 0; i < m; i++) {
      before[i] = input.nextLine().toCharArray();
    }

    System.out.println(before[0][0]);

  }
}
