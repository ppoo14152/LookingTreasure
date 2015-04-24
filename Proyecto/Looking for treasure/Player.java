import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Player extends Actor
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

    public Player()
    {
        
        this.setNumImagen(0);
        //Salto---------------------------------
        this.velocidad = 7;
        this.velocidadSalto = 0;
        this.aceleracion = 2;
        this.salto = false;
        this.jump = 10;
        this.tiempo = 0;
        this.estaSaltando=true;
    }
    
    /*public void setNumImagenD(int unNum)
    {
        this.numImagenD=unNum;
    }
    
    public int getNumImagenD()
    {
        return this.numImagenD;
    }*/
    
    public void setNumImagen(int unNum)
    {
        this.numImagen=unNum;
    }
    
    public int getNumImagen()
    {
        return this.numImagen;
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
    
    public void cambiaImagen(GreenfootImage unaImagen,int numI)
    {
        
        
         this.setImage(unaImagen);
         this.setNumImagen(numI);
       
       
    }
    
   /* public void cambiaImagenI(GreenfootImage unaImagen,int numI)
    {
        this.setImage(unaImagen);
        this.setNumImagenI(numI);
    }*/
    
    public void act() 
    {
        if(isTouching(Treasure.class)){
            removeTouching(Treasure.class);
        }
    }    
}
