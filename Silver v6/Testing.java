import java.util.*;
import java.io.*;

public class Testing {
	public static void main(String[] args) {
		LinkedList<Integer> test = new LinkedList<>();

		test.add(1);

		System.out.println(Collections.binarySearch(test, 2));
	}
}
