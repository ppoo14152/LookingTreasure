import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Player extends Animal
{
    private int numImagen;
    //Salto------------------
    private int velocidad;
    private int velocidadSalto;
    private int aceleracion;
    private boolean salto;
    private int jump;
    private int tiempo;
    private boolean estaSaltando;
    private int velJugador;
    private GreenfootImage[] arrTesoro;

    public Player(int numImagenes)
    {
        super(numImagenes);
        this.setNumImagen(0);
        //Salto---------------------------------
        this.velocidad = 7;
        this.velocidadSalto = 0;
        this.aceleracion = 2;
        this.salto = false;
        this.jump = 10;
        this.tiempo = 0;
        this.estaSaltando=true;
        this.setVelJugador(3);
    }
    
    public int getVelJugador()
    {
        return this.velJugador;
    }
    
    public void setVelJugador(int unNum)
    {
        this.velJugador=unNum;
    }
    
    public void setNumImagen(int unNum)
    {
        this.numImagen=unNum;
    }
    
    public int getNumImagen()
    {
        return this.numImagen;
    }
    
    abstract public void movimiento();
    
    public void saltar()
    {
        if(!this.estaSaltando)
        {
            this.estaSaltando=true;    
            this.velocidadSalto = -this.jump;
            this.caer();
        }
    }
      
    public boolean estaEnPiso()
    {
        boolean avisa;
        
        if(!isTouching(FloorTwo.class))
            avisa=false;
        else
            avisa=true;
            
        return avisa;
    }
      
    public void caida()
    {
        if(this.estaEnPiso()){
            this.velocidadSalto = 0;
        }
        else{
            this.caer();
        }   
    }
            
    public void caer()
    {
        setLocation(getX(),getY()+velocidadSalto);
        velocidadSalto = velocidadSalto + aceleracion;
        this.estaSaltando=false;
    }  
    
    public void cambiaImagen(GreenfootImage unaImagen,int numI)
    {
         this.setImage(unaImagen);
         this.setNumImagen(numI);
    }

    public void act()
    {
        if(isTouching(Treasure.class)){
            removeTouching(Treasure.class);
        }
    }    
}
