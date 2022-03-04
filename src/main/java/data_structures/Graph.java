package data_structures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, Vertex<T>> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(T label) {
        vertices.put(label, new Vertex<>(label));
    }

    public Vertex<T> getVertex(T label) {
        return vertices.get(label);
    }

    public void addEdge(T l1, T l2) {
        Vertex<T> v1 = vertices.get(l1);
        Vertex<T> v2 = vertices.get(l2);
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException();
        }
        v1.addEdge(new Edge<>(v2));
    }

    public void addBidirectionalEdge(T l1, T l2) {
        addEdge(l1, l2);
        addEdge(l2, l1);
    }

    public List<Edge<T>> getEdges(T label) {
        return vertices.get(label).getEdges();
    }



}
