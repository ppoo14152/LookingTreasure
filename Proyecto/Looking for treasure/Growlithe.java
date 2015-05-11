import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Growlithe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Growlithe extends Enemy
{
    private int vida;
    
    public Growlithe()
    {
        super(4,0);
        vida=0;
        for(int i = 0; i < 4;i++)
        {
            super.insertaIma(i,"Gd");
        }
    }
    
    public void act()
    {
        this.quitaVida();
        this.movimiento();
    }
    
    /**
     * metodo para animar al enemigo
     */
    public void movimiento()
    {  
       super.setIzq(true);
       this.setLocation(this.getX()-5,this.getY());
       super.animar();
    } 
    
    /**
     * metodo para restar vidas al jugador
     */
    public void quitaVida()
    {
        if(isTouching(Cyndaquil.class) || isTouching(Squirtle.class)) 
        {
            if(vida == 0)
            {
                if(((WorldTreasure)getWorld()).getLives().getValue() >= 0)
                      ((WorldTreasure)getWorld()).setLives();
                 vida++;
           }
        }
    }
}