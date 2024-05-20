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
    World parent_node;
    Label scoreLabel;
    Label gameTimer;
    
    public int score = 0;
    public int appleSpeed = 2;
    public int bSpeed = 2;
    public boolean endGame = false;
    
    SimpleTimer timer = new SimpleTimer();
    Counter timeCount = new Counter();
    /**
     * Constructor for objects of class MyWorld.
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
        
        //Creates timer
        Label time = new Label("Time Remaining:",30);
        addObject(time,width/2,30);
        addObject (timeCount, width/2, 60);
        timer.mark();
    }
    
    /**
     * The main world act loop
     */
    public void act()
    {
        int timeLimit = 30;
        if (timeLimit - timer.millisElapsed()/1000 < 0)
        {
            gameOver();
        }
        if (endGame)
        {
            if(Greenfoot.isKeyDown("r"))
            {
                Greenfoot.setWorld(parent_node);
            }
        }
        else if (!endGame) 
        {
            timeCount.setValue(timeLimit - timer.millisElapsed()/1000);
        }
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,width/2, height/2);
        
        Label restart = new Label ("Press r to restart", 30);
        addObject (restart, width/2, height/2 + 50);
        
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
        if (score>0)
        {
            score--;
        }
        scoreLabel.setValue(score);
        appleSpdDecrease();
        bombSpdDecrease();
        if (score == 0)
        {
            gameOver();
        }
    }
    
    /**
     * Increase apple speed
     */
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
    
    /**
     * Decrease apple speed
     */
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
    
    /**
     * Increase bomb speed
     */
    public void bombSpdIncrease()
    {
        if (score % 5 == 0)
        {
           if (bSpeed <5)
           {
               bSpeed ++;
           }
           createBomb();
           int surprise = Greenfoot.getRandomNumber(3);
           if (surprise == 1)
           {
               createBomb();
           }
        }
    }
    
    /**
     * Decrease bomb speed
     */
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
    
    /**
     * Get whether game has ended or not
     */
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
        int y = Greenfoot.getRandomNumber(50);
        addObject(bomb, x, -30-y);
    }
}
