import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cyndaquil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cyndaquil extends Player
{
    public Cyndaquil()
    {
        super(6);
        for(int i = 0; i < super.getNumIma();i++)
        {
            super.insertaIma(i,"Cd");
        }
        super.animar();
    }
    
    public void act()
    {
        this.movimiento();
        super.caida();
    }
    
    public void movimiento()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            super.setIzq(false);
            if(this.getX()+10 < getWorld().getWidth()/2)
            {
                setLocation(getX()+super.getVelJugador(),getY());
            }
            super.animar();
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            super.setIzq(true);
            if(this.getX()+10 > 0)
            {
                setLocation(getX()-super.getVelJugador(),getY());
            }
            super.animar();
        }
        
        if(Greenfoot.isKeyDown("up"))
        { 
            super.saltar();
        }
    }
    
    public int getPosXc()
    {
        return this.getX();
    }
}
