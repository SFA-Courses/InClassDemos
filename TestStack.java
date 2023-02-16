public class TestStack {
    public static void main(String[] args) {
        StackArrayBased<Character> stack = new StackArrayBased<Character>();

        for (char i = 'a'; i <= 'z'; i++) {
            Character num = i;
            stack.push(num);
        }
        System.out.println("Original Stack");
        System.out.println(stack.toString());
        System.out.println();

        System.out.println("Test Pop");
        for (int i = 1; i <= 3; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack);

        System.out.println();
        System.out.println("Test Pop all");
        stack.popAll();
        System.out.println(stack.toString());
    }
}
