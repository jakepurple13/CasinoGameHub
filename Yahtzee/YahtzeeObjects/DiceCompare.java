package YahtzeeObjects;
import java.util.Comparator;

public class DiceCompare implements Comparator<Dice>
{
    @Override
    public int compare(Dice p1, Dice p2)
    {
        if(p1.getValue()==p2.getValue()) {
            return 0;
        } else if(p1.getValue()>=p2.getValue()) {
        	return 1;
        } else {
        	return -1;
        }
    }
}