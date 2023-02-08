import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;

public class SetTest {

    private Set<Integer> set;

    @Before
    public void setUp() {
        set = new ArrayList<>();
    }

    @Test
    public void testAdd() {
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
    }

    @Test
    public void testAddDuplicate() {
        assertTrue(set.add(1));
        assertFalse(set.add(1));
    }

    @Test
    public void testRemove() {
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertTrue(set.remove(2));
        assertFalse(set.remove(2));
    }

    @Test
    public void testContains() {
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertTrue(set.contains(2));
        assertFalse(set.contains(4));
    }

    @Test
    public void testClear() {
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        set.clear();
        assertEquals(0, set.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, set.size());
        assertTrue(set.add(1));
        assertEquals(1, set.size());
        assertTrue(set.add(2));
        assertEquals(2, set.size());
        assertTrue(set.add(3));
        assertEquals(3, set.size());
        assertTrue(set.remove(2));
        assertEquals(2, set.size());
        assertTrue(set.remove(3));
        assertEquals(1, set.size());
        assertTrue(set.remove(1));
        assertEquals(0, set.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(set.isEmpty());
        assertTrue(set.add(1));
        assertFalse(set.isEmpty());
        assertTrue(set.remove(1));
        assertTrue(set.isEmpty());
    }

    @Test
    public void testToArray() {
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        Object[] array = set.toArray();
        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    public void testToArrayEmpty() {
        Object[] array = set.toArray();
        assertEquals(0, array.length);
    }

    @Test
    public void testUnion() {
        Set<Integer> setA = new ArrayList<>();
        Set<Integer> setB = new ArrayList<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(3);
        setB.add(4);
        Set<Integer> setUnion = set.union(setA, setB);
        assertEquals(4, setUnion.size());
        assertTrue(setUnion.contains(1));
        assertTrue(setUnion.contains(2));
        assertTrue(setUnion.contains(3));
        assertTrue(setUnion.contains(4));
    }

    @Test
    public void testIntersection() {
        Set<Integer> setA = new ArrayList<>();
        Set<Integer> setB = new ArrayList<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(3);
        setB.add(4);
        Set<Integer> setIntersection = set.intersection(setA, setB);
        assertEquals(2, setIntersection.size());
        assertFalse(setIntersection.contains(1));
        assertTrue(setIntersection.contains(2));
        assertTrue(setIntersection.contains(3));
        assertFalse(setIntersection.contains(4));
    }

    @Test
    public void testDifference() {
        Set<Integer> setA = new ArrayList<>();
        Set<Integer> setB = new ArrayList<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(3);
        setB.add(4);
        Set<Integer> setDifference = set.difference(setA, setB);
        assertEquals(1, setDifference.size());
        assertTrue(setDifference.contains(1));
        assertFalse(setDifference.contains(2));
        assertFalse(setDifference.contains(3));
        assertFalse(setDifference.contains(4));
    }

}
