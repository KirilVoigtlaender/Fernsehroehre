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
        image.drawOval(Pol1.x-10,Pol1.y-10,20,20);
        //setImage(image);
        Bildpunkt Pol2 = MyWorld.perspective(Lage.multiplizieren(-abstand/2));
        image.setColor(Color.BLUE);
        image.drawOval(Pol2.x-10,Pol2.y-10,20,20);
        image.setColor(Color.ORANGE);
        image.drawLine(Pol1.x,Pol1.y,Pol2.x,Pol2.y);
        setImage(image);
    }
}
