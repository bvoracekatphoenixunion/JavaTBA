/*
    Location's are where most of the important information
    in our game is stored. 
    
    Each Location has an integer Array which stores it's coordinates in the world.
    Each Location has an Option which shows which options the player can
    select when they arrive at this Location.
    Each Location has a text String which is displayed to the player when
    they arrive at each Location. 
    
    You could also store enemies in each location, or maybe a store, or a magic sword.
*/

public class Location {
    Option option;
    String text;
    int[] coordinates = new int[2];
    Enemy enemy;
    
    public Location () {
        
    }
    
    public void setCoordinates(int[] coordinates) 
    {
        this.coordinates = coordinates;
    }
    
    public int[] getCoordinates()
    {
        return this.coordinates;
    }
    
    public void setOption(Option option) 
    {
        this.option = option;
    }
    
    public Option getOption()
    {
        return this.option;
    }
    
    public void setText(String text) 
    {
        this.text = text;
    }
    
    public String getText() 
    {
        return this.text;
    }
    
    public void setEnemy(Enemy enemy)
    {
        this.enemy = enemy;
    }
    
    public Enemy getEnemy()
    {
        return this.enemy;
    }
    
}