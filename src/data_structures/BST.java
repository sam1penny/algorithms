package data_structures;

import utils.TreePrinter;

import java.util.LinkedList;

public class BST<K extends Comparable<K>, V>{
    public Node<K, V> head;

    public Node<K, V> getRoot() {
        return head;
    }

    public boolean hasKey(K k) {
        return recursiveHasKey(head, k);
    }

    private boolean recursiveHasKey(Node<K, V> cur, K k) {
        if (cur == null) {
            return false;
        }
        return cur.key == k || recursiveHasKey(cur.left, k) || recursiveHasKey(cur.right, k);
    }

    public V search(K k) {
        Node<K, V> result = searchForNode(k);
        if (result == null) {
            return null; //throw error?
        }
        return result.value;
    }

    private Node<K, V> searchForNode(K k) {
        Node<K, V> cur = head;
        while (cur != null) {
            if (cur.key.compareTo(k) == 0) {
                return cur;
            }
            else if (cur.key.compareTo(k) > 0) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        return null;
    }

    //returns node with smallest key
    public Node<K, V> min() {
        return minSubtree(head);
    }

    private Node<K, V> minSubtree(Node<K, V> cur) {
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public Node<K, V> max() {
        return maxSubtree(head);
    }

    private Node<K, V> maxSubtree(Node<K, V> cur) {
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }


    public void insert(Node<K, V> n) {
        assert n != null;
        if (head == null) {
            head = n;
        }
        Node<K, V> prev = null;
        Node<K, V> cur = head;
        while (cur != null) {
            prev = cur;
            if (cur.key.compareTo(n.key) == 0) {
                cur.value = n.value;
                return;
            }
            else if (cur.key.compareTo(n.key) > 0) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        if (prev.key.compareTo(n.key) > 0) {
            prev.left = n;
        }
        else {
            prev.right = n;
        }
    }

    public Node<K, V> successor(K k){
        return findSuccessor(head, null, k);
    }

    private Node<K, V> findSuccessor(Node<K, V> root, Node<K, V> succ, K k) {
        if (root == null) {
            return succ;
        }
        if (root.key == k) {
            if (root.right != null) {
                return minSubtree(root.right);
            }
            else {
                return succ;
            }
        }
        else if (k.compareTo(root.key) < 0) {
            succ = root;
            return findSuccessor(root.left, succ, k);
        }
        else {
            return findSuccessor(root.right, succ, k);
        }
    }

    public Node<K, V> predecessor(K k){
        return findPredecessor(head, null, k);
    }

    private Node<K,V> findPredecessor(Node<K, V> root, Node<K, V> pred, K k) {
        if (root == null) {
            return pred;
        }
        if (root.key == k) {
            if (root.left != null) {
                return maxSubtree(root.left);
            }
            else {
                return pred;
            }
        }
        else if (k.compareTo(root.key) < 0) {
            return findPredecessor(root.left, pred, k);
        }
        else {
            pred = root;
            return findPredecessor(root.right, pred, k);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void delete(K k){ head = deleteRec(head, k);}

    private Node<K, V> deleteRec(Node<K, V> root, K k) {
        if (root == null) {
            return root;
        }
        if (k.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, k);
        }
        else if (k.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, k);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            Node<K, V> newRoot = root.right;
            Node<K, V> parent = null;
            // find successor and parent of successor
            while(newRoot.left != null){
                parent = newRoot;
                newRoot = newRoot.left;
            }
            // if successor is the right child of the node to delete
            if(parent == null){
                newRoot.left = root.left;
                return newRoot;
            }
            // otherwise set the left of the parent to the right of the root and then swap the successor and the root
            parent.left = newRoot.right;
            newRoot.left = root.left;
            newRoot.right = root.right;
            return newRoot;

        }
        return root;


    }

    public static void main(String[] args) {
        BST<Integer, Integer> t = new BST<>();
        t.insert(new Node<>(5, 3));
        t.insert(new Node<>(2, 3));
        t.insert(new Node<>(9, 6));
        t.insert(new Node<>(10, 6));
        t.insert(new Node<>(7, 6));
        t.insert(new Node<>(8, 6));


        System.out.println("Max " + t.max());
        System.out.println("Min " + t.min());

        TreePrinter.print(t.getRoot());
        LinkedList<Integer> keys = new LinkedList<>();
        keys.add(5);
        keys.add(3);
        keys.add(4);
        keys.add(7);
        for (int k: keys) {
            System.out.println("Successor of " + k + " = " + t.successor(k));
            System.out.println("Predecessor of " + k + " = " + t.predecessor(k));
            System.out.println("Value associated with key " + k + " = " + t.search(k));
            System.out.println(t.search(k));
        }
        TreePrinter.print(t.getRoot());
        t.delete(9);
        TreePrinter.print(t.getRoot());
        t.delete(5);
        TreePrinter.print(t.getRoot());
    }

}
