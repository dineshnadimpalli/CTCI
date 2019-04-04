import java.util.*;

class Dfs {
    public int vertices;
    public LinkedList<Integer> adj[];

    Dfs(int v) {
        vertices = v;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addNode(int v, int i) {
        adj[v].add(i);
    }

    void findDFS(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> l = adj[s].listIterator();
        while (l.hasNext()) {
            int n = l.next();
            if (!visited[n]) {
                findDFS(n, visited);
            }
        }
    }
    
    void DFS(int a) {
        boolean visited[] = new boolean[vertices];

        findDFS(a, visited);
    }

    public static void main(String[] arg) {
        Dfs g = new Dfs(4);
        g.addNode(0, 1);
        g.addNode(0, 2);
        g.addNode(1, 2);
        g.addNode(2, 0);
        g.addNode(2, 3);
        g.addNode(3, 3);

        g.DFS(2);
    }
}