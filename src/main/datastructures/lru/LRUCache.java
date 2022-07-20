package main.datastructures.lru;

import java.util.Optional;

public interface LRUCache<K, V> {

    V put(K key, V value);

    V get(K key);

    int getCurrentSize();

    int getMaximumSize();

    V getCurrentLastRecentlyUsed();

    V getValueInTail();
}
