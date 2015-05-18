import greenfoot.*;

/**
 * Esta es la clase Piso.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
public class Floor extends FondoImagenes
{
    
    /**
     * Actua de Floor
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
          this.setLocation(getX()-2,getY());
        }
    }
}
