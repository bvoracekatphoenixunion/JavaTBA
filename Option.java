import java.util.ArrayList;

/*
    An option is a wrapper for an ArrayList with the 
    ability to select one of the items in it.
    
    This Class is currently used as a way for the player
    to select which options they have at each Location,
    and for the ability to show fighting options for the
    Player. 
*/
public class Option {
    
    ArrayList<String> choices = new ArrayList<String>();
    String selection;
    
    public Option() {
        
    }
    
    public void add(String newOption){
        choices.add(newOption);
    }
    
    public void select(String selection){
        this.selection = selection;
    }
    
    public String getSelection(){
        return this.selection;
    }
    
    @Override
    public String toString(){
        return choices.toString();
    }
    
}
