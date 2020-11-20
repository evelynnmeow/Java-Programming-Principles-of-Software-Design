
/**
 * Write a description of MarkovModel here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovModel extends AbstractMarkovModel {
    private int keyLength;
    private String myText;
    private Random myRandom;
    
    public MarkovModel(int len) {
        myRandom = new Random();
        keyLength = len;
        nChars = len;
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
        int index = myRandom.nextInt(myText.length() - keyLength);
        String key = myText.substring(index, index + keyLength);
        sb.append(key);
        
        for(int k=0; k < numChars-keyLength; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            
            int indexFollows = myRandom.nextInt(follows.size());
            String next = follows.get(indexFollows);
            sb.append(next);
            key = key.substring(1) + next;
        }
        
        return sb.toString();
    }

}


