
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter{
    private Location loc;
    private double maxDistance;
    private String name;
    public DistanceFilter (Location location, double max, String filterName) {
        loc = location;
        maxDistance = max;
        name = filterName;
    }
    
    public boolean satisfies (QuakeEntry qe) {
        Location currentLoc = qe.getLocation();
        if (currentLoc.distanceTo(loc) / 1000.0 < maxDistance) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getName() {
        return name;
    }

}
