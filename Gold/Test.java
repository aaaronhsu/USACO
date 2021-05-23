import java.util.*;
import java.io.*;

public class Test {
  public static void main(String[] args) {
    ArrayList<int[]> hold = new ArrayList<>();

    hold.add(new int[] {1, 2, 3});
    hold.add(new int[] {2, 2, 3});
    hold.add(new int[] {4, 2, 3});
    hold.add(new int[] {5, 2, 3});
    hold.add(new int[] {3, 2, 3});

    Collections.sort(hold);
    for (int[] i : hold) System.out.println(i[0]);
  }  
}
