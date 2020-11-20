
/**
 * Write a description of MarkovOne here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovOne {
    private String myText;
	private Random myRandom;
	
	public MarkovOne() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<String>();
        int pos =0;
        while(true){
            int index = myText.indexOf(key,pos);
            int indexOfFollow = index + key.length();
            
            if(index == -1 || indexOfFollow >= myText.length()){
                break;
            }
            
            String follow = myText.substring(indexOfFollow,indexOfFollow+1);
            follows.add(follow);
            
            pos = index+1;
        }
        return follows;
    
	   }
	
	public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index, index+1);
        sb.append(key);
        
        for(int k=0; k < numChars-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            
            int indexFollows = myRandom.nextInt(follows.size());
            String next = follows.get(indexFollows);
            sb.append(next);
            key = next;
        }
        
        return sb.toString();
    }

}