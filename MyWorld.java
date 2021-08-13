import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private GreenfootImage image=new GreenfootImage(1200,800);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        //image.drawLine(100,70,10,18);
        //setBackground(image);
        Vektor P1 = new Vektor(-200,-80,-80);
        Vektor P2 = new Vektor(-200,-80,80);
        Vektor P3 = new Vektor(-200,80,80);
        Vektor P4 = new Vektor(-200,80,-80);
        Vektor P5 = new Vektor(200,80,-80);
        Vektor P6 = new Vektor(200,80,80);
        Vektor P7 = new Vektor(200,-80,-80);
        Vektor P8 = new Vektor(200,-80,80);
        Vektor P9 = new Vektor(600,-200,200);
        Vektor P10 = new Vektor(600,-200,-200);
        Vektor P11 = new Vektor(600,200,200);
        Vektor P12 = new Vektor(600,200,-200);
        Bildpunkt B1 = perspective(P1);
        //B1.koordinatenAusgeben(image);
        Bildpunkt B2 = perspective(P2);
        //B2.koordinatenAusgeben(image);
        Bildpunkt B3 = perspective(P3);
        //B3.koordinatenAusgeben(image);
        Bildpunkt B4 = perspective(P4);
        //B4.koordinatenAusgeben(image);
        Bildpunkt B5 = perspective(P5);
        //B5.koordinatenAusgeben(image);
        Bildpunkt B6 = perspective(P6);
        //B6.koordinatenAusgeben(image);
        Bildpunkt B7 = perspective(P7);
        Bildpunkt B8 = perspective(P8);
        Bildpunkt B9 = perspective(P9);
        Bildpunkt B10 = perspective(P10);
        Bildpunkt B11 = perspective(P11);
        Bildpunkt B12 = perspective(P12);
        image.drawLine(B9.x,B9.y,B11.x,B11.y);
        image.drawLine(B9.x,B9.y,B10.x,B10.y);
        image.drawLine(B11.x,B11.y,B6.x,B6.y);
        image.drawLine(B10.x,B10.y,B7.x,B7.y);
        image.drawLine(B9.x,B9.y,B8.x,B8.y);
        image.drawLine(B1.x,B1.y,B2.x,B2.y);
        image.drawLine(B3.x,B3.y,B2.x,B2.y);
        image.drawLine(B1.x,B1.y,B4.x,B4.y);
        image.drawLine(B1.x,B1.y,B7.x,B7.y);
        image.drawLine(B8.x,B8.y,B2.x,B2.y);
        image.drawLine(B3.x,B3.y,B4.x,B4.y);
        image.drawLine(B8.x,B8.y,B7.x,B7.y);
        image.drawLine(B8.x,B8.y,B6.x,B6.y);
        image.drawLine(B3.x,B3.y,B6.x,B6.y);
        image.setColor(Color.LIGHT_GRAY);
        image.drawLine(B5.x,B5.y,B6.x,B6.y);
        image.drawLine(B5.x,B5.y,B7.x,B7.y);
        image.drawLine(B5.x,B5.y,B4.x,B4.y);
        image.drawLine(B12.x,B12.y,B5.x,B5.y);
        image.drawLine(B12.x,B12.y,B11.x,B11.y);
        image.drawLine(B12.x,B12.y,B10.x,B10.y);
        setBackground(image);
    }
    
    public Bildpunkt perspective(Vektor v)
    {
        double x1 = (2*Math.sqrt(5)/5)*v.x + (-Math.sqrt(5)/5)*v.y + +400;
        double y1= 500-((Math.sqrt(30)/30)*v.x + (Math.sqrt(30)/15)*v.y + (Math.sqrt(30)/6)*v.z );
        return new Bildpunkt((int) x1,(int) y1,v);
    }
}
