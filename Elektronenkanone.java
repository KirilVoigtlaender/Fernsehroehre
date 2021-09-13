import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Magnet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elektronenkanone extends Actor
{
    private Vektor richtungsvektor;
    private double abstand;
    private int labelY;
    private String name;
    private String erhöhen;
    private String verringern;
    private double maxSpannung;
    
    private double spannung;
    private GreenfootImage image = new GreenfootImage(1200,800);
    
    public Elektronenkanone(Vektor richtungsvektor , double abstand,  int labelY ,String name, String erhöhen, String verringern, double maxSpannung)
    {
        this.richtungsvektor = richtungsvektor;
        this.abstand = abstand;
        this.labelY = labelY;
        this.name = name;
        this.erhöhen = erhöhen;
        this.verringern = verringern;
        this.maxSpannung = maxSpannung;
        spannung = maxSpannung/2;
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
        
        Vektor vektorPolNegativ = new Vektor(-180,0,0);
        int helligkeit;
        image.clear();
        Bildpunkt polNegativ = MyWorld.perspective(vektorPolNegativ);
        Bildpunkt polPositiv = MyWorld.perspective(vektorPolNegativ.addieren(richtungsvektor.multiplizieren(abstand)));
        
        helligkeit =(int) (-245 * Math.abs(spannung)/maxSpannung+250);
        
        
        farbePolPositiv = new Color(255,helligkeit,helligkeit);
        farbePolNegativ = new Color(helligkeit,helligkeit,255);
        
        
        
           
            
        
        image.setColor(farbePolPositiv);
        image.fillOval(polPositiv.x-10,polPositiv.y-10,20,20);
        
        image.setColor(farbePolNegativ);
        image.fillOval(polNegativ.x-10,polNegativ.y-10,20,20);
        image.setColor(Color.ORANGE);
        image.drawLine(polPositiv.x,polPositiv.y,polNegativ.x,polNegativ.y);
        image.setColor(Color.BLACK);
        image.drawString(name + ": "+ String.valueOf(spannung),10,labelY);
        
    }
    public void steuern()
    {
        if(Greenfoot.isKeyDown(erhöhen))
        {
            spannung += 0.1;
            if(spannung > maxSpannung)
            {
                spannung = maxSpannung;
            }
        }
        if(Greenfoot.isKeyDown(verringern))
        {
           spannung -= 0.1;
           if(spannung < 0)
            {
                spannung = 0;
            }
        }
    }
}
