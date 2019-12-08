import java.util.*;
import java.io.*;

public class circlecross {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("circlecross.in"));
    PrintWriter output = new PrintWriter(new File("circlecross.out"));

    // Start code here
    char[] pLine = input.next().toChar();
    List<Integer> line = new ArrayList<Integer>();
    List<Integer> checked = new ArrayList<Integer>();
    List<Integer> holder = new ArrayList<Integer>();
    List<Integer> checking = new ArrayList<Integer>();

    for(int i = 0; i < pLine.length; i++) {
      line.add((int)pLine[i] - 64);
    }

    for(int i = 0; i < 52; i++) {
      holder = line.clone();
      holder.remove(0);

      if(holder.indexOf(line.get(i)) != -1) {
        for(int a = i + 1; a < holder.indexOf(line.get(i)); a++) {
          if(checking.contains(a)) {
            checking.remove(a);
          }
          else {
            checking.add(a);
          }
        }

        for(int n : checking) {
          if()
        }
      }
      for(int a = i; )
    }

  }
}
