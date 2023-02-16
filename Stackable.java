public interface Stackable<E> {
    public boolean isEmpty();
    public void push(E item);
    public E pop() throws StackException;
    public void popAll();
    public E peek() throws StackException;
}
