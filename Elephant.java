import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author (Elena Z.) 
 * @version (May 1st 2024)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
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
        eat();
    }
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten
     */
    public void eat()
    {
        if (isTouching(Apple.class))
        {
           removeTouching(Apple.class);
           MyWorld world = (MyWorld) getWorld();
           world.createApple();
           world.increaseScore();
           elephantSound.play();
        }
    }
}
