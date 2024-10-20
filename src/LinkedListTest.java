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

    @Test
    public void testConstructorWithCollection() {
        list.LinkedList<String> list1 = new list.LinkedList<>();
        list1.add("A");
        list1.add("B");
        list.LinkedList<String> list2 = new list.LinkedList<>(list1);
        assertEquals(2, list2.size());
        assertEquals("A", list2.getFirst());
        assertEquals("B", list2.getLast());
    }

    @Test
    public void testAddAllWithIndex() {
        list.add("A");
        list.add("B");
        list.LinkedList<String> otherList = new list.LinkedList<>();
        otherList.add("C");
        otherList.add("D");
        assertTrue(list.addAll(1, otherList));
        assertEquals(4, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
        assertEquals("D", list.get(2));
        assertEquals("B", list.get(3));
    }

    @Test
    public void testAddAllWithIndexAtEnd() {
        list.add("A");
        list.add("B");
        list.LinkedList<String> otherList = new list.LinkedList<>();
        otherList.add("C");
        otherList.add("D");
        assertTrue(list.addAll(2, otherList));
        assertEquals(4, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));
    }

    @Test
    public void testEntryMethodWithLargeList() {
        for (int i = 0; i < 1000; i++) {
            list.add("Element" + i);
        }
        assertEquals("Element0", list.get(0));
        assertEquals("Element499", list.get(499));
        assertEquals("Element999", list.get(999));
    }

    @Test
    public void testIndexOfWithNullElements() {
        list.add(null);
        list.add("A");
        list.add(null);
        list.add("B");
        assertEquals(0, list.indexOf(null));
        assertEquals(1, list.indexOf("A"));
        assertEquals(3, list.indexOf("B"));
        assertEquals(-1, list.indexOf("C"));
    }

    @Test
    public void testRemoveWithNullElements() {
        list.add(null);
        list.add("A");
        list.add(null);
        list.add("B");
        assertTrue(list.remove(null));
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertNull(list.get(1));
        assertEquals("B", list.get(2));
    }

    @Test
    public void testClearAndSize() {
        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());

        // Test adding after clearing
        list.add("C");
        assertEquals(1, list.size());
        assertEquals("C", list.getFirst());
        assertEquals("C", list.getLast());
    }

    @Test
    public void testSetWithValidIndexes() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("A", list.set(0, "X"));
        assertEquals("B", list.set(1, "Y"));
        assertEquals("C", list.set(2, "Z"));
        assertEquals("X", list.get(0));
        assertEquals("Y", list.get(1));
        assertEquals("Z", list.get(2));
    }

    @Test
    public void testAddFirstAndGetFirst() {
        list.addFirst("B");
        list.addFirst("A");
        assertEquals("A", list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    public void testAddLastAndGetLast() {
        list.addLast("A");
        list.addLast("B");
        assertEquals("B", list.getLast());
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveFirstOccurrence() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertTrue(list.removeFirstOccurrence("A"));
        assertEquals(2, list.size());
        assertEquals("B", list.getFirst());
        assertEquals("A", list.getLast());
        assertFalse(list.removeFirstOccurrence("C"));
    }

    @Test
    public void testRemoveLastOccurrence() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertTrue(list.removeLastOccurrence("A"));
        assertEquals(2, list.size());
        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());
        assertFalse(list.removeLastOccurrence("C"));
    }

    @Test
    public void testOfferFirst() {
        assertTrue(list.offerFirst("A"));
        assertTrue(list.offerFirst("B"));
        assertEquals("B", list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    public void testOfferLast() {
        assertTrue(list.offerLast("A"));
        assertTrue(list.offerLast("B"));
        assertEquals("B", list.getLast());
        assertEquals(2, list.size());
    }

    @Test
    public void testPeekFirstAndLast() {
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
        list.add("A");
        list.add("B");
        assertEquals("A", list.peekFirst());
        assertEquals("B", list.peekLast());
    }

    @Test
    public void testPollFirstAndLast() {
        assertNull(list.pollFirst());
        assertNull(list.pollLast());
        list.add("A");
        list.add("B");
        assertEquals("A", list.pollFirst());
        assertEquals("B", list.pollLast());
        assertEquals(0, list.size());

        // Test polling from empty list
        assertNull(list.pollFirst());
        assertNull(list.pollLast());
    }

    @Test
    public void testPush() {
        list.push("A");
        list.push("B");
        assertEquals("B", list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    public void testPop() {
        list.push("A");
        list.push("B");
        assertEquals("B", list.pop());
        assertEquals("A", list.pop());
        assertEquals(0, list.size());

        try {
            list.pop();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            // The exception message is null, so we don't check for a specific message
            assertNotNull(e);
        }
    }

    @Test
    public void testGetFirstEmpty() {
        try {
            list.getFirst();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
//            assertEquals("List is empty", e.getMessage());
            assertNotNull(e);
        }
    }

    @Test
    public void testGetLastEmpty() {
        try {
            list.getLast();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
//            assertEquals("List is empty", e.getMessage());
            assertNotNull(e);
        }
    }

    @Test
    public void testRemoveFirstEmpty() {
        try {
            list.removeFirst();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
//            assertEquals("List is empty", e.getMessage());
            assertNotNull(e);
        }
    }

    @Test
    public void testRemoveLastEmpty() {
        try {
            list.removeLast();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testAddAtInvalidIndex() {
        try {
            list.add(1, "A");
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Size: 0", e.getMessage());
        }
    }

    @Test
    public void testSetWithInvalidIndex() {
        list.add("A");
        try {
            list.set(1, "B");
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Size: 1", e.getMessage());
        }
    }

    @Test
    public void testAddAllAtInvalidIndex() {
        list.LinkedList<String> otherList = new list.LinkedList<>();
        otherList.add("A");
        try {
            list.addAll(1, otherList);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Size: 0", e.getMessage());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyList() {
        list.pop();
    }

    @Test
    public void testAddFirstToEmptyList() {
        list.addFirst("A");
        assertEquals(1, list.size());
        assertEquals("A", list.getFirst());
        assertEquals("A", list.getLast());
    }

    @Test
    public void testAddLastToEmptyList() {
        list.addLast("A");
        assertEquals(1, list.size());
        assertEquals("A", list.getFirst());
        assertEquals("A", list.getLast());
    }

    @Test
    public void testAddAllWithIndexAtBeginning() {
        list.add("X");
        list.add("Y");
        list.LinkedList<String> otherList = new list.LinkedList<>();
        otherList.add("A");
        otherList.add("B");
        assertTrue(list.addAll(0, otherList));
        assertEquals(4, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("X", list.get(2));
        assertEquals("Y", list.get(3));
    }

    @Test
    public void testToArrayWithLargerTypedArray() {
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
    public void testAddAllWithEmptySourceList() {
        list.add("A");
        list.LinkedList<String> emptyList = new list.LinkedList<>();
        assertFalse(list.addAll(emptyList));
        assertEquals(1, list.size());
        assertEquals("A", list.getFirst());
    }

    @Test
    public void testSetOnSingleElementList() {
        list.add("A");
        assertEquals("A", list.set(0, "B"));
        assertEquals(1, list.size());
        assertEquals("B", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    public void testRemoveOnSingleElementList() {
        list.add("A");
        assertEquals("A", list.remove(0));
        assertEquals(0, list.size());
    }
}