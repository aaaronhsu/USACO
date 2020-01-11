import java.util.*;
import java.io.*;

public class lostcow {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("lostcow.in"));
    PrintWriter output = new PrintWriter(new File("lostcow.out"));

    // Start code here
    int x = input.nextInt();
    int y = input.nextInt() - x;
    x = 0;
    int times = 0;

    if(x > y) {
      // bessie is behind farmer
      y *= -1;
      for(int i = 2; i < y; i *= 4) {
        times++;
      }

      times++;
      times *= 2;
      times--;

    }
    else if (y > x) {
      // bessie is in front of farmer
      for(int i = 1; i < y; i *= 4) {
        times++;
      }
      times *= 2;
    }
    else {
      // bessie is on farmer
      output.println("0");
      output.close();
    }

    int ans = calculate(times) + (int) Math.abs(Math.pow(2, times - 1)) + Math.abs(y);
    output.println(ans);
    output.close();
  }

  static int calculate(int times) {
    int sum = 0;
    for(int i = 0; i < times; i++) {
      if(i != 0) {
        sum += Math.pow(2, i) + Math.pow(2, i - 1);
      }
      else {
        sum += Math.pow(2, i);
      }
    }
    return sum;
  }

}
