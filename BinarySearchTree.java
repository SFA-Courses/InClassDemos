
public class BinarySearchTree<T extends Comparable<T>> {
    private T root;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    // create an empty tree
    public BinarySearchTree() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    // create a 1 - node tree
    public BinarySearchTree(T rootOfTree) {
        this.root = rootOfTree;
        // make the right and left empty trees
        this.left = new BinarySearchTree<T>();
        this.right = new BinarySearchTree<>();
    }

    public boolean isEmpty() {
        return (this.root == null);
    }

    public int height() {
        if (this.isEmpty())
            return 0;
        else {
            int heightLeft = this.left.height();
            int heightRight = this.right.height();
            return 1 + Math.max(heightLeft,heightRight);
        }
    }

    public int numElements() {
        if (this.isEmpty())
            return 0;
        else {
            int numLeft = this.left.numElements();
            int numRight = this.right.numElements();
            return 1 + numLeft + numRight;
        }
    }

    public T min() {
        if (this.left.isEmpty())
            return this.root;
        else 
            return this.left.min();
    }

    public T max() {
        if (this.right.isEmpty())
            return this.root;
        else 
            return this.right.max();
    }

    // add an item to the BST
    public void add(T item) {
        if (this.isEmpty()) {
            this.root = item;
            this.left = new BinarySearchTree<T>(); // empty tree;
            this.right = new BinarySearchTree<T>(); // empty tree
        } else {
            // compare < 0   -> item < this.root
            // compare = 0  -> item = this.root
            // compare > 0  -> item > this.root
            int compare = item.compareTo(this.root);
            if (compare < 0) 
                this.left.add(item);
            else // compare >= 0
                this.right.add(item);
        }
    }

    public String inOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += this.left.inOrder();
            s += " " + this.root.toString() + " ";
            s += this.right.inOrder();
        }
        return s;
    }

    public String preOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += " " + this.root.toString() + " ";
            s += this.left.preOrder();            
            s += this.right.preOrder();
        }
        return s;
    }

    public String postOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += this.left.postOrder();            
            s += this.right.postOrder();
            s += " " + this.root.toString() + " ";
        }
        return s;
    }




    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        if (!this.isEmpty())
            buildTreeString(buffer, "", "");
        return buffer.toString();
    }
    
    private void buildTreeString(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.root.toString());
        buffer.append('\n');
        if (!this.left.isEmpty()) 
            if (!this.right.isEmpty())
                left.buildTreeString(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            else
                left.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
        
        if (!this.right.isEmpty())
            right.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
    }
}
