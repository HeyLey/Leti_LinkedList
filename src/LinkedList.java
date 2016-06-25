import java.util.List;
import java.util.NoSuchElementException;

interface LinkedList<T> extends List<T> {

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    T getHead();

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    T getLast();
}
