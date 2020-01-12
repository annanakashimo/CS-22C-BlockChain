package test;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlist.List;

public class AddLastTest {

    @Test
    public void test() {
        List<Integer> L = new List<>();
        L.addLast(1);
        assertEquals(1, L.getLength());
        L.addLast(2);
        assertEquals(new Integer(2), L.getLast());       
        L.addLast(3);
        assertEquals(new Integer(3), L.getLast());
    }

}
