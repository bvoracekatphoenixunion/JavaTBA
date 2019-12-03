public class MyProgram extends ConsoleProgram
{
    public void run()
    {
        //This initializes the game's world and our player
        World myWorld = new World();
        Player player = new Player();
        myWorld.setPlayer(player);
        
        //This is the main game loop. You don't need to edit anything in 
        //this file, but you might want to. 
        myWorld.gameLoop();
    }
}
