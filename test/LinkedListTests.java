import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @autor LeylaH
 */

public class LinkedListTests {

    @Test
    public void testIsEmpty() {
        MyLinkedList<String> list = createEmptyList();
        Assert.assertEquals(0, list.size());
        Assert.assertTrue(list.isEmpty());
        list.add("a");
        Assert.assertFalse(list.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetHeadExeption() {
        MyLinkedList<String> list = createEmptyList();
        list.getHead();
    }

    @Test
    public void testGetHead() {
        MyLinkedList<String> list = createListOfStrings("a", "b");
        Assert.assertEquals("a", list.getHead());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastExeption() {
        MyLinkedList<String> list = createEmptyList();
        list.getLast();
    }

    @Test
    public void testGetLast() {
        MyLinkedList<String> list = createListOfStrings("a", "b");
        Assert.assertEquals("b", list.getLast());
    }

    @Test
    public void testContains() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c");
        Assert.assertTrue(list.contains("b"));
        Assert.assertFalse(list.contains("d"));
    }


    @Test
    public void testIterator() {
        MyLinkedList<String> list = createListOfStrings("a", "b");
        Iterator<String> iterator = list.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("a", iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("b", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorRemove() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c");
        Iterator<String> iterator = list.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("a", iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("b", iterator.next());
        iterator.remove();
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("c", list.get(1));
    }

    @Test
    public void testAddAll() {
        MyLinkedList<String> list = createEmptyList();
        list.addAll(Arrays.asList("c", "d", "a", "b"));
        Assert.assertEquals(4, list.size());
        Assert.assertEquals("c", list.get(0));
        Assert.assertEquals("d", list.get(1));
        Assert.assertEquals("a", list.get(2));
        Assert.assertEquals("b", list.get(3));
    }

    @Test
    public void testClear() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c");
        list.clear();
        Assert.assertEquals(0, list.size());
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testGet() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c");
        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("b", list.get(1));
        Assert.assertEquals("c", list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetExeption() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c");
        list.get(5);
    }

    @Test
    public void testSet() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c");
        list.set(2, "s");
        Assert.assertEquals("s", list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetExeption() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c");
        list.set(5, "s");
    }

    @Test
    public void testAdd() {
        MyLinkedList<String> list = createEmptyList();
        list.add("a");
        list.add("b");
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("b", list.get(1));
    }

    @Test
    public void testAddToIndex() {
        MyLinkedList<String> list = createListOfStrings("a", "b");
        list.add(1, "c");
        Assert.assertEquals(3, list.size());
        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("c", list.get(1));
        Assert.assertEquals("b", list.get(2));
    }

    @Test
    public void testRemove() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c");
        list.remove(1);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("c", list.get(1));
    }

    @Test
    public void testIndexOf() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c", "c", "b");
        Assert.assertEquals(2, list.indexOf("c"));
        Assert.assertEquals(1, list.indexOf("b"));
        Assert.assertEquals(-1, list.indexOf("s"));
    }

    @Test
    public void testLastIndexOf() {
        MyLinkedList<String> list = createListOfStrings("a", "b", "c", "c", "b");
        Assert.assertEquals(3, list.lastIndexOf("c"));
        Assert.assertEquals(4, list.lastIndexOf("b"));
        Assert.assertEquals(-1, list.lastIndexOf("k"));
    }


    private <T> MyLinkedList<T> createEmptyList() {
        return new MyLinkedListImpl<T>();
    }

    private MyLinkedList<String> createListOfStrings(String ... args) {
        return new MyLinkedListImpl<>(Arrays.asList(args));
    }
}
