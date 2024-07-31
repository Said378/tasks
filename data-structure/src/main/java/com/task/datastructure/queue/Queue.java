package com.task.datastructure.queue;

public class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }


    public void enqueue(int value) {
        if (size == arr.length) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        size++;
    }


    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return value;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }
}
