import java.util.*;
import java.io.*;

public class testing {
  public static void main(String[] args) throws FileNotFoundException {

    LinkedList<Integer> asdf = new LinkedList<>();

    asdf.add(1);
    asdf.add(2);
    asdf.add(3);
    asdf.add(4);
    asdf.add(5);
    asdf.add(6);

    asdf.add(1, 5);
    System.out.println(asdf.get(1));
  }
}
