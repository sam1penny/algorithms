package data_structures;

import utils.PrintableNode;

public class Node<K, V> implements PrintableNode {
    public K key;
    public V value;
    public Node<K, V> left;
    public Node<K, V> right;

    Node(K key, V value, Node<K, V> left, Node<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
         return key + "," + value;
    }

    @Override
    public String getText() {
        return toString();
    }

    @Override
    public Node<K, V> getLeft() {
        return left;
    }

    @Override
    public Node<K, V> getRight() {
        return right;
    }
}
