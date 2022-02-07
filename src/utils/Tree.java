package utils;

public class Tree<T extends Comparable<T>> implements Comparable<Tree<T>> {
    private T value;
    private Tree<T> left;
    private Tree<T> right;
    public Tree(T v) {
        value = v;
        left = null;
        right = null;
    }

    public Tree(T v, Tree<T> l, Tree<T> r) {
        value = v;
        left = l;
        right = r;
    }

    public T getValue(){return value;}

    public Tree<T> getLeft() {
        return left;
    }

    public Tree<T> getRight() {
        return right;
    }

    @Override
    public int compareTo(Tree o) {
        return o == null ? 1 : value.compareTo((T) o.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
