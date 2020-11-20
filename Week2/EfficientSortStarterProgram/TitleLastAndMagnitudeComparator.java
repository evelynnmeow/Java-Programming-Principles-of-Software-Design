
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>{
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        
        int index1 = q1.getInfo().toString().lastIndexOf(" ");
        String lastWord1 = q1.getInfo().toString().substring(index1 + 1, q1.getInfo().length());
        int index2 = q2.getInfo().toString().lastIndexOf(" ");
        String lastWord2 = q2.getInfo().toString().substring(index2 + 1, q2.getInfo().length());
        
        if (lastWord1.compareTo(lastWord2) < 0) {
            return -1;
        }
        else if (lastWord1.compareTo(lastWord2) > 0) {
            return 1;
        }
        else if (lastWord1.compareTo(lastWord2) == 0) {
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
            
        }
        return 0;
    }
}
