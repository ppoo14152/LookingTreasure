import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arbok here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbok extends Enemy
{
    private int cont;

    public Arbok()
    {
        super(6,2);
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
        super.setIzq(true);
        this.setLocation(getX()-2,getY());
        this.animar();
        if(this.cont == 8) 
        {
            super.setBandAtaca(true);
            for(int i=0; i < super.getnumAtaca(); i++)
            {
                super.animar();
            }
            super.disparar(3,this.getX(),this.getY());
            super.setBandAtaca(false);
            this.cont=0;
        }
        this.cont++;
    }
}