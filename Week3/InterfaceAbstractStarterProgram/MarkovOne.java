
/**
 * Write a description of MarkovOne here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovOne extends AbstractMarkovModel{
    private String myText;
    private Random myRandom;
    
    
    public MarkovOne (int num) {
        
        myRandom = new Random();
        
        nChars = 1;
    }
    
    public MarkovOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 1);
        String key = myText.substring(index, index + 1);
        sb.append(key);
        
        for(int k=0; k < numChars; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            
            int indexFollows = myRandom.nextInt(follows.size());
            String next = follows.get(indexFollows);
            sb.append(next);
            key =  next;
        }
        return sb.toString();
    }

}
