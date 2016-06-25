/**
 * @author LeylaH
 */
public class MyNode<T> {
    T value;
    MyNode next;

    public MyNode(T v, MyNode<T> next) {
        this.value = v;
        this.next = next;
    }
}