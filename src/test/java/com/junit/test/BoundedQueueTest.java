package com.junit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BoundedQueueTest {

    private static BoundedQueue underTest;

    @BeforeEach
    public void setUp() {
        underTest = new BoundedQueue(3);
    }

    @Test
    public void whenEnqueueNull_throwNullPointerException() {

        assertThatThrownBy(() -> underTest.enQueue(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("BoundedQueue.enQueue");
    }

    @Test
    public void whenQueueIsFull_throwIllegalStateException() {
        // Given there is just space for 3 items
        underTest.enQueue("element1");
        underTest.enQueue("element2");
        underTest.enQueue("element3");

        // Then
        assertThat(underTest.isFull()).isTrue();
        assertThatThrownBy(() -> underTest.enQueue("element4"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("BoundedQueue.enQueue");
    }

    @Test
    public void whenPerformEnqueue_BoundedQueueNotEmpty() {

        // When no element, It is empty
        assertThat(underTest.isEmpty()).isTrue();

        // When enqueue an element it is not empty
        underTest.enQueue("element1");
        assertThat(underTest.isEmpty()).isFalse();
    }

    @Test
    public void whenDequeEmptyBoundedQueue_returnIllegalStateException() {
        assertThatThrownBy(() -> underTest.deQueue())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("BoundedQueue.deQueue");
    }

    @Test
    public void whenDequeBoundedQueue_returnItemInQueue() {
        // Given
        String element1 = "element1";
        String element2 = "element2";
        underTest.enQueue(element1);
        underTest.enQueue(element2);
        // When
        String removedItem = (String) underTest.deQueue();

        // Since first-in-first-out, removedItem should be element1
        assertThat(removedItem).isNotEmpty();
        assertThat(removedItem).isEqualTo(element1);
    }

    @Test
    public void whenPerformIsEmpty_andNoItem_returnTrue() {
        boolean isEmptyResult = underTest.isEmpty();
        assertThat(isEmptyResult).isTrue();
    }

    @Test
    public void whenPerformIsEmpty_andItemPresent_returnFalse() {
        // Given
        underTest.enQueue("element1");
        // When
        boolean isEmptyResult = underTest.isEmpty();
        // Then
        assertThat(isEmptyResult).isFalse();
    }

    @Test
    public void whenPerformIsFull_andNoItem_returnFalse() {
        boolean isFullResult = underTest.isFull();
        assertThat(isFullResult).isFalse();
    }

    @Test
    public void whenPerformIsFull_andFilledToCapacity_returnTrue() {
        // Given
        underTest.enQueue("element1");
        underTest.enQueue("element2");
        underTest.enQueue("element3");
        // When
        boolean isFullResult = underTest.isFull();
        // Then
        assertThat(isFullResult).isTrue();
    }

    @Test
    public void whenPerformToString_andBoundedQueueEmpty_returnEmptyList() {
        String result = underTest.toString();

        // Then
        assertThat(result).isEqualTo("[]");
    }

    @Test
    public void whenPerformToString_ItemsPresentInBoundedQueue_returnCommaSeparatedListOfItems() {
        // Given
        underTest.enQueue("element1");
        underTest.enQueue("element2");
        // When
        String result = underTest.toString();

        // Then
        assertThat(result).isEqualTo("[element1, element2]");
    }
}
