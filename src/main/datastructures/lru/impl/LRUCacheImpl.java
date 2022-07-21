package main.datastructures.lru.impl;

import main.datastructures.lru.LRUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;


// IMPORTANT: We want ALL THE OPERATIONS AS O(1) !!!

public class LRUCacheImpl<K, V> implements LRUCache<K, V> {

    // A map will be used so the read of the catch should be O(1)
    private final Map<K, Node<K, V>> fastReadableMap;

    // Head == Most Recently, Tail == Least Recently (and the one that will be removed in case the Cache is full)
    // Not using the LinkedList Java implementation because we need access to the Node, so we can do some operations like remove a value in O(1)
    private final InternalLinkedList<K, V> mostRecentlyObjects;

    // In case of concurrency, we can control the access for read and write in our Data Structure
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // The maximum size of the cache
    private final int maximumSize;

    public LRUCacheImpl(int maximumSize) {

        if (maximumSize < 1) {
            throw new IllegalArgumentException("Invalid Cache Size");
        }

        this.maximumSize = maximumSize;
        this.fastReadableMap = new HashMap<>(maximumSize);
        this.mostRecentlyObjects =  new InternalLinkedList<>();
    }

    @Override
    public V get(K key) {

        try {
            lock.readLock().lock();
            // if the item already exist, just get the item and move to the head because it's the most recent item
            Node<K, V> newHead = fastReadableMap.get(key);
            if (mostRecentlyObjects.getSize() > 1) {
                mostRecentlyObjects.moveToHead(newHead);
            }
            return Optional.ofNullable(newHead)
                    .map(node -> node.value)
                    .orElse(null);
        } finally {
            lock.readLock().unlock();
        }

    }

    @Override
    public V put(K key, V value) {
        try {
            lock.writeLock().lock();
            // If the item is new then it should be the new head and if the size reaches the max, then the tail should be removed.
            // The tail is the LRU
            // If the size is 1, we don't need to move anything
            Node<K,V> nodeValue = fastReadableMap.get(key);
            if (nodeValue == null) {
                Node<K,V> newNode = mostRecentlyObjects.addHead(key, value);
                fastReadableMap.put(key, newNode);

                if (mostRecentlyObjects.getSize() > maximumSize) {
                    Node<K, V> tailRemoved = mostRecentlyObjects.removeTail();
                    fastReadableMap.remove(tailRemoved.getKey());
                }
                return newNode.getValue();
            } else if (mostRecentlyObjects.getSize() > 1) {
                mostRecentlyObjects.moveToHead(nodeValue);
            }
            return nodeValue.value;
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public int getCurrentSize() {
        return mostRecentlyObjects.getSize();
    }

    @Override
    public int getMaximumSize() {
        return maximumSize;
    }

    public V getCurrentLastRecentlyUsed() {
        return Optional.ofNullable(mostRecentlyObjects.getHead())
                .map(Node::getValue)
                .orElse(null);
    }

    public V getValueInTail() {
        return Optional.ofNullable(mostRecentlyObjects.getTail())
                .map(Node::getValue)
                .orElse(null);
    }
}
