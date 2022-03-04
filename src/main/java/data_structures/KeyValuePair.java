package data_structures;

public class KeyValuePair<K, V>{
    private K key;
    private V value;

    KeyValuePair() {}

    KeyValuePair(K k, V v) {
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (key == null) {
            return "DELETED";
        }
        return key + "|" + value;
    }
}
