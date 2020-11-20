
/**
 * Write a description of largestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class largestQuakes {
    public void fildLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("Read data for " + list.size());
        /*
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
        */
       
        //System.out.println("Index of the max magnitude");
        //System.out.println(indexOfLargest(list));
        
        ArrayList<QuakeEntry> highestMagnitude = getLargest(list, 50);
        System.out.println("Highest maginitude");
        for (QuakeEntry qe1 : highestMagnitude) {
            System.out.println(qe1);
        }
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int maxIndex = 0;
        for (int i = 0; i < data.size(); i++) {
            double currentMag = data.get(i).getMagnitude();
            if (currentMag > data.get(maxIndex).getMagnitude()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        for (int i = 0; i < howMany; i++) {
            int maxIndex = indexOfLargest(copy);
            ret.add(copy.get(maxIndex));
            copy.remove(maxIndex);
        }
        return ret;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
