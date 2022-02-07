package greedy;

import utils.MinHeap;
import utils.Pair;
import utils.Tree;
import utils.TreePrinter;

import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanEncoding {
    public static void main(String[] args) {
        String[] symbols = new String[]{"a", "b", "c", "d", "e", "f"};
        int[] freqs = new int[]{20, 3, 6, 7, 8 , 56};
        ArrayList<Pair<String, Integer>> a = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++) {
            a.add(new Pair<>(symbols[i], freqs[i]));
        }
        Tree t = makeHuffmanTree(a);
        TreePrinter.print(t);
        System.out.println(treeToCodes(t));
    }

    public static Tree makeHuffmanTree(ArrayList<Pair<String, Integer>> alphabet) {
        MinHeap<Tree> heap = new MinHeap();
        Tree tmp;
        for (Pair<String, Integer> p: alphabet) {
            tmp = new Tree(p.getFirst(), p.getSecond());
            heap.insert(tmp);
        }

        Tree t1;
        Tree t2;
        Tree t3;

        while (heap.length() >= 2) {
            t1 = heap.popMin();
            t2 = heap.popMin();
            t3 = new Tree(t1.getFreq() + t2.getFreq(), t1, t2);
            heap.insert(t3);
        }

        return heap.popMin();
    }

    public static HashMap<String, String> treeToCodes(Tree t) {
        HashMap<String, String> h = new HashMap<>();
        traverse(t, h, "");
        return h;
    }

    private static void traverse(Tree t, HashMap<String, String> h, String s) {
        if (t.getSymbol() == null) {
            traverse(t.getLeft(), h, s + "0");
            traverse(t.getRight(), h, s + "1");
        }
        else {
            h.put(t.getSymbol(), s);
        }
    }
}
