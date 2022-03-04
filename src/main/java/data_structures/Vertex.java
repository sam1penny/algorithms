package data_structures;

import java.util.ArrayList;

public class Vertex<T> {
    private T label;
    private ArrayList<Edge<T>> edges;
    public Vertex(T t) {
        label = t;
        edges = new ArrayList<Edge<T>>();
    }

    public T getLabel() {
        return label;
    }

    public void addEdge(Edge<T> e) {
        edges.add(e);
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }
}
