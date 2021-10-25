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
    public Vektor(double x,double y,double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vektor multiplizieren(double zahl)
    {
        return new Vektor(x*zahl, y*zahl, z*zahl);
    }

    public Vektor addieren(Vektor v)
    {
        return new Vektor(x + v.x, y + v.y, z + v.z);
    }

    public Vektor kreuzprodukt(Vektor v)
    {
        return new Vektor(y * v.z - z * v.y , z * v.x - x * v.z , x * v.y - y * v.x);
    }
}
