package ru.aton.corporatebus;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StructureHash {

    private Map<Long, InMemoryEntity> map1;
    private Map<String, InMemoryEntity> map2;
    private Map<Double, InMemoryEntity> map3;

    public StructureHash() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        map3 = new HashMap<>();
    }

    public void add(InMemoryEntity obj) {
        map1.put(obj.getAccount(), obj);
        map2.put(obj.getName(), obj);
        map3.put(obj.getValue(), obj);
    }

    public void remove(InMemoryEntity obj) {
        map1.remove(obj.getAccount());
        map2.remove(obj.getName());
        map3.remove(obj.getValue());
    }

    public void update(InMemoryEntity obj) {
        remove(obj);
        add(obj);
    }

    public InMemoryEntity findByAccount(long account) {
        return map1.get(account);
    }

    public InMemoryEntity findByName(String name) {
        return map2.get(name);
    }

    public InMemoryEntity findByValue(double value) {
        return map3.get(value);
    }

    public int size() {
        return map1.size();
    }

}
