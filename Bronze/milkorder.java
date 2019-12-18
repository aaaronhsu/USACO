import java.util.*;
import java.io.*;
// 4/10 
public class milkorder {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("milkorder.in"));
    PrintWriter output = new PrintWriter(new File("milkorder.out"));

    // Start code here
    int n = input.nextInt();
    int m = input.nextInt();
    int k = input.nextInt();

    List<Integer> hierachy = new ArrayList<>();

    for(int i = 0; i < m; i++) {
      hierachy.add(input.nextInt());
    }

    HashMap<Integer, Integer> demand = new HashMap<>();
    HashMap<Integer, Integer> potato = new HashMap<>();

    for(int i = 0; i < k; i++) {
      int a = input.nextInt();
      int c = input.nextInt();
      potato.put(a, c);
      demand.put(c, a);
    }


    int cBoth = 0; // num of cow that is in both
    int back = 0; // how many cows that are taking up sapce back
    int front = 0; // how many cows that are taking up space front
    boolean isBoth = false;
    Set<Integer> die = demand.keySet();
    List<Integer> req = new ArrayList<>();
    for(int a : die) {
      req.add(demand.get(a));
    }

    for(int i = 0; i < hierachy.size(); i++) {

      if(req.contains(hierachy.get(i))) {
        cBoth = hierachy.get(i);
        back = i;
        front = hierachy.size() - i - 1;
        isBoth = true;
        break;
      }
    }

    int ans = -1;
    if(isBoth) {
        int posBoth = potato.get(cBoth); // position of cow that is in both sets
        int cBack = posBoth - back;
        int cFront = posBoth + front;

        for(int i = cBack; i < cFront; i++) {
          demand.put(i, -1);
        }
    }

    for(int i = 1; i < n; i++) {
      if(!demand.keySet().contains(i)) {
        ans = i;
        break;
      }
    }
    output.println(ans);
    output.close();


  }
}
