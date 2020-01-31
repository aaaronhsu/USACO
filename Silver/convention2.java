import java.util.*;
import java.io.*;

public class convention2 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("convention2.in"));
    PrintWriter output = new PrintWriter(new File("convention2.out"));

    // Start code here
    int n = input.nextInt();

    cow[] array = new cow[n];

    for(int i = 0; i < array.length; i++) {
      array[i] = new cow(i, input.nextInt(), input.nextInt());
    }

    Arrays.sort(array, (x, y) -> x.arrive - y.arrive);

    PriorityQueue<cow> queue = new PriorityQueue<>((x, y) -> x.id - y.id);

    int maxWaitTime = 0;
    int currentTime = 0;

    for(int i = 0; i < n; i++) {
      if(array[i].arrive <= currentTime) {
        queue.add(array[i]);
      }
      else if(queue.size() == 0) {
        queue.add(array[i]);
        currentTime = array[i].arrive;
      }
      else {
        cow temp = queue.poll();
        maxWaitTime = Math.max(maxWaitTime, currentTime - temp.arrive);
        currentTime += temp.spend;
        i--;
      }
    }

    output.println(maxWaitTime);
    output.close();


  }
}

class cow {
  int id;
  int arrive;
  int spend;

  cow(int id, int arrive, int spend) {
    this.id = id;
    this.arrive = arrive;
    this.spend = spend;
  }

}
