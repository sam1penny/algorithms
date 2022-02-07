package utils;

public class Tree implements Comparable<Tree> {
    private String symbol;
    private int freq;
    private Tree left;
    private Tree right;
    public Tree(String symb, int f) {
        symbol = symb;
        freq = f;
        left = null;
        right = null;
    }

    public Tree(int f, Tree l, Tree r) {
        freq = f;
        left = l;
        right = r;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getFreq() {
        return freq;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    @Override
    public int compareTo(Tree o) {
        return o == null ? 1 : freq - o.freq;
    }

    @Override
    public String toString() {
        return symbol + "|" + freq;
    }

}
