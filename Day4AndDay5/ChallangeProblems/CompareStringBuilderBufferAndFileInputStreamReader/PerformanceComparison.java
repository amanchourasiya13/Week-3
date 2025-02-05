package Day04AndDay05.ChallangeProblems.CompareStringBuilderBufferAndFileInputStreamReader;
import java.io.*;
        import java.util.*;

public class PerformanceComparison {
    // Part 1: StringBuilder vs StringBuffer for concatenation
    public static void testStringConcatenation() {
        String[] words = new String[1000000];
        Arrays.fill(words, "hello");

        // Measure time taken by StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " nanoseconds");

        // Measure time taken by StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (String word : words) {
            sbf.append(word);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " nanoseconds");
    }

    // Part 2: FileReader vs InputStreamReader for reading a file
    public static void testFileReading() throws IOException {
        File file = new File("src/day4/ChallangeProblems/LargeFile.txt"); // Ensure this file exists and is around 100MB
        BufferedReader brFileReader = null;
        BufferedReader brInputStreamReader = null;

        // Measure time taken by FileReader
        long startTime = System.nanoTime();
        brFileReader = new BufferedReader(new FileReader(file));
        String line;
        int wordCountFileReader = 0;
        while ((line = brFileReader.readLine()) != null) {
            wordCountFileReader += line.split("\\s+").length;
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCountFileReader);
        System.out.println("FileReader time: " + (endTime - startTime) + " nanoseconds");

        // Measure time taken by InputStreamReader
        startTime = System.nanoTime();
        brInputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line2;
        int wordCountInputStreamReader = 0;
        while ((line2 = brInputStreamReader.readLine()) != null) {
            wordCountInputStreamReader += line2.split("\\s+").length;
        }
        endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCountInputStreamReader);
        System.out.println("InputStreamReader time: " + (endTime - startTime) + " nanoseconds");

        brFileReader.close();
        brInputStreamReader.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Testing String concatenation with StringBuilder and StringBuffer:");
        testStringConcatenation();

        System.out.println("\nTesting File reading with FileReader and InputStreamReader:");
        testFileReading();
    }
}
