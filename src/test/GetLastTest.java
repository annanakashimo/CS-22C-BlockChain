package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import linkedlist.List;

public class GetLastTest {

    @Test
    public void test() {
        List<Integer> L = new List<>();
        boolean threw = false;
        try {
        	L.getFirst();
        } catch (NoSuchElementException ex) {
        	threw = true;
        }
        assertTrue(threw);
        L.addLast(1);
        assertEquals(new Integer(1), L.getLast());
        L.addLast(2);
        assertEquals(new Integer(2), L.getLast());     
        L.addLast(3);
        assertEquals(new Integer(3), L.getLast());
    }

}