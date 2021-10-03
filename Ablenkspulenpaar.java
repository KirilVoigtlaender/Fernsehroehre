import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ablenkspulenpaar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ablenkspulenpaar extends Actor
{
    private Vektor richtungsvektor;
    private double abstand;
    private int labelY;
    private String name;
    private String erhöhen;
    private String verringern;
    private double maxBetrag;
    private Strahl strahl;
    private double felddurchmesser;// in mm
    
    private double magnetfeldstärke; // in mT
    private GreenfootImage image = new GreenfootImage(1200,800);
    public double alpha;
    private double bahnradius; // in mm
    public Vektor ablenkungsrichtung;
    public Ablenkspulenpaar(Vektor richtungsvektor , double abstand,  int labelY ,String name, String erhöhen, String verringern, double maxBetrag, Strahl strahl,double felddurchmesser)
    {
        this.richtungsvektor = richtungsvektor;
        this.abstand = abstand;
        this.labelY = labelY;
        this.name = name;
        this.erhöhen = erhöhen;
        this.verringern = verringern;
        this.maxBetrag = maxBetrag;
        this.strahl = strahl;
        this.felddurchmesser = felddurchmesser;
        magnetfeldstärke = maxBetrag/2;
        setImage(image);
        ablenkungberechnen();
        draw();
    }
    /**
     * Act - do whatever the Ablenkspulenpaar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        steuern();
        ablenkungberechnen();
        draw();
    }
    public void draw()
    {
        Color farbePolPositiv;
        Color farbePolNegativ;
        int helligkeit;
        image.clear();
        Bildpunkt polPositiv = Fernsehröhre.perspective(richtungsvektor.multiplizieren(abstand/2));
        Bildpunkt polNegativ = Fernsehröhre.perspective(richtungsvektor.multiplizieren(-abstand/2));
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
        image.fillOval(polPositiv.x-(int)felddurchmesser/2,polPositiv.y-(int)felddurchmesser/2,(int)felddurchmesser,(int)felddurchmesser);
        
        image.setColor(farbePolNegativ);
        image.fillOval(polNegativ.x-(int)felddurchmesser/2,polNegativ.y-(int)felddurchmesser/2,(int)felddurchmesser,(int)felddurchmesser);
        image.setColor(Color.YELLOW);
        image.drawLine(polPositiv.x,polPositiv.y,polNegativ.x,polNegativ.y);
        image.setColor(Color.BLACK);
        image.drawString(name + ": "+ String.valueOf(magnetfeldstärke)+" in mT" + " um zu erhöhen drückt man: "+erhöhen+" ; um zu verringern drückt man: "+verringern ,10,labelY);
        image.drawString("Der Winkel alpha beträgt = "+180/Math.PI * alpha + " in °",10,labelY+15);
        image.drawString("Der Radius beträgt = "+bahnradius + " mm",10 ,labelY+30);
        image.drawString("Ablenkungsrichtung : "+ablenkungsrichtung.x + ", "+ablenkungsrichtung.y + " , "+ablenkungsrichtung.z,10,labelY+45);
    }
    public void steuern()
    {
        if(Greenfoot.isKeyDown(erhöhen))
        {
            magnetfeldstärke += maxBetrag/100;
            if(magnetfeldstärke > maxBetrag)
            {
                magnetfeldstärke = maxBetrag;
            }
        }
        if(Greenfoot.isKeyDown(verringern))
        {
           magnetfeldstärke -= maxBetrag/100;
           if(magnetfeldstärke < -maxBetrag)
            {
                magnetfeldstärke = -maxBetrag;
            }
        }
    }
    public void ablenkungberechnen()
    {
        bahnradius 
          = strahl.elektronenmasse 
            * strahl.teilchengeschwindigkeit 
            / (strahl.elektronenladung * magnetfeldstärke/1000)
            * 1000;
        alpha = 2 * Math.atan(felddurchmesser/ (2 *bahnradius ));
        ablenkungsrichtung
          = strahl.quelle.richtungsvektor.
            multiplizieren(-1).
            kreuzprodukt(this.richtungsvektor);
    }
}
