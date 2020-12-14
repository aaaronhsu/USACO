import java.util.*;
import java.io.*;

public class Restuarant {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		Value[] value = new Value[n * 2];
		for (int i = 0; i < n; i++) {
			value[i * 2] = new Value(in.nextInt(), 1);
			value[i * 2 + 1] = new Value(in.nextInt(), -1);
		}

		Arrays.sort(value);

		int ans = 0;
		int sum = 0;

		for (int i = 0; i < n * 2; i++) {
			sum += value[i].v;
			ans = Integer.max(sum, ans);
		}

		System.out.println(ans);

	}

	static class Value implements Comparable<Value> {
		int i, v;

		Value(int a, int b) {
			i = a;
			v = b;
		}

		public int compareTo(Value other) {
			return Integer.compare(this.i, other.i);
		}
	}
}