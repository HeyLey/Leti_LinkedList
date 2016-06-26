import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testGetHead() {

    }

    @Test
    public void testGetLast() {

    }

    @Test
    public void testContains() {

    }


    @Test
    public void testIterator() {

         /*
            public boolean hasNext() {

            }


            public T next() {

            }


            public void remove() {

            } */
    }

    @Test
    public void testAddAll() {

    }

    @Test
    public void testClear() {

    }

    @Test
    public void testGet() {

    }

    @Test
    public void testSet() {

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

    }

    @Test
    public void testIndexOf() {

    }

    @Test
    public void testLastIndexOf(Object o) {

    }


    private <T> MyLinkedList<T> createEmptyList() {
        return new MyLinkedListImpl<T>();
    }

    private MyLinkedList<String> createListOfStrings(String ... args) {
        return new MyLinkedListImpl<>(Arrays.asList(args));
    }
}
