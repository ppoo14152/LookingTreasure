import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cyndaquil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cyndaquil extends Player
{
    private GreenfootImage[] cindaAtack;
    private boolean ataque;
    private int posicion ;
    private GreenfootImage cindaquil; 
    private int cont;
    
    public Cyndaquil()
    {
        super(6,0);
        cindaAtack = new GreenfootImage[2];
        ataque = false;
        cindaquil=new GreenfootImage("Ct1.png");
        cont=0;
        for(int i = 0; i < super.getNumIma();i++)
        {
            super.insertaIma(i,"Cd");
        }
        
        for(int i = 0; i < 1; i++){
            cindaAtack[i]= new GreenfootImage("atackC1.png");
            cindaAtack[i+1]= new GreenfootImage("atackC1.png");
            cindaAtack[i+1].mirrorHorizontally();
        }
        super.animar();
    }
    
    public void act()
    {
        this.movimiento();
        super.tocoLLave();
        super.caida();
    }
    
    public void movimiento()
    {
        
        if(Greenfoot.isKeyDown("right")) {
            super.setIzq(false);
            if(this.getX()+10 < getWorld().getWidth()/2)
            {
                setLocation(getX()+super.getVelJugador(),getY());
            }
            posicion = 0;
            super.animar();
        }
        
        if(Greenfoot.isKeyDown("left")) {
            super.setIzq(true);
            if(this.getX()+10 > 0)
            {
                setLocation(getX()-super.getVelJugador(),getY());
            }
            posicion = 1;
            super.animar();
        }
        
        if(Greenfoot.isKeyDown("up"))
        { 
            super.saltar();
        }
        
        if(Greenfoot.isKeyDown("m") ){
            if( cont ==10) {
               if(posicion == 0){
                   cont =0;
                   super.disparaPlayer(this.cindaAtack[0],posicion,this.getX(),this.getY());
                }else{
                   super.disparaPlayer(this.cindaAtack[1],posicion,this.getX(),this.getY());
                   cont=0;
                }
          }else {
            cont++;
            }
        }       
    }
  } 
