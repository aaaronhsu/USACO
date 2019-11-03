// http://www.usaco.org/index.php?page=viewproblem2&cpid=808
import java.util.*;
import java.io.*;

public class Hoofball {
  public static void main(String[] args) {

    Scanner inp = new Scanner(System.in);

    String fileName = inp.nextLine();

    try {
      Scanner sc = new Scanner(new File(fileName));
      int numOfCows = sc.nextInt();

      int[] cows = new int[numOfCows];
      for(int i = 0; sc.hasNext(); i++) {
        cows[i] = sc.nextInt();
      }
      sc.close();

      // end of file reading

      // sort array
      Arrays.sort(cows);

      for(int i = 0; i < cows.length; i++) {
        System.out.println(cows[i]);
      }

      int numBalls = 1;
      int cowNumber = 2 - 1;
      int bCowNumber = 0 + 1;
      boolean left = true;

      // keeps checking unti
      while(cowNumber <= cows.length - 2) {

        if(cowNumber <= bCowNumber) {
          if(left) {
            if(cows[cowNumber] - cows[cowNumber - 1] <= cows[cowNumber + 1] - cows[cowNumber]) {
              numBalls++;
              cowNumber++;
              System.out.println("Skipping because the difference between cow " + cowNumber + " and " + (cowNumber - 1) + " is less than or equal to " + (cowNumber + 1) + " and " + cowNumber);
              left = false;
            }
          }
          else {
            if(cows[cows.length - bCowNumber] - cows[cows.length - bCowNumber - 1] >= cows[cows.length - bCowNumber + 1] - cows[cows.length - bCowNumber]) {
              numBalls++;
              cowNumber++;
              left = true;
            }
          }
        }
        cowNumber++;
      }

      output(Integer.toString(numBalls));
    }
    catch(FileNotFoundException fnfe) {
      System.out.println("file 'hoofball.in' cannot be found");
      System.exit(1);
    }
  }

  private static void output(String data) {
        File file = new File("hoofball.out");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
