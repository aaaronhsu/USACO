import java.util.*;

public class MyBeer {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int total = 0;

    int[] people = new int[n];
    ArrayList<Integer> after = new ArrayList<Integer>(n);

    for(int i = 0; i < n; i++) {
      after.add(i);
    }

    for(int a = 0; a < 1000; a++) {
      Collections.shuffle(after);

      for(int i = 0; i < n; i++) {
        people[i] = after.get(i);
        if(i == people[i]) {
          total++;
          break;
        }
      }
    }

    System.out.println(total / 1000.0);
  }
}
