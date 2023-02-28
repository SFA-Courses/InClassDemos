public class TestQueueArrayBased {
    public static void main(String[] args) {
        QueueArrayBased<Integer> queue = new QueueArrayBased<Integer>();

        for (int i = 30; i <= 76; i++) 
            queue.enqueue(i);
        System.out.println("After enqueue: ");
        System.out.println(queue);
        System.out.println(queue.peek());

        for (int i = 1; i <= 40; i++) {
            int num = queue.dequeue();
            if (num % 10 == 0)
                System.out.println(num);
        }
        System.out.println();
        System.out.println("After Dequeue");
        System.out.println(queue);

        System.out.println();
        System.out.println("Is Empty: " + queue.isEmpty());
        queue.dequeueAll();
        System.out.println("Is Empty: " + queue.isEmpty());

        
    }
    
}
