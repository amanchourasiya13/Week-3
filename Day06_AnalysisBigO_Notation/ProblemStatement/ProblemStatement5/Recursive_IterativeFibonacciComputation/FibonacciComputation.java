package Day06_AnalysisBigO_Notation.ProblemStatement.ProblemStatement5.Recursive_IterativeFibonacciComputation;

public class FibonacciComputation {

    // Recursive method to compute the nth Fibonacci number
    public static int fibonacciRecursive(int n){
        // Base case: If n is 0 or 1, return n
        if(n <= 1) return n;
        // Recursive case: Sum the results of the two previous Fibonacci numbers
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative method to compute the nth Fibonacci number
    public static int fibonacciIterative(int n){
        int a = 0, b = 1, sum;
        // Iterate from 2 to n to calculate Fibonacci numbers
        for(int i = 2; i <= n; i++){
            sum = a + b;  // Calculate the next Fibonacci number
            a = b;        // Update the first number to the second
            b = sum;      // Update the second number to the new sum
        }
        return b;  // Return the nth Fibonacci number
    }

    // Method to run both the recursive and iterative Fibonacci methods and measure execution time
    public static void fibonacciMethod(int n){

        // Measure time taken by the iterative Fibonacci method
        long startTime = System.nanoTime();
        fibonacciIterative(n);  // Call the iterative Fibonacci method
        long endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;  // Calculate the time taken
        // Print the time taken for the iterative method in milliseconds
        System.out.println("Total time for iterative fibonacci for: " + n + " fibonacci is: " + iterativeTime / 1000000.0 + " ms");

        // Measure time taken by the recursive Fibonacci method
        startTime = System.nanoTime();
        fibonacciRecursive(n);  // Call the recursive Fibonacci method
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;  // Calculate the time taken
        // Print the time taken for the recursive method in milliseconds
        System.out.println("Total time for recursive fibonacci for: " + n + " fibonacci is: " + recursiveTime / 1000000.0 + " ms");
    }

    // Main method to test the Fibonacci methods with different values of n
    public static void main(String[] args) {
        // Test for the 10th Fibonacci number
        fibonacciMethod(10);
        // Test for the 30th Fibonacci number
        fibonacciMethod(30);
        // Test for the 50th Fibonacci number
        fibonacciMethod(50);
    }
}
