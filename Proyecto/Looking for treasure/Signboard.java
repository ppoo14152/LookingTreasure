import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase Signboard realiza los letreros en el juego.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
   
public class Signboard extends Actor
{
    private int tiempo;
    
    /**
     * Constructor de Signboard.
     * 
     */
    public Signboard(String mensaje)
    {
        GreenfootImage letrero;
        letrero= new GreenfootImage(mensaje ,50 ,java.awt.Color.BLACK ,java.awt.Color.YELLOW);
        setImage(letrero);
        tiempo=10;
    } 
}
