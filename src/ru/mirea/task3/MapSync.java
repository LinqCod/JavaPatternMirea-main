package ru.mirea.task3;

import java.util.*;

//Map с использованием ключевого слова synchronized

public class MapSync<K, V> implements Map<K, V> {
    //Объявление переменной с ключевым словом volatile отключает для неё такое кэширование
    // и все запросы к переменной будут направляться непосредственно в память.
    //+дженерики

    private volatile Map<K, V> map = new HashMap<>();

    //synchronized значит, что только один поток может выполнять блок
    @Override
    synchronized public int size() {
        return map.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    synchronized public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    synchronized public boolean containsValue(Object value) {
        return map.containsKey(value);
    }

    @Override
    synchronized public V get(Object key) {
        return map.get(key);
    }

    @Override
    synchronized public V put(K key, V value) {
        return map.put(key,value);
    }

    @Override
    synchronized public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    synchronized public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    synchronized public void clear() {
        map.clear();
    }

    @Override
    synchronized public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    synchronized public Collection<V> values() {
        return map.values();
    }

    @Override
    synchronized public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}
