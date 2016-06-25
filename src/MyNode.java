/**
 * @author LeylaH
 */
public class MyNode<T> {
    T value;
    MyNode link;

    public MyNode(T v, MyNode<T> link) {
        this.value = v;
        this.link = link;
    }

    public MyNode getNext() {
        return link;
    }
}