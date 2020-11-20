
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    private String where;
    private String phrase;
    private String name;
    public PhraseFilter (String w, String p, String filterName) {
        where = w;
        phrase = p;
        name = filterName;
    }
    
    public boolean satisfies (QuakeEntry qe) {
        if (where == "start") {
            return qe.getInfo().startsWith(phrase);
        }
        else if (where == "end") {
            return qe.getInfo().endsWith(phrase);
        }
        else if (where == "any") {
            return qe.getInfo().contains(phrase);
        }
        else{
            return false;
        }
            
    }
    
    public String getName() {
        return name;
    }

}
