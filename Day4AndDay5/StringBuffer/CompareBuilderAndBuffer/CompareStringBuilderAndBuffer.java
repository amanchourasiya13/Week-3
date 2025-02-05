package Day04AndDay05.StringBuffer.CompareBuilderAndBuffer;

public class CompareStringBuilderAndBuffer {
    public static void stringBuilder(){

        // Testing StringBuilder Performance
        long startTime,endTime;
        startTime=System.nanoTime();

        //creating an new object of string builder.
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10000;i++){
            sb.append("Hello");
        }

        endTime=System.nanoTime();
        System.out.println("String Builder Time: "+(endTime-startTime)+" ns");
    }

    public static void stringBuffer(){

        //Testing String Buffer Performance
        long startTime,endTime;
        startTime=System.nanoTime();

        //create an new object of string buffer.
        StringBuffer sbf=new StringBuffer();
        for(int i=0;i<100000;i++){
            sbf.append("Hello");
        }
        endTime=System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");

    }
    public static void main(String[] args) {
        stringBuilder();
        stringBuffer();


    }

}