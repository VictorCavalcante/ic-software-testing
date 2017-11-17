package br.ufal.ic.my.queue;

/**
 *
 * @author julia
 */
public class MyQueue<T> {

    private T[] queue;
    private int maxSize;
    private int first;
    private int last;
    private int currentSize;

    /*
    QueuePack constructor.
    @param Integer which corresponds to the size of the queue.
     */
    public MyQueue(int size) {
        this.maxSize = size;
        this.queue = (T[]) new Object[size];
        this.first = 0;
        this.last = size - 1;
        this.currentSize = 0;
    }

    public int getSize(){
        if(this.isEmpty()){
            return 0;
        } else {
            return (this.last - this.first) + 1;
        }
    }

    public boolean isEmpty() {
        return (first == -1 && last == -1);
    }
    
    /*
    Inserts an element at the end of the queue.
     */
    public void add(T element) {
        // If queue is full
        if ((last + 1) % maxSize == first) {
            throw new QueueIsFullException("Queue está com tamanho máximo.");
            // If queue is empty
        } else if (this.isEmpty()) {
            first++;
            last++;
            queue[last] = element;
            // If queue has > 1 element
        } else {
            last = (last + 1) % maxSize;
            queue[last] = element;
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
            T element = queue[first];
            
            return element;
        }
    }
    
    /*
    Removes the queue first element and returns it.
    */
    public T dequeue() {
        T returnedValue;
        // If queue is empty
        if (this.isEmpty()) {
            throw new QueueIsFullException("Queue está vazia.");
        } else {
            returnedValue =  queue[first];
            // If queue has 1 element
            if (first == last) {
                first = -1; last = -1; // Empty list indexes
            // If queue has > 1 element
            } else {
                first = (first + 1) % maxSize; // Relocate first
            }
            return returnedValue;
        }
    }
    
    /*
    Transforms the queue elements in a String.
     */
    public String toString() {
        
        String string = "QueuePack = {";
        
        for (int i = 0; i < this.getSize(); i++) {
            if (i < this.getSize() - 1) {
                string += queue[i] + ", ";
            } else {
                string += queue[i];
            }
        }
        
        string += "}";
        
        return string;
    }
    
    //Reboot the queue
    public void resetQueue() {
        
        for (int i = 0; i < this.getSize(); i++) {
            this.dequeue();
        }
        
    }
    
}
