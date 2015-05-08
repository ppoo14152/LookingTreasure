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
    private int numAtaca;
    private boolean bandTesoro;

    public Player(int numJug,int numTes,int numImaAtack)
    {
        super(numJug+numTes,numImaAtack);
        this.numJug=numJug;
        this.numTes=numTes;
        this.setnumAtaca(numImaAtack);
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
        super.setPos(unaI+this.numJug+this.numTes+this.numAtaca,new GreenfootImage(this.getPos(unaI)));
        super.getPos(unaI+this.numJug+this.numTes+this.numAtaca).mirrorHorizontally();
    }   

    public void animar()
    {
        WorldTreasure mundo;
        mundo=((WorldTreasure)this.getWorld());
        int inicio,fin;
        
        if(!super.getIzq())
        {
            if(!this.getBanTesoro())
            {
                if(!super.getBandAtaca())
                {
                    inicio=0;
                    fin=this.numJug;
                }
                else
                {
                    inicio=this.numJug+numTes;
                    fin=this.numJug+numTes+numAtaca;
                }
            }
            else
            {
                inicio=this.numJug;
                fin=this.numJug+numTes;
            }
        }
        else
        {
            if(!this.getBanTesoro())
            {
                if(!super.getBandAtaca())
                {
                    inicio=this.numJug+this.numTes+this.numAtaca;
                    fin=(2*this.numJug)+numTes+numAtaca;
                }
                else
                {
                    inicio=(2*numJug)+(2*numTes)+numAtaca;
                    fin=(2*numAtaca)+(2*numJug)+(2*numTes);
                }
            }
            else
            {
                inicio=(2*this.numJug)+numTes+numAtaca;
                fin=(2*numJug)+(2*numTes)+numAtaca;
            }
        }
        if(super.getActual() >= inicio && super.getActual() < fin)
        {
            this.setImage(super.getPos(super.getActual()));
            super.setActual(super.getActual()+1);
        }
        else
            super.setActual(inicio);
    }
    
    public void setBanTesoro(boolean unaBan)
    {
        this.bandTesoro=unaBan;
    }
    
    public boolean getBanTesoro()
    {
        return this.bandTesoro;
    }
    
    public void setnumAtaca(int unNum)
    {
        this.numAtaca=unNum;
    }
    
    public int getnumAtaca()
    {
        return this.numAtaca;
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