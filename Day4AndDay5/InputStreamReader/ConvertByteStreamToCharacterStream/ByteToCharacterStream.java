package Day04AndDay05.InputStreamReader.ConvertByteStreamToCharacterStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteToCharacterStream{
    public static void readFile(String filePath,String charsetName){
        // create new bufferReader object,wrap fileInputStream with Input StreamReader and wrap  InputStreamReader with BufferReader.
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {// read line by line.
                System.out.println(line);//print line.
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filePath="src/day4/InputStreamReader/data.txt"; // path to the file.
        String charsetName="UTF-8"; // encoding format.
        readFile(filePath,charsetName);  //call the method.
    }
}