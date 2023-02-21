public class StackReferenceBased<E> implements Stackable<E> {
    private Node<E> top;

    public StackReferenceBased() {
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.top == null);
    }

    @Override
    public void push(E item) {
        Node<E> currentTop = this.top;
        Node<E> newNode = new Node<E>(item);
        this.top = newNode;
        newNode.setNext(currentTop);
    }

    @Override
    public E pop() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Stack is empty.");
        } else {
            E item = this.top.getItem();
            this.top = this.top.getNext();
            return item;
        }
    }

    @Override
    public void popAll() {
        this.top = null;
    }

    @Override
    public E peek() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Stack is empty.");
        } else {
            return this.top.getItem();
        }
    }

    @Override
    public String toString() {
        String s = "[";
        Node<E> current = this.top;
        while (current != null) {
            s = s + current.getItem().toString();
            current = current.getNext();
            if (current != null)
                s = s + ", ";
        }
        s += "]";
        return s;
    }   

}