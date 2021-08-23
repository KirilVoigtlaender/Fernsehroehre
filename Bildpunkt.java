import greenfoot.GreenfootImage;

/**
 * Write a description of class Bildpunkt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bildpunkt  
{
    // instance variables - replace the example below with your own
    protected int x;
    protected int y;
    private Vektor original;
    /**
     * Constructor for objects of class Bildpunkt
     */
    public Bildpunkt(int x, int y, Vektor original)
    {
        this.x = x;
        this.y = y;
        this.original = original;
    }
    
    public void koordinatenAusgeben(GreenfootImage image)
    {
        image.drawString(String.valueOf(original.x) + "," + String.valueOf(original.y) + "," + String.valueOf(original.z),x,y);
    }
    
}
