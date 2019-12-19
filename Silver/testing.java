import java.io.*;
import java.util.*;

public class testing {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("dog.in"));
    PrintWriter output = new PrintWriter(new File("dog.out"));

    // Start code here
    int read = input.nextInt();

    System.out.println(read); // prints 5

    output.println(read); // creates a file named dog.out and writes 5
    output.close(); // need to close to finish writing file

  }
}
