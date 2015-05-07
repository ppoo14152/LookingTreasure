import greenfoot.*;

/**
 * Write a description of class Piso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends FondoImagenes
{
    public void act()
    {
        if(Greenfoot.isKeyDown("right")) {
          this.setLocation(getX()-2,getY());
        }
    }
}
