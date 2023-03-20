public class QueueCircular<E> implements Queueable<E> {
    private Node<E> last;

    public QueueCircular() {
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.last == null);
    }

    @Override
    public void dequeueAll() {
        this.last = null;
    }

    @Override
    public E peek() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty.");
        else {
            Node<E> first = this.last.getNext();
            return first.getItem();
        }
    }

    @Override
    public void enqueue(E newItem) {
        Node<E> node = new Node<E>(newItem);
        if (this.isEmpty()) {
            Node<E> first = node;
            this.last = node;
            this.last.setNext(first);
        } else {
            Node<E> first = this.last.getNext();            
            last.setNext(node);            
            this.last = node;
            this.last.setNext(first);
        }
        
    }

    @Override
    public E dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty!");
        
        Node<E> first = this.last.getNext();
        if (first == last) // signleton list
            this.last = null;
        else{
            Node<E> next = first.getNext();
            this.last.setNext(next);
        }

        return first.getItem();
    }

    @Override
    public String toString() {
        if (this.isEmpty())
             return "[]";

        String s = "[";
        Node<E> current = this.last.getNext(); // first element
        while (current != this.last) {
            s = s + current.getItem().toString() + ", ";
            current = current.getNext();
        }
        s = s + this.last.getItem() + "]";
        return s;
    }
}
