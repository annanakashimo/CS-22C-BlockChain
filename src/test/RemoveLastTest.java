package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import linkedlist.List;

public class RemoveLastTest {

	@Test
    public void test() {
        List<Integer> L = new List<>();
        boolean threw = false;
        try {
        	L.removeLast();
        } catch (NoSuchElementException ex) {
        	threw = true;
        }
        assertTrue(threw);
        
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        
        L.removeLast();
        assertEquals(new Integer(3), L.getLast());
        L.removeLast();
        assertEquals(new Integer(2), L.getLast());       
        L.removeLast();
        assertEquals(new Integer(1), L.getLast());
    }

}
