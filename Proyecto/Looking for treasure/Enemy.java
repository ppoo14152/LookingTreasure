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
    
    public Enemy(int numImagenes,int numImaAtack)
    {
        super(numImagenes,numImaAtack);
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
}    