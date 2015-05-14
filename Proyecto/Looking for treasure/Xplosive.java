import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Xplosive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Xplosive extends Actor
{   
    private GreenfootImage imagen;
    private int tiempo;
    
    public Xplosive(String unNombre)
    {
        this.imagen=new GreenfootImage(unNombre);
        this.imagen.scale(this.imagen.getWidth()/4,this.imagen.getHeight()/4);
        this.setImage(imagen);
        tiempo = 30;
    }
    
    public void quitoBala()
    {
      if(tiempo != 0) {
          tiempo = tiempo-1;
      }else {
          ((WorldTreasure)getWorld()).removeObject(this);
      }
    }
    
    public void act()
    {
        this.quitoBala();   
    }
}