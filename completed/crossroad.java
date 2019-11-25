import java.util.*;
import java.io.*;

public class crossroad {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("crossroad.in"));
    PrintWriter output = new PrintWriter(new File("crossroad.out"));

    // Start code here
    int n = input.nextInt();

    Map<Integer, ArrayList<Integer>> crossings = new HashMap<Integer, ArrayList<Integer>>();

    for(int i = 0; i < n; i++) {
      int cow = input.nextInt();
      int location = input.nextInt();

      if(crossings.keySet().contains(cow)) {
        ArrayList<Integer> past = crossings.get(cow);
        past.add(location);
        crossings.put(cow, past);
      }
      else {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(location);
        crossings.put(cow, in);
      }
    }

    int holder = 0;
    int crosses = 0;
    for(int cow : crossings.keySet()) {

      holder = crossings.get(cow).get(0);

      for(int pos : crossings.get(cow)) {
        if(holder != pos) {
          crosses++;
        }
        holder = pos;
      }

    }

    output.write(Integer.toString(crosses));
    output.close();
  }
}
