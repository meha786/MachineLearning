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
                System.out.println(line);

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
