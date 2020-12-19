/*
ID: pufflew1
LANG: JAVA
TASK: milk2
*/

import java.util.*;
import java.io.*;

public class milk2 {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("milk2.in")));
		PrintWriter out = new PrintWriter(new File("milk2.out"));

		int n = nextInt();

		int[] times = new int[1000000];
		for (int i = 0; i < n; i++) {
			int a = nextInt();
			int b = nextInt();
			
			for (int start = a; start < b; start++) {
				times[start]++;
			}
		}

		int curM = 0;
		int curNM = 0;
		int m = 0;
		int nm = 0;
		boolean init = false;

		for (int i = 0; i < times.length; i++) {
			if (times[i] > 0) {
				init = true;
				if (nm > curNM) {
					curNM = nm;
				}
				nm = 0;
				m++;
			}
			else if (init) {
				if (m > curM) {
					curM = m;
				}
				m = 0;
				nm++;
			}
		}

		out.println(curM + " " + curNM);
		out.close();
	}
}