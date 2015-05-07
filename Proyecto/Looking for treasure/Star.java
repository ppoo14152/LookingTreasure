import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Estrella here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Bonus
{
    public Star() 
    {
       this.getImage().scale(this.getImage().getWidth()/4,this.getImage().getHeight()/4);
    }    
}