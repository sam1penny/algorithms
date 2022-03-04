package utils;

public class WordFreqPair implements Comparable<WordFreqPair>{
    private String word;
    private int freq;

    public WordFreqPair(String w, int f) {
        word = w;
        freq = f;
    }

    public WordFreqPair(int f) {
        freq = f;
    }

    public String getWord(){ return word; }
    public int getFreq(){ return freq; }

    @Override
    public int compareTo(WordFreqPair o) {
        return freq - o.getFreq();
    }

    @Override
    public String toString() {
        return word + "|" + freq;
    }
}
