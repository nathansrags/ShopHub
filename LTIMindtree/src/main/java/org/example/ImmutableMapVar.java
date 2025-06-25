package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ImmutableMapVar {

    private int id;
    private Map<String, String> hashMap;
    private List<String> myList;
    private Set<String> mySet;

    public ImmutableMapVar(final int id, final Map<String, String> map) {
        this.id = id;
        this.hashMap = map;
    }

    public ImmutableMapVar(final List<String> list){
        this.myList = list;
    }

    public ImmutableMapVar(final Set<String> set){
        this.mySet = set;
    }

    public int getId() {
        return id;
    }
    // prevents modification of map
    public Map<String, String> getHashMap() {
        return Collections.unmodifiableMap(hashMap);
    }

    // prevents modification of List
    public List<String> getMyList() {
        return Collections.unmodifiableList(myList);
    }
    //prevents modification of Set

    public Set<String> getMySet() {
        return Collections.unmodifiableSet(mySet);
    }
}
