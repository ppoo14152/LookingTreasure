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
    private int disparo;
    private boolean ataco;
    private int posicion;

    public Arbok(Cyndaquil c, Squirtle s)
    {
        super(6,3);
        this.cindaquil=c;
        this.squirtle=s;
        this.ataco=false;
        
        for(int i = 0; i < 6; i++){
            super.insertaIma(i,"Ad");
        }

        for(int i=12; i< 15; i++){
            super.insertaIma(i,"atack");
        }

        super.animar();
    }

    public void act()
    {
        this.movimiento();
    }

    public void movimiento()
    {  
        disparo = Greenfoot.getRandomNumber(50);

        if(cindaquil.getPosXc() > this.getX() || squirtle.getPosXs() > this.getX() && ataco == false)
        {
            super.setIzq(false);
            setLocation(getX()+2,getY());
            super.animar();
            posicion = 0;
        }

        if(cindaquil.getPosXc() < this.getX() || squirtle.getPosXs() < this.getX() && ataco == false) 
        {
            super.setIzq(true);
            setLocation(getX()-2,getY());
            super.animar();
            posicion = 1;
        }
        
        if(disparo == 5) {
            ataco = true;
            super.animarDisparo();
            //super.dispara(imagen,posicion,x,y);
        }

    }
}