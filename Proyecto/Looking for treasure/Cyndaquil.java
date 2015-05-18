import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase Cyndaquil uno de los jugadores tiene el poder de disparar fuego.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
public class Cyndaquil extends Player
{
    private boolean ataque;
    private int posicion ;
    private int cont;
    
    /**
     * Constructor de Cyndaquil.
     */
    public Cyndaquil()
    {
        super(6,6,0);
        this.ataque = false;
        this.cont=0;
        for(int i = 0; i < 12;i++)
        {
            super.insertaIma(i,"Cd");
        }
    }
    
    /**
     * Actua de Cyndaquil
     */
    public void act()
    {
        this.movimiento();
        super.caida();
        super.tocoTesoro();
    }
    
    /**
     * Método para animar el movimiento del jugador
     */
    public void movimiento()
    {
        
        if(Greenfoot.isKeyDown("right")) {
            super.setIzq(false);
            if(this.getX()+10 < getWorld().getWidth()/2)
            {
                this.setLocation(getX()+super.getVelJugador(),this.getY());
            }
            this.posicion = 0;
            super.animar();
        }
        
        if(Greenfoot.isKeyDown("left")) {
            super.setIzq(true);
            if(this.getX()+10 > 0)
            {
                this.setLocation(getX()-super.getVelJugador(),this.getY());
            }
            this.posicion = 1;
            super.animar();
        }
        
        if(Greenfoot.isKeyDown("up"))
        { 
            super.saltar();
        }
        
        if(Greenfoot.isKeyDown("p") )
        {
            if(this.cont == 8) 
            {
                super.setBandAtaca(true);
                if(!super.getBanTesoro())
                {
                    super.disparar(2,this.getX(),this.getY());
                    super.setBandAtaca(false);
                    this.cont=0;
                }
            }
            this.cont++;
        }       
    }
  } 