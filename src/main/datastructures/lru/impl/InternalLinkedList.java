package main.datastructures.lru.impl;

public class InternalLinkedList<K, V> {

    // The maximum size of the cache
    private int size = 0;

    private Node<K, V> head;
    private Node<K, V> tail;

    public Node<K, V> addHead(K key, V value) {
        Node<K,V> newNode = new Node<>(key, value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            putNewNodeAsHead(newNode);
        }
        size++;
        return newNode;
    }

    private void putNewNodeAsHead(Node<K, V> newNode) {
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
    }

    public Node<K,V> moveToHead(Node<K, V> newHead) {
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
        return newHead;
    }

    public Node<K,V> removeTail() {
        Node<K, V> oldTail = tail;
        tail.previous.next = null;
        tail.next = null;
        tail = tail.previous;
        size--;
        return oldTail;
    }

    public int getSize() {
        return size;
    }

    public Node<K, V> getHead() {
        return head;
    }

    public Node<K, V> getTail() {
        return tail;
    }
}
