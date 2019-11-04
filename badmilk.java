import java.util.*;
import java.io.*;

// COMPLETE 10/10

public class badmilk {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("badmilk.in"));
    PrintWriter output = new PrintWriter(new File("badmilk.out"));

    int friend = input.nextInt();
    int milk = input.nextInt();
    int drank = input.nextInt();
    int sick = input.nextInt();

    int[][] sickLog = new int[drank][3];
    int[][] peopleSick = new int[sick][2];

    for(int i = 0; i < drank; i++) {
      for(int a = 0; a < 3; a++) {
        sickLog[i][a] = input.nextInt();
      }
    }

    for(int i = 0; i < sick; i++) {
      for(int a = 0; a < 2; a++) {
        peopleSick[i][a] = input.nextInt();
      }
    }

    int[][] contaminated = new int[sick][milk];
    int timeSick = -1;
    int personSick = -1;
    int milkNumber = 0;

    for(int i = 0; i < sick; i++) {
      personSick = peopleSick[i][0];
      timeSick = peopleSick[i][1];

      for(int a = 0; a < drank; a++) {
        if(sickLog[a][0] == personSick && sickLog[a][2] < timeSick) {
          contaminated[i][milkNumber] = sickLog[a][1];
          milkNumber++;
        }
      }
      milkNumber = 0;

    }


    Set<Integer> badMilks = new HashSet<>();

    for(int i = 0; i < contaminated[0].length; i++) {
      badMilks.add(contaminated[0][i]);
    }

    Set<Integer> holder = new HashSet<>();

    for(int i = 0; i < contaminated.length; i++)
      for(int a = 0; a < contaminated[i].length; a++) {
        holder.add(contaminated[i][a]);
      }
      badMilks.retainAll(holder);
      holder.clear();
    }

    Object[] die = badMilks.toArray();


    int highest = 0;
    int sum = 0;

    Set<Integer> checked = new HashSet<>();

    for(int i = 0; i < die.length; i++) {
      for(int a = 0; a < drank; a++) {
        if((sickLog[a][1] == (int)die[i]) && !checked.contains(sickLog[a][0])) {
          sum++;
          checked.add(sickLog[a][0]);
        }
      }

      if(sum > highest) {
        highest = sum;
      }
      sum = 0;
    }

    output.write(Integer.toString(highest));
    output.close();
  }

}
