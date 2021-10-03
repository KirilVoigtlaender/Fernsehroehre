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
    public Elektronenkanone quelle;
    private double bildschirmabstand;
    
    private GreenfootImage image = new GreenfootImage(1200,800);
    public double teilchengeschwindigkeit; // m/s
    public double elektronenladung = 1.602E-19;//in C = A*s
    public double elektronenmasse = 9.109E-31;// in kg
    public Strahl( int labelY ,String name, Elektronenkanone quelle, double bildschirmabstand)
    {
        this.labelY = labelY;
        this.name = name;
        this.quelle = quelle;
        this.bildschirmabstand = bildschirmabstand;
        setImage(image);
        geschwindigkeitBerechnen();
        //draw();
        
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
        
        Bildpunkt strahlAnfang = Fernsehröhre.perspective(new Vektor(quelle.positionX,0,0));
        Bildpunkt strahlMitte = Fernsehröhre.perspective(new Vektor(0,0,0));
        Bildpunkt strahlEnde = Fernsehröhre.perspective(auslenkungBerechnen());
        strahlEnde.koordinatenAusgeben(image);
        image.setColor(Color.BLUE);
        
        image.drawLine(strahlAnfang.x,strahlAnfang.y,strahlMitte.x,strahlMitte.y);
        image.drawLine(strahlMitte.x,strahlMitte.y,strahlEnde.x,strahlEnde.y);
        image.setColor(Color.BLACK);
        image.drawString(name + ": "+ String.valueOf(teilchengeschwindigkeit/1000)+ " km/s",10,labelY);
        
    }
    public void geschwindigkeitBerechnen()
    {
        teilchengeschwindigkeit = Math.sqrt(2 * elektronenladung * quelle.spannung * 1000 / elektronenmasse);
    }
    public Vektor auslenkungBerechnen()
    {
        Vektor ergebnisvektor = new Vektor(bildschirmabstand,0,0);
        for(Ablenkspulenpaar m : getWorld().getObjects(Ablenkspulenpaar.class) )
        {
            ergebnisvektor = ergebnisvektor.addieren( m.ablenkungsrichtung.multiplizieren(bildschirmabstand*Math.tan(m.alpha)));
        }
        return ergebnisvektor;
    }
}
