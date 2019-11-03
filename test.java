import java.util.*;
import java.io.*;

public class test {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("test.in"));
    PrintWriter output = new PrintWriter(new File("test.out"));

    // Start code here

    String data = input.next();

    output.write("My favorite food is " + data);
    output.close();
  }
}
