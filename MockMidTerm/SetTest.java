import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;

public class SetTest {

    private ArrayList<Integer> set;

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
        assertEquals(0, set.getCurrentSize());
    }

    @Test
    public void testSize() {
        assertEquals(0, set.getCurrentSize());
        assertTrue(set.add(1));
        assertEquals(1, set.getCurrentSize());
        assertTrue(set.add(2));
        assertEquals(2, set.getCurrentSize());
        assertTrue(set.add(3));
        assertEquals(3, set.getCurrentSize());
        assertTrue(set.remove(2));
        assertEquals(2, set.getCurrentSize());
        assertTrue(set.remove(3));
        assertEquals(1, set.getCurrentSize());
        assertTrue(set.remove(1));
        assertEquals(0, set.getCurrentSize());
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
        ArrayList<Integer> set1 = new ArrayList<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        ArrayList<Integer> set2 = new ArrayList<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        ArrayList<Integer> union = set.union(set1, set2);
        assertEquals(4, union.getCurrentSize());
        assertTrue(union.contains(1));
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }

    @Test
    public void testIntersection() {
        ArrayList<Integer> set1 = new ArrayList<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        ArrayList<Integer> set2 = new ArrayList<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        ArrayList<Integer> intersection = set.intersection(set1, set2);
        assertEquals(2, intersection.getCurrentSize());
        assertFalse(intersection.contains(1));
        assertTrue(intersection.contains(2));
        assertTrue(intersection.contains(3));
        assertFalse(intersection.contains(4));
    }

    @Test
    public void testDifference() {
        ArrayList<Integer> set1 = new ArrayList<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        ArrayList<Integer> set2 = new ArrayList<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        ArrayList<Integer> difference = set.difference(set1, set2);
        assertEquals(1, difference.getCurrentSize());
        assertTrue(difference.contains(1));
        assertFalse(difference.contains(2));
        assertFalse(difference.contains(3));
        assertFalse(difference.contains(4));
    }

}
