import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Enemy extends Animal
{
    private int numeroImagen;
    private int numEne;
    private int numAtaca;
    
    public Enemy(int numImagenes,int numImaAtack)
    {
        super(numImagenes,numImaAtack);
        this.numEne=numImagenes;
        this.numAtaca=numImaAtack;
        this.setNum(0);
    }
    
    public void act() 
    {
        this.setLocation(this.getX()-2,this.getY());
    }
    
    public void setNum(int unNum)
    {
        this.numeroImagen=unNum;
    }
    
    public int getNum()
    {
        return this.numeroImagen;
    }
    
    public void cambiaImagen(GreenfootImage unaImagen,int num)
    {
        this.setImage(unaImagen);
        this.setNum(num);
    }
    
    abstract public void movimiento();
    
    public void animar()
    {
        WorldTreasure mundo;
        mundo=((WorldTreasure)this.getWorld());
        int inicio,fin;
        
        if(!super.getIzq())
        {
            if(!super.getBandAtaca())
            {
                inicio=0;
                fin=this.numEne;
            }
            else
            {
                inicio=this.numEne;
                fin=this.numEne+numAtaca;
            }
        }
        else
        {
            if(!super.getBandAtaca())
            {
                inicio=this.numEne+this.numAtaca;
                fin=(2*this.numEne)+numAtaca;
            }
            else
            {
                inicio=(2*this.numEne)+numAtaca;
                fin=(2*numAtaca)+(2*numEne);
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
    
     public void setnumAtaca(int unNum)
    {
        this.numAtaca=unNum;
    }
    
    public int getnumAtaca()
    {
        return this.numAtaca;
    }
}