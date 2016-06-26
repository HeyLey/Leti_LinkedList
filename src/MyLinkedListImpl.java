import java.util.*;

/**
 * @autor LeylaH
 */

public class MyLinkedListImpl<T> extends AbstractList<T> implements MyLinkedList<T> {

    /**
     * Pointer to first node.
     */
    MyNode<T> head = null;
    /**
     * Pointer to last node.
     */
    MyNode<T> last = null;
    private int size = 0;

    /**
     * Constructs an empty list.
     */
    public MyLinkedListImpl() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param  c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public MyLinkedListImpl(Collection<? extends T> c) {
        addAll(c);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     */
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
    @Override
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
    @Override
    public T getLast() {
        final MyNode<T> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.value;
    }

    private void checkIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns a iterator of the elements in this list.
     *
     * @return a Iterator of the elements in this list (in proper
     *         sequence), starting at the specified position in the list
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode<T> next = head;
            MyNode<T> current = null;
            MyNode<T> previous = null;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                T value = next.value;
                if (current != null) {
                    previous = current;
                }
                current = next;
                next = next.next;
                return value;
            }

            @Override
            public void remove() {
                if (current == null) {
                    throw new IllegalStateException();
                }

                if (previous == null) {
                    head = next;
                    next = next.next;
                } else {
                    previous.next = next;
                    next = next.next;
                }
                current = null;
            }
        };
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e the element to add
     */
    @Override
    public boolean add(T e) {
        final MyNode<T> l = last;
        final MyNode<T> newNode = new MyNode<>(e, null);
        last = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }


    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.
     *
     * @param c collection containing elements to be added to this list
     * @return {@code true}
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(Collection c) {
        for (Object value: c) {
            add((T) value);
        }
        return true;
    }


    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        head = last = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return element at index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
        checkIndex(index);
        MyNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        T oldValue = node.value;
        node.value = element;
        return oldValue;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, T element) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        } else if (index == 0) {
            head = new MyNode<>(element, head);
            size++;
        } else {
            MyNode<T> prev = null;
            MyNode<T> current = head;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            MyNode<T> node = new MyNode<>(element, head);

            prev.next = node;
            node.next = current;

            size++;
        }
    }

    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            T value = head.value;
            head = head.next;
            size--;
            if (size == 0) {
                last = null;
            }
            return value;
        } else {
            MyNode<T> prev = null;
            MyNode<T> current = head;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            T value = current.value;
            prev.next = current.next;

            if (current == last) {
                last = prev;
            }
            size--;

            return value;
        }

    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (MyNode<T> node = head; node != null; node = node.next) {
                if (node.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (MyNode<T> node = head; node != null; node = node.next) {
                if (o.equals(node.value)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int index = 0;
        if (o == null) {
            for (T value : this) {
                if (value == null) {
                    lastIndex = index;
                }
                index++;
            }
        } else {
            for (T value : this) {
                if (o.equals(value)) {
                    lastIndex = index;
                }
                index++;
            }
        }
        return lastIndex;
    }

    static private class MyNode<T> {
        T value;
        MyNode<T> next;

        MyNode(T v, MyNode<T> next) {
            this.value = v;
            this.next = next;
        }
    }

}

