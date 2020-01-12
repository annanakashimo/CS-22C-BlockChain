package test;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlist.List;

public class IsEmptyTest {

	@Test
    public void test() {
        List<Integer> L = new List<>();
        assertEquals(true, L.isEmpty());
        L.addLast(3);
        assertEquals(false, L.isEmpty());
        L.removeLast();
        assertEquals(true, L.isEmpty());
    }

}
