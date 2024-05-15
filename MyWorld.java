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
    int appleSpeed = 1;
    
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
        addObject(elephant,50,height-100);
        
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
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        speedChange();
        // Make bombs
        createBomb();
    }
    
    /**
     * Decrease score
     */
    public void decreaseScore()
    {
        score--;
        scoreLabel.setValue(score);
        speedChange();
        // Make bombs
        createBomb();
    }
    
    public void speedChange()
    {
        if (score % 5 == 0)
        {
            appleSpeed ++;
        }
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(appleSpeed);
        int x = Greenfoot.getRandomNumber(width);
        int y = Greenfoot.getRandomNumber(10);
        addObject(apple, x, y);
    }
    
    /**
     * Create a bomb once score is higher than 5
     */
    public void createBomb()
    {
        if (score>5)
        {
            Bomb bomb = new Bomb();
            int x = Greenfoot.getRandomNumber(width);
            int y = Greenfoot.getRandomNumber(10);
            addObject(bomb, x, y);
        }
    }
}
