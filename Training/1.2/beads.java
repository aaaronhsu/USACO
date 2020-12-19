/*
ID: pufflew1
LANG: JAVA
TASK: beads
*/

import java.util.*;
import java.io.*;

public class beads {
	static StreamTokenizer in;
	static String str;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("beads.in")));
		PrintWriter out = new PrintWriter(new File("beads.out"));

		int oqiwroiwqer = nextInt();
		str = next();
		int ans = 0;
		int qwer = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int hold = det(i);
			System.out.println(hold);
			if (hold > ans) {
				ans = hold;
				qwer = i;
			}
		}

		out.println(ans);
		out.close();
	}

	static int det(int start) {
		char fwd = str.charAt(start);
		char bk = str.charAt((start - 1 + str.length()) % str.length());

		System.out.println(fwd + ", " + bk);
		int forward = 0;
		int backward = 0;
		for (int i = 0; i < str.length(); i++) {
      if (fwd == 'w') {
        if ('w' != str.charAt((start + i) % str.length())) {
          fwd = str.charAt((start + i) % str.length());
        }
        forward++;
      }
			else if (str.charAt((start + i) % str.length()) == fwd || 'w' == str.charAt((start + i) % str.length())) {
				forward++;
				// System.out.println(str.charAt(Math.abs((i) % str.length())));
			}
			else break;
		}
		
		for (int i = 1; i < str.length(); i++) {
      if (bk == 'w') {
        if ('w' != str.charAt((start - i + str.length()) % str.length())) {
          bk = str.charAt((start - i + str.length()) % str.length());
        }
        backward++;
      }
			else if (str.charAt((start - i + str.length()) % str.length()) == bk || 'w' == str.charAt((start - i + str.length()) % str.length())) backward++;
			else break;
    }
    
    System.out.println(forward + ", " + backward);

		if (forward + backward > str.length()) {
			return (forward + backward) - ((forward + backward) - str.length());
		}
		else return forward + backward;

	}
}