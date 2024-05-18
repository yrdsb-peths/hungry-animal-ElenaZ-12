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
    Label scoreLabel;
    public int score = 0;
    public int appleSpeed = 2;
    public int bSpeed = 2;
    public boolean endGame = false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Create the elephant
        Elephant elephant = new Elephant();
        addObject(elephant,50,height-70);
        
        // Create a label
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        // Creates apples
        createApple();
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,width/2, height/2);
        endGame = true;
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        appleSpdIncrease();
        bombSpdIncrease();
    }
    
    /**
     * Decrease score
     */
    public void decreaseScore()
    {
        score--;
        scoreLabel.setValue(score);
        appleSpdDecrease();
        bombSpdDecrease();
    }
    
    public void appleSpdIncrease()
    {
        if (score % 5 == 0)
        {
            if (appleSpeed <5)
            {
                appleSpeed ++;
            }
        }
    }
    
    public void appleSpdDecrease()
    {
        if (score % 5 == 0)
        {
            if (appleSpeed > 2)
            {
                appleSpeed --;
            }
        }
    }
    
    public void bombSpdIncrease()
    {
        if (score % 5 == 0)
        {
           if (bSpeed <5)
           {
               bSpeed ++;
           }
           createBomb();
        }
    }
    
    public void bombSpdDecrease()
    {
        if (score % 5 == 0)
        {
           if (bSpeed > 1)
           {
               bSpeed --;
           }
        }
    }
    
    /**
     * Get score
     */
    public int getScore()
    {
        return score;
    }
    
    public boolean getEndGame()
    {
        return endGame;
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(appleSpeed);
        int x = Greenfoot.getRandomNumber(width-60);
        int y = Greenfoot.getRandomNumber(10);
        addObject(apple, x+30, y);
    }
    
    /**
     * Create a bomb once score is higher than 5
     */
    public void createBomb()
    {
        Bomb bomb = new Bomb();
        bomb.setSpeed(bSpeed);
        int x = Greenfoot.getRandomNumber(width);
        int y = Greenfoot.getRandomNumber(10);
        addObject(bomb, x, y-50);
    }
}
