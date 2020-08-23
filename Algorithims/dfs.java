import java.util.LinkedList;

public class dfs {
	public static void main(String[] args) {
		int[][] arr = {{0, 0, 1, 1, 0},
						{0, 1, 0, 0, 0},
						{1, 1, 1, 1, 1},
						{0, 0, 0, 0, 1},
						{1, 0, 1, 0, 1}};


		// dfs using Linked Lists (each index represents a node connected to other nodes, values array represents values of each index in linkedlist array)
		int N= 10;
		LinkedList[] graph = new LinkedList[N];
		int [] values = new int [N];
		for(int i = 0; i < N; i++) graph[i] = new LinkedList<Integer>();

		values[0] = 1; // Node 0 has a value of 1
		graph[0].add(1); // Node 0 -> Node 1
		graph[1].add(0); // Node 1 -> Node 0


		// dfs using Node class, each node is represented by an index in a list of nodes
		Node[] graph2 = new Node[N];
		for(int i =0; i < N;i++) graph2[i] = new Node(i); // creation of nodes with their values set to their indexes
		graph2[0].neighbors.add(graph2[1]); // Node 0 -> Node 1

	}

	// n^2 (counts the number of nodes that are connected to each other; connected components)
	static int dfs(LinkedList<Integer>[] graph, boolean [] visited, int start){
		if (visited[start]) return 0;
		int count = 1;
		for(int neighbor : graph[start]){
			count+=dfs(graph,visited,start);
		}
		return count;
	}

	// n ^2 (counts the number of spaces that is equal to the target and next to it)
	static int floodfill(int[][] arr, boolean[][] searched, int x, int y, int target) {
		if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || searched[x][y] || arr[x][y] != target) return 0;

		searched[x][y] = true;
		

		return 1 + 
			floodfill(arr, searched, x + 1, y, target) +	
			floodfill(arr, searched, x - 1, y, target) + 
			floodfill(arr, searched, x, y + 1, target) +
			floodfill(arr, searched, x, y - 1, target);
	}

	static class Node {
		int value;
		LinkedList<Node> neighbors = new LinkedList<>();

		Node(int a) {
			value = a;
		}
	}
}