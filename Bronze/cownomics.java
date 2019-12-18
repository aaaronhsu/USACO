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

    List<Integer> potential = new ArrayList<>();

    boolean isEqual = true;
    for(int i = 0; i < seqLength; i++) {
      for(int a = 0; a < cows - 1; a++) {
        if(plain[a].charAt(i) != plain[a + 1].charAt(i)) {
          isEqual = false;
          break;
        }
      }

      if(!isEqual) {
        potential.add(i);
      }
    }

    boolean potentialGenome = true;
    int ans = 0;
    for(int a : potential) {
      for(int i = 0; i < cows - 1; i++) {
        if(spotted[i].charAt(a) == spotted[i + 1].charAt(a)) {
          potentialGenome = false;
          break;
        }
      }

      if(potentialGenome) {
        ans++;
      }

      potentialGenome = true;
    }

    output.println(ans);
    output.close();
  }
}
