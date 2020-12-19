/*
ID: pufflew1
LANG: JAVA
TASK: palsquare
*/

import java.util.*;
import java.io.*;

public class palsquare {
	static StreamTokenizer in;

	static char symbols[] = new char[] { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("palsquare.in")));
		PrintWriter out = new PrintWriter(new File("palsquare.out"));

		int base = nextInt();

		for (int i = 1; i <= 300; i++) {
			if (pal(convert(i * i, base))) {
				out.println(convert(i, base) + " " + convert(i * i, base));
			}
		}
		out.close();
	}

	static String convert ( int number, int base )
    {
        return convert(number, base, 0, "" );
    }

    static String convert ( int number, int base, int position, String result )
    {
        if ( number < Math.pow(base, position + 1) )
        {
            return symbols[(number / (int)Math.pow(base, position))] + result;
        }
        else
        {
            int remainder = (number % (int)Math.pow(base, position + 1));
            return convert (  number - remainder, base, position + 1, symbols[remainder / (int)( Math.pow(base, position) )] + result );
        }
    }

	static boolean pal(String n) {
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) != n.charAt(n.length() - 1 - i)) return false;
		}

		return true;
	}
}