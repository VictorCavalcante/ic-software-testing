

package br.ufal.ic.my.queue;

import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class MyQueue<T> {
    
    private ArrayList<T> queue;
    private int first;
    private int last;
    private int currentSize;

    /*
    QueuePack constructor.
    @param Integer which corresponds to the size of the queue.
     */
    public MyQueue(int size) {
        this.queue = new ArrayList<T>();
        this.first = 0;
        this.last = size - 1;
        this.currentSize = 0;
    }
    
    /*
    Inserts an element at the end of the queue.
     */
    public void enqueue(T element) {
        if (currentSize == queue.size()){
            throw new QueueIsFullException("Queue está com tamanho máximo.");
        } else {
            queue.add(element);
            currentSize++;
        }
            
    }
    
     /*
    Returns the queue size.
     */
    public int size() {
        return this.currentSize;
    }
    
    /*
    Returns the first queue element.
     */
    public T element() {
        if (currentSize == 0) {
            throw new QueueIsFullException("Queue está vazia.");
        } else {
            T element = queue.get(first);
            
            return element;
        }
    }
    
    /*
    Removes the queue first element and returns it.
    */
    public T dequeue() {
        if (currentSize == 0) {
            throw new QueueIsFullException("Queue está vazia.");
        } else {
            T element = queue.get(first);
            queue.add(first,null);
            this.currentSize--;
            
            return element;
        }
    }
    
    /*
    Transforms the queue elements in a String.
     */
    public String toString() {
        
        String string = "QueuePack = {";
        
        for (int i = 0; i < queue.size(); i++) {
            if (i < queue.size() - 1) {
                string += queue.get(i) + ", ";
            } else {
                string += queue.get(i);
            }
        }
        
        string += "}";
        
        return string;
    }
    
    //Reboot the queue
    public void resetQueue() {
        
        for (int i = 0; i < queue.size(); i++) {
            this.dequeue();
        }
        
    }
    
}
