import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Signboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
   
   
public class Signboard extends Actor
{
    private int tiempo;
    public Signboard(String mensaje)
    {
        GreenfootImage letrero;
        letrero= new GreenfootImage(mensaje ,50 ,java.awt.Color.BLACK ,java.awt.Color.YELLOW);
        setImage(letrero);
        tiempo=10;
    } 
    
     public void quitoLetrero()
    {
      if(tiempo != 0) {
          tiempo = tiempo-1;
      }else {
          ((WorldTreasure)getWorld()).removeObject(this);
      }
    }
    
    public void act()
    {
        //this.quitoLetrero();   
    }
}
