package com.junit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NewVectorTest {

//    @Test
//    public void whenDuplicateItemsInVectorInput_throwIllegalArgumentException() {
//        NewVector<Integer> a = new NewVector<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(3);
//
//        NewVector<Integer> b = new NewVector<>();
//        b.add(3);
//        b.add(4);
//        b.add(4);
//
//        assertThatThrownBy(() -> NewVector.union(a, b))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("Vector a or b contains duplicate");
//    }

//    @Test
//    public void whenEitherOfVectorInputIsNull_throwNullPointerException() {
//
//        NewVector<Integer> b = new NewVector<>();
//        b.add(3);
//        b.add(4);
//        b.add(4);
//
//        assertThatThrownBy(() -> NewVector.union(null, b))
//                .isInstanceOf(NullPointerException.class)
//                .hasMessage("Vector a or b cannot be null");
//    }
}
