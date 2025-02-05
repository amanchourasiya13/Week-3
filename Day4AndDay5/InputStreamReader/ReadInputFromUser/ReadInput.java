package Day04AndDay05.InputStreamReader.ReadInputFromUser;

import java.io.*;
public class ReadInput {

    public static void main(String[] args) {
        // Define the output file name
        String filename = "src/day4/InputStreamReader/data.txt";

        try (
            // Create an InputStreamReader to read from System.in
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            // Wrap it in a BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // Create a FileWriter to write to the file
            FileWriter fileWriter = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            System.out.println("Enter text (type 'exit' to quit):");

            String userInput;
            while ((userInput = bufferedReader.readLine()) != null) {
                // Check for exit condition
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                // Write the input to the file followed by a new line
                bufferedWriter.write(userInput);
                bufferedWriter.newLine();
            }
            System.out.println("User input saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}