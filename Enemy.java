
public class Enemy {
    
    Location location;

    /* 
        here you would add other attributes to your enemy Class, 
        such as HP, or perhaps an inventory
    */
    
    //This is the Constructor for the Player Object
    public Enemy() {
    
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
}
