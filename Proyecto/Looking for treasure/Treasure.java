import greenfoot.*;

/**
 * Write a description of class Tesoro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure extends Bonus
{
    /**
     * Act - do whatever the Tesoro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage imagen = new GreenfootImage("tesoro.png");
    
    public Treasure() 
    {
        // Add your action code here.
        imagen.scale(imagen.getWidth()/4,imagen.getHeight()/4);
        setImage(imagen);
    }    
}
