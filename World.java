/*
    The World is where all of the action happens.
    A World has a 2D Location Array which stores all of the locations
    in our Game. Each Location holds information about what is located there

    Our Player and a startingLocation are two other variables a World keeps track of
        
    The bulk of game play happens in the gameLoop method.
    I started a combatLoop method where combat can happen.
    
    You might be interested in creating a shoppingLoop if you'd like to make a store,
    or you can come up with whatever else sounds interesting!
*/

public class World extends ConsoleProgram {
    Location[][] myWorld = new Location[3][3];
    Player player;
    Location startingLocation;

    public World () {
        /*
            Creating a world is creating a bunch of locations and options of things
            you can do in those locations.
            
            Right now there are only two locations.
        */
        
        //location 0,0
        Location location00 = new Location();
        int[] coordinates00 = {0,0};
        Option option00 = new Option();
        option00.add("north");
        option00.add("east");
        location00.setCoordinates(coordinates00);
        location00.setOption(option00);
        location00.setText("Welcome to Mr. V's adventure!");
        this.addLocation(location00);
        
        //location 0,1
        Location location01 = new Location();
        int[] coordinates01 = {0,1};
        Option option01 = new Option();
        Enemy robot = new Enemy();
        option01.add("north");
        option01.add("south");
        option01.add("east");
        option01.add("fight");
        location01.setCoordinates(coordinates01);
        location01.setOption(option01);
        location01.setText("north of starting point");
        location01.setEnemy(robot);
        this.addLocation(location01);
        
        //location 0,2
        Location location02 = new Location();
        int[] coordinates02 = {0,2};
        Option option02 = new Option();
        option02.add("south");
        location02.setCoordinates(coordinates02);
        location02.setOption(option02);
        location02.setText("a dead end");
        this.addLocation(location02);

        //location 1,0
        //location 1,1
        //location 1,2
        
        //location 2,0
        //location 2,1
        //location 2,2
        
        this.startingLocation = location00;
    }
    
    public void setPlayer(Player player)
    {
        player.setLocation(this.startingLocation);
        this.player = player;
    }
    
    public void addLocation(Location location)
    {
        int[] coordinates = location.getCoordinates();
        myWorld[coordinates[0]][coordinates[1]]=location;
    }
    
    public void gameLoop()
    {
        boolean playing = true;
        
        while(playing) 
        {
            //find out which location the player is in
            Location location = player.getLocation();
            //find out which options the player has at this location
            Option option = location.getOption();
            
            //print out the flavor text for this location
            System.out.println(location.getText());
            //select an option of what the player wants to do at this location
            String str = readLine("Your current choices are: " + option.toString() + "\nWhat will you do? ");
            option.select(str);
            
            //this loop makes the player move if they select north,south,east,west
            //It is slightly incomplete at the moment, as a player can attempt
            //to move off the map and the game will break. Can you add error checking to this?
            if (option.getSelection().equals("north")) 
            {
                int[] coordinates = location.getCoordinates();
                player.setLocation(myWorld[coordinates[0]][coordinates[1]+1]);
            }
            
            else if (option.getSelection().equals("south")) 
            {
                int[] coordinates = location.getCoordinates();
                player.setLocation(myWorld[coordinates[0]][coordinates[1]-1]);
            }
            
            else if (option.getSelection().equals("west")) 
            {
                int[] coordinates = location.getCoordinates();
                player.setLocation(myWorld[coordinates[0]-1][coordinates[1]]);
            }
            
            else if (option.getSelection().equals("east")) 
            {
                int[] coordinates = location.getCoordinates();
                player.setLocation(myWorld[coordinates[0]+1][coordinates[1]]);
            }
            
            else if (option.getSelection().equals("fight"))
            {
                Enemy enemy = location.getEnemy();
                combatLoop(enemy);
            }
            
            else {
                System.out.println("\ninvalid option\n");
            }
        }
    }
    
    public void combatLoop(Enemy enemy)
    {
        boolean inBattle = true;
        
        while(inBattle) {
            Option option = player.getFightOption();
            String str = readLine("Your current choices are: " + option.toString() + "\nWhat will you do? ");
            option.select(str);
            if (option.getSelection().equals("attack")){
                System.out.println("you attacked!");
            }
            else if (option.getSelection().equals("run")){
                inBattle = false;
            }
            else {
                System.out.println("\ninvalid option\n");
            }
        }
    }
}
