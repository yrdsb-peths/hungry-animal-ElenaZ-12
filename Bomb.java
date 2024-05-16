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
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        int score = world.getScore();
        if (score>4)
        {
            bombing();
        }
    }
    
    public void setScore(int scr)
    {
        score = scr;
    }
    
    public void bombing()
    {
        MyWorld world = (MyWorld) getWorld();
        
        // Makes bomb move down according to speed
        setLocation(getX(),getY()+bombSpeed);
        
        // Remove bomb when elephant touches it or reaches the bottom
        if (isTouching(Elephant.class))
        {
            world.removeObject(this);
            for (int i = 0; i<5; i++)
            {
                world.decreaseScore();
            }
            world.createBomb();
        }
        else if(getY()>=world.getHeight())
        {
            world.removeObject(this);
            world.createBomb();
        }
    }
    
    public void setSpeed(int spd)
    {
        bombSpeed = spd;
    }
}
