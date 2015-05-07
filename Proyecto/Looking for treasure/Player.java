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
    private int numJug;
    private int numTes;
    private boolean bandTesoro;

    public Player(int numJug,int numImaAtack,int numTes)
    {
        super(numJug+numTes,numImaAtack);
        this.numJug=numJug;
        this.numTes=numTes;
        this.bandTesoro=false;
        
        this.setNumImagen(0);
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
        if(this.estaEnPiso()) {
            this.velocidadSalto = 0;
        }
        else {
            this.caer();
        }   
    }
            
    public void caer()
    {
        this.setLocation(getX(),getY()+velocidadSalto);
        this.velocidadSalto = this.velocidadSalto + this.aceleracion;
        this.estaSaltando=false;
    }  
    
    public void cambiaImagen(GreenfootImage unaImagen,int numI)
    {
         this.setImage(unaImagen);
         this.setNumImagen(numI);
    }
    
    public void insertaIma(int unaI,String unaCad)
    {
        super.setPos(unaI,new GreenfootImage(unaCad+(unaI+1)+".png"));
        super.setPos(unaI+this.numJug+this.numTes,new GreenfootImage(this.getPos(unaI)));
        super.getPos(unaI+this.numJug+this.numTes).mirrorHorizontally();
    }   

    public void animar()
    {
        WorldTreasure mundo;
        mundo=((WorldTreasure)this.getWorld());
        
        if(!super.getIzq())
        {
            if(!this.getBanTesoro())
            {
                if(super.getActual() >= 0 && getActual() < this.numJug)
                {
                    setImage(super.getPos(super.getActual()));
                    super.setActual(super.getActual()+1);
                }
                else
                    super.setActual(0);
            }
            else
            {
                if(super.getActual() >= this.numJug && super.getActual() < numJug+numTes)
                {        
                    setImage(super.getPos(super.getActual()));
                    super.setActual(super.getActual()+1);
                }
                else
                    super.setActual(numJug);
            }
        }
        else
        {
            if(!this.getBanTesoro())
            {
                if(super.getActual() >= numJug+numTes && super.getActual() < 2*this.numJug+numTes)
                {
                    setImage(super.getPos(super.getActual()));
                    super.setActual(super.getActual()+1);
                }
                else
                    super.setActual(numJug+numTes);
            }
            else
            {
                if(super.getActual() >= 2*this.numJug+numTes && super.getActual() < (2*numJug)+(2*numTes))
                {
                    setImage(super.getPos(super.getActual()));
                    super.setActual(super.getActual()+1);
                }
                else
                    super.setActual(2*numJug+numTes);
            }
        }
    }
    
    public void setBanTesoro(boolean unaBan)
    {
        this.bandTesoro=unaBan;
    }
    
    public boolean getBanTesoro()
    {
        return this.bandTesoro;
    }
    
    public void tocoTesoro()
    {
        WorldTreasure mundo=(WorldTreasure)getWorld();
        if(isTouching(Treasure.class))
        {
            mundo.removeObjects(mundo.getObjects(Treasure.class));
            this.setBanTesoro(true);
        }
    }
}