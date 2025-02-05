package Day04AndDay05.StringBuilder.RemoveDuplicateFromStringUsingStringBuilder;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        // Create a StringBuilder and HashSet to track unique characters
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!hs.contains(c)) { //check if character is not repeated-
                sb.append(c); // append it and
                hs.add(c);   // add in hashset
            }
        }
        return  sb.toString();// Convert the StringBuilder back to a string and return it.
    }

    public static void main(String[] args) {
        //create sc object for taking input from user.
     Scanner sc=new Scanner(System.in);
        System.out.print("Enter a String to remove duplicates: ");
        String str=sc.next(); // taking string input from user.
        String result=removeDuplicates(str); //call removeDuplicates methods and store in result.
        System.out.println("String after removing duplicates: "+result);//print the result.
    }
}




