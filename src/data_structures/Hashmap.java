package data_structures;

import java.util.Arrays;

public class Hashmap<K, V> {

    private final KeyValuePair<K, V> nil = new KeyValuePair<>();
    private int capacity;
    private int size;
    private KeyValuePair<K, V>[] array;

    Hashmap() {
        capacity = 5;
        array = (KeyValuePair<K, V>[]) new KeyValuePair[capacity];
    }

    Hashmap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        array = (KeyValuePair<K, V>[]) new KeyValuePair[capacity];
    }


    private int linearProbe(K key, int j) {
        return (((Math.abs(key.hashCode()) + j) % capacity) + capacity) % capacity;
    }

    private int quadraticProbe(K key, int j) {
        return (((Math.abs(key.hashCode()) + j + j*j) % capacity) + capacity) % capacity;
    }


    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        int index;
        KeyValuePair<K, V> cur;
        for (int i = 0; i < capacity; i++) {
            index = quadraticProbe(key, i);
            cur = array[index];
            if (cur == null) {
                return null;
            } else if (cur.getKey() == key) {
                return cur.getValue();
            }
        }
        return null;
    }

    public void set(K key, V value) {
        System.out.println(size);
        if (size > 0.75 * capacity) {
            resize();
        }
        setWithArray(new KeyValuePair<>(key, value), array);
    }

    private void setWithArray(KeyValuePair<K, V> kv, KeyValuePair<K, V>[] arr) {
        int index;
        KeyValuePair<K, V> cur;
        for (int i = 0; i < capacity; i++) {
            index = quadraticProbe(kv.getKey(), i);
            cur = arr[index];
            if (cur == null || cur == nil) {
                arr[index] = kv;
                size += 1;
                return;
            } else if (cur.getKey() == kv.getKey()) {
                cur.setValue(kv.getValue());
            }
        }
    }

    public void delete(K key) {
        int index;
        KeyValuePair<K, V> cur;
        for (int i = 0; i < capacity; i++) {
            index = quadraticProbe(key, i);
            cur = array[index];
            if (cur == null) {
                return;
            } else if (cur.getKey() == key) {
                array[index] = nil;
                size -= 1;
            }
        }
    }

    private void resize() {
        capacity *= 2;
        size = 0;
        KeyValuePair<K, V>[] newarr = (KeyValuePair<K, V>[]) new KeyValuePair[capacity];
        for (KeyValuePair<K, V> kv : array) {
            if (kv != null && kv != nil) {
                setWithArray(kv, newarr);
            }
        }
        this.array = newarr;

    }

    @Override
    public String toString() {
        return "Hashmap{" +
                "capacity=" + capacity +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        Hashmap<String, Integer> h = new Hashmap<>();
        h.set("Kofi", 1);
        h.set("Sam", 2);
        System.out.println(h);
        h.set("kofi5", 8);
        System.out.println(h);
        h.set("Toria", 9);
        h.set("Alex", 10);
        h.set("Lizzie", 11);
        System.out.println(h);
        System.out.println(h.get("kofi5"));
    }
}
