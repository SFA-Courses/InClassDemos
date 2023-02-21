public class TestStackRef {
    public static void main(String[] args) {
        StackReferenceBased<Character> stack = new  StackReferenceBased<Character>();
        
        for (char i = 'a'; i <= 'z'; i++) {
            Character num = i;
            stack.push(num);
        }
        System.out.println("Original Stack");
        System.out.println(stack.toString());
        System.out.println();

        System.out.println("Test Pop");
        for (int i = 1; i <= 5; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack);

        System.out.println();
        System.out.println("Test Pop all");
        stack.popAll();
        System.out.println(stack.toString());
    }
}
