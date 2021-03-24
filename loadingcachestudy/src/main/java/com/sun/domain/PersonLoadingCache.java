package com.sun.domain;

import com.google.common.collect.Maps;

import java.util.Map;

public class PersonLoadingCache<K, V> {

    private Map<K, V> cache = Maps.newHashMap();

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V val) {
        cache.put(key, val);
    }



}
