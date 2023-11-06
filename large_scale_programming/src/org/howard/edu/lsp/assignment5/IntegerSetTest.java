package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.howard.edu.lsp.assignment5.IntegerSet.IntegerSetException;

public class IntegerSetTest {
    private IntegerSet setA;
    private IntegerSet setB;

    @BeforeEach
    void setUp() {
        setA = new IntegerSet();
        setB = new IntegerSet();
    }

    @Test
    void testClear() {
        setA.add(1);
        setA.clear();
        assertTrue(setA.isEmpty());
    }

    @Test
    void testLength() {
        setA.add(1);
        setA.add(2);
        assertEquals(2, setA.length());
    }

    @Test
    void testEquals() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(1);
        assertTrue(setA.equals(setB));
    }

    @Test
    void testContains() {
        setA.add(1);
        setA.add(2);
        assertTrue(setA.contains(2));
    }

    @Test
    void testLargest() {
        setA.add(1);
        setA.add(5);
        try {
            assertEquals(5, setA.largest());
        } catch (IntegerSetException e) {
            fail("Exception not expected");
        }
    }

    @Test
    void testLargestWithEmptySet() {
        assertThrows(IntegerSetException.class, () -> setA.largest());
    }

    @Test
    void testSmallest() {
        setA.add(3);
        setA.add(2);
        try {
            assertEquals(2, setA.smallest());
        } catch (IntegerSetException e) {
            fail("Exception not expected");
        }
    }

    @Test
    void testSmallestWithEmptySet() {
        assertThrows(IntegerSetException.class, () -> setA.smallest());
    }
    
    @Test
    void testAdd() {
        setA.add(1);
        setA.add(2);
        assertTrue(setA.contains(1));
        assertTrue(setA.contains(2));
        assertFalse(setA.contains(3));
    }

    @Test
    void testRemove() {
        setA.add(1);
        setA.add(2);
        setA.remove(1);
        assertFalse(setA.contains(1));
        assertTrue(setA.contains(2));
    }

    @Test
    void testUnion() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.union(setB);
        assertTrue(setA.contains(1));
        assertTrue(setA.contains(2));
        assertTrue(setA.contains(3));
    }

    @Test
    void testIntersect() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.intersect(setB);
        assertFalse(setA.contains(1));
        assertTrue(setA.contains(2));
        assertFalse(setA.contains(3));
    }

    @Test
    void testDiff() {
    	IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.diff(setB);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(3));
    }

    @Test
    void testComplement() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setA.complement(setB);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(2));
    }

    @Test
    void testIsEmpty() {
        assertTrue(setA.isEmpty());
        setA.add(1);
        assertFalse(setA.isEmpty());
    }

    @Test
    void testToString() {
        setA.add(1);
        setA.add(2);
        assertEquals("[1, 2]", setA.toString());
    }
}