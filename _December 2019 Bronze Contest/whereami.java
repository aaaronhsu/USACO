import java.util.*;
import java.io.*;
// 10/10 correct: 38 minutes
public class whereami {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("whereami.in"));
    PrintWriter output = new PrintWriter(new File("whereami.out"));

    // Start code here
    int indexes = input.nextInt();
    String str = input.next();
    StringBuilder sb = new StringBuilder();
    String holder = "";

    char[] farm = new char[indexes];

    for(int i = 0; i < indexes; i++) {
      farm[i] = str.charAt(i);
    }

    List<String> list = new ArrayList<>();

    boolean ans = true;
    int minSize = 0;

    for(int size = 1; size <= indexes; size++) {

      for(int a = 0; a < indexes - size + 1; a++) {

        for(int i = a; i < size + a; i++) {
          sb.append(farm[i]);
        }

        holder = sb.toString();
        System.out.println(holder);
        if(!list.contains(holder)) {
          list.add(holder);
        }
        else {
          ans = false;
        }

        sb = new StringBuilder();
      }
      list.clear();

        if(ans) {
          minSize = size;
          break;
        }
        ans = true;

    }

    output.write(Integer.toString(minSize));
    output.close();
  }
}
