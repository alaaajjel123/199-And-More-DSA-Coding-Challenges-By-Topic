import java.util.*;

public class GraphTraversal {

    public List<String> travDFSIterative(Map<String, List<String>> graph, String start) {
        List<String> output = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        
        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            output.add(current);
            
            List<String> neighbours = graph.get(current);
            for (String neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        
        return output;
    }
}
