import java.util.*;

/**
 * @autor LeylaH
 */

public class MyLinkedList<T> implements LinkedList<T> {

    /**
     * Pointer to first node.
     */
    MyNode<T> head = null;
    MyNode<T> last = null;
    private int size = 0;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param  c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public MyLinkedList(Collection<? extends T> c) {
        this();
        addAll(c);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(head == null) {
            return false;
        }
        return true;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public T getHead() {
        final MyNode<T> h = head;
        if (h == null) {
            throw new NoSuchElementException();
        }
        return h.value;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */

    public T getLast() {
        final MyNode<T> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.value;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (MyNode<T> node = head; node != null; node = node.next) {
                if (node.value == null)
                    return index;
                index++;
            }
        } else {
            for (MyNode<T> node = head; node != null; node = node.next) {
                if (o.equals(node.value))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list
     *         in proper sequence
     */
    @Override
    public Object[] toArray(Object[] a) {
        Object[] result = new Object[size];
        int i = 0;
        for (MyNode<T> node = head; node != null; node = node.next) {
            result[i++] = node.value;
        }
        return result;
    }
}

