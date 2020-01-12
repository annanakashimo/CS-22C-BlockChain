package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import linkedlist.List;

public class RemoveFirstTest {

	@Test
    public void test() {
        List<Integer> L = new List<>();
        boolean threw = false;
        try {
        	L.removeFirst();
        } catch (NoSuchElementException ex) {
        	threw = true;
        }
        assertTrue(threw);
        
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
        
        L.removeFirst();
        assertEquals(new Integer(3), L.getFirst());
        L.removeFirst();
        assertEquals(new Integer(2), L.getFirst());       
        L.removeFirst();
        assertEquals(new Integer(1), L.getFirst());
    }

}
