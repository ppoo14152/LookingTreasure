import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la class Estrella se agarran todas las posibles en el juego.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
public class Star extends Bonus
{
    /**
     * Constructor de Star.
     * 
     */
    public Star() 
    {
       this.getImage().scale(this.getImage().getWidth()/4,this.getImage().getHeight()/4);
    }    
    
    public void act()
    {
        this.movimiento();
        this.tocoEstrella();
    }
    
    /**
     * Método donde verifica si lo toco Squirtle o Cyndaquil
     */
    public void tocoEstrella()
    {
        WorldTreasure mundo=(WorldTreasure)getWorld();
        if( isTouching(Cyndaquil.class) || isTouching(Squirtle.class)) 
        {
            mundo.setStars();
            this.getWorld().removeObject(this);
        }
    }
    
    /**
     * Método donde las estrellas se mueven en el mundo
     */
    public void movimiento()
    {
        this.setLocation(this.getX()-5,this.getY());
    }
}