public class QueueArrayBased<E> implements Queueable<E> {
    private Object[] queueArray;
    private int size;

    private final static int MAX_QUEUE = 50;

    // create an empty queue
    public QueueArrayBased() {
        this.size = 0;
        this.queueArray = new Object[MAX_QUEUE];
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public void dequeueAll() {
        this.size = 0;
        this.queueArray = new Object[MAX_QUEUE];
    }

    @Override
    public E peek() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty.");
        else {
            return (E) this.queueArray[0];
        }
    }

    @Override
    public void enqueue(E newItem) throws QueueException {
        if (this.size == MAX_QUEUE)
            throw new QueueException("Queue is full!");
        else {            
            this.queueArray[size] = newItem;
            this.size++;
        }
    }

    @Override
    public E dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty.");

        E firstItem = (E) this.queueArray[0];
        for (int i = 0; i < size; i++) 
            this.queueArray[i] = this.queueArray[i+1];

        this.size--;
        return firstItem;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s = s + this.queueArray[i].toString();
            if (i != size-1)
                s = s + ", ";
        }
        s = s + "]";
        return s;
    }
}
