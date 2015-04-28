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
    private int imaActual;
    
    public Animal(int unTam)
    {
        this.arrIma=null;
        this.izq=false;
        this.numImagenes=unTam;
        this.imaActual=0;
        this.creaArregloIma(unTam);
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
        this.arrIma=new GreenfootImage[unTam*2];
    }
    
    public void insertaIma(int unaI,String unaCad)
    {
        this.arrIma[unaI]=new GreenfootImage(unaCad+(unaI+1)+".png");
        this.arrIma[unaI+this.numImagenes]=new GreenfootImage(this.arrIma[unaI]);
        this.arrIma[unaI+this.numImagenes].mirrorHorizontally();
    }   
    
    abstract public void movimiento();
    
    public void animar()
    {
       if(this.izq)
           this.setImage(arrIma[this.imaActual+this.numImagenes]);
       else
            setImage(arrIma[this.imaActual]);
            
       if(this.imaActual >= this.numImagenes-1)
            this.imaActual=0;
       else
            this.imaActual++;
    }
}