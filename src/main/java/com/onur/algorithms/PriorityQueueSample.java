package com.onur.algorithms;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSample {

    public Queue<Integer> maxHeap(List<Integer> values) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer val : values) {
            pq.offer(val);
        }
        return pq;
    }

    public Queue<Integer> minHeap(List<Integer> values) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (Integer val : values) {
            pq.offer(val);
        }
        return pq;
    }


    public Queue<Integer> maxNElement(List<Integer> values, int n) {
        Queue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        for (Integer val : values) {
            pq.offer(val);
            i++;

            if (i > n) {
                pq.poll();
            }
        }
        return pq;
    }

    public Queue<Integer> minNElement(List<Integer> values, int n) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        for (Integer val : values) {
            pq.offer(val);
            i++;

            if (i > n) {
                pq.poll();
            }
        }
        return pq;
    }
}
