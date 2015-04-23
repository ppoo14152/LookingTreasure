import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Player extends Actor
{
    private int numImagenD;
    private int numImagenI;
    //Salto------------------
    private int velocidad;
    private int velocidadSalto;
    private int aceleracion;
    private boolean salto;
    private int jump;
    private int tiempo;
    private boolean estaSaltando;

    public Player()
    {
        this.setNumImagenD(0);
        this.setNumImagenI(0);
        //Salto---------------------------------
        this.velocidad = 7;
        this.velocidadSalto = 0;
        this.aceleracion = 2;
        this.salto = false;
        this.jump = 10;
        this.tiempo = 0;
        this.estaSaltando=true;
    }
    
    public void setNumImagenD(int unNum)
    {
        this.numImagenD=unNum;
    }
    
    public int getNumImagenD()
    {
        return this.numImagenD;
    }
    
    public void setNumImagenI(int unNum)
    {
        this.numImagenI=unNum;
    }
    
    public int getNumImagenI()
    {
        return this.numImagenI;
    }
    
    abstract public void movePlayer();
    
    public void saltar()
    {
        if(!this.estaSaltando)
        {
            this.estaSaltando=true;    
            this.velocidadSalto = -this.jump;
            fall();
        }
    }
      
    public boolean onGround()
    {
        boolean avisa;
        
        if(!isTouching(FloorTwo.class))
            avisa=false;
        else
            avisa=true;
            
        return avisa;
    }
      
    public void checkFall()
    {
        if(onGround()){
            this.velocidadSalto = 0;
        }
        else{
            fall();
        }   
    }
            
    public void fall()
    {
        setLocation(getX(),getY()+velocidadSalto);
        velocidadSalto = velocidadSalto + aceleracion;
        this.estaSaltando=false;
    }  
    
    public void cambiaImagenD(GreenfootImage unaImagen,int numD)
    {
        this.setImage(unaImagen);
        this.setNumImagenD(numD);
    }
    
    public void cambiaImagenI(GreenfootImage unaImagen,int numI)
    {
        unaImagen.mirrorHorizontally();
        this.setImage(unaImagen);
        this.setNumImagenI(numI);
    }
    
    public void act() 
    {
        if(isTouching(Treasure.class)){
            removeTouching(Treasure.class);
        }
    }    
}
