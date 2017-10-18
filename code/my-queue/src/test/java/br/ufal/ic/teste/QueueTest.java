package br.ufal.ic.teste;

import br.ufal.ic.queue.EmptyQueueException;
import br.ufal.ic.queue.FullQueueException;
import br.ufal.ic.queue.Queue;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueueTest {

    private Queue<String> stringQueue;
    private Queue<String> emptyStringQueue;
    private Queue<String> fullStringQueue;

    private boolean[] givenArray() {
        return new boolean[]{true, false, true, false, false};
    }
    private boolean[] givenTrueFilledArray() {
        return new boolean[]{true, true, true, true, true};
    }

    @Before
    public void init() throws FullQueueException {
        stringQueue = new Queue<String>(3);
        emptyStringQueue = new Queue<String>(3);

        fullStringQueue = new Queue<String>(3);
        fullStringQueue.insert("circle");
        fullStringQueue.insert("triangle");
        fullStringQueue.insert("square");
    }

    // getSize
    @Test
    public void shouldInitializeWithEmptySize() {
        assertThat(emptyStringQueue.getSize(), is(equalTo(0)));
    }

    @Test
    public void shouldReturnCorrectSize() throws FullQueueException, EmptyQueueException {
        Queue<String> stringQueue = new Queue<String>(3);

        stringQueue.insert("banana");
        assertThat(stringQueue.getSize(), is(equalTo(1)));

        stringQueue.insert("orange");
        assertThat(stringQueue.getSize(), is(equalTo(2)));

        stringQueue.insert("apple");
        assertThat(stringQueue.getSize(), is(equalTo(3)));

        stringQueue.remove();
        assertThat(stringQueue.getSize(), is(equalTo(2)));
    }

    // getFirst
    @Test
    public void shouldGetFirstElement() throws EmptyQueueException, FullQueueException {
        Queue<String> stringQueue = new Queue<String>(3);

        stringQueue.insert("orange");
        assertThat(stringQueue.getFirst(), is(equalTo("orange")));

        stringQueue.insert("apple");
        assertThat(stringQueue.getFirst(), is(equalTo("orange")));

        stringQueue.remove();
        assertThat(stringQueue.getFirst(), is(equalTo("apple")));
    }

    // insert
    @Test
    public void shouldInsertANewElement() throws EmptyQueueException, FullQueueException {
        Queue<Integer> integerQueue = new Queue<Integer>(3);

        integerQueue.insert(42);
        assertThat(integerQueue.getFirst(), is(equalTo(42)));

        integerQueue.insert(30);
        assertThat(integerQueue.getSize(), is(equalTo(2)));
    }

    @Test(expected = FullQueueException.class)
    public void shouldThrowFullQueueException() throws FullQueueException {
        fullStringQueue.insert("x");
    }

    // remove
    @Test
    public void shouldRemoveAnElement() throws EmptyQueueException, FullQueueException {
        Queue<Integer> integerQueue = new Queue<Integer>(3);
        integerQueue.insert(42);
        integerQueue.insert(30);

        integerQueue.remove();
        assertThat(integerQueue.getFirst(), is(equalTo(30)));
    }

    @Test(expected = EmptyQueueException.class)
    public void shouldThrowEmptyQueueException() throws EmptyQueueException {
        emptyStringQueue.remove();
    }

    // isEmpty
    @Test
    public void shouldBeEmpty() throws EmptyQueueException, FullQueueException {
        assertThat(emptyStringQueue.isEmpty(), is(equalTo(true)));
    }

    @Test
    public void shouldNotBeEmpty() throws EmptyQueueException, FullQueueException {
        assertThat(fullStringQueue.isEmpty(), is(equalTo(false)));
    }

}
