import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        /*
        Filter f = new MinMagFilter(4.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } 
        */
        /*
        Filter magFilter = new MagnitudeFilter(4.0, 5.0);
        Filter depFilter = new DepthFilter(-35000.0, -12000.0);
        ArrayList<QuakeEntry> qeByMag = filter(list, magFilter);
        ArrayList<QuakeEntry> qeByMagDep = filter(qeByMag, depFilter);
        for (QuakeEntry qe : qeByMagDep) {
            System.out.println(qe);
        }
        */
        
        Location japan = new Location(35.42, 139.43);
        Filter disFilter = new DistanceFilter(japan, 10000000.0, "distance");
        Filter phraFilter = new PhraseFilter ("end", "Japan", "phrase");
        ArrayList<QuakeEntry> qeByDis = filter(list, disFilter);
        ArrayList<QuakeEntry> qeByDisPhra = filter(qeByDis, phraFilter);
        for (QuakeEntry qe: qeByDisPhra) {
            System.out.println(qe);
        }
    }
    
    public void testMatchAllFilter() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilter maf = new MatchAllFilter();
        Filter f = new MagnitudeFilter(1.0, 4.0, "magnitude");
        maf.addFilter(f);
        
        f= new DepthFilter(-180000.0, -30000.0, "depth");
        maf.addFilter(f);
        f = new PhraseFilter("any", "o", "phrase");
        maf.addFilter(f);
        
        
        ArrayList<QuakeEntry> answer = filter(list, maf);
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }
        
        System.out.println("Number of earthquakes that match the criteria: " + answer.size());
        System.out.println("Filters used are: " + maf.getName());
        
    }
    
    public void testMatchAllFilter2(){
        String source = "data/nov20quakedata.atom";
        EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilter maf = new MatchAllFilter();
        Filter f1 = new MagnitudeFilter(0.0, 5.0, "magnitude");
        maf.addFilter(f1);
        Location billund = new Location(55.7308, 9.1153);
        Filter f2 = new DistanceFilter(billund,  3000000, "distance");
        maf.addFilter(f2);
        Filter f3 = new PhraseFilter("any", "e", "phrase");
        maf.addFilter(f3);
        ArrayList<QuakeEntry> result = filter(list, maf);
        for(QuakeEntry qe: result){
            System.out.println(qe);
        }
        
        System.out.println("Number of earthquakes that match the criteria: " + result.size());
        System.out.println("Filters used are: " + maf.getName());
    }
    
    public void quiz() {
        
        String source = "data/nov20quakedata.atom";
        EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        
        Location Japan = new Location (35.42, 139.43);
        MatchAllFilter maf = new MatchAllFilter();
        Filter f2 = new MagnitudeFilter(4.0, 5.0, "magnitude");
        maf.addFilter(f2);
        Filter f3 = new DepthFilter(-35000.0, -12000.0, "depth");
        maf.addFilter(f3);
        //Filter f1 = new PhraseFilter("last", "Japan", "phrase");
        //maf.addFilter(f1);
        ArrayList<QuakeEntry> result = filter(list, maf);
        for(QuakeEntry qe: result){
            System.out.println(qe);
        }
        System.out.println("Number of earthquakes that match the criteria: " + result.size());
        System.out.println("Filters used are: " + maf.getName());
    }
    
    public void reviewQuiz() {
        String source = "data/nov20quakedata.atom";
        EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        MatchAllFilter maf = new MatchAllFilter();
        Filter f3 = new DepthFilter(-55000.0, -20000.0, "depth");
        maf.addFilter(f3);
        Filter f4 = new MagnitudeFilter(3.5, 4.5, "magnitude");
        maf.addFilter(f4);
        //Location Denvor = new Location (39.7392, -104.9903);
        
        //Filter f2 = new DistanceFilter(Denvor,  1000000, "distance");
        //maf.addFilter(f2);
        //Filter f1 = new PhraseFilter("end", "a", "phrase");
        //maf.addFilter(f1);
        ArrayList<QuakeEntry> result = filter(list, maf);
        for(QuakeEntry qe: result){
            System.out.println(qe);
        }
        System.out.println("Number of earthquakes that match the criteria: " + result.size());
        System.out.println("Filters used are: " + maf.getName());
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
