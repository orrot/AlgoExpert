package main.datastructures.lru.impl;

import main.datastructures.lru.LRUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


// IMPORTANT: We want ALL THE OPERATIONS AS O(1) !!!

public class LRUCacheImpl<K, V> implements LRUCache<K, V> {

    // Double Linked Node
    private static class Node<K, V> {

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        Node<K, V> previous;
        Node<K, V> next;
        K key;
        V value;
    }

    // A map will be used so the read of the catch should be O(1)
    private final Map<K, Node<K, V>> fastReadableMap;

    // A LinkedList will be used because we need a queue to identify the Least Recently Used then it should be removed in case the size is reached
    // What we need to do is to move the last used (read or written) to the head of the list
    // The item in the tail is the Least Recently Used, so it should be removed
    // Head == Most Recently, Tail == Least Recently (and the one that will be removed in case the Cache is full)
    private Node<K, V> head;
    private Node<K, V> tail;

    // In case of concurrency, we can control the access for read and write in our Data Structure
    // TODO Reentracnt Lock Implementation is missing
    // private ReentrantLock reentrantLock = new ReentrantLock();

    // The maximum size of the cache
    private int currentSize = 0;
    // The maximum size of the cache
    private final int maximumSize;

    public LRUCacheImpl(int maximumSize) {
        this.maximumSize = maximumSize;
        this.fastReadableMap = new HashMap<>(maximumSize);
        this.head = null;
        this.tail = null;
    }

    @Override
    public V get(K key) {

        // if the item already exist, just get the item, move in the head of the recently item and remove from the position the item had
        Node<K, V> newHead = fastReadableMap.get(key);
        if (currentSize > 1) {

            moveNodeToTheHead(newHead);
        }
        return Optional.ofNullable(newHead)
                .map(node -> node.value)
                .orElse(null);
    }

    @Override
    public V put(K key, V value) {
        Node<K,V> nodeValue = fastReadableMap.get(key);
        if (nodeValue == null) {
            currentSize++;
            Node<K,V> newNode = new Node<>(key, value);
            fastReadableMap.put(key, newNode);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                head.previous = newNode;
                newNode.next = head;
                head = newNode;
            }
            if (currentSize > maximumSize) {
                tail.previous.next = null;
                tail.next = null;
                fastReadableMap.remove(tail.key);
                tail = tail.previous;
                currentSize--;
            }
            return newNode.value;
        } else if (currentSize > 1) {
            moveNodeToTheHead(nodeValue);
        }
        return nodeValue.value;
    }

    private void moveNodeToTheHead(Node<K, V> newHead) {
        newHead.previous.next = newHead.next;
        if (newHead.next != null) {
            newHead.next.previous = newHead.previous;
        } else {
            tail = newHead.previous;
        }
        newHead.next = head;
        newHead.previous = null;
        head.previous = newHead;
        head = newHead;
    }

    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public int getMaximumSize() {
        return maximumSize;
    }

    public V getCurrentLastRecentlyUsed() {
        return Optional.ofNullable(head)
                .map(node -> node.value)
                .orElse(null);
    }

    public V getValueInTail() {
        return Optional.ofNullable(tail)
                .map(node -> node.value)
                .orElse(null);
    }
}
