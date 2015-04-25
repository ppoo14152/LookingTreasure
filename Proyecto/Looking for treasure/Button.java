import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Button extends Actor
{    
    private int numBoton;
    private GreenfootImage[] arrIma;
    
    public Button(int unNumBot)
    {
       /* arrIma=new GreenfootImage[4];
        
        for(int i = 0; i <= arrIma.length; i++)
        {
            arrIma[i]=new GreenfootImage("boton"+i+".png");
        }
        this.setImage(arrIma[unNumBot]);
        this.numBoton=unNumBot;*/
    }
    
    public void act() 
    {
        this.cualBoton();
    }    
    
    public void cualBoton()
    {
       /* World mundo;
        mundo=getWorld();
        if (Greenfoot.mouseClicked(this))
        {
            ((WorldTreasure)mundo).menu(numBoton);
        }*/
    }
}
