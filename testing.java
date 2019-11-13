import java.util.*;
import java.io.*;

public class testing {
  public static void main(String[] args) throws FileNotFoundException{

    // Start code here

    char[] before = {'x', '.', 'x'};
    int factor = 2;

    char[] after = new char[before.length * factor];

    int offset = 0;
    for(int i = 0; i < before.length; i++) {
      for(int a = 0; a < factor; a++) {
        after[offset] = before[i];
        offset++;
      }
    }

    System.out.println(Arrays.toString(after));

  }
}

// https://www.geeksforgeeks.org/send-email-using-java-program/
