import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Meha Verma on 4/8/2017.
 */
public class PerceptronWithMargin {

    static int largestXValue = Integer.MIN_VALUE;

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

                    if(xVectorEachRow.size() > largestXValue)
                    {
                        largestXValue = xVectorEachRow.size();
                    }
                }



                r.setXList(xVectorEachRow);
                rowsList.add(r);

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return rowsList;
    }


    private static ArrayList<Double> calculateWByPerceptron(ArrayList<Row> dataSetRows) {
        ArrayList<Double> wVector = new ArrayList<>();

        for (int i=0;i<largestXValue;i++)
        {
            wVector.add(0.0);
        }
        double b = 0;
        int t = 0;
        int T = 20;

        int gama = 1;
        double eta[] = new double[]{1.5, 0.25, 0.03, 0.005, 0.001};


        for (int e=0; e<eta.length;e++)
        {
            for (t=0;t<T;t++)
            {
                for (Row r : dataSetRows)
                {
                    int y = r.getLabel();

                    ArrayList<Double> xVector = r.getXList();

                    double sumOfProduct = 0;
                    for (int i=0;i<xVector.size();i++)
                    {
                        Double w = wVector.get(i);
                        Double xValue = xVector.get(i);

                        sumOfProduct = sumOfProduct + (w * xValue);
                    }


                    if(( y * (sumOfProduct + b)) <= gama)
                    {
                        for(int i=0;i<xVector.size();i++)
                        {

                            double newValue =  wVector.get(i) + (eta[e] * (xVector.get(i)) * y);
                            wVector.set(i,newValue);
                            b = b + eta[e] * y;

                        }
                    }

                }

            }

            System.out.println("wVector with " + eta[e] );

            for (int i=0; i<wVector.size();i++)
            {
                System.out.print(wVector.get(i));
            }

            System.out.println("\n");

        }

        return wVector;

    }


    public static void main(String args[])
    {

        ArrayList<Row> dataSetD1 = readOutputFile();

        ArrayList<Double> learnedWVector = calculateWByPerceptron(dataSetD1);

        System.out.println();

    }



}
