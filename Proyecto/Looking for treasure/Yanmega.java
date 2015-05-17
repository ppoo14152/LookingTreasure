import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase Yanmega uno de los enemigos del bosque su poder es disparar aguijón.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
public class Yanmega extends Enemy
{  
    private int disparo;
    
   public Yanmega()
   {
      super(14,0);
      for(int i = 0; i < 14;i++) 
      {
          super.insertaIma(i,"Yi");
      }
   }
   
   public void act()
   {
       this.movimiento();
       this.atacaJugador();
   }
   
   /**
    * Método para animar al enemigo
    */
   public void movimiento()
   {  
       super.setIzq(false);
       this.setLocation(getX()-3,getY());
       super.animar();
   }
   
   /**
    * Método para atacar del enemigo 
    */
   public void atacaJugador()
   {
     this.disparo = Greenfoot.getRandomNumber(100);
     if( this.disparo == 50 ) 
     { 
         super.disparar(4,this.getX(),this.getY());
     }
   }
}