import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Bonus
{
    public Key() 
    {
        this.getImage().scale(this.getImage().getWidth()/4,this.getImage().getHeight()/4);
    }  
    
    public void act()
    {
        this.tocoLLave();
    }
    
    /**
     * metodo para checar si alguno de los jugadores toco la llave
     */
    public void tocoLLave()
    {
        WorldTreasure mundo=(WorldTreasure)getWorld();
        if( isTouching(Cyndaquil.class) || isTouching(Squirtle.class)) 
        {
            mundo.setLevel(mundo.getLevel()+1);
            mundo.removeObject(this);
            mundo.setExisteLlave(false);
        }
    }
}