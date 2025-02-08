package Day06_AnalysisBigO_Notation.ProblemStatement.ProblemStatement4.LargeFileReadingEfficiency;

import java.io.*;

public class LargeFileReader {

    // Method to read a file using BufferedReader and FileReader
    public static void readFile(String filePath){
        // Create a BufferedReader object wrapped around a FileReader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read the file line by line until the end
            while ((line = br.readLine()) != null) {
                // Uncomment the following line to print each line read from the file
                // System.out.println(line);
            }
            // The file is automatically closed at the end of the try block
        } catch (IOException e) {
            e.printStackTrace();  // Handle potential I/O exceptions
        }
    }

    // Method to read a file using FileInputStream, InputStreamReader, and BufferedReader
    public static void readFileStream(String filePath, String charsetName){
        // Create a BufferedReader wrapped around an InputStreamReader which is further wrapped around a FileInputStream
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            // Read the file line by line until the end
            while ((line = br.readLine()) != null) {
                // Uncomment the following line to print each line read from the file
                // System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle potential I/O exceptions
        }
    }

    // Method to measure and compare file reading performance using different methods
    public static void FileMethod(String filePath, int num){
        System.out.println("For " + num + " MB files: ");

        // Measure the time taken by BufferedReader with FileReader
        long startTime = System.nanoTime();
        readFile(filePath);  // Call the method to read the file using FileReader and BufferedReader
        long endTime = System.nanoTime();
        long readTime = endTime - startTime;  // Calculate the time difference
        System.out.println("Time for file reader: " + readTime / 1000000.0 + " ms");  // Print the time in milliseconds

        // Measure the time taken by FileInputStream, InputStreamReader, and BufferedReader
        startTime = System.nanoTime();
        String charsetName = "UTF-8";  // Define the encoding format
        readFileStream(filePath, charsetName);  // Call the method to read the file using InputStreamReader and BufferedReader
        endTime = System.nanoTime();
        long streamTime = endTime - startTime;  // Calculate the time difference
        System.out.println("Time for input stream reader: " + streamTime / 1000000.0 + " ms");  // Print the time in milliseconds
    }

    // Main method to execute the performance tests with different file sizes
    public static void main(String[] args) {
        // File paths to test with different sizes of files
        // Example file paths (ensure that these files exist on your system)
        // String filePath = "src/Day06_AnalysisBigO_Notation/ProblemStatement/ProblemStatement4/LargeFileReadingEfficiency/sample.txt";

        // Test for a small 1MB file
        FileMethod("src/Day06_AnalysisBigO_Notation/ProblemStatement/ProblemStatement4/sample.txt", 1);
        // Test for a 100MB file
        FileMethod("src/Day06_AnalysisBigO_Notation/ProblemStatement/ProblemStatement4/sample100mb.txt", 100);
        // Test for a 500MB file
        FileMethod("src/Day06_AnalysisBigO_Notation/ProblemStatement/ProblemStatement4/sample100mb.txt", 500);
    }
}
