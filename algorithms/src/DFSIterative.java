import java.util.*;

public class DFSIterative {
    private final Map<Integer, List<Integer>> adjList;

    public DFSIterative() {
        this.adjList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(destination);
    }

    public List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);

                // Push all unvisited neighbors to the stack
                List<Integer> neighbors = adjList.get(node);
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DFSIterative graph = new DFSIterative();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        List<Integer> dfsResult = graph.dfs(1);
        System.out.println("DFS Traversal starting from node 1: " + dfsResult);
    }
}
