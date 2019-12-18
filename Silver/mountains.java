import java.util.*;
import java.io.*;

public class mountains {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("mountains.in"));
    PrintWriter output = new PrintWriter(new File("mountains.out"));

    // Start code here
    int n = input.nextInt();

    int mountains[][] = new int[n][2];

    for(int i = 0; i < n; i++) {
      for(int coord = 0; coord < 2; coord++) {
        mountains[i][coord] = input.nextInt();
      }
    }

    List<Integer> maxX = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      maxX.add(mountains[i][0]);
    }
    Collections.sort(maxX);

    int[] height = new int[maxX.get(maxX.size() - 1)];

    int peaks = 0;
    for(int i = 0; i < n; i++) {
      if(height[mountains[i][0]] < mountains[i][1]) {
        peaks++;
      }

      height = fill(mountains[i][0], mountains[i][1], height);
    }

  }

  static int[] fill(int x, int y, int[] height) {
    int leftY = x;
    int rightY = y;

    int counter = 0;
    for(int i = x; leftY == 0 || counter + x >= height.length; i--) {
      if(height[i] < leftY - counter) {
        height[i] = leftY - counter;
      }
    }

    counter = 0;

    for(int i = x; rightY == 0 || counter - x <= 0; i++) {
      if(height[i] < rightY - counter) {
        height[i] = rightY - counter;
      }
    }

    return height;
  }
}
