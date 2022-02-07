package utils;

public class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(F f, S s) {
        first = f;
        second = s;
    }

    public F getFirst(){ return first; }
    public S getSecond(){ return second; }
}
