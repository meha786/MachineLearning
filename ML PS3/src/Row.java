import java.util.ArrayList;

/**
 * Created by Meha Verma on 4/8/2017.
 */
public class Row {
    private int label;
    private ArrayList<Double> xList;

    public int getLabel()
    {
        return this.label;
    }

    public void setLabel(int labelInput)
    {
        this.label = labelInput;
    }

    public ArrayList<Double>  getXList()
    {
        return this.xList;
    }

    public void setXList(ArrayList<Double> xListInput)
    {
        this.xList = xListInput;
    }
}
