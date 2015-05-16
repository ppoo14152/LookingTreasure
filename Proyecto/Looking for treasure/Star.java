import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Estrella here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Bonus
{
    public Star() 
    {
       this.getImage().scale(this.getImage().getWidth()/4,this.getImage().getHeight()/4);
    }    
    
    public void act()
    {
        this.tocoEstrella();
        this.movimiento();
    }
    
    public void tocoEstrella()
    {
        WorldTreasure mundo=(WorldTreasure)getWorld();
        if( isTouching(Cyndaquil.class) || isTouching(Squirtle.class)) 
        {
            mundo.setStars();
            this.removeTouching(Star.class);
        }
    }
    
    public void movimiento()
    {
        this.setLocation(this.getX()-5,this.getY());
    }
}