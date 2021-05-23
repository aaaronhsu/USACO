import java.io.StreamTokenizer;

public class Slingshot {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(System.in); // StreamTokenizer reads input faster than Scanner

		// This question boils down to "how many prime factors exist in n, excluding the factor of n if n is a prime number".

		// We can't use n itself because if n is a factor, then 1 is a factor. 
		// We can't use 1 as a factor because there doesn't exist a positive integer z such that (z + 1) == 1 (0 is not positive).
		// We are going for only prime factors because every composite factor can be broken up into prime factors (which maximizes k).

		int n = nextInt();
		int ans = 0;

		// Composite numbers will always be larger than the prime numbers that make them, so it's safe to check [2, n).
		for (int i = 2; i < n; i++) {
			// While i is a factor of n, increment answer and remove the factor of i from n.
			while (n % i == 0) {
				ans++; // we could easily store these factors in a list and take the size, but that would adversely affect runtime so a simple counter is sufficient.
				n /= i;
			}
		}
		
		if (ans != 0 && n != 1) ans++; // if there isn't a factor in [2, n), then the only factors are 1 and n (both of which we don't count). If we already found a factor, then we account for what n is currently (unless n is 1).

		System.out.println(ans);
	}
}