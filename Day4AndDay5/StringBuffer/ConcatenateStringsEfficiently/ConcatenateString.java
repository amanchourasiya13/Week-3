package Day04AndDay05.StringBuffer.ConcatenateStringsEfficiently;

public class ConcatenateString {
    public static String concatenateStringBuffer(String arr[]) {
        //check if array is emtpy.
        if (arr == null || arr.length == 0) {
            return ""; // Return an empty string if input is null or empty
        }
        // Create a new sbf StringBuffer object and append the string in array.
        StringBuffer sbf = new StringBuffer();
        for (String s : arr) {// trsverse in array.
            sbf.append(s);
        }
        return sbf.toString();
    }
    public static void main(String[] args) {
        // create an string type array arr.
     String []arr={"Hello"," ","World"," !"};
     String result=concatenateStringBuffer(arr); // call the method and store in result.
        System.out.println(result);//print the result.
    }
}
