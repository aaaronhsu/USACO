/*
ID: pufflew1
LANG: JAVA
TASK: namenum
*/

import java.util.*;

import java.io.*;

public class namenum {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("namenum.in")));
		PrintWriter out = new PrintWriter(new File("namenum.out"));

		long n = nextLong();
		String str = Long.toString(n);

		HashMap<Long, LinkedList<String>> map = new HashMap<>();

		HashMap<Character, String> convert = new HashMap<>();

		convert.put('A', "2");
		convert.put('B', "2");
		convert.put('C', "2");
		convert.put('D', "3");
		convert.put('E', "3");
		convert.put('F', "3");
		convert.put('G', "4");
		convert.put('H', "4");
		convert.put('I', "4");
		convert.put('J', "5");
		convert.put('K', "5");
		convert.put('L', "5");
		convert.put('M', "6");
		convert.put('N', "6");
		convert.put('O', "6");
		convert.put('P', "7");
		convert.put('R', "7");
		convert.put('S', "7");
		convert.put('T', "8");
		convert.put('U', "8");
		convert.put('V', "8");
		convert.put('W', "9");
		convert.put('X', "9");
		convert.put('Y', "9");
		convert.put('Z', "0");
		convert.put('Q', "0");

		in = new StreamTokenizer(new BufferedReader(new FileReader("dict.txt")));
		for (int i = 0; i < 4617; i++) {
			String hold = next();
			String build = "";

			// converts name to string
			for (int a = 0; a < hold.length(); a++) {
				build += convert.get(hold.charAt(a));
			}
			
			Long asdf = Long.valueOf(build);

			// adds name to map
			if (map.get(asdf) == null) {
				LinkedList<String> names = new LinkedList<>();
				names.add(hold);
				map.put(asdf, names);
			}
			else {
				map.get(asdf).add(hold);
			}
		}

		if (map.get(n) == null) {
			out.println("NONE");
		}
		else {
			for (String i : map.get(n)) {
				out.println(i);
			}
		}
		

		out.close();
	}
}