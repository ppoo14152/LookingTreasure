import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yanmega here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yanmega extends Enemy
{  
    Cyndaquil cindaquil;
    Squirtle squirtle;
    GreenfootImage imagen;
    private int disparo;
    
   public Yanmega(Cyndaquil c,Squirtle s)
   {
      super(14,0);
      cindaquil=c;
      squirtle=s;
      imagen = new GreenfootImage("aguijon.png");
      for(int i = 0; i < super.getNumIma();i++) {
          super.insertaIma(i,"Yi");
      }
   }
   
   public void act()
   {
       this.movimiento();
       this.atacaJugador();
       this.checaMuerte();
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
     if( this.disparo == 50 ) { 
         super.disparaEnemy(imagen,2,this.getX(),this.getY());
     }
   }
   
    public void checaMuerte()
    {
        if( isTouching(BalaJugador.class) ) {
            ((WorldTreasure)getWorld()).setPoints();
            ((WorldTreasure)getWorld()).removeObject(this);
        }
    }
}