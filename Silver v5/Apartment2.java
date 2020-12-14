import java.io.File;
import java.util.*;

public class Apartment2 {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		int[] people = new int[n];
		LinkedList<Integer> rooms = new LinkedList<>();


		for (int i = 0; i < n; i++) {
			people[i] = in.nextInt();
		}

		for (int i = 0; i < m; i++) {
			rooms.add(in.nextInt());
		}

		Arrays.sort(people);
		Collections.sort(rooms);
		int ans = 0;

		for (int i = 0; i < n; i++) {
			int hold = Collections.binarySearch(rooms, people[i]);

			if (hold < 0) continue;
			
			if (people[i] - k <= rooms.get(hold) && people[i] - k >= rooms.get(hold)) {
				ans++;
				rooms.remove(hold);
			}
			else if (people[i] - k <= rooms.get(hold + 1) && people[i] - k >= rooms.get(hold + 1)) {
				ans++;
				rooms.remove(hold + 1);
			}

		}

		System.out.println(ans);
	}

}
