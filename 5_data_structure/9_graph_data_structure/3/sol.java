public class GraphComponents {

    public List<List<Integer>> buildAdjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        return adjList;
    }

    public void dfs(List<List<Integer>> graph, int vertex, Set<Integer> visited) {
        visited.add(vertex);
        List<Integer> neighbors = graph.get(vertex);

        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = buildAdjList(n, edges);
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited.contains(vertex)) {
                count++;
                dfs(graph, vertex, visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        GraphComponents gc = new GraphComponents();
        int n = 7; 
        int[][] edges = { {0, 1}, {1, 2}, {3, 4}, {5, 6} };
        System.out.println(gc.countComponents(n, edges));
    }
}