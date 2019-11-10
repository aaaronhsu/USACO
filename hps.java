import java.util.*;
import java.io.*;

public class hps {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("hps.in"));
    PrintWriter output = new PrintWriter(new File("hps.out"));

    // Start code here

    int numRounds = input.nextInt();

    int[][] rounds = new int[numRounds][2];
    int[] wins = new int[6];

    for(int i = 0; i < numRounds; i++) {
      rounds[i][0] = input.nextInt();
      rounds[i][1] = input.nextInt();
    }

    // 1 = rock 2 = paper 3 = scissors

    for(int i = 0; i < rounds.length; i++) {
      if((rounds[i][0] == 2 && rounds[i][1] == 1) || (rounds[i][0] == 3 && rounds[i][1] == 2) || (rounds[i][0] == 1 && rounds[i][1] == 3)) {
        wins[0]++;
      }
    }

    // 1 = rock 2 = scissors 3 = paper

    for(int i = 0; i < rounds.length; i++) {
      if((rounds[i][0] == 1 && rounds[i][1] == 2) || (rounds[i][0] == 3 && rounds[i][1] == 1) || (rounds[i][0] == 2 && rounds[i][1] == 3)) {
        wins[1]++;
      }
    }

    // 1 = paper 2 = scissors 3 = rock

    for(int i = 0; i < rounds.length; i++) {
      if((rounds[i][0] == 1 && rounds[i][1] == 3) || (rounds[i][0] == 3 && rounds[i][1] == 2) || (rounds[i][0] == 2 && rounds[i][1] == 1)) {
        wins[2]++;
      }
    }

    // 1 = paper 2 = rock 3 = scissors
    for(int i = 0; i < rounds.length; i++) {
      if((rounds[i][0] == 3 && rounds[i][1] == 1) || (rounds[i][0] == 1 && rounds[i][1] == 2) || (rounds[i][0] == 2 && rounds[i][1] == 3)) {
        wins[3]++;
      }
    }

    // 1 = scissors 2 = rock 3 = paper

    for(int i = 0; i < rounds.length; i++) {
      if((rounds[i][0] == 2 && rounds[i][1] == 1) || (rounds[i][0] == 1 && rounds[i][1] == 3) || (rounds[i][0] == 3 && rounds[i][1] == 2)) {
        wins[4]++;
      }
    }

    // 1 = scissors 2 = paper 3 = rock

    for(int i = 0; i < rounds.length; i++) {
      if((rounds[i][0] == 1 && rounds[i][1] == 2) || (rounds[i][0] == 3 && rounds[i][1] == 1) || (rounds[i][0] == 2 && rounds[i][1] == 3)) {
        wins[5]++;
      }
    }

    Arrays.sort(wins);

    output.write(Integer.toString(wins[5]));
    output.close();

  }
}
