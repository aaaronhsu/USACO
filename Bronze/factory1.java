import java.util.*;
import java.io.*;


public class factory1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("factory.in"));
		PrintWriter out = new PrintWriter(new File("factory.out"));
		int N = in.nextInt();
		node [] array = new node [N+1];
		for (int i = 0; i < N-1; i++)
		{
			int node1 = in.nextInt();
			int node2 = in.nextInt();
			if(array[node1]==null)
			{
				array[node1] = new node(node1);
			}
			if(array[node2]==null)
			{
				array[node2] = new node(node2);
			}
			array[node1].add(array[node2]);
		}
		int ans = -1;
		for (int i = N; i >=1; i--)
		{
			for (int j = 1; j <= N; j++)
			{
				if(i==j) continue;
				if(!dfs(array[j], array[i])) break;
				if(j==N) ans = i;
			}
		}

		out.print(ans);
		out.println();
		in.close();
		out.close();
	}
	static boolean dfs(node curr, node target)
	{
		if(curr == null) return false;
		if(curr.data == target.data) return true;
		boolean ret = false;
		for(node x: curr.neighbors) return ret = dfs(x,target);

		return ret;
	}
	static class node
	{
		    int data;
		    Set<node> neighbors;
		    node(int item)
		    {
		        data = item;
		        neighbors = new HashSet<node>();
		    }
		    void add(node n)
		    {
		    	neighbors.add(n);
		    }
	}
}
