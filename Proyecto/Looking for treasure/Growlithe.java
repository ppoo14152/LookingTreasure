import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Growlithe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Growlithe extends Enemy
{
    private Cyndaquil cindaquil;
    private Squirtle squirtle; 
    
    public Growlithe(Cyndaquil c, Squirtle s)
    {
        super(4);
        cindaquil=c;
        squirtle=s;
        for(int i = 0; i < super.getNumIma();i++)
        {
            super.insertaIma(i,"Gd");
        }
        super.animar();
    }
    
    public void act()
    {
        this.movimiento();
    }
    
    public void movimiento()
    {    
        if(cindaquil.getPosXc() > this.getX() || squirtle.getPosXs() > this.getX())
        {
            super.setIzq(false);
            this.setLocation(this.getX()+3,this.getY());
            super.animar();
        }
        
        if(cindaquil.getPosXc() < this.getX() || squirtle.getPosXs() > this.getX())
        {
            super.setIzq(true);
            this.setLocation(this.getX()-3,this.getY());
            super.animar();
        }
    } 
}