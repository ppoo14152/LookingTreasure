import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yanmega here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yanmega extends Enemy
{  
   public Yanmega()
   {
      super(14);
      for(int i = 0; i < super.getNumIma();i++)
      {
          super.insertaIma(i,"Yi");
      }
      super.animar();
   }
   
   public void act()
   {
       this.movimiento();
   }
    
   public void movimiento()
   {  
       super.setIzq(false);
       setLocation(getX()-3,getY());
       super.animar();
   }
}