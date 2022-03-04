package greedy;

import utils.MinHeap;
import utils.Tree;
import utils.TreePrinter;
import utils.WordFreqPair;

import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanEncoding {
    public static void main(String[] args) {
        String[] symbols = new String[]{"a", "b", "c", "d", "e", "f"};
        int[] freqs = new int[]{20, 3, 6, 7, 8 , 56};
        ArrayList<WordFreqPair> a = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++) {
            a.add(new WordFreqPair(symbols[i], freqs[i]));
        }
        Tree<WordFreqPair> t = makeHuffmanTree(a);
        TreePrinter.print(t);
        System.out.println(treeToCodes(t));
    }

    public static Tree<WordFreqPair> makeHuffmanTree(ArrayList<WordFreqPair> alphabet) {
        MinHeap<Tree<WordFreqPair>> heap = new MinHeap<>();
        Tree<WordFreqPair> tmp;
        for (WordFreqPair p: alphabet) {
            tmp = new Tree<>(p);
            heap.insert(tmp);
        }

        Tree<WordFreqPair> t1;
        Tree<WordFreqPair> t2;
        Tree<WordFreqPair> t3;

        while (heap.length() >= 2) {
            t1 = heap.popMin();
            t2 = heap.popMin();
            t3 = new Tree<>(new WordFreqPair(t1.getValue().getFreq() + t2.getValue().getFreq()), t1, t2);
            heap.insert(t3);
        }

        return heap.popMin();
    }

    public static HashMap<String, String> treeToCodes(Tree t) {
        HashMap<String, String> h = new HashMap<>();
        traverse(t, h, "");
        return h;
    }

    private static void traverse(Tree<WordFreqPair> t, HashMap<String, String> h, String s) {
        if (t.getValue().getWord() == null) {
            traverse(t.getLeft(), h, s + "0");
            traverse(t.getRight(), h, s + "1");
        }
        else {
            h.put(t.getValue().getWord(), s);
        }
    }
}
