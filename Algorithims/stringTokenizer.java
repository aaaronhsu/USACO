import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class stringTokenizer {
	static StreamTokenizer in;
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}
	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}
	static long nextLong() throws Exception{
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("input.in")));
		PrintWriter out = new PrintWriter(new File("output.out"));
		String N = next();
		System.out.println(N);
	}
}