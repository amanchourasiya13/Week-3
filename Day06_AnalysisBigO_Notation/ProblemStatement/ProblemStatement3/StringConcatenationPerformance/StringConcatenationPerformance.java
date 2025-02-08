package Day06_AnalysisBigO_Notation.ProblemStatement.ProblemStatement3.StringConcatenationPerformance;

public class StringConcatenationPerformance {

    // Method that uses String concatenation in a loop (inefficient for large counts)
    public static void stringConcatenation(int counts) {
        String result = "";  // Initialize an empty string
        // Loop to concatenate "ab" to the result string 'counts' number of times
        for (int i = 0; i < counts; i++) {
            result += "ab";  // String concatenation in each iteration
        }
    }

    // Method that uses StringBuilder to concatenate strings (more efficient than String concatenation)
    public static void stringBuilderConcatenate(int counts) {
        StringBuilder sb = new StringBuilder();  // Initialize a StringBuilder object
        // Loop to append "aman" to the StringBuilder 'counts' number of times
        for (int i = 0; i < counts; i++) {
            sb.append("aman");  // Append string to the StringBuilder
        }
    }

    // Method that uses StringBuffer to concatenate strings (similar to StringBuilder, but thread-safe)
    public static void stringBufferConcatenate(int counts) {
        StringBuffer sb = new StringBuffer();  // Initialize a StringBuffer object
        // Loop to append "Hello" to the StringBuffer 'counts' number of times
        for (int i = 0; i < counts; i++) {
            sb.append("Hello");  // Append string to the StringBuffer
        }
    }

    // Run all three methods and measure the time taken for each approach
    public static void run(int counts) {
        // Measure time for String concatenation
        long startTime = System.nanoTime();  // Start time measurement
        stringConcatenation(counts);  // Call the String concatenation method
        long endTime = System.nanoTime();  // End time measurement
        long stringTime = endTime - startTime;  // Calculate the elapsed time
        System.out.println("\nTotal Time taken by string for " + counts + " is: " + stringTime / 1000000.0 + " ms");

        // Measure time for StringBuilder concatenation
        startTime = System.nanoTime();  // Start time measurement
        stringBuilderConcatenate(counts);  // Call the StringBuilder concatenation method
        endTime = System.nanoTime();  // End time measurement
        long builderTime = endTime - startTime;  // Calculate the elapsed time
        System.out.println("Total time taken by string builder for " + counts + " is: " + builderTime / 1000000.0 + " ms");

        // Measure time for StringBuffer concatenation
        startTime = System.nanoTime();  // Start time measurement
        stringBufferConcatenate(counts);  // Call the StringBuffer concatenation method
        endTime = System.nanoTime();  // End time measurement
        long bufferTime = endTime - startTime;  // Calculate the elapsed time
        System.out.println("Total time taken by String Buffer for " + counts + " is: " + bufferTime / 1000000.0 + " ms");
    }

    public static void main(String[] args) {
        // Run the test for different counts to compare the performance of each method
        run(1000);    // Test with 1000 iterations
        run(10000);   // Test with 10,000 iterations
        run(100000);  // Test with 100,000 iterations
    }
}
