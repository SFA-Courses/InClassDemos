public class Node<E> {
    private E item; 
    private Node<E> nextNode;

    public Node(E nodeItem) {
        this.item = nodeItem;
        this.nextNode = null;
    }

    public E getItem() {
        return this.item;
    }

    public Node<E> getNext() {
        return this.nextNode;
    }

    public void setNext(Node<E> next) {
        this.nextNode = next;
    }
    @Override
    public String toString() {
        if (this.nextNode == null) 
            return "(" + item.toString() + ")";
        else
            return "(" + item.toString() + ", " + this.nextNode.toString() + ")";
    }
}
