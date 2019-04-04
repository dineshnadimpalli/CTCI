import java.util.*;

class GraphPathBtwNodes {
    public int vertices;
    public LinkedList<Integer> adj[];

    GraphPathBtwNodes(int v) {
        vertices = v;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addNode(int v, int i) {
        adj[v].add(i);
    }
    
    boolean isPath(int s, int d) {
        LinkedList<Integer> queue = new LinkedList<>();

        boolean visited[] = new boolean[vertices];

        visited[s] = true;
        queue.add(s);
        Iterator<Integer> l;
        while (queue.size() != 0) {
            int i = queue.poll();
            l = adj[i].listIterator();
            while (l.hasNext()) {
                int n = l.next();
                if (n == d) {
                    return true;
                }
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    public static void main(String[] arg) {
        GraphPathBtwNodes g = new GraphPathBtwNodes(4);
        g.addNode(0, 1);
        g.addNode(0, 2);
        g.addNode(1, 2);
        g.addNode(2, 0);
        g.addNode(2, 3);
        g.addNode(3, 3);

        int s = 3, d = 0;
        if (g.isPath(s, d)) {
            System.out.println("There exists a path between " + s + " and " + d);
        }
        else {
            System.out.println("There exists no path between " + s + " and " + d);
        }
    }
}