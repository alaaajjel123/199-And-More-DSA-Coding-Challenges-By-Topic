public class CourseScheduler {

    public List<int[]> helper(int n, int[][] prerecs) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerec : prerecs) {
            int toTake = prerec[0];
            int firstTake = prerec[1];
            adjList.get(firstTake).add(toTake);
            inDegree[toTake]++;
        }
        
        List<int[]> result = new ArrayList<>();
        result.add(adjList);
        result.add(inDegree);
        return result;
    }

    public boolean checkIfCanFinish(int n, int[][] prerecs) {
        List<int[]> result = helper(n, prerecs);
        List<List<Integer>> adjList = (List<List<Integer>>) result.get(0);
        int[] inDegree = (int[]) result.get(1);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        
        int count = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            count++;
            List<Integer> neighbours = adjList.get(current);
            for (int neighbour : neighbours) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    stack.push(neighbour);
                }
            }
        }
        
        return count == n;
    }

    public static void main(String[] args) {
        CourseScheduler cs = new CourseScheduler();
        int n = 4;
        int[][] prerecs = {{1,0}, {2,1}, {3,2}};
        System.out.println(cs.checkIfCanFinish(n, prerecs));
    }
}