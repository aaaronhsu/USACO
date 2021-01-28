import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class testing {
	public static void main(String[] args) {
		
		System.out.println(wordAppend(new String[] {"a", "b", "b", "b", "a", "c", "a", "a", "a", "b", "a"}));
	}

	static String wordAppend(String[] strings) {
		HashMap<String, Integer> asdf = new HashMap<>();
		
		String holder = "";
		for (int i = 0; i < strings.length; i++) {
		  if (asdf.keySet().contains(strings[i])) {
			asdf.put(strings[i], asdf.get(strings[i]) + 1);
			
			if (asdf.get(strings[i]) % 2 == 0) {
			  holder += strings[i];
			}
		  }
		  else {
			asdf.put(strings[i], 0);
		  }
		}
		
		return holder;
	  }
	  
}