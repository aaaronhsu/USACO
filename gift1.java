/*
ID: your_id_here
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;

public class gift1 {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("gift1.in"));
    PrintWriter output = new PrintWriter(new File("gift1.out"));

    // Start code here
    int p = input.nextInt();
    Map<String, Integer> people = new HashMap<>();

    String[] asdf = new String[p];

    for(int i = 0; i < p; i++) {
      asdf[i] = input.next();
      people.put(asdf[i], 0);
    }

    String giver = null;
    int bal = 0;
    int rec = 0;
    String person = null;

    for(int i = 0; i < p; i++) {
      giver = input.next();
      bal = input.nextInt();
      rec = input.nextInt();

      if(rec != 0 || bal != 0) {
        people.put(giver, (people.get(giver) - bal) + bal % rec);

        for(int a = 0; a < rec; a++) {
          person = input.next();
          people.put(person, people.get(person) + (bal / rec));
        }
      }
    }

    for(int i = 0; i < p; i++) {
      output.write(asdf[i] + " " + Integer.toString(people.get(asdf[i])));
      output.println("");
    }
    output.close();

  }
}
