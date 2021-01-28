import java.io.File;
import java.util.*;

public class Apartment {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("testing.in"));
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		int[] people = new int[n];
		int[] rooms = new int[m];
		boolean[] taken = new boolean[m];


		for (int i = 0; i < n; i++) {
			people[i] = in.nextInt();
		}

		for (int i = 0; i < m; i++) {
			rooms[i] = in.nextInt();
		}

		Arrays.sort(people);
		Arrays.sort(rooms);

		int ans = 0;
		int room = 0;

		for (int i = 0; i < n; i++) {
			room = 0;
			boolean found = false;

			while (true) {

				if (!taken[room] && Math.abs(people[i] - rooms[room]) <= k) {
					found = true;
					break;
				}

				if (rooms[room] > people[i] + k) break;
				
				room++;

				if (room == m) break;
			}

			if (found) {
				ans++;
				taken[room] = true;
			}
			
		}

		System.out.println(ans);
	}
}
