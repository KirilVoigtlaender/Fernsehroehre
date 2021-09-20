import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Magnet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elektronenkanone extends Actor
{
    public Vektor richtungsvektor;
    public double positionX;
    private double abstand;
    private int labelY;
    private String name;
    private String erhöhen;
    private String verringern;
    private double minSpannung;
    private double maxSpannung;

    
    public double spannung;
    private GreenfootImage image = new GreenfootImage(1200,800);
    
    public Elektronenkanone(Vektor richtungsvektor ,double positionX, double abstand,  int labelY ,String name, String erhöhen, String verringern,double minSpannung, double maxSpannung)
    {
        this.richtungsvektor = richtungsvektor;
        this.positionX = positionX;
        this.abstand = abstand;
        this.labelY = labelY;
        this.name = name;
        this.erhöhen = erhöhen;
        this.verringern = verringern;
        this.minSpannung = minSpannung ;
        this.maxSpannung = maxSpannung;
        spannung = (maxSpannung+minSpannung)/2;
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
        
        image.fillPolygon(new int[]{Kanone1.x,Kanone2.x,Kanone6.x,Kanone8.x,},
        new int[]{Kanone1.y,Kanone2.y,Kanone6.y,Kanone8.y},4);
        image.fillPolygon(new int[]{Kanone1.x,Kanone8.x,Kanone7.x,Kanone4.x},
        new int[] {Kanone1.y,Kanone8.y,Kanone7.y,Kanone4.y},4);
        image.fillPolygon(new int[]{Kanone7.x,Kanone4.x,Kanone3.x,Kanone5.x,},
        new int[]{Kanone7.y,Kanone4.y,Kanone3.y,Kanone5.y,},4);
        image.fillPolygon(new int[]{Kanone3.x,Kanone2.x,Kanone6.x,Kanone5.x,},
        new int[]{Kanone3.y,Kanone2.y,Kanone6.y,Kanone5.y,},4);
        
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

        

        image.setColor(Color.BLACK);
        image.drawString(name + ": "+ String.valueOf(spannung)+" kV"+ " um zu erhöhen drückt man: "+erhöhen+" ; um zu verringern drückt man: "+verringern,10,labelY);

    }

    public void steuern()
    {
        if(Greenfoot.isKeyDown(erhöhen))
        {
            spannung += maxSpannung/100;
            if(spannung > maxSpannung)
            {
                spannung = maxSpannung;
            }
        }
        if(Greenfoot.isKeyDown(verringern))
        {
            spannung -=  maxSpannung/100;
            if(spannung < minSpannung)
            {
                spannung = minSpannung;
            }
        }
    }
}
