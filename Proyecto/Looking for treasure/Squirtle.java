import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Squirtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Squirtle extends Player
{
    public Squirtle()
    {
        super(4);
        for(int i = 0; i < super.getNumIma();i++)
        {
            super.insertaIma(i,"Sd");
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
        if(Greenfoot.isKeyDown("X") || Greenfoot.isKeyDown("x"))
        {
            super.setIzq(false);
            if(this.getX() < getWorld().getWidth()/2)
            {           
                setLocation(getX()+super.getVelJugador(),getY());
            }
            super.animar();
        }
        
        if(Greenfoot.isKeyDown("Z") || Greenfoot.isKeyDown("z"))
        {
            super.setIzq(true);
            if(this.getX()+10 > 0)
            {
                setLocation(getX()-super.getVelJugador(),getY());
            }
            super.animar();
        }
        
        if(Greenfoot.isKeyDown("q") || Greenfoot.isKeyDown("Q")) 
        {
            super.saltar();
        }
    }
    
    public int getPosXs()
    {
        return this.getX();
    }
}