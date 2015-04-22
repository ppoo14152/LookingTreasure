import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Estrella here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Bonus
{
    /**
     * Act - do whatever the Estrella wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage imagen = new GreenfootImage("star.png");
    
    public Star() 
    {
        // Add your action code here.
        imagen.scale(imagen.getWidth()/4,imagen.getHeight()/4);
        setImage(imagen);
    }    
}
