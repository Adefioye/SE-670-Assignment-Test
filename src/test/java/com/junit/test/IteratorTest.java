package com.junit.test;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


public class IteratorTest {


    @Test
    public void whenMultipleElementsInList_returnElementAfterNextAndRemoveOperation() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> it = list.iterator();
        it.next();
        it.remove();

        assertEquals(2, (int) it.next());
    }

    @Test
    public void whenSingleElementInList_returnFalse_afterNextAndRemoveOperation() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        Iterator<Integer> it = list.iterator();
        it.next();
        it.remove();

        assertFalse(it.hasNext());
    }

    @Test
    public void whenListEmpty_returnFalse() {
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> it = list.iterator();

        assertFalse(it.hasNext());
    }

    @Test
    public void whenModifyingAndCallingRemove_throwConcurrentModificationException() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        Iterator<Integer> it = list.iterator();

        list.add(2);
        assertThrows(ConcurrentModificationException.class, it::next);
    }
}
