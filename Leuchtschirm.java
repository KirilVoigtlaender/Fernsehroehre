import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leuchtschirm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leuchtschirm extends Actor
{
    private double bildschirmbreite;
    private double bildschirmhöhe;
    private int labelY;
    private String löschen;

    private GreenfootImage image = new GreenfootImage(1200,800);
    public Leuchtschirm(double bildschirmbreite,double bildschirmhöhe, int labelY,String löschen)
    {
        this.bildschirmbreite = bildschirmbreite;
        this.bildschirmhöhe = bildschirmhöhe;
        this.labelY = labelY;
        this.löschen = löschen;
        textAusgabe();
        setImage(image);
    }

    /**
     * Act - do whatever the Leuchtschirm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        steuern();
    }

    public void setzePunkt(Vektor v)
    {
        Bildpunkt L = Fernsehröhre.perspective(v);
        if(Math.abs(v.y)<=bildschirmbreite && Math.abs(v.z)<=bildschirmhöhe)
        {
            image.drawOval(L.x,L.y,1,1);
        }

    }

    public void textAusgabe()
    {
        image.setColor(Color.BLACK);
        image.drawString("Durch das Drücken von \""+ löschen+ "\" wird das Leuchtbild gelöscht.",10,labelY);
        image.setColor(Color.ORANGE);
    }

    public void steuern()
    {
        if(Greenfoot.isKeyDown(löschen))
        {
            image.clear();
            textAusgabe();
        }
    }
}
