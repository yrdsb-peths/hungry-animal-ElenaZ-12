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
        if (score>5)
        {
            setLocation(getX(),getY()+bombSpeed);
            // Remove bomb when elephant touches it or reaches the bottom
            if (isTouching(Elephant.class))
            {
                world.removeObject(this);
                world.decreaseScore();
                world.createBomb();
            }
            else if(getY()>=world.getHeight())
            {
                world.removeObject(this);
                world.createBomb();
            }
        }
    }
    
    public void setScore(int scr)
    {
        score = scr;
    }
}
