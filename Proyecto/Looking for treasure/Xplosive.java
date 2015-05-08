import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Xplosive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Xplosive extends Actor
{   
    private GreenfootImage imagen;
    
    public Xplosive(String unNombre)
    {
        this.imagen=new GreenfootImage(unNombre);
        this.setImage(imagen);
    }    
}
