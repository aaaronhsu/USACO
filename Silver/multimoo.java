import java.util.*;
import java.io.*;

public class multimoo {

  static int n;
  static int[][] board;

  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("multimoo.in"));
    PrintWriter output = new PrintWriter(new File("multimoo.out"));

    // Start code here
    n = input.nextInt();
    board = new int[n][n];
    boolean[][] searched = new boolean[n][n];

    for(int i = 0; i < n; i++) {
      for(int a = 0; a < n; a++) {
        board[i][a] = input.nextInt();
      }
    }

    int max = 0;
    int l;
    for(int i = 0; i < n; i++) {
      for(int a = 0; a < n; a++) {
        if(!searched[i][a]) {
          l = floodfill(i, a, new boolean[n][n], board[i][a]);
          if(l > max) max = l;
        }
      }
    }

    output.println(max);

    max = 0;
    l = 0;
    searched = new boolean[n][n];
    for(int i = 0; i < n; i++) {
      for(int a = 0; a < n - 1; a++) {
        if(board[i][a] != board[i][a + 1]) {
          l = flood(i, a, new boolean[n][n], board[i][a], board[i][a + 1]);
          if(l > max) max = l;
        }
        if(board[a][i] != board[a + 1][i]) {
          l = flood(i, a, new boolean[n][n], board[a][i], board[a + 1][i]);
          if(l > max) max = l;
        }
      }
    }

    output.println(max);
    output.close();

  }

  static int flood(int x, int y, boolean[][] s, int target1, int target2) {
    if(x >= s.length || y >= s.length || x < 0 || y < 0 || s[x][y]) return 0;
    s[x][y] = true;

    if(board[x][y] == target1 || board[x][y] == target2) {
      return 1 + flood(x + 1, y, s, target1, target2) + flood(x - 1, y, s, target1, target2) + flood(x, y + 1, s, target1, target2) + flood(x, y - 1, s, target1, target2);
    }

    return 0;
  }

  static int floodfill(int x, int y, boolean[][] s, int target) {
    if(x >= s.length || y >= s.length || x < 0 || y < 0 || s[x][y]) return 0;
    s[x][y] = true;

    if(board[x][y] == target) {
      return 1 + floodfill(x + 1, y, s, target) + floodfill(x - 1, y, s, target) + floodfill(x, y + 1, s, target) + floodfill(x, y - 1, s, target);
    }

    return 0;
  }


}
