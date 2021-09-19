import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Strahl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Strahl extends Actor
{
    private int labelY;
    private String name;
    private Elektronenkanone quelle;
    
    private GreenfootImage image = new GreenfootImage(1200,800);
    public double teilchengeschwindigkeit; // m/s
    public double elektronenladung = 1.602E-19;//in C = A*s
    public double elektronenmasse = 9.109E-31;// in kg
    public Strahl( int labelY ,String name, Elektronenkanone quelle)
    {
        this.labelY = labelY;
        this.name = name;
        this.quelle = quelle;
        setImage(image);
        geschwindigkeitBerechnen();
        draw();
        
    }
    /**
     * Act - do whatever the Strahl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        geschwindigkeitBerechnen();
        draw();
    }
    public void draw()
    {
        
        image.clear();
        
        Bildpunkt strahlAnfang = MyWorld.perspective(new Vektor(quelle.positionX,0,0));
        Bildpunkt strahlMitte = MyWorld.perspective(new Vektor(0,0,0));
       
        
        image.setColor(Color.ORANGE);
        
        image.drawLine(strahlAnfang.x,strahlAnfang.y,strahlMitte.x,strahlMitte.y);
        image.setColor(Color.BLACK);
        image.drawString(name + ": "+ String.valueOf(teilchengeschwindigkeit)+ " m/s",10,labelY);
        
    }
    public void geschwindigkeitBerechnen()
    {
        teilchengeschwindigkeit = Math.sqrt(2 * elektronenladung * quelle.spannung * 1000 / elektronenmasse);
    }
}