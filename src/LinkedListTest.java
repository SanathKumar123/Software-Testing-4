import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

public class LinkedListTest {
    private list.LinkedList<String> list;

    @Before
    public void setUp() {
        list = new list.LinkedList<>();
    }

    @Test
    public void testConstructorAndSize() {
        assertEquals(0, list.size());
        list.LinkedList<String> listFromCollection = new list.LinkedList<>(list);
        assertEquals(0, listFromCollection.size());
    }

    @Test
    public void testAddAndGet() {
        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testAddAtIndex() {
        list.add(0, "A");
        list.add(1, "C");
        list.add(1, "B");
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtInvalidIndex() {
        list.add(1, "A");
    }

    @Test
    public void testSet() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.set(0, "C"));
        assertEquals("C", list.get(0));
    }

    @Test
    public void testRemove() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertTrue(list.remove("B"));
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
        assertFalse(list.remove("D"));
    }

    @Test
    public void testRemoveAtIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    public void testClear() {
        list.add("A");
        list.add("B");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testAddFirst() {
        list.addFirst("B");
        list.addFirst("A");
        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    public void testAddLast() {
        list.addLast("A");
        list.addLast("B");
        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    public void testRemoveFirst() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.removeFirst());
        assertEquals(1, list.size());
        assertEquals("B", list.getFirst());
    }

    @Test
    public void testRemoveLast() {
        list.add("A");
        list.add("B");
        assertEquals("B", list.removeLast());
        assertEquals(1, list.size());
        assertEquals("A", list.getLast());
    }

    @Test
    public void testContains() {
        list.add("A");
        list.add("B");
        assertTrue(list.contains("A"));
        assertTrue(list.contains("B"));
        assertFalse(list.contains("C"));
    }

    @Test
    public void testIndexOf() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertEquals(0, list.indexOf("A"));
        assertEquals(1, list.indexOf("B"));
        assertEquals(-1, list.indexOf("C"));
    }

    @Test
    public void testAddAll() {
        list.LinkedList<String> otherList = new list.LinkedList<>();
        otherList.add("A");
        otherList.add("B");
        assertTrue(list.addAll(otherList));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testAddAllAtIndex() {
        list.add("X");
        list.add("Y");
        list.LinkedList<String> otherList = new list.LinkedList<>();
        otherList.add("A");
        otherList.add("B");
        assertTrue(list.addAll(1, otherList));
        assertEquals(4, list.size());
        assertEquals("X", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("B", list.get(2));
        assertEquals("Y", list.get(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstEmpty() {
        list.getFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastEmpty() {
        list.getLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstEmpty() {
        list.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastEmpty() {
        list.removeLast();
    }

    @Test
    public void testRemoveNull() {
        list.add(null);
        list.add("A");
        assertTrue(list.remove(null));
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testAddAllEmpty() {
        list.LinkedList<String> emptyList = new list.LinkedList<>();
        assertFalse(list.addAll(emptyList));
        assertEquals(0, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllAtInvalidIndex() {
        list.LinkedList<String> otherList = new list.LinkedList<>();
        otherList.add("A");
        list.addAll(1, otherList);
    }

    // New tests to improve branch and edge coverage

    @Test
    public void testAddAllAtEnd() {
        list.add("X");
        list.LinkedList<String> otherList = new list.LinkedList<>();
        otherList.add("A");
        otherList.add("B");
        assertTrue(list.addAll(1, otherList));
        assertEquals(3, list.size());
        assertEquals("X", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("B", list.get(2));
    }

    @Test
    public void testIndexOfWithNullElements() {
        list.add(null);
        list.add("A");
        list.add(null);
        assertEquals(0, list.indexOf(null));
        assertEquals(1, list.indexOf("A"));
    }

    @Test
    public void testRemoveFromMiddle() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testSetAtBeginningAndEnd() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("A", list.set(0, "X"));
        assertEquals("C", list.set(2, "Z"));
        assertEquals("X", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("Z", list.get(2));
    }

    @Test
    public void testAddAllWithLargeList() {
        list.LinkedList<String> largeList = new list.LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            largeList.add("Element" + i);
        }
        assertTrue(list.addAll(largeList));
        assertEquals(1000, list.size());
        assertEquals("Element0", list.get(0));
        assertEquals("Element999", list.get(999));
    }

    @Test
    public void testEntryMethodWithLargeList() {
        for (int i = 0; i < 1000; i++) {
            list.add("Element" + i);
        }
        assertEquals("Element500", list.get(500));
        assertEquals("Element999", list.get(999));
    }

    @Test
    public void testLastIndexOf() {
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");
        assertEquals(2, list.lastIndexOf("A"));
        assertEquals(1, list.lastIndexOf("B"));
        assertEquals(3, list.lastIndexOf("C"));
        assertEquals(-1, list.lastIndexOf("D"));
    }

    @Test
    public void testToArray() {
        list.add("A");
        list.add("B");
        list.add("C");
        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);
    }

    @Test
    public void testToArrayWithArgument() {
        list.add("A");
        list.add("B");
        list.add("C");
        String[] array = new String[3];
        String[] result = list.toArray(array);
        assertSame(array, result);
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);
    }

    @Test
    public void testToArrayWithSmallerArgument() {
        list.add("A");
        list.add("B");
        list.add("C");
        String[] array = new String[2];
        String[] result = list.toArray(array);
        assertNotSame(array, result);
        assertEquals(3, result.length);
        assertEquals("A", result[0]);
        assertEquals("B", result[1]);
        assertEquals("C", result[2]);
    }

    @Test
    public void testToArrayWithLargerArgument() {
        list.add("A");
        list.add("B");
        String[] array = new String[3];
        String[] result = list.toArray(array);
        assertSame(array, result);
        assertEquals("A", result[0]);
        assertEquals("B", result[1]);
        assertNull(result[2]);
    }

    @Test
    public void testAddAllWithEmptyList() {
        list.LinkedList<String> emptyList = new list.LinkedList<>();
        assertFalse(list.addAll(emptyList));
        assertEquals(0, list.size());
    }

    @Test
    public void testAddAllAtIndexWithEmptyList() {
        list.add("A");
        list.add("B");
        list.LinkedList<String> emptyList = new list.LinkedList<>();
        assertFalse(list.addAll(1, emptyList));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testRemoveWithNullElement() {
        list.add(null);
        list.add("A");
        list.add(null);
        assertTrue(list.remove(null));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void testIndexOfWithNullElement() {
        list.add(null);
        list.add("A");
        list.add(null);
        assertEquals(0, list.indexOf(null));
    }

    @Test
    public void testLastIndexOfWithNullElement() {
        list.add(null);
        list.add("A");
        list.add(null);
        assertEquals(2, list.lastIndexOf(null));
    }
}