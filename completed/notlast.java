import java.util.*;
import java.io.*;

public class notlast {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("notlast.in"));
    PrintWriter output = new PrintWriter(new File("notlast.out"));

    // Start code here

    int cow = input.nextInt();

    Map<String, Integer> cows = new HashMap<>();

    String holder = null;

    for(int i = 0; i < cow; i++) {
      holder = input.next();

      if(cows.containsKey(holder)) {
        cows.put(holder, input.nextInt() + cows.get(holder));
      }
      else {
        cows.put(holder, input.nextInt());
      }
    }

    boolean notFirst = true;

    if(cows.keySet().size() != 7) {
      notFirst = false;
    }

    List[] milk = new ArrayList[6000];

    for(String s : cows.keySet()) {

      if(milk[cows.get(s)] == null) {
        milk[cows.get(s)] = new ArrayList<String>();
      }

      milk[cows.get(s)].add(s);
    }

    String out = null;

    for(int i = 0; i < milk.length; i++) {

      if(milk[i] != null && milk[i].size() == 7) {
        out = "Tie";
        break;
      }
      else if(notFirst && milk[i] != null) {
        notFirst = false;
      }
      else if(!notFirst && milk[i] != null) {
        if(milk[i].size() == 1) {
          out = (String) milk[i].get(0);
          break;
        }
        else {
          out = "Tie";
          break;
        }
      }

    }

    output.write(out);
    output.close();

  }
}
