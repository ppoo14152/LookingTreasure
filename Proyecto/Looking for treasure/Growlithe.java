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
        super(4,0);
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
        this.checaMuerte();
    }
    
    public void movimiento()
    {  
       super.setIzq(true);
       this.setLocation(this.getX()-5,this.getY());
       super.animar();
    } 
    
    public void checaMuerte()
    {
        if( isTouching(BalaJugador.class) ) {
            ((WorldTreasure)getWorld()).setPoints();
            ((WorldTreasure)getWorld()).removeObject(this);
        }
    }
}