package day2.problemStackQueue.QueueUsingStack;
//Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
import java.util.Stack;
class QueueUsingStacks {
    private Stack<Integer> stack1; // Stack for enqueue
    private Stack<Integer> stack2; // Stack for dequeue

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (O(1))
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation (Amortized O(1))
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
              throw new RuntimeException("Queue is empty");
            }
            // Move elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation (O(1) amortized)
    public int peek() {
        if (stack2.isEmpty()){
            if (stack1.isEmpty()) {
               throw new RuntimeException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
       System.out.println(queue.peek());    // Output: 2
       System.out.println(queue.dequeue()); // Output: 2
       System.out.println(queue.isEmpty()); // Output: false
    }
}
