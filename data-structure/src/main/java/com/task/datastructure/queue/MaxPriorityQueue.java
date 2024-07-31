package com.task.datastructure.queue;

public class MaxPriorityQueue {
    private int[] arr;
    private int size;

    public MaxPriorityQueue(int capacity) {
        arr = new int[capacity];
        size = 0;
    }


    public void enqueue(int value) {
        if (size == arr.length) {
            throw new IllegalStateException("Queue is full");
        }

        int i;
        for (i = size - 1; i >= 0; i--) {
            if (value > arr[i]) {
                arr[i + 1] = arr[i];
            } else {
                break;
            }
        }
        arr[i + 1] = value;
        size++;
    }


    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[--size];
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }
}