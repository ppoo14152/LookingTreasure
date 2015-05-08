import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arbok here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbok extends Enemy
{
    private int disparo;
    private int posicion;
    private int timer;
    private int cont;

    public Arbok()
    {
        super(6,2);
        this.disparo=0;
        this.timer = 0;
        this.cont = 0;
        for(int i = 0; i < 8; i++)
        {
            super.insertaIma(i,"Ad");
        }
    }

    public void act()
    {
        this.movimiento();
    }

    public void movimiento()
    {  
        /*if(((WorldTreasure)getWorld()).getPosXc()  > this.getX() || ((WorldTreasure)getWorld()).getPosXs() > this.getX() && super.getBandAtaca() == false)
        {
            super.setIzq(false);
            this.setLocation(getX()+2,getY());
            super.animar();
            this.posicion = 0;
        }

        if(((WorldTreasure)getWorld()).getPosXc() < this.getX() || ((WorldTreasure)getWorld()).getPosXs() < this.getX() && super.getBandAtaca() == false) 
        {
            super.setIzq(true);
            this.setLocation(getX()-2,getY());
            super.animar();
            this.posicion = 1;
        }
        
        if(this.posicion == 1) 
        {
            super.setBandAtaca(true);
            if(super.getBandAtaca() == true && this.timer <1)
            {
                this.ataca();
                this.timer++;
            }
        }
        else 
        {
            this.timer = 0;
            super.setBandAtaca(false);
        }
    
        if(this.posicion == 0) 
        {
            super.setBandAtaca(true);
            if(super.getBandAtaca() == true && this.timer <1) 
            {
                this.ataca();
                this.timer++;
            }
        }
        else 
        {
            this.timer = 0;
            super.setBandAtaca(false);
        }*/
    }
       
    public void ataca()
    {
        super.animar();
        super.disparar(3,this.getX(),this.getY());
    }
} 
