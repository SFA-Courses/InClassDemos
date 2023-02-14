public class FriendsList extends ListADT<Friend> {
    private Node<Friend> head;
    private int numFriends;

    public FriendsList() {
        this.numFriends = 0;
        this.head = null;
    }

    public FriendsList(Friend firstFriend) {
        this.numFriends = 1;
        this.head = new Node<Friend>(firstFriend);
    }

    @Override
    public boolean isEmpty() {
        return (this.numFriends == 0);
        // other way
        // return (this.head == null);
    }

    @Override
    public int getSize() {
        return this.numFriends;
    }

    private Node<Friend> getNodeAt(int index) {
        // 0 - return this.head
        // 1 - return
        // this.head.getNext();
        // 2 - return
        Node<Friend> node = this.head;
        for (int k = 1; k <= index; k++)
            node = node.getNext();

        return node;
    }

    @Override
    public Friend get(int index) throws ListException {
        if (index < 0 || index >= this.getSize())
            throw new ListException("Index " + index + " is invalid for a list of size " + this.getSize());

        Node<Friend> node = this.getNodeAt(index);
        return node.getItem();
    }

    @Override
    public void add(int index, Friend newFriend) throws ListException {
        if (index < 0 || index > this.getSize())
            throw new ListException("Index " + index + " is invalid for a list of size " + this.getSize());

        Node<Friend> node = new Node<Friend>(newFriend);
        if (index == 0) {
            node.setNext(this.head);
            this.head = node;
        } else {

            Node<Friend> previous = this.getNodeAt(index - 1);
            Node<Friend> current = previous.getNext();

            previous.setNext(node);
            node.setNext(current);
        }
        this.numFriends++;

    }

    @Override
    public void remove(int index) throws ListException {
        if (index < 0 || index >= this.getSize())
            throw new ListException("Index " + index + " is invalid for a list of size " + this.getSize());

        if (index == 0) { // removing the head
            this.head = this.head.getNext();
        } else {

            Node<Friend> previous = this.getNodeAt(index - 1);
            Node<Friend> nodeToRemove = previous.getNext();
            Node<Friend> nodeAfter = nodeToRemove.getNext();

            previous.setNext(nodeAfter);
            nodeToRemove.setNext(null);
        }
        this.numFriends--;
    }

    @Override
    public void removeAll() {
        this.numFriends = 0;
        this.head = null;
    }

    @Override
    public String toString() {
        String s = "[";
        if (this.getSize() > 0) {
            Node<Friend> current = this.head;
            for (int i =0; i < this.getSize()-1; i++) {
                s = s + current.getItem().toString() + ", ";
                current = current.getNext();
            }
            s = s + current.getItem().toString();
        }
        
        return s + "]";
    }

    
    public int getPosition(Friend listItem) {
        Node<Friend> current = this.head;
        Friend currentFriend = current.getItem();
        if (currentFriend.equals(listItem)) 
            return 0;
        
        for (int i = 1; i < this.getSize(); i++) {
            current = current.getNext();
            currentFriend = current.getItem();
            if (currentFriend.equals(listItem)) 
                return i;
        }
        
        return -1; 
    }

}
