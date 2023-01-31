public abstract class ListADT<E> {
    public abstract boolean isEmpty();
    public abstract int getSize();
    public abstract void add(int index, E item);
    public abstract void remove(int index);
    public abstract void removeAll();
    public abstract E get(int index);

}