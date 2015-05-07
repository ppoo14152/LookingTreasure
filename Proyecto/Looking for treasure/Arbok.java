import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arbok here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbok extends Enemy
{
    private Cyndaquil cindaquil;
    private Squirtle squirtle;
    private int disparo;
    private boolean ataco;
    private int posicion;
    private int timer;
    private int cont;

    public Arbok(Cyndaquil c, Squirtle s)
    {
        super(6,3);
        this.cindaquil=c;
        this.squirtle=s;
        this.ataco=false;
        this.disparo=0;
        this.timer = 0;
        this.cont = 0;
        for(int i = 0; i < 6; i++){
            super.insertaIma(i,"Ad");
        }

        for(int i=12; i< 15; i++){
            super.insertaIma(i,"atack");
        }
    }

    public void act()
    {
        this.movimiento();
        this.checaMuerte();
    }

    public void movimiento()
    {  
        
        if(((WorldTreasure)getWorld()).getPosXc()  > this.getX() || ((WorldTreasure)getWorld()).getPosXs() > this.getX() && ataco == false)
        {
            super.setIzq(false);
            this.setLocation(getX()+2,getY());
            super.animar();
            this.posicion = 0;
        }

        if(((WorldTreasure)getWorld()).getPosXc() < this.getX() || ((WorldTreasure)getWorld()).getPosXs() < this.getX() && ataco == false) 
        {
            super.setIzq(true);
            this.setLocation(getX()-2,getY());
            super.animar();
            this.posicion = 1;
        }
        
        if(this.posicion == 1) {
         if( this.detectaJugadorI() != null ){
            this.ataco = true;
            super.animarDisparo();
             if(this.ataco == true && this.timer <1) {
             this.ataca();
             this.timer++;
           }
        }else {
            this.timer = 0;
            this.ataco = false;
        }
      }
      
        if(this.posicion == 0) {
         if( this.detectaJugadorD() != null ){
            this.ataco = true;
            super.animarDisparo();
             if(this.ataco == true && this.timer <1) {
             this.ataca();
             this.timer++;
           }
        }else {
            this.timer = 0;
            this.ataco = false;
        }
      }
      
      
    }
       
    public void ataca()
    {
        //super.animarDisparo();
        /*if(posicion == 0){
            super.disparaEnemy(imagenes[17],posicion,this.getX(),this.getY());
        }else{
            super.disparaEnemy(imagenes[14],posicion,this.getX(),this.getY());
        }*/
    }
    
    public Player detectaJugadorI()
    {
      Player p;
      ataco = true;
      p = (Player)(getOneObjectAtOffset(-100,0,Player.class));
      return p;
    } 
    
     public Player detectaJugadorD()
    {
      Player p;
      ataco = true;
      p = (Player)(getOneObjectAtOffset(100,0,Player.class));
      return p;
    } 
    
    /**
     * Metodo para saber si el enemigo murio
     * al momento de atacarlo
     */
      public void checaMuerte()
    {
        if( isTouching(BalaJugador.class) ) {
            ((WorldTreasure)getWorld()).setPoints();
            ((WorldTreasure)getWorld()).removeObject(this);
        }
    }
     
} 
