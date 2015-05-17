import greenfoot.*;

/**
 * Esta es la class Tesoro que se usara para que alguno de los jugadores lo encuentre.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
public class Treasure extends Bonus
{
    /**
     * Constructor de Treasure.
     * 
     */
    public Treasure() 
    {
        this.getImage().scale(this.getImage().getWidth()/4,this.getImage().getHeight()/4);
    }
}