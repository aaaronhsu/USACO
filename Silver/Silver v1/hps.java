import java.util.*;
import java.io.*;

public class hps {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("hps.in"));
    PrintWriter output = new PrintWriter(new File("hps.out"));

    // Start code here
    int n = input.nextInt();
    int[] move = new int[n];

    for(int i = 0; i < n; i++) {
      String a = input.next();

      if(a.equals("P")) move[i] = 0;
      else if(a.equals("H")) move[i] = 1;
      else move[i] = 2;
    }

    int[] fP = new int[n + 1];
    int[] fH = new int[n + 1];
    int[] fS = new int[n + 1];

    int[] bP = new int[n + 1];
    int[] bH = new int[n + 1];
    int[] bS = new int[n + 1];

    if(move[0] == 0) fP[0] = 1;
    else if(move[0] == 1) fH[0] = 1;
    else fS[0] = 1;

    if(move[n - 1] == 0) bP[0] = 1;
    else if(move[n - 1] == 1) bH[0] = 1;
    else bS[0] = 1;

    
    for(int i = 1; i < n; i++) {
      if(move[i] == 0) {
        fP[i] = fP[i - 1] + 1;
        fH[i] = fH[i - 1];
        fS[i] = fS[i - 1];
      }
      else if(move[i] == 1) {
        fP[i] = fP[i - 1];
        fH[i] = fH[i - 1] + 1;
        fS[i] = fS[i - 1];
      }
      else {
        fP[i] = fP[i - 1];
        fH[i] = fH[i - 1];
        fS[i] = fS[i - 1] + 1;
      }
    }

    for(int i = 1; i < n; i++) {
      if(move[n - i - 1] == 0) {
        bP[i] = bP[i - 1] + 1;
        bH[i] = bH[i - 1];
        bS[i] = bS[i - 1];
      }
      else if(move[n - i - 1] == 1) {
        bP[i] = bP[i - 1];
        bH[i] = bH[i - 1] + 1;
        bS[i] = bS[i - 1];
      }
      else {
        bP[i] = bP[i - 1];
        bH[i] = bH[i - 1];
        bS[i] = bS[i - 1] + 1;
      }
    }

    int[] ans = new int[6];
    ans[0] = count(fP, bH, n);
    ans[1] = count(fP, bS, n);
    ans[2] = count(fH, bP, n);
    ans[3] = count(fH, bS, n);
    ans[4] = count(fS, bP, n);
    ans[5] = count(fS, bH, n);

    for(int i = 0; i < 6; i++) {
      System.out.println(ans[i]);
    }

    Arrays.sort(ans);

    output.println(ans[5]);
    output.close();
  }

  static int count(int[] fwd, int[] back, int n) {
    int max = 0;
    for(int i = 1; i < n; i++) {
      if(fwd[i] + back[n - i - 1] > max) max = fwd[i] + back[n - i - 1];
    }

    return max;

  }
}
