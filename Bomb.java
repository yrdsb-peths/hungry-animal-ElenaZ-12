import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    int bombSpeed = 2;
    int score = 0;
    boolean startBomb = false;
    
    /**
     * Makes the bomb act
     */
    public void act()
    {
        checkStartBomb();
        if (startBomb)
        {
            bombing();
        }
    }
    
    /**
     * Checks if score is over 4, if it is, startBomb is true
     */
    public void checkStartBomb()
    {
        MyWorld world = (MyWorld) getWorld();
        int score = world.getScore();
        if (score>4)
        {
            startBomb = true;
        }
        if (world.getEndGame())
        {
            startBomb = false;
        }
    }
    
    /**
     * Moves the bomb and removes it if touching Elephant or reached bottom
     */
    public void bombing()
    {
        MyWorld world = (MyWorld) getWorld();
        // Makes bomb move down according to speed
        setLocation(getX(),getY()+bombSpeed);
        // Remove bomb when elephant touches it or reaches the bottom
        if (isTouching(Elephant.class))
        {
            removeBomb();
            for (int i = 0; i<5; i++)
            {
                world.decreaseScore();
            }
        }
        else if(getY()>=world.getHeight())
        {
            removeBomb();
            world.createBomb();
        }
    }
    
    /**
     * Set bomb speed to given int
     */
    public void setSpeed(int spd)
    {
        bombSpeed = spd;
    }
    
    /**
     * Removes bomb from world
     */
    public void removeBomb()
    {
        MyWorld world = (MyWorld) getWorld();
        world.removeObject(this);
    }
}
