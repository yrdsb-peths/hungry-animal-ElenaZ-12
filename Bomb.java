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
    
    public void act()
    {
        checkStartBomb();
        if (startBomb)
        {
            bombing();
        }
    }
    
    public void checkStartBomb()
    {
        MyWorld world = (MyWorld) getWorld();
        int score = world.getScore();
        if (score>4)
        {
            startBomb = true;
        }
    }
    
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
    
    public void setSpeed(int spd)
    {
        bombSpeed = spd;
    }
    
    public void removeBomb()
    {
        MyWorld world = (MyWorld) getWorld();
        world.removeObject(this);
    }
}
