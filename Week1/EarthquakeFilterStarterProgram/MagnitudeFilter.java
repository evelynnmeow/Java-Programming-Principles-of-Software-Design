
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter{
    private double minMag;
    private double maxMag;
    private String name;
    
    public MagnitudeFilter (double min, double max, String filterName) {
        minMag = min;
        maxMag = max;
        name = filterName;
    }
    
    public boolean satisfies (QuakeEntry qe) {
        if (qe.getMagnitude() >= minMag && qe.getMagnitude()<= maxMag) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getName(){
        return name;
    }
    
    

}
