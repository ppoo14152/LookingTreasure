import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cyndaquil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cyndaquil extends Player
{
    private boolean ataque;
    private int posicion ;
    private int cont;
    
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
    
    public void act()
    {
        this.movimiento();
        super.caida();
        super.tocoTesoro();
    }
    
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
        
        if(Greenfoot.isKeyDown("m") )
        {
            super.setBandAtaca(true);
            if(this.cont == 8) 
            {
                super.disparar(2,this.getX(),this.getY());
                this.cont=0;
            }
            this.cont++;
            /*if( this.cont ==10) 
            {
               if(this.posicion == 0)
               {
                   this.cont =0;
                   
                  // super.disparaPlayer(this.cindaAtack[0],posicion,this.getX(),this.getY());
                }else
                {
                   //super.disparaPlayer(this.cindaAtack[1],posicion,this.getX(),this.getY());
                   this.cont=0;
                }
          }else 
            cont++;*/
        }       
    }
  } 