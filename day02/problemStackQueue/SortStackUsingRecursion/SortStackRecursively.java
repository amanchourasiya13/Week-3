package day2.problemStackQueue.SortStackUsingRecursion;
//Problem: Given a stack, sort its elements in ascending order using recursion
import java.util.Stack;

public class SortStackRecursively{

    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Pop the top element
            int temp = stack.pop();

            // Recursively sort the remaining stack
            sortStack(stack);

            // Insert the popped element back in sorted order
            insertInSortedOrder(stack, temp);
        }
    }

    // Helper function to insert an element in sorted order
   private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // If stack is empty or element is greater than the top, push it
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        // Pop the top element and recursively insert the current element
        int temp = stack.pop();
        insertInSortedOrder(stack, element);

        // Push the popped element back
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        System.out.println("Original Stack: " + stack);
        // Sort the stack
        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

