import greenfoot.*;

/**
 * Write a description of class Piso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends FondoImagenes
{
    /**
     * Act - do whatever the Piso wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Floor() 
    {
        
    } 
    
    public void act()
    {
        if(Greenfoot.isKeyDown("right")) {
          setLocation(getX()-2,getY());
        }
        
        if(Greenfoot.isKeyDown("left")) {
          setLocation(getX()+2,getY());
        }
        
        if(this.getX() <= -30) {
            getWorld().removeObject(this);
        }
    }

}
