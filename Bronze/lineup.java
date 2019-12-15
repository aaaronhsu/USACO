import java.util.*;
import java.io.*;

public class lineup {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("lineup.in"));
    PrintWriter output = new PrintWriter(new File("lineup.out"));

    // Start code here
    LinkedList<String> cows = new LinkedList<>();

    cows.add("Beatrice");
    cows.add("Belinda");
    cows.add("Bella");
    cows.add("Bessie");
    cows.add("Betsy");
    cows.add("Blue");
    cows.add("Buttercup");
    cows.add("Sue");

    int mismatches = input.nextInt();
    HashMap<String, List<String>> milkedBy = new HashMap<>();
    for(int i = 0; i < mismatches; i++) {
      String cow1 = input.next();

      for(int a = 0; a < 4; a++) {
        input.next();
      }

      String cow2 = input.next();
      if(milkedBy.keySet().contains(cow2)) {
        List<String> asdf = milkedBy.get(cow2);
        asdf.add(cow1);
        milkedBy.put(cow2, asdf);
      }
      else {
        List<String> holder = new ArrayList<>();
        holder.add(cow1);
        milkedBy.put(cow2, holder);
      }
    }

    // end of file reading
    for(String a : milkedBy.keySet()) {
      List<String> neighbors = milkedBy.get(a);

      if(neighbors.size() == 1) {
        // only 1 neighbors
        String cow1 = a;
        String cow2 = neighbors.get(0);
        int cow1Index = cows.indexOf(cow1);
        int cow2Index = cows.indexOf(cow2);

        if(cow1Index < cow2Index) {
          // cow1 appears before cow2
          if(alph(cow1, cow2)) {
            cows.remove(cow2);
            int index = cows.indexOf(cow1);
            cows.add(index + 1, cow2);
          }
          else {
            cows.remove(cow2);
            int index = cows.indexOf(cow1);
            cows.add(index, cow2);
          }
        }
        else {
          if(!alph(cow2, cow1)) {
            cows.remove(cow1);
            int index = cows.indexOf(cow2);
            cows.add(index + 1, cow1);
          }
          else {
            cows.remove(cow1);
            int index = cows.indexOf(cow2);
            cows.add(index, cow1);
          }
        }



      }
      else {
        // two neighbors
        String cow1 = a;
        String cow2 = neighbors.get(0);
        String cow3 = neighbors.get(1);
        int cow1Index = cows.indexOf(cow1);
        int cow2Index = cows.indexOf(cow2);
        int cow3Index = cows.indexOf(cow3);

        if(cow2Index < cow3Index) {
          // cow 2 appears before cow 3
          cows.remove(cow1);
          cows.remove(cow3);
          cow2Index = cows.indexOf(cow2);
          cows.add(cow2Index + 1, cow3);
          cows.add(cow2Index + 1, cow1);
        }
        else {
          // cow 3 appears before cow 2
          cows.remove(cow1);
          cows.remove(cow2);

          cow3Index = cows.indexOf(cow3);
          cows.add(cow3Index + 1, cow2);
          cows.add(cow3Index + 1, cow1);
        }
      }

    }



    for(int i = 0; i < 8; i++) {
      output.println(cows.get(i));
    }

    output.close();

  }

  static boolean alph(String cow1, String cow2) {
    List<String> al = new ArrayList<>();
    al.add(cow1);
    al.add(cow2);
    Collections.sort(al);

    return al.get(0).equals(cow1);
  }

  static List<String> alph3(String cow1, String cow2, String cow3) {
    List<String> qwer = new ArrayList<>();
    qwer.add(cow1);
    qwer.add(cow2);
    qwer.add(cow3);
    Collections.sort(qwer);
    return qwer;
  }
}
