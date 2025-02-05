package Day04AndDay05.FileReader.CountOccurenceOfWord;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WordCountInFile{
    public static int wordCountOccurencesInFile(String filePath,String target){
        int count=0; // initialize count as 0.

        //create file Reader and  buffer with buffer reader.
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;
            while((line=br.readLine())!=null){// read line by line.
               String[]words=line.split("\\s+") ;//Split line into words (by spaces or multiple spaces)
               for(String word:words){ //traverse in words array.
                   if(word.equalsIgnoreCase(target)){
                       count++;  // update the value of count.
                   }
               }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return count;  //
    }
    public static void main(String[] args) {
        String filePath="src/day4/FileReader/sample.txt";// path to the file.
        String target="This"; // target word to count.
       int occurences=wordCountOccurencesInFile(filePath,target);// call the method and stores result.
        System.out.println("The word "+target+" occurs "+occurences+" times in file.");//print the output.
    }
}