/*
    This is our Player Class. It contains all of the information
    about the person who is navigating the World!
    
    Right now the player keeps track of which Location they are in,
    
*/
public class Player {
    
    Location location;
    Option fightOption;
    /* 
        here you would add other attributes to your player Class, 
        such as HP, or perhaps an inventory
    */
    
    //This is the Constructor for the Player Object
    public Player() {
        Option fightOption = new Option();
        fightOption.add("attack");
        fightOption.add("run");
        this.fightOption = fightOption;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public void setFightOption(Option option)
    {
        this.fightOption = option;
    }
    
    public Option getFightOption() 
    {
        return this.fightOption;
    }
    
}
