import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Enemy extends Actor
{
    private int numeroImagenD;
    private int numeroImagenI;
    
    public Enemy()
    {
        this.setNumD(0);
        this.setNumI(0);
    }
    
    public void act() 
    {
        this.setLocation(this.getX()-2,this.getY());
    }
    
    public void setNumD(int unNum)
    {
        this.numeroImagenD=unNum;
    }
    
    public int getNumD()
    {
        return this.numeroImagenD;
    }
    
    public void setNumI(int unNum)
    {
        this.numeroImagenI=unNum;
    }
    
    public int getNumI()
    {
        return this.numeroImagenI;
    }
    
    public void cambiaImagen(GreenfootImage unaImagen,int numD)
    {
        this.setImage(unaImagen);
        this.setNumD(numD);
    }
    
    abstract public void moveEnemy();
}    

