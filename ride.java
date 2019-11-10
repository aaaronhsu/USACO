/*
ID: pufflew1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class ride {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("ride.in"));
    PrintWriter output = new PrintWriter(new File("ride.out"));

    // Start code here

    String comet = input.next();
    int cValue = 1;
    String ufo = input.next();
    int uValue = 1;

    for(int i = 0; i < comet.length(); i++) {
      cValue *= letterToNumber(comet.charAt(i));
    }

    for(int i = 0; i < ufo.length(); i++) {
      uValue *= letterToNumber(ufo.charAt(i));
    }

    if(cValue % 47 == uValue % 47) {
      output.write("GO");
    }
    else {
      output.write("STAY");
    }

    output.println("");
    output.close();

  }

  static int letterToNumber(char a) {
    return (int) a - 64;
  }


}
