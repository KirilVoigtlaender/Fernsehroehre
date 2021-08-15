import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Magnet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Magnet extends Actor
{
    private Vektor Lage;
    private double abstand;
    private GreenfootImage image=new GreenfootImage(1200,800);
    public Magnet(Vektor v, double abstand)
    {
        Lage=v;
        this.abstand=abstand;
        draw();
    }
    /**
     * Act - do whatever the Magnet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        draw();
    }
    public void draw()
    {
        Bildpunkt Pol1 = MyWorld.perspective(Lage.multiplizieren(abstand/2));
        
        image.setColor(Color.RED);
        image.drawOval(Pol1.x,Pol1.y,20,20);
        setImage(image);
    }
}
