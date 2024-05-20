import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Elena Z. 
 * @version May 13th 2024
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label ("Hungry Elephant", 60);
    GreenfootSound bgMusic = new GreenfootSound("titlescreen_bgm.mp3");
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }
    
    /**
     * The main world act loop
     */
    public void act()
    {
        // Start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
        bgMusic.playLoop();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant, getWidth()/2, getHeight()/2-80);
        Label label = new Label("Use \u2190 and \u2192 to move", 30);
        addObject(label,310,250);
        Label label2 = new Label("Press <space> to start", 30);
        addObject(label2,306,284);
    }
}
