import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yanmega here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yanmega extends Enemy
{  
    private int disparo;
    
   public Yanmega()
   {
      super(14,0);
      for(int i = 0; i < 14;i++) {
          super.insertaIma(i,"Yi");
      }
   }
   
   public void act()
   {
       this.movimiento();
       this.atacaJugador();
   }
    
   public void movimiento()
   {  
       super.setIzq(false);
       this.setLocation(getX()-3,getY());
       super.animar();
   }
   
   public void atacaJugador()
   {
     this.disparo = Greenfoot.getRandomNumber(100);
     if( this.disparo == 50 ) 
     { 
         super.disparar(4,this.getX(),this.getY());
     }
   }
}