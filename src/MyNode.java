/**
 * @author LeylaH
 */
public class MyNode<T> {
    T value;
    MyNode<T> next;

    public MyNode(T v, MyNode<T> next) {
        this.value = v;
        this.next = next;
    }
}