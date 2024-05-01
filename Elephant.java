import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author (Elena Z.) 
 * @version (May 1st 2024)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        
        //Remove apple if elephant eats it
        removeTouching(Apple.class);
        
    }
}
