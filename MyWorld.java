import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private GreenfootImage Würfel=new GreenfootImage(600,400);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //Würfel.drawLine(100,70,10,18);
        //setBackground(Würfel);
        Vektor P1 = new Vektor(-100,-100,-100);
        Vektor P2 = new Vektor(-100,-100,100);
        Vektor P3 = new Vektor(-100,100,100);
        Vektor P4 = new Vektor(-100,100,-100);
        Vektor P5 = new Vektor(100,100,-100);
        Vektor P6 = new Vektor(100,100,100);
        Vektor P7 = new Vektor(100,-100,-100);
        Vektor P8 = new Vektor(100,-100,100);
        Bildpunkt B1 = perspective(P1);
        B1.koordinatenAusgeben(Würfel);
        Bildpunkt B2 = perspective(P2);
        B2.koordinatenAusgeben(Würfel);
        Bildpunkt B3 = perspective(P3);
        B3.koordinatenAusgeben(Würfel);
        Bildpunkt B4 = perspective(P4);
        B4.koordinatenAusgeben(Würfel);
        Bildpunkt B5 = perspective(P5);
        B5.koordinatenAusgeben(Würfel);
        Bildpunkt B6 = perspective(P6);
        B6.koordinatenAusgeben(Würfel);
        Bildpunkt B7 = perspective(P7);
        Bildpunkt B8 = perspective(P8);
        Würfel.drawLine(B1.x,B1.y,B2.x,B2.y);
        Würfel.drawLine(B3.x,B3.y,B2.x,B2.y);
        Würfel.drawLine(B1.x,B1.y,B4.x,B4.y);
        Würfel.drawLine(B1.x,B1.y,B7.x,B7.y);
        Würfel.drawLine(B8.x,B8.y,B2.x,B2.y);
        Würfel.drawLine(B3.x,B3.y,B4.x,B4.y);
        Würfel.drawLine(B8.x,B8.y,B7.x,B7.y);
        Würfel.drawLine(B8.x,B8.y,B6.x,B6.y);
        Würfel.drawLine(B3.x,B3.y,B6.x,B6.y);
        Würfel.drawLine(B5.x,B5.y,B6.x,B6.y);
        Würfel.drawLine(B5.x,B5.y,B7.x,B7.y);
        Würfel.drawLine(B5.x,B5.y,B4.x,B4.y);
        setBackground(Würfel);
    }
    
    public Bildpunkt perspective(Vektor v)
    {
        double x1 = (2*Math.sqrt(5)/5)*v.x + (-Math.sqrt(5)/5)*v.y + 14*Math.sqrt(5)+300;
        double y1= 200-((Math.sqrt(30)/30)*v.x + (Math.sqrt(30)/15)*v.y + (Math.sqrt(30)/6)*v.z + 1/3*Math.sqrt(30));
        return new Bildpunkt((int) x1,(int) y1,v);
    }
}
