/**
 * Write a description of class Vektor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vektor  
{
    // instance variables - replace the example below with your own
    protected double x;
    protected double y;
    protected double z;
    /**
     * Constructor for objects of class Vektor
     */
    public Vektor(double x1,double y1,double z1)
    {
        x=x1;
        y=y1;
        z=z1;
    }
    public Vektor multiplizieren(double zahl)
    {
        return new Vektor(x*zahl, y*zahl, z*zahl);
    }
    
}
