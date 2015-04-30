import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Signboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Signboard extends Actor
{
    /**
     * Act - do whatever the Signboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Signboard(String mensaje)
    {
        GreenfootImage letrero;
        letrero= new GreenfootImage(mensaje ,50 ,java.awt.Color.WHITE ,java.awt.Color.BLUE);
        setImage(letrero);
    }
    
    public void act() 
    {

    }    
}
