import java.util.*;
import java.io.*;

public class blocks {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("blocks.in"));
    PrintWriter output = new PrintWriter(new File("blocks.out"));

    // Start code here

    int blocks = input.nextInt();
    String[][] words = new String[blocks][2];

    for(int i = 0; i < words.length; i++) {
      for(int a = 0; a < 2; a++) {
        words[i][a] = input.next();
      }
    }

    int[] blocksNeeded = new int[26];
    int first = 0;
    int second = 0;
    for(int i = 0; i < 26; i++) {

      for(int a = 0; a < blocks; a++) {
        // checks first word
        for(int f = 0; f < words[a][0].length(); f++) {
          if(words[a][0].charAt(f) - 97 == i) {
            first++;
          }
        }

        // checks second word
        for(int f = 0; f < words[a][1].length(); f++) {
          if(words[a][1].charAt(f) - 97 == i) {
            second++;
          }
        }

        if(first > second) {
          blocksNeeded[i] += first;
        }
        else {
          blocksNeeded[i] += second;
        }
        first = 0;
        second = 0;
      }

    }

    for(int i = 0; i < 26; i++) {
      output.println(Integer.toString(blocksNeeded[i]));
    }
    output.close();
  }
}
