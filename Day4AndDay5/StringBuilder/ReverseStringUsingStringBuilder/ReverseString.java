package Day04AndDay05.StringBuilder.ReverseStringUsingStringBuilder;

public class ReverseString {
    public static String reverse(String str){
        // Create a new StringBuilder object and append the str string
        StringBuilder sb=new StringBuilder();
        sb.append(str);

        // Use the reverse() method
        sb.reverse();

        // Convert StringBuilder back to a string and return
        return sb.toString();
    }
    public static void main(String[] args) {
//        // create String str.
        String str="Hello";
        String reversed=reverse(str);// call reversed string.
        System.out.println("Real String: "+str);
        System.out.println("Reversed String: "+reversed);// print reversed string.
    }
}
