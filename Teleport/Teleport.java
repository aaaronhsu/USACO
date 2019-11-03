// http://www.usaco.org/index.php?page=viewproblem2&cpid=807
import java.util.*;
import java.io.*;
import java.lang.Math;

public class Teleport {
  public static void main(String[] args) {

    try {
      Scanner sc = new Scanner(new File("teleport.in"));

      int[] positions = new int[4];

      for(int i = 0; sc.hasNext(); i++) {
        positions[i] = sc.nextInt();
      }


      int choice1 = Math.abs(positions[0] - positions[2]) + Math.abs(positions[1] - positions[3]);
      int choice2 = Math.abs(positions[0] - positions[3]) + Math.abs(positions[1] - positions[2]);

      int noTp = Math.abs(positions[1] - positions[0]);

      int[] thingies = {choice1, choice2, noTp};
      Arrays.sort(thingies);

      writeUsingFileWriter(Integer.toString(thingies[0]));
    }
    catch(FileNotFoundException fnfe) {
     fnfe.printStackTrace();
    }
  }

  private static void writeUsingFileWriter(String data) {
        File file = new File("teleport.out");
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
