package graph_algorithms;

import data_structures.Edge;
import data_structures.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");

        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("a", "c");
        graph.addEdge("c", "d");

        List<String> x = bfs(graph, "a", "d");

        System.out.println(x);


    }

    public static <T> List<T> bfs(Graph<T> graph, T start, T end) {
        Set<T> seen = new HashSet<>();
        HashMap<T, T> comeFrom = new HashMap<>();
        seen.add(start);
        Queue<T> toExplore = new LinkedList<T>();
        toExplore.add(start);

        T label;
        T neighbourLabel;
        while (!toExplore.isEmpty()) {
            label = toExplore.poll();
            for (Edge<T> edge: graph.getEdges(label)) {
                neighbourLabel = edge.getVertex().getLabel();
                if (!seen.contains(neighbourLabel)) {
                    toExplore.offer(neighbourLabel);
                    seen.add(neighbourLabel);
                    comeFrom.put(neighbourLabel, label);
                }
            }
        }

        if (!comeFrom.containsKey(end)) {
            return null;
        }

        LinkedList<T> path = new LinkedList<>();
        path.add(end);
        while (comeFrom.containsKey(path.getFirst())) {
            path.addFirst(comeFrom.get(path.getFirst()));
        }
        return path;
    }
}
