package Day04AndDay05.FileReader.ReadFileLineByLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLine {
    public static void readFile(String filePath){
        //create filereader and wrap  with bufferReader.
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) { // Read line by line
                System.out.println(line); //print each line.
            }
            //File is closed automatically when the try block finishes.
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filePath = "src/day4/FileReader/Sample.txt"; // path to the file.
        readFile(filePath);// call read file.
    }
}

