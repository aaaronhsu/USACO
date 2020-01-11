import java.util.*;
import java.io.*;

public class paint {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("paint.in"));
    PrintWriter output = new PrintWriter (new File("paint.out"));
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();
    int d = input.nextInt();
    //acdb
    if (a <= c && c<d && b >= d) {
      output.println(b - a);
    }
    //cabd
    else if (c<=a && d>=b){
      output.println(d - c);
    }
    //acbd
    else if (a<c && c<b && b<d){
      output.println(d - a);
    }
    //cadb
    else if (c<a && a<d && d<b){
      output.println(b - c);
    }
    //abcd
    else if (a<d && b == c){
      output.println(d - a);
    }
    //ab cd
    else {
      output.println((b-a) + (d-c));
    }

    output.close();
  }
}
