import java.util.*;
import java.io.*;

public class factory {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("factory.in"));
    PrintWriter output = new PrintWriter(new File("factory.out"));

    // Start code here
    int n = input.nextInt();

    node[] graph = new node[n + 1];

    for(int i = 1; i < n; i++) {
      int node1 = input.nextInt();
      int node2 = input.nextInt();

      if(graph[node1] == null) {
        graph[node1] = new node(node1);
        if(graph[node2] == null) {
          graph[node2] = new node(node2);
        }

        graph[node1].add(graph[node2]);
      }
    }

    int answer = -1;

    for(int i = n; i >= 1; i--) {
      for(int a = 1; a <= n; a++) {
        if(i == a) {
          continue;
        }
        if(!dfs(graph[a], graph[i])) {
          break;
        }
        if(a == n) {
          answer = i;
        }
      }
    }
    output.write(Integer.toString(answer));
    output.close();

  }

  static boolean dfs(node start, node end) {
    if(start == null) {
      return false;
    }

    if(start.data == end.data) {
      return true;
    }
    boolean ret = false;

    for(node x : start.neighbors) {
      return ret = dfs(x , end);
    }

    return ret;
  }

  static class node {
    int data;
    HashSet<node> neighbors = new HashSet<>();

    node(int num) {
      data = num;
      neighbors = new HashSet<node>();
    }

    void add(node a) {
      neighbors.add(a);
    }
  }
}
