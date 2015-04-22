import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Bonus
{
    /**
     * Act - do whatever the Llave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage imagen = new GreenfootImage("llave1.png");
    
    public Key() 
    {
        // Add your action code here.
        imagen.scale(imagen.getWidth()/4,imagen.getHeight()/4);
        setImage(imagen);
    }  
}
