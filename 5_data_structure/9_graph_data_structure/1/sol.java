public class GraphTraversal {

    public List<String> travBFS(Map<String, List<Integer>> graph, String start, List<String> vertices) {
        Map<String, Boolean> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        List<String> output = new ArrayList<>();
        
        queue.add(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            output.add(current);

            int currentIndex = vertices.indexOf(current);
            List<Integer> neighbours = graph.get(vertices.get(currentIndex));

            for (int i = 0; i < neighbours.size(); i++) {
                if (neighbours.get(i) == 1 && !visited.containsKey(vertices.get(i))) {
                    queue.add(vertices.get(i));
                    visited.put(vertices.get(i), true);
                }
            }
        }

        return output;
    }
}
