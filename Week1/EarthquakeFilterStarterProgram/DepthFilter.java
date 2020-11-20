
/**
 * Write a description of DepthFilter here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter {
    private double minDepth;
    private double maxDepth;
    private String name;
    
    public DepthFilter (double min, double max, String filterName) {
        minDepth = min;
        maxDepth = max;
        name = filterName;
    }
    
    public boolean satisfies (QuakeEntry qe) {
        if (qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth) {
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
