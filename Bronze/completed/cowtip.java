import java.util.*;
import java.io.*;

public class cowtip {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("cowtip.in"));
    PrintWriter output = new PrintWriter(new File("cowtip.out"));

    // Start code here

    int side = input.nextInt();
    int hold = 0;
    String holder = null;

    int[][] cows = new int[side][side];
    int counter = 0;
    for(int i = 0; i < side; i++) {
        holder = input.next();
        for(int a = 0; a < side; a++) {
        	cows[i][a] = (int) holder.charAt(a) - 48;
        }
    }

    for(int i = side - 1; i >= 0; i--) {

      for(int a = i; a >= 0; a--) {

        for(int q = 0; q < 2; q++) {
          // needs to be flipped
          if(cows[i][a] == 1) {
            counter++;
            for(int j = i; j >= 0; j--) {
              for(int k = a; k >= 0; k--) {
                if(cows[j][k] == 1) {
                  cows[j][k] = 0;
                }
                else {
                  cows[j][k] = 1;
                }
              }
            }
          }
          hold = a;
          a = i;
          i = hold;
        }

      }

    }

    output.println(counter);
    output.close();
  }

}
