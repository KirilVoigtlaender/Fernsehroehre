import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Magnet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Magnet extends Actor
{
    private Vektor richtungsvektor;
    private double abstand;
    private int labelY;
    private String name;
    private String erhöhen;
    private String verringern;
    private double maxBetrag;
    
    private double magnetfeldstärke;
    private GreenfootImage image = new GreenfootImage(1200,800);
    
    public Magnet(Vektor richtungsvektor , double abstand,  int labelY ,String name, String erhöhen, String verringern, double maxBetrag)
    {
        this.richtungsvektor = richtungsvektor;
        this.abstand = abstand;
        this.labelY = labelY;
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
        Color farbePolPositiv;
        Color farbePolNegativ;
        int helligkeit;
        image.clear();
        Bildpunkt polPositiv = MyWorld.perspective(richtungsvektor.multiplizieren(abstand/2));
        Bildpunkt polNegativ = MyWorld.perspective(richtungsvektor.multiplizieren(-abstand/2));
        helligkeit =(int) (-245 * Math.abs(magnetfeldstärke)/maxBetrag+250);
        if(magnetfeldstärke>0)
        {
            farbePolPositiv = new Color(helligkeit,255,helligkeit);
            farbePolNegativ = new Color(255,helligkeit,helligkeit);
        }
        else
        {
            farbePolPositiv = new Color(255,helligkeit,helligkeit);
            farbePolNegativ = new Color(helligkeit,255,helligkeit);
        }
        image.setColor(farbePolPositiv);
        image.fillOval(polPositiv.x-10,polPositiv.y-10,20,20);
        
        image.setColor(farbePolNegativ);
        image.fillOval(polNegativ.x-10,polNegativ.y-10,20,20);
        image.setColor(Color.ORANGE);
        image.drawLine(polPositiv.x,polPositiv.y,polNegativ.x,polNegativ.y);
        image.setColor(Color.BLACK);
        image.drawString(name + ": "+ String.valueOf(magnetfeldstärke)+ " um zu erhöhen drückt man: "+erhöhen+" ; um zu verringern drückt man: "+verringern,10,labelY);
        
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
