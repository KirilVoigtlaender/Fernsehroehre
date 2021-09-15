import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private GreenfootImage image = new GreenfootImage(1200,800);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        
        image.setColor(Color.WHITE);
        image.fill();
        image.setColor(Color.BLACK);
        Bildpunkt B1 = perspective(new Vektor(-200,-80,-80));
        B1.koordinatenAusgeben(image);
        Bildpunkt B2 = perspective(new Vektor(-200,-80,80));
        B2.koordinatenAusgeben(image);
        Bildpunkt B3 = perspective(new Vektor(-200,80,80));
        B3.koordinatenAusgeben(image);
        Bildpunkt B4 = perspective(new Vektor(-200,80,-80));
        B4.koordinatenAusgeben(image);
        Bildpunkt B5 = perspective(new Vektor(200,80,-80));
        B5.koordinatenAusgeben(image);
        Bildpunkt B6 = perspective(new Vektor(200,80,80));
        B6.koordinatenAusgeben(image);
        Bildpunkt B7 = perspective(new Vektor(200,-80,-80));
        B7.koordinatenAusgeben(image);
        Bildpunkt B8 = perspective( new Vektor(200,-80,80));
        B8.koordinatenAusgeben(image);
        Bildpunkt B9 = perspective( new Vektor(600,-200,200));
        B9.koordinatenAusgeben(image);
        Bildpunkt B10 = perspective(new Vektor(600,-200,-200));
        B10.koordinatenAusgeben(image);
        Bildpunkt B11 = perspective(new Vektor(600,200,200));
        B11.koordinatenAusgeben(image);
        Bildpunkt B12 = perspective(new Vektor(600,200,-200));
        B12.koordinatenAusgeben(image);
        
        image.drawPolygon(new int []{B3.x,B4.x,B1.x,B7.x,B10.x,B9.x,B11.x,B6.x},
        new int[]{B3.y,B4.y,B1.y,B7.y,B10.y,B9.y,B11.y,B6.y},8);
        image.drawLine(B9.x,B9.y,B8.x,B8.y);
        image.drawLine(B1.x,B1.y,B2.x,B2.y);
        image.drawLine(B3.x,B3.y,B2.x,B2.y);
        image.drawLine(B8.x,B8.y,B2.x,B2.y);
        image.drawLine(B8.x,B8.y,B7.x,B7.y);
        image.drawLine(B8.x,B8.y,B6.x,B6.y);
        
        image.setColor(Color.LIGHT_GRAY);
        image.drawLine(B5.x,B5.y,B6.x,B6.y);
        image.drawLine(B5.x,B5.y,B7.x,B7.y);
        image.drawLine(B5.x,B5.y,B4.x,B4.y);
        image.drawLine(B12.x,B12.y,B5.x,B5.y);
        image.drawLine(B12.x,B12.y,B11.x,B11.y);
        image.drawLine(B12.x,B12.y,B10.x,B10.y);
        setBackground(image);
        
        addObject(new Magnet(new Vektor(0,0,1),200,20,"senkrechtes Spulenpaar","up","down",40),600,400);
        addObject(new Magnet(new Vektor(0,1,0),200,50,"waagerechtes Spulenpaar","right","left",40),600,400);
        
        addObject(new Elektronenkanone(new Vektor(1,0,0),-180,30,80,"Elektronenkanone","+","-",15),600,400);

    }
    
    public static Bildpunkt perspective(Vektor v)
    {
        double x1 = (2*Math.sqrt(5)/5)*v.x + (-Math.sqrt(5)/5)*v.y + +400;
        double y1 = 500-((Math.sqrt(30)/30)*v.x + (Math.sqrt(30)/15)*v.y + (Math.sqrt(30)/6)*v.z );
        return new Bildpunkt((int) x1,(int) y1,v);
    }
}
