package main.datastructures.lru.impl;

import main.datastructures.lru.LRUCache;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheImplTest {

    @Test
    public void shouldReturnValueForOneItemCacheWhenExists() {

        LRUCache<String, String> lruCache = new LRUCacheImpl<>(3);
        lruCache.put("1", "One");

        Assert.assertEquals(lruCache.get("1"), "One");
        Assert.assertEquals(lruCache.getCurrentSize(), 1);
        Assert.assertEquals(lruCache.getMaximumSize(), 3);
        Assert.assertEquals(lruCache.getCurrentLastRecentlyUsed(), "One");
        Assert.assertEquals(lruCache.getValueInTail(), "One");

    }


    @Test
    public void shouldReturnValueForGreaterItemCacheWhenExists() {
        LRUCache<String, String> lruCache = new LRUCacheImpl<>(3);
        lruCache.put("1", "One");
        lruCache.put("2", "Two");
        lruCache.put("3", "Three");

        Assert.assertEquals(lruCache.get("2"), "Two");
        Assert.assertEquals(lruCache.getCurrentSize(), 3);
        Assert.assertEquals(lruCache.getMaximumSize(), 3);
        Assert.assertEquals(lruCache.getCurrentLastRecentlyUsed(), "Two");
        Assert.assertEquals(lruCache.getValueInTail(), "One");
    }

    @Test
    public void shouldReturnNullValueIfIfDoesNotExist() {

    }
}