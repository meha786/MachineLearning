import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Meha Verma on 4/8/2017.
 */
public class PerceptronWithMargin {

    public static ArrayList<Row> readOutputFile() {

        ArrayList<Row> rowsList = new ArrayList<>();
        try {
            FileReader in = new FileReader("C:\\Users\\Meha Verma\\Documents\\MachineLearning\\ML PS3\\src\\output.txt");
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
             //   System.out.println(line);
                String[] splited = line.split("\\s+");

                Row r = new Row();

                String checkLabel = splited[0];

                char classSign = checkLabel.charAt(0);

                if(classSign == '+')
                {
                    r.setLabel(1);
                }else if(classSign == '-')
                {
                    r.setLabel(-1);
                }

                ArrayList<Double> xVectorEachRow = new ArrayList<>();

                for(int i=1;i<splited.length;i++)
                {
                    String s = splited[i];
                    String[] xVectorArray = s.split(":");
                    String partX = xVectorArray[0];
                    Double partXDouble = Double.valueOf(partX);
                    xVectorEachRow.add(partXDouble);
                }

                r.setXList(xVectorEachRow);
                rowsList.add(r);

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return rowsList;
    }





    public static void main(String args[])
    {
        ArrayList<Row> dataSetD1 = readOutputFile();

    }

}
