import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author (Elena Z.) 
 * @version (May 1st, 2024)
 */
public class Apple extends Actor
{
    int speed = 1;
    
    public void act()
    {
        setLocation(getX(),getY()+speed);
        
        MyWorld world = (MyWorld) getWorld();
        // Remove apple and draw game over when apple gets to bottom
        if(getY()>=world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
