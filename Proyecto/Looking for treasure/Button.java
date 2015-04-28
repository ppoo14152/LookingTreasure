import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Button extends Actor
{    
    private int numBoton;
    private boolean sedioClick;
    
    public Button(int unNum)
    {
        this.numBoton=unNum;
        this.setSedioclick(false);
        this.setImage(new GreenfootImage("boton"+this.numBoton+".png"));
        this.getImage().scale(this.getImage().getWidth()/3,this.getImage().getHeight()/3);
        if(numBoton==4)
        {
            this.getImage().scale(this.getImage().getWidth()/2,this.getImage().getHeight()/2);
        }
    }
    
    public void act()
    {
       if(Greenfoot.mouseClicked(this))
       {
           this.sedioClick=true;
       }
    }
    
    public boolean getSedioclick()
    {
        return this.sedioClick;
    }
    
    public void setSedioclick(boolean unClick)
    {
        this.sedioClick=unClick;
    }
}