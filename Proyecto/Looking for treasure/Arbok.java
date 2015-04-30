import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arbok here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbok extends Enemy
{
    /**
     * Act - do whatever the Arbok wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Cyndaquil cindaquil;
    private Squirtle squirtle;
    private GreenfootImage[] imagenes;
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
        imagenes = super.getIimagenArr();
        timer = 0;
        cont = 0;
        for(int i = 0; i < 6; i++){
            super.insertaIma(i,"Ad");
        }

        for(int i=12; i< 15; i++){
            super.insertaIma(i,"atack");
        }
        super.animar();
    }

    public void act()
    {
        this.checaMuerte();
        if(this.detectaJugador() != null ) {
           if(ataco == true && timer <1) {
             ataca();
             timer++;
             this.checaMuerte();
           }
        }else {
           ataco = false;
           timer = 0;
           this.movimiento();
           this.checaMuerte();
        }
        
    }

    public void movimiento()
    {  
        
        if(((WorldTreasure)getWorld()).getPosXc()  > this.getX() || ((WorldTreasure)getWorld()).getPosXs() > this.getX() && ataco == false)
        {
            super.setIzq(false);
            setLocation(getX()+2,getY());
            super.animar();
            posicion = 0;
        }

        if(((WorldTreasure)getWorld()).getPosXc() < this.getX() || ((WorldTreasure)getWorld()).getPosXs() < this.getX() && ataco == false) 
        {
            super.setIzq(true);
            setLocation(getX()-2,getY());
            super.animar();
            posicion = 1;
        }
        
        }
       
    public void ataca()
    {
        super.animarDisparo();
        if(posicion == 0){
            super.disparaEnemy(imagenes[17],posicion,this.getX(),this.getY());
        }else{
            super.disparaEnemy(imagenes[14],posicion,this.getX(),this.getY());
        }
    }
    
    public Player detectaJugador()
    {
      Player p;
      ataco = true;
      p = (Player)(getOneObjectAtOffset(-100,0,Player.class));
      return p;
    } 
    
      public void checaMuerte()
    {
        if( isTouching(BalaJugador.class) ) {
            ((WorldTreasure)getWorld()).setPoints();
            ((WorldTreasure)getWorld()).removeObject(this);
        }
    }
     
} 
