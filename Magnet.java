import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Magnet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Magnet extends Actor
{
    private Vektor Richtungsvektor;
    private double abstand;
    private GreenfootImage image = new GreenfootImage(1200,800);
    private double magnetfeldstärke;
    private String name;
    private String erhöhen;
    private String verringern;
    private double maxBetrag;
    
    private int y;
    public Magnet(Vektor Richtungsvektor , double abstand,  int y ,String name, String erhöhen, String verringern, double maxBetrag)
    {
        this.Richtungsvektor = Richtungsvektor;
        this.abstand = abstand;
        this.y = y;
        this.name = name;
        this.erhöhen = erhöhen;
        this.verringern = verringern;
        this.maxBetrag = maxBetrag;
        magnetfeldstärke = maxBetrag/2;
        setImage(image);
        draw();
    }
    /**
     * Act - do whatever the Magnet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        steuern();
        draw();
    }
    public void draw()
    {
        Color farbepol1;
        Color farbepol2;
        int helligkeit;
        image.clear();
        Bildpunkt Pol1 = MyWorld.perspective(Richtungsvektor.multiplizieren(abstand/2));
        Bildpunkt Pol2 = MyWorld.perspective(Richtungsvektor.multiplizieren(-abstand/2));
        helligkeit =(int) (-245 * Math.abs(magnetfeldstärke)/maxBetrag+250);
        if(magnetfeldstärke>0)
        {
            farbepol1 = new Color(helligkeit,255,helligkeit);
            farbepol2 = new Color(255,helligkeit,helligkeit);
        }
        else
        {
            farbepol1 = new Color(255,helligkeit,helligkeit);
            farbepol2 = new Color(helligkeit,255,helligkeit);
        }
        image.setColor(farbepol1);
        image.fillOval(Pol1.x-10,Pol1.y-10,20,20);
        
        image.setColor(farbepol2);
        image.fillOval(Pol2.x-10,Pol2.y-10,20,20);
        image.setColor(Color.ORANGE);
        image.drawLine(Pol1.x,Pol1.y,Pol2.x,Pol2.y);
        image.setColor(Color.BLACK);
        image.drawString(name + ": "+ String.valueOf(magnetfeldstärke),10,y);
        
    }
    public void steuern()
    {
        if(Greenfoot.isKeyDown(erhöhen))
        {
            magnetfeldstärke += 0.1;
            if(magnetfeldstärke > maxBetrag)
            {
                magnetfeldstärke = maxBetrag;
            }
        }
        if(Greenfoot.isKeyDown(verringern))
        {
           magnetfeldstärke -= 0.1;
           if(magnetfeldstärke < -maxBetrag)
            {
                magnetfeldstärke = -maxBetrag;
            }
        }
    }
}
