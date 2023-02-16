public class StackArrayBased<E> implements Stackable<E> {
    private static final int MAX_STACK = 200;
    private int top;
    private Object[] items;

    public StackArrayBased() {
        this.top = -1; // currently the stack is empty
        this.items = new Object[MAX_STACK];
    }

    @Override
    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == MAX_STACK - 1);
    }

    @Override
    public void push(E item) throws StackException {
        if (this.isFull())
            throw new StackException("Stack is at maximum capacity.");
        else {
            this.top++;
            this.items[top] = item;
        }
    }

    @Override
    public E pop() throws StackException {
        if (this.isEmpty())
            throw new StackException("Stack is empty.");
        else {
            E item = (E) this.items[top];
            this.top--;
            return item;
        }
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = top; i >= 0; i--) {
            s = s + this.items[i].toString();
            if (i != 0)
                s = s + ", ";
        }
        s += "]";
        return s;
    }

    @Override
    public void popAll() {
        this.top = -1;
        this.items = new Object[MAX_STACK]; // not necessary, but allows for garbage collection
    }

    @Override
    public E peek() throws StackException {
        if (this.isEmpty())
            throw new StackException("Stack is empty.");
        else
            return (E) this.items[top];
    }

}
