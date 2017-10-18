package br.ufal.ic.queue;

import java.util.Arrays;

public class Queue<E> {

	private E[] queueList;
    private int maxSize;
	private int head;
    private int tail;

    public Queue(int size) {
        this.maxSize = size;
        this.queueList = (E[]) new Object[size];
        this.head = -1;
        this.tail = -1;
    }

    public int getSize(){
    	if(this.isEmpty()){
    		return 0;
    	} else {
    		return (this.tail - this.head) + 1;
    	}
    }

    public E getFirst(){
    	return this.queueList[this.head];
    }

    public void insert(E value) throws FullQueueException {
    	// If queue is full
        if ((tail + 1) % maxSize == head) {
            throw new FullQueueException("Queue is full");
        // If queue is empty
        } else if (this.isEmpty()) {
            head++;
            tail++;
            queueList[tail] = value;
        // If queue has > 1 element
        } else {
            tail = (tail + 1) % maxSize;
            queueList[tail] = value;
        }
    }

    public void remove() throws EmptyQueueException {
        // If queue is empty
        if (this.isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        // If queue has 1 element
        } else if (head == tail) {
            // Empty list indexes
            head = -1;
            tail = -1;
         // If queue has > 1 element
        } else {
            // Relocate head
            head = (head + 1) % maxSize;
        }
    }

    public boolean isEmpty() {
        return (head == -1 && tail == -1);
    }

    @Override
    public String toString() {
        return "(h:" + head
        		+ ", t:" + tail
        		+ ", s:" + maxSize
                + ") queue = " + Arrays.toString(queueList);
    }

}