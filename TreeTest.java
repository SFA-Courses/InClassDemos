import java.util.Scanner;

public class TreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();        
        
        for (int i = 0; i < 12; i++) {
            tree.add((int) (Math.random() * 25));                        
        }

        System.out.println(tree.toString());
        System.out.println();
        
        System.out.println("Num Elements: " + tree.numElements());
        System.out.println("Height: " + tree.height());
        System.out.println("Max: " + tree.max());
        System.out.println("Min: " + tree.min());
        //System.out.println("In Order: " + tree.inOrder());
        //System.out.println("Pre Order: " + tree.preOrder());
        //System.out.println("Post Order: " + tree.postOrder());

        // System.out.println("Enter a number to remove: ");
        // Scanner console = new Scanner(System.in);
        // int num = console.nextInt();
        // tree.remove(num);
        // console.close();
        // System.out.println(tree.inOrder());
        // System.out.println(tree.toString());

    }
}


