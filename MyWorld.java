import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our hero lives in.
 * 
 * @author (Elena Z.) 
 * @version (May 1st 2024)
 */
public class MyWorld extends World
{
    private int width = 600;
    private int height = 400;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,50,height/2);
        
        createApple();
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(width);
        int y = Greenfoot.getRandomNumber(height);
        addObject(apple, x, y);
    }
}
