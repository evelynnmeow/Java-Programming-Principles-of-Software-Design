
/**
 * Write a description of MarkovModel here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovModel {
    private String myText;
	private Random myRandom;
	private int keyLength;
	
	public MarkovModel(int len) {
		myRandom = new Random();
		keyLength = len;
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
        int index = myRandom.nextInt(myText.length() - keyLength);
        String key = myText.substring(index, index + keyLength);
        sb.append(key);
        
        for(int k=0; k < numChars-4; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            
            int indexFollows = myRandom.nextInt(follows.size());
            String next = follows.get(indexFollows);
            sb.append(next);
            key = key.substring(key.length() - keyLength + 1) + next;
        }
        
        return sb.toString();
    }

}


