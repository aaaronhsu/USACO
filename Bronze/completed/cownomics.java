import java.util.*;
import java.io.*;

public class cownomics {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("cownomics.in"));
    PrintWriter output = new PrintWriter(new File("cownomics.out"));

    // Start code here
    int cows = input.nextInt();
    int seqLength = input.nextInt();

    String[] spotted = new String[cows];
    String[] plain = new String[cows];

    for(int i = 0; i < cows; i++) {
      spotted[i] = input.next();
    }
    for(int i = 0; i < cows; i++) {
      plain[i] = input.next();
    }

    int ans = 0;
    boolean noMatches = true;

    List<Character> potential = new ArrayList<>(); // potential base pairs that could be responsible

    for(int i = 0; i < seqLength; i++) {
      for(int cow = 0; cow < cows; cow++) {
        potential.add(plain[cow].charAt(i)); // adding the base pairs of plain cows at index i

        if(potential.contains("a") && potential.contains("t") && potential.contains("g") && potential.contains("c")) {
          // because potential already contains all possible base pairs, no need to add duplicates
          break;
        }
      }

      for(int cow = 0; cow < cows; cow++) {
        if(potential.contains(spotted[cow].charAt(i))) {
          // a spotted cow also has a gene that a plain cow has at index i
            noMatches = false;
            break;
        }
      }

      if(noMatches) {
        ans++;
      }

      // reset variables
      noMatches = true;
      potential.clear();
    }



    output.println(ans);
    output.close();
  }
}
