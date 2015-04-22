import greenfoot.*;

/**
 * Write a description of class FloorTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FloorTwo extends FondoImagenes
{
    /**
     * Act - do whatever the FloorTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage imagen;
    
    public FloorTwo() 
    {
        imagen = new GreenfootImage("tronco.png");
        imagen.scale(imagen.getWidth()*6,imagen.getHeight());
        setImage(imagen);
    }
   
    public void act()
    {
        /*if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("z"))
            setLocation(this.getX()+3,this.getY());
            
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("x"))
            setLocation(this.getX()-3,this.getY());*/
             
    }
}
