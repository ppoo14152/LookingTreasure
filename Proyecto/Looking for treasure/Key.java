import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la class Llave que es la que se hace que pase al siguente nivel.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
public class Key extends Bonus
{
    /**
     * Constructor de Key.
     * 
     */
    public Key() 
    {
        this.getImage().scale(this.getImage().getWidth()/4,this.getImage().getHeight()/4);
    }  
    
    public void act()
    {
        this.tocoLLave();
    }
    
    /**
     * Método para checar si alguno de los jugadores toco la llave
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