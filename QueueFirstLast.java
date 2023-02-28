public class QueueFirstLast<E> implements Queueable<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueFirstLast() {
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.first == null); // also could do this.last == null
    }

    @Override
    public void dequeueAll() {
        this.first = null;
        this.last = null;
    }

    @Override
    public E peek() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty!");
        else {
            return this.first.getItem();
        }
    }

    @Override
    public void enqueue(E newItem) {
        Node<E> newNode = new Node<E>(newItem);
        if (this.isEmpty()) {
            this.first = newNode;            
        } else {
            this.last.setNext(newNode);            
        }
        this.last = newNode;
    }

    @Override
    public E dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty.");
        else {
            Node<E> next = this.first.getNext();
            E front = this.first.getItem();
            this.first = next;
            return front;
        }
    }

    @Override
    public String toString() {
        String s = "[";
        Node<E> current = this.first;
        while (current != null) {
            s = s + current.getItem().toString();
            if (current.getNext() != null)
                s += ", ";

            current = current.getNext();
        }
        return s + "]";
    }
}
