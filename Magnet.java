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
    private double magnetfeldstärke = 0;
    private String name;
    private String erhöhen;
    private String verringern;
    private double maxBetrag;
    
    private int y;
    public Magnet(Vektor v, double abstand,  int y ,String name, String erhöhen, String verringern, double maxBetrag)
    {
        Lage = v;
        this.abstand = abstand;
        
        this.y = y;
        this.name = name;
        this.erhöhen = erhöhen;
        this.verringern = verringern;
        this.maxBetrag = maxBetrag;
        
        draw();
        
    }
    /**
     * Act - do whatever the Magnet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        draw();
        steuern();
    }
    public void draw()
    {
        image.clear();
        Bildpunkt Pol1 = MyWorld.perspective(Lage.multiplizieren(abstand/2));
        image.setColor(Color.RED);
        image.fillOval(Pol1.x-10,Pol1.y-10,20,20);
        
        Bildpunkt Pol2 = MyWorld.perspective(Lage.multiplizieren(-abstand/2));
        image.setColor(Color.BLUE);
        image.fillOval(Pol2.x-10,Pol2.y-10,20,20);
        image.setColor(Color.ORANGE);
        image.drawLine(Pol1.x,Pol1.y,Pol2.x,Pol2.y);
        image.setColor(Color.BLACK);
        image.drawString(name + ": "+ String.valueOf(magnetfeldstärke),10,y);
        setImage(image);
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
