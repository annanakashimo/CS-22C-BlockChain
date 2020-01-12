package test;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlist.List;

public class AddFirstTest {

    @Test
    public void test() {
        List<Integer> L = new List<>();
        L.addFirst(1);
        assertEquals(1, L.getLength());
        L.addFirst(2);
        assertEquals(new Integer(2), L.getFirst());       
        L.addFirst(3);
        assertEquals(new Integer(3), L.getFirst());
    }

}