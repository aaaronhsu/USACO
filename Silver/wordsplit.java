import java.util.*;
import java.io.*;

public class wordsplit {
  public static void main(String[] args) throws FileNotFoundException {
    // Start code here
    String str = "ok i added another section on our budget spreadsheet for lumiere";
    int a = 0;
    for(int i = 0; i < str.length(); i++) {
      a += str.charAt(i);
    }

    System.out.println(a);
  }
}
