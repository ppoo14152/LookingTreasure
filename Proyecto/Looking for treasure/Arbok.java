import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arbok here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbok extends Enemy
 {
    /**
     * Act - do whatever the Arbok wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Cyndaquil cindaquil;
    private Squirtle squirtle;
   
    public Arbok(Cyndaquil c, Squirtle s)
    {
        super(6);
        this.cindaquil=c;
        this.squirtle=s; 
        for(int i = 0; i < super.getNumIma();i++)
        {
            super.insertaIma(i,"Ad");
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
           setLocation(getX()+3,getY());
           super.animar();
        }
        
        if(cindaquil.getPosXc() < this.getX() || squirtle.getPosXs() > this.getX()) 
        {
            super.setIzq(true);
            setLocation(getX()-3,getY());
            super.animar();
        }
    }
}