package com.emm.entities;

/**
 * Created by vladimir on 07.02.2018.
 */
public enum SexType {
    male(1),
    female(0);

    private final Integer index;

    SexType(int i) {
        index = i;
    }

    public int index() {
        return index;
    }

    public static SexType getById(Integer id) {
        for(SexType e : values()) {
            if(e.index.equals(id)) return e;
        }
        return null;
    }
}
