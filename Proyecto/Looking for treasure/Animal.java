import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Pokemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Animal extends Actor
{
    private GreenfootImage[] arrIma;
    private boolean izq;
    private int numImagenes;
    private int numImagenesAtack;
    private int imaActual;
    private boolean bandAtaca;
    private SimpleTimer time;
    
    public Animal(int numImaJug,int numImaAttack)
    {
        this.time=new SimpleTimer();
        this.arrIma=null;
        this.izq=false;
        this.numImagenes=numImaJug;
        this.imaActual=0;
        this.numImagenesAtack=numImaAttack;
        this.creaArregloIma(numImaJug);
        this.setBandAtaca(false);
    }

    public void setIzq(boolean unaDir)
    {
        this.izq=unaDir;
    }

    public boolean getIzq()
    {
        return this.izq;
    }

    public void setActual(int unaActual)
    {
        this.imaActual=unaActual;
    }

    public int getActual()
    {
        return this.imaActual;
    }

    public void setNumIma(int unNum)
    {
        this.numImagenes=unNum;
    }

    public int getNumIma()
    {
        return this.numImagenes;
    }

    public void creaArregloIma(int unTam)
    {
        this.arrIma=new GreenfootImage[(unTam+this.numImagenesAtack) * 2];
    }
    
    public void insertaAtaque(int unaI,String unaCad)
    {
        this.setPos(unaI,new GreenfootImage(unaCad+(unaI+1)+".png"));
        this.setPos(unaI+(2*numImagenes)+numImagenesAtack,new GreenfootImage(this.getPos(unaI)));
        this.getPos(unaI+(2*numImagenes)+numImagenesAtack).mirrorHorizontally();
    }
    
    public void insertaIma(int unaI,String unaCad)
    {
        this.arrIma[unaI]=new GreenfootImage(unaCad+(unaI+1)+".png");
        this.arrIma[unaI+this.numImagenes+numImagenesAtack]=new GreenfootImage(this.arrIma[unaI]);
        this.arrIma[unaI+this.numImagenes+numImagenesAtack].mirrorHorizontally();
    }   

    abstract public void movimiento();

    public void animar()
    {  
     if(!this.getIzq())
     {
         if(!this.getBandAtaca())
         {
             if(this.getActual() >= 0 && getActual() < this.numImagenes)
             {
                 setImage(this.getPos(this.getActual()));
                 this.setActual(this.getActual()+1);
             }
             else
                 this.setActual(0);
         }
         else
         {
             if(this.getActual() >= this.numImagenes && this.getActual() < numImagenes+numImagenesAtack)
             {        
                setImage(this.getPos(this.getActual()));
                this.setActual(this.getActual()+1);
             }
             else
                 this.setActual(numImagenes);
         }
     }
     else
     {
         if(!this.getBandAtaca())
         {
             if(this.getActual() >= numImagenes+numImagenesAtack && this.getActual() < 2*this.numImagenes+numImagenesAtack)
             {
                setImage(this.getPos(this.getActual()));
                this.setActual(this.getActual()+1);
             }
             else
                this.setActual(numImagenes+numImagenesAtack);
         }
         else
         {
             if(this.getActual() >= 2*this.numImagenes+numImagenesAtack && this.getActual() < (2*numImagenes)+(2*numImagenesAtack))
             {
                setImage(this.getPos(this.getActual()));
                this.setActual(this.getActual()+1);
             }
             else
                this.setActual(2*numImagenes+numImagenesAtack);
         }
     }  
    }
    
    public void setBandAtaca(boolean unaBan)
    {
        this.bandAtaca=unaBan;
    }
    
    public boolean getBandAtaca()
    {
        return this.bandAtaca;
    }
    
    public void disparar(int unTipo,int x,int y)
    {
        if(time.millisElapsed()>=1000) 
        {
            this.time.mark();
            getWorld().addObject(new Bala(unTipo,this.getIzq()),x,y);
        }
    }
    
    public GreenfootImage getPos(int unaPos)
    {
        return this.arrIma[unaPos];
    }
    
    public void setPos(int unaPos,GreenfootImage unaImagen)
    {
        this.arrIma[unaPos]=unaImagen;
    }
}