import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fernsehröhre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fernsehröhre extends World
{
    private GreenfootImage background = new GreenfootImage(1200,800);
    private GreenfootImage foreground = new GreenfootImage(1200,800);
    /**
     * Constructor for objects of class Fernsehröhre.
     * 
     */
    public Fernsehröhre()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        double bildschirmabstand = 500;
        double bildschirmbreite = 220;
        double bildschirmhöhe = 220;
        double röhrendicke = 100;
        background.setColor(Color.WHITE);
        background.fill();
        background.setColor(Color.BLACK);
        Bildpunkt B1 = perspective(new Vektor(-200,-röhrendicke,-röhrendicke));
        B1.koordinatenAusgeben(background);
        Bildpunkt B2 = perspective(new Vektor(-200,-röhrendicke,röhrendicke));
        B2.koordinatenAusgeben(background);
        Bildpunkt B3 = perspective(new Vektor(-200,röhrendicke,röhrendicke));
        B3.koordinatenAusgeben(background);
        Bildpunkt B4 = perspective(new Vektor(-200,röhrendicke,-röhrendicke));
        B4.koordinatenAusgeben(background);
        Bildpunkt B5 = perspective(new Vektor(150,röhrendicke,-röhrendicke));
        B5.koordinatenAusgeben(background);
        Bildpunkt B6 = perspective(new Vektor(150,röhrendicke,röhrendicke));
        B6.koordinatenAusgeben(background);
        Bildpunkt B7 = perspective(new Vektor(150,-röhrendicke,-röhrendicke));
        B7.koordinatenAusgeben(background);
        Bildpunkt B8 = perspective( new Vektor(150,-röhrendicke,röhrendicke));
        B8.koordinatenAusgeben(background);
        Bildpunkt B9 = perspective( new Vektor(bildschirmabstand,-bildschirmbreite,bildschirmhöhe));
        B9.koordinatenAusgeben(background);
        Bildpunkt B10 = perspective(new Vektor(bildschirmabstand,-bildschirmbreite,-bildschirmhöhe));
        B10.koordinatenAusgeben(background);
        Bildpunkt B11 = perspective(new Vektor(bildschirmabstand,bildschirmbreite,bildschirmhöhe));
        B11.koordinatenAusgeben(background);
        Bildpunkt B12 = perspective(new Vektor(bildschirmabstand,bildschirmbreite,-bildschirmhöhe));
        B12.koordinatenAusgeben(background);
        
        foreground.drawPolygon(new int []{B3.x,B4.x,B1.x,B7.x,B10.x,B9.x,B11.x,B6.x},
        new int[]{B3.y,B4.y,B1.y,B7.y,B10.y,B9.y,B11.y,B6.y},8);
        foreground.drawLine(B9.x,B9.y,B8.x,B8.y);
        foreground.drawLine(B1.x,B1.y,B2.x,B2.y);
        foreground.drawLine(B3.x,B3.y,B2.x,B2.y);
        foreground.drawLine(B8.x,B8.y,B2.x,B2.y);
        foreground.drawLine(B8.x,B8.y,B7.x,B7.y);
        foreground.drawLine(B8.x,B8.y,B6.x,B6.y);
        addObject(new Gehäuse(foreground),600,400);
        
        background.setColor(Color.LIGHT_GRAY);
        background.drawLine(B5.x,B5.y,B6.x,B6.y);
        background.drawLine(B5.x,B5.y,B7.x,B7.y);
        background.drawLine(B5.x,B5.y,B4.x,B4.y);
        background.drawLine(B12.x,B12.y,B5.x,B5.y);
        background.drawLine(B12.x,B12.y,B11.x,B11.y);
        background.drawLine(B12.x,B12.y,B10.x,B10.y);
        setBackground(background);
        Leuchtschirm L = new Leuchtschirm(bildschirmbreite,bildschirmhöhe,280,"delete");
        addObject(L,600,400);
        Elektronenkanone E = new Elektronenkanone(new Vektor(1,0,0),-180,35,205,"Elektronenkanone","+","-",12,16);
        addObject(E,600,400);
        Strahl S = new Strahl (240,"Strahlgeschwindigkeit",E,L,bildschirmabstand);
        addObject(S,600,400);
        
        addObject(new Ablenkspulenpaar(new Vektor(0,0,1),200,30,"senkrechtes Spulenpaar","up","down",5,S,30),600,400);
        addObject(new Ablenkspulenpaar(new Vektor(0,-1,0),200,130,"waagerechtes Spulenpaar","right","left",5,S,30),600,400);
        setPaintOrder(Gehäuse.class,Leuchtschirm.class,Strahl.class,Ablenkspulenpaar.class,Elektronenkanone.class);
    }
    
    public static Bildpunkt perspective(Vektor v)
    {
        double x1 = (2*Math.sqrt(5)/5)*v.x + (-Math.sqrt(5)/5)*v.y + 400;
        double y1 = 500-((Math.sqrt(30)/30)*v.x + (Math.sqrt(30)/15)*v.y + (Math.sqrt(30)/6)*v.z );
        return new Bildpunkt((int) x1,(int) y1,v);
    }
}
