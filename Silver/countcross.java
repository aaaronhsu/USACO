import java.util.*;
import java.io.*;

public class countcross {

  static Field[][] fields;

  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("countcross.in"));
    PrintWriter output = new PrintWriter(new File("countcross.out"));

  int n = input.nextInt();
  int k = input.nextInt();
  int r = input.nextInt();
  fields = new Field[n][n];

  for(int i = 0; i < n; i++) {
    for(int a = 0; a < n; a++) {
      fields[i][a] = new Field(i, a);
    }
  }

    // Start code here
    for(int i = 0; i < r; i++) { //*How to mark roads?
   int r1 = input.nextInt() - 1;
   int c1 = input.nextInt() - 1;
   int r2 = input.nextInt() - 1;
   int c2 = input.nextInt() - 1;
   if(r1 > r2) {
    fields[r1][c1].blockedUp = true;
    fields[r2][c2].blockedDown = true;
   } else if(r2 > r1) {
    fields[r1][c1].blockedDown = true;
    fields[r2][c2].blockedUp = true;
   } else if(c1 > c2) {
    fields[r1][c1].blockedLeft = true;
    fields[r2][c2].blockedRight = true;
   } else if(c2 > c1) {
    fields[r1][c1].blockedRight = true;
    fields[r2][c2].blockedLeft = true;
   }
  }


  boolean[][] s = new boolean[n][n];
  int[] cows = new int[k * 2];
    for(int i = 0; i < k; i++) {
      cows[i * 2] = input.nextInt() - 1;
      cows[i * 2 + 1] = input.nextInt() - 1;
      fields[cows[i * 2]][cows[i * 2 + 1]].cowCount++;
    }

    int counter = 0;

    for(int i = 0; i < k; i++) {
      counter += floodFill(cows[i * 2], cows[i * 2 + 1], s) + 1;
      System.out.println(counter);
      s = new boolean[n][n];
    }

    output.println(counter / 2);
    output.close();
  }

  static int floodFill(int i, int j, boolean[][] s) {
    if(i >= fields[0].length || j >= fields[0].length || i < 0 || j < 0 || s[i][j]) return 0;

    int count = 0;
    s[i][j] = true;

    if(!fields[i][j].blockedUp) count += floodFill(i - 1, j, s);
    if(!fields[i][j].blockedDown) count += floodFill(i + 1, j, s);
    if(!fields[i][j].blockedLeft) count += floodFill(i, j - 1, s);
    if(!fields[i][j].blockedRight) count += floodFill(i, j + 1, s);

    if(fields[i][j].cowCount > 0) {
      return 1;
    }
    return count;
  }

  static class Field {
    boolean blockedUp, blockedDown, blockedLeft, blockedRight;
    int cowCount = 0;
    int row,  col;
    Field(int row, int col)
    {
     this.row = row;
     this.col = col;
    }
   }
  }
