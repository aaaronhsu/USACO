import java.util.*;
import java.io.*;

public class citystate {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("citystate.in"));
    PrintWriter output = new PrintWriter(new File("citystate.out"));

    // Start code here
    int n = input.nextInt();
    int ans = 0;

    Map<String, String> di = new HashMap<>();

    for(int i = 0; i < n; i++) {
      String hcity = input.next();
      String city = hcity.charAt(0) + "" + hcity.charAt(1);
      String state = input.next();

      if(di.keySet().contains(city)) {
        if(di.get(city).equals(state)) {
          ans++;

          di.remove(city);
          di.remove(state);
        }
      }

      di.put(state, city);
    }

    output.println(ans);
    output.close();
  }
}
