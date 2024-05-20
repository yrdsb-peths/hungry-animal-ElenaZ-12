import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author (Elena Z.) 
 * @version (May 1st, 2024)
 */
public class Apple extends Actor
{
    int speed = 0;
    
    /**
     * Allows the apple move and act
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        boolean endGame = world.getEndGame();
        if (!endGame)
        {
            move();
            resetApple();
        }
    }
    
    /**
     * Moves the apple
     */
    public void move()
    {
        setLocation(getX(),getY()+speed);
    }
    
    /**
     * Resets the apple to top of the screen
     */
    public void resetApple()
    {
        MyWorld world = (MyWorld) getWorld();
        // Remove apple and draw game over when apple gets to bottom
        if(getY()>=world.getHeight())
        {
            //world.gameOver();
            world.removeObject(this);
            world.createApple();
        }
    }
    
    /**
     * Sets apple speed to given int
     */
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
