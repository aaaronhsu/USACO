import java.util.*;
import java.io.*;

public class paintbarn {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("paintbarn.in"));
    PrintWriter output = new PrintWriter(new File("paintbarn.out"));

    // Start code here
    int n = input.nextInt();
    int k = input.nextInt();
    int[][] coords = new int[n][4];
    int maxX = 0;
    int maxY = 0;
    for(int i = 0; i < n; i++) {
      coords[i][0] = input.nextInt();
      coords[i][1] = input.nextInt();
      coords[i][2] = input.nextInt();
      coords[i][3] = input.nextInt();

      if(maxX < coords[i][2]) {
        maxX = coords[i][2];
      }
      if(maxY < coords[i][3]) {
        maxY = coords[i][3];
      }
    }

    int[][] map = new int[maxX][maxY];

    for(int i = 0; i < n; i++) {
      for(int x = coords[i][0]; x < coords[i][2]; x++) {
        for(int y = coords[i][1]; y < coords[i][3]; y++) {
          map[x][y]++;
        }
      }
    }

    int ans = 0;

    for(int i = 0; i < map.length; i++) {
      for(int a = 0; a < map[0].length; a++) {
        if(map[i][a] == k) {
          ans++;
        }
      }
    }

    output.write(Integer.toString(ans));
    output.close();

  }
}
