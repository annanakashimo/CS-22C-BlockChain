package test;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlist.List;

public class GetLengthTest {

    @Test
    public void test() {
        List<Integer> L = new List<>();
        assertEquals(0, L.getLength());
        L.addLast(3);
        assertEquals(1, L.getLength());
        L.addFirst(2);
        assertEquals(2, L.getLength());
    }

}
