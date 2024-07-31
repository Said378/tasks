package com.task;

import com.task.datastructure.linked_list.ListNode;
import com.task.datastructure.linked_list.MiddleOfLinkedList;
import com.task.datastructure.queue.MaxPriorityQueue;
import com.task.datastructure.queue.Queue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        testQueue();
        testMaxPriorityQueue();
        MiddleOfLinkedList.testLinkedList();
    }

public static void  testQueue (){
    System.out.println("---------------- Queue ----------------");
    Queue queue = new Queue(5);
    System.out.println("Enqueueing elements: 1, 2, 3");
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println("Dequeued element: " + queue.dequeue());
    System.out.println("Dequeued element: " + queue.dequeue());
    System.out.println("Dequeued element: " + queue.dequeue());

    System.out.println("Is queue empty? " + queue.isEmpty());

    queue.enqueue(4);
    System.out.println("Enqueued element: 4");
    System.out.println("Dequeued element: " + queue.dequeue());

}

public static void testMaxPriorityQueue(){
    System.out.println("---------------- MaxPriorityQueue ----------------");
    MaxPriorityQueue priorityQueue = new MaxPriorityQueue(5);
    System.out.println("Enqueueing elements: 3, 1, 2");
    priorityQueue.enqueue(3);
    priorityQueue.enqueue(1);
    priorityQueue.enqueue(2);
    System.out.println("Dequeued element: " + priorityQueue.dequeue());
    System.out.println("Dequeued element: " + priorityQueue.dequeue());
    System.out.println("Dequeued element: " + priorityQueue.dequeue());

    System.out.println("Is priority queue empty? " + priorityQueue.isEmpty());

    priorityQueue.enqueue(4);
    System.out.println("Enqueued element: 4");
    System.out.println("Dequeued element: " + priorityQueue.dequeue());
}
}
