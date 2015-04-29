import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Squirtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Squirtle extends Player
{
    
    private boolean ataque;
    private int posicion;
    
    public Squirtle()
    {
        super(4,3);
        ataque = false;
        
        for(int i = 0; i < 4; i++)
        {
            super.insertaIma(i,"Sd");
        }
        
        for(int i = 8; i < 11; i++)
        {
            super.insertaIma(i,"atackS");
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
        if(Greenfoot.isKeyDown("X") || Greenfoot.isKeyDown("x") && ataque == false)
        {
            super.setIzq(false);
            if(this.getX() < getWorld().getWidth()/2)
            {           
                setLocation(getX()+super.getVelJugador(),getY());
            }
            super.animar();
        }

        if(Greenfoot.isKeyDown("Z") || Greenfoot.isKeyDown("z") && ataque == false)
        {
            super.setIzq(true);
            if(this.getX()+10 > 0){
                setLocation(getX()-super.getVelJugador(),getY());
            }
            super.animar();
        }

        if(Greenfoot.isKeyDown("q") || Greenfoot.isKeyDown("Q") && ataque == false) 
        {
            super.saltar();
        }
        
        if(Greenfoot.isKeyDown("w")) {
            ataque=true;
            super.animarDisparo();
            //super.dispara(,1,this.getX(),this.getY());
        }
    }

    public int getPosXs()
    {
        return this.getX();
    }
    
}