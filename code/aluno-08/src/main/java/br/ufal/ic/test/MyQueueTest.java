package br.ufal.ic.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;

public class MyQueueTest {
    private ArrayList<Integer> list;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setUp() {
        list = new ArrayList<Integer>();
    }
    
    @Test
    public void EnqueueTest() {
    		for(int i = -10; i < 100000; i++) {
    			list.add(i);
    		}
    		int enqueue = list.get(0);
    		assertEquals(enqueue, -10);
    }
    
    @Test
    public void SizeTest() {
    		for(int i = 1; i < 1000000; i++) {
    			list.add(i);
    	        assertEquals(i, list.size());
    		}
    }
    
    @Test
    public void ElementTest() {
	    	for(int i = 0; i < 1000; i++) {
	    		list.add(i);
	    	}
	    	int element = list.get(0);
    		assertEquals(0, element);
    		
    		setUp();
    }
    
    @Test
    public void DequeueTest() {
    		for(int i = 0; i < 1000; i++) {
    			list.add(i);
    			list.remove(0);
    			assertEquals(list.size(), 0);
    		}
        
        setUp();
    }
    
    @Test
    public void toStringTest() {
    		for(int i = -10; i < 10; i++) {
    			list.add(i);
    		}
		assertEquals("[-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());

    }

    @Test
	public void ResetQueueTest() {
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		list.clear();
	}
}
