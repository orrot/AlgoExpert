package main.datastructures.lru.impl;

import main.datastructures.lru.LRUCache;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheImplTest {

    @Test
    public void shouldReturnValueForOneItemCacheWhenExists() {

        LRUCache<String, String> lruCache = new LRUCacheImpl<>(3);
        lruCache.put("1", "One");

        Assert.assertEquals("One", lruCache.get("1"));
        Assert.assertEquals(1, lruCache.getCurrentSize());
        Assert.assertEquals(3, lruCache.getMaximumSize());
        Assert.assertEquals("One", lruCache.getCurrentLastRecentlyUsed());
        Assert.assertEquals("One", lruCache.getValueInTail());

    }

    @Test
    public void shouldReturnValueForGreaterItemCacheWhenExists() {
        LRUCache<String, String> lruCache = new LRUCacheImpl<>(3);
        lruCache.put("1", "One");
        Assert.assertEquals("One", lruCache.getCurrentLastRecentlyUsed());
        Assert.assertEquals("One", lruCache.getValueInTail());

        lruCache.put("2", "Two");
        Assert.assertEquals("Two", lruCache.getCurrentLastRecentlyUsed());
        Assert.assertEquals("One", lruCache.getValueInTail());

        lruCache.put("3", "Three");
        Assert.assertEquals("Three", lruCache.getCurrentLastRecentlyUsed());
        Assert.assertEquals("One", lruCache.getValueInTail());

        String lastAccess = lruCache.get("2");
        Assert.assertEquals(lastAccess, "Two");
        Assert.assertEquals(3, lruCache.getCurrentSize());
        Assert.assertEquals(3, lruCache.getMaximumSize());
        Assert.assertEquals("Two", lruCache.getCurrentLastRecentlyUsed());
        Assert.assertEquals("One", lruCache.getValueInTail());
    }

    @Test
    public void shouldReturnNullValueIfIfDoesNotExist() {

        LRUCache<String, String> lruCache = new LRUCacheImpl<>(3);
        lruCache.put("1", "One");
        lruCache.put("2", "Two");
        lruCache.put("3", "Three");
        lruCache.put("4", "Four");

        String lastAccess = lruCache.get("2");
        Assert.assertEquals(lastAccess, "Two");
        Assert.assertEquals(3, lruCache.getCurrentSize());
        Assert.assertEquals(3, lruCache.getMaximumSize());
        Assert.assertEquals("Two", lruCache.getCurrentLastRecentlyUsed());
        Assert.assertEquals("Three", lruCache.getValueInTail());

    }

    @Test
    public void shouldReturnManageCacheWhenMaximumSizeIsOne() {

        LRUCache<String, String> lruCache = new LRUCacheImpl<>(1);
        lruCache.put("1", "One");
        lruCache.put("2", "Two");

        Assert.assertEquals(1, lruCache.getCurrentSize());
        Assert.assertEquals(1, lruCache.getMaximumSize());
        Assert.assertEquals("Two", lruCache.getCurrentLastRecentlyUsed());
        Assert.assertEquals("Two", lruCache.getValueInTail());

        Assert.assertNull(lruCache.get("1"));

    }
}