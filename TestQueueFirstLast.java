public class TestQueueFirstLast {
    public static void main(String[] args) {
        QueueFirstLast<String> line = new QueueFirstLast<String>();

        String[] names = new String[]{"Tony", "Bruce", "Natasha", "Scott", "Wanda", "Stephen"};
        for (String name : names) {
            line.enqueue(name);
        }
        System.out.println("After Enqueue: ");
        System.out.println(line);
        System.out.println();

        System.out.println("Test Dequeue: ");
        for (int i = 0; i < 3; i++)
            System.out.println(line.dequeue());            
        System.out.println(line);
        System.out.println(        );

        System.out.println("Test Peek:");
        System.out.println(line.peek());
        System.out.println();

        System.out.println("Test Dequeue All");
        line.dequeueAll();
        System.out.println(line);
        System.out.println("Is Empty: " + line.isEmpty());
    }
    
}
