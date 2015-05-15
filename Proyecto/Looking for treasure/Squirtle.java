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
    private int cont;
    
    public Squirtle()
    {
        super(4,4,2);
        this.ataque = false;
        this.cont = 0;
        for(int i = 0; i < 10; i++)
        {
            super.insertaIma(i,"Sd");
        }
    }

    public void act()
    {
        this.movimiento();
        super.caida();
        super.tocoTesoro();
    }
    
    /**
     * metodo para animar el movimiento del jugador
     */
    public void movimiento()
    {   
        if((Greenfoot.isKeyDown("X") || Greenfoot.isKeyDown("x")) && ataque == false) {
            super.setIzq(false);
            if(this.getX() < getWorld().getWidth()/2)
            {           
                this.setLocation(getX()+super.getVelJugador(),getY());
            }
            super.animar();
        }

        if((Greenfoot.isKeyDown("Z") || Greenfoot.isKeyDown("z")) && ataque == false) {
            super.setIzq(true);
            if(this.getX()+10 > 0) {
                setLocation(getX()-super.getVelJugador(),getY());
            }
            super.animar();
        }

        if((Greenfoot.isKeyDown("q") || Greenfoot.isKeyDown("Q")) && ataque == false) {
            super.saltar();
        }
        
        if(Greenfoot.isKeyDown("w")) 
        {
            if(this.cont == 8) 
            {
                super.setBandAtaca(true);
                if(!super.getBanTesoro())
                {
                for(int i=0; i < super.getnumAtaca(); i++)
                {
                    super.animar();
                }
                super.disparar(1,this.getX(),this.getY());
                super.setBandAtaca(false);
                this.cont=0;
                }
            }
            this.cont++;
        }
    }
}