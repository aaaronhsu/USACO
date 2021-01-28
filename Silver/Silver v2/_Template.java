import java.util.*;
import java.io.*;

public class _Template {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("_Template.in")));
		PrintWriter out = new PrintWriter(new File("_Template.out"));
	}
}