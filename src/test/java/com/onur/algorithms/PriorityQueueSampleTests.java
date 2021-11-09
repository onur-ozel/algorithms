package com.onur.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PriorityQueueSampleTests {
    private static PriorityQueueSample priorityQueueApp;
    private static List<Integer> values;

    @BeforeAll
    public static void setup() {
        priorityQueueApp = new PriorityQueueSample();
        initValues();
    }

    private static void initValues() {
        values = List.of(9, 11, 7, 3, 5);
    }

    @Test
    public void maxHeapTest() {
        Queue<Integer> result = priorityQueueApp.maxHeap(values);

        assertEquals(result.poll(), 11);
        assertEquals(result.poll(), 9);
        assertEquals(result.poll(), 7);
    }

    @Test
    public void minHeapTest() {
        Queue<Integer> result = priorityQueueApp.minHeap(values);

        assertEquals(result.poll(), 3);
        assertEquals(result.poll(), 5);
        assertEquals(result.poll(), 7);
    }

    @Test
    public void max3Test() {
        Queue<Integer> result = priorityQueueApp.maxNElement(values, 3);

        assertEquals(result.poll(), 7);
        assertEquals(result.poll(), 9);
        assertEquals(result.poll(), 11);
        assertEquals(result.isEmpty(), true);
    }

    @Test
    public void min3Test() {
        Queue<Integer> result = priorityQueueApp.minNElement(values, 3);

        assertEquals(result.poll(), 7);
        assertEquals(result.poll(), 5);
        assertEquals(result.poll(), 3);
        assertEquals(result.isEmpty(), true);
    }
}
