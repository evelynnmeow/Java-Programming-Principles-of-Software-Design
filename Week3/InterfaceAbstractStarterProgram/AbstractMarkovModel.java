
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int nChars;
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key){
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

}
