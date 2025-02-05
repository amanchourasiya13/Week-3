package Day04AndDay05.LinearSearch.SearchSpecificWord;

public class LinearSearch {

    // Method to search for a specific word in a list of sentences
    public static String searchWordInSentences(String[] sentences, String word) {
        // Iterate through the array of sentences
        for (String sentence : sentences) {
            // Check if the sentence contains the specific word
            if (sentence.contains(word)) {
                return sentence; // Return the first sentence that contains the word
            }
        }
        return "Not Found"; // If no sentence contains the word, return "Not Found"
    }

    public static void main(String[] args) {
        // Example list of sentences
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Hello world, this is a test.",
                "The weather is nice today.",
                "I love programming with Java!"
        };

        // Word to search for
        String word = "test";

        // Call the method and print the result
        String result = searchWordInSentences(sentences, word);
        System.out.println(result);  // Output: "Hello world, this is a test."
    }
}
