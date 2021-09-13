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
    private double positionX;
    private double abstand;
    private int labelY;
    private String name;
    private String erhöhen;
    private String verringern;
    private double maxSpannung;

    private double spannung;
    private GreenfootImage image = new GreenfootImage(1200,800);

    public Elektronenkanone(Vektor richtungsvektor ,double positionX, double abstand,  int labelY ,String name, String erhöhen, String verringern, double maxSpannung)
    {
        this.richtungsvektor = richtungsvektor;
        this.positionX = positionX;
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
        
        Vektor vektorPolNegativ = new Vektor(positionX,0,0);
        Vektor vektorPolPositiv = vektorPolNegativ.addieren(richtungsvektor.multiplizieren(abstand));
        
        int helligkeit;
        image.clear();
        Bildpunkt polNegativ1 = MyWorld.perspective(vektorPolNegativ.addieren(new Vektor(0,30,30)));
        Bildpunkt polNegativ2 = MyWorld.perspective(vektorPolNegativ.addieren(new Vektor(0,30,-30)));
        Bildpunkt polNegativ3 = MyWorld.perspective(vektorPolNegativ.addieren(new Vektor(0,-30,-30)));
        Bildpunkt polNegativ4 = MyWorld.perspective(vektorPolNegativ.addieren(new Vektor(0,-30,30)));

        Bildpunkt polPositiv1 = MyWorld.perspective(vektorPolPositiv.addieren(new Vektor(0,30,30)));
        Bildpunkt polPositiv2 = MyWorld.perspective(vektorPolPositiv.addieren(new Vektor(0,30,-30)));
        Bildpunkt polPositiv3 = MyWorld.perspective(vektorPolPositiv.addieren(new Vektor(0,-30,-30)));
        Bildpunkt polPositiv4 = MyWorld.perspective(vektorPolPositiv.addieren(new Vektor(0,-30,30)));
        Bildpunkt Kanone1 = MyWorld.perspective(new Vektor(-200,5,5));
        Bildpunkt Kanone2 = MyWorld.perspective(new Vektor(-200,5,-5));
        Bildpunkt Kanone3 = MyWorld.perspective(new Vektor(-200,-5,-5));
        Bildpunkt Kanone4 = MyWorld.perspective(new Vektor(-200,-5,5));
        Bildpunkt Kanone5 = MyWorld.perspective(new Vektor(positionX,-5,-5));
        Bildpunkt Kanone6 = MyWorld.perspective(new Vektor(positionX,5,-5));
        Bildpunkt Kanone7 = MyWorld.perspective(new Vektor(positionX,-5,5));
        Bildpunkt Kanone8 = MyWorld.perspective(new Vektor(positionX,5,5));
        image.drawPolygon(new int[]{Kanone1.x,Kanone2.x,Kanone3.x,Kanone4.x,Kanone5.x,Kanone6.x,Kanone7.x,Kanone8.x,}, 
        new int[]{Kanone1.y,Kanone2.y,Kanone3.y,Kanone4.y,Kanone5.y,Kanone6.y,Kanone7.y,Kanone8.y},8);
        

        helligkeit =(int) (-245 * Math.abs(spannung)/maxSpannung+250);
        
        farbePolPositiv = new Color(255,helligkeit,helligkeit);
        farbePolNegativ = new Color(helligkeit,helligkeit,255);
        image.setColor(farbePolPositiv);
        
        image.drawPolygon(new int[] { polPositiv1.x, polPositiv2.x, polPositiv3.x, polPositiv4.x },
            new int[] { polPositiv1.y, polPositiv2.y, polPositiv3.y, polPositiv4.y },
            4);
         
        image.setColor(farbePolNegativ);
        
        image.drawPolygon(new int[] { polNegativ1.x, polNegativ2.x, polNegativ3.x, polNegativ4.x },
            new int[] { polNegativ1.y, polNegativ2.y, polNegativ3.y, polNegativ4.y },
            4); 

        image.setColor(Color.ORANGE);
        Bildpunkt polNegativ =  MyWorld.perspective( new Vektor(-180,0,0));
        Bildpunkt polPositiv =  MyWorld.perspective(vektorPolNegativ.addieren(richtungsvektor.multiplizieren(abstand)));
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
