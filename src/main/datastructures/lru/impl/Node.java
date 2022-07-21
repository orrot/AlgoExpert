package main.datastructures.lru.impl;

public class Node<K, V> {

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    Node<K, V> previous;
    Node<K, V> next;
    K key;
    V value;

    public Node<K, V> getPrevious() {
        return previous;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
