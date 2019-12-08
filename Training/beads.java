/*
ID: pufflew1
LANG: JAVA
TASK: beads
*/

import java.util.*;
import java.io.*;

public class beads {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("beads.in"));
    PrintWriter output = new PrintWriter(new File("beads.out"));

    // Start code here

    int num = input.nextInt();
    int[] beads = new int[3];

    String chain = input.next();
    for(int i = 0; i < num; i++) {
      if(chain.charAt(i) == 'r') {
        beads[0]++;
      }
      if(chain.charAt(i) == 'b') {
        beads[1]++;
      }
      if(chain.charAt(i) == 'w') {
        beads[2]++;
      }
    }

    Arrays.sort(beads);
    output.write(Integer.toString(beads[2] - 1));
    output.println("");
    output.close();
  }
}
