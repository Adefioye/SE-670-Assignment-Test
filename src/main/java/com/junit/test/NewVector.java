package com.junit.test;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class NewVector<T> extends Vector<T> {
    public NewVector() {
        super();
    }

    public NewVector(Vector<? extends T> c) {
        super(c);
    }

    private boolean containDuplicates() {
        Set<T> uniqueItems = new HashSet<>(this);

        return this.size() != uniqueItems.size();
    };
    public static <T> Set<T> union(Set<T> a, Set<T> b) {

        // Check for null set
        if (a == null || b == null) {
            throw new NullPointerException("Vector a or b cannot be null");
        }

        Set<T> result = new HashSet<>(a);

        result.addAll(b);

        return result;
    }
}
