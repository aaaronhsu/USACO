import java.util.*;
import java.io.*;

public class ConcertTickets {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception {
		in.nextToken();
		return (String) in.sval;
	}
	
	static long nextLong() throws Exception {
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		TreeSet<Integer> tickets = new TreeSet<>();
		
		int n = in.nextInt();
		int m = in.nextInt();

		for (int i = 0; i < n; i++) {
			tickets.add(in.nextInt());
		}

		for (int i = 0; i < m; i++) {
			String ticket = "" + tickets.lower(in.nextInt() + 1);

			if (!ticket.equals("null")) {
				tickets.remove(Integer.parseInt(ticket));
				System.out.println(ticket);
			}
			else {
				System.out.println(-1);
			}
		}
	}
}