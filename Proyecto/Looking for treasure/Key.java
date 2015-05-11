import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Bonus
{
    private int velocidad;
    private int lim;
    private int cont;
    
    public Key() 
    {
        this.getImage().scale(this.getImage().getWidth()/4,this.getImage().getHeight()/4);
        this.velocidad = 2;
        this.lim = 100;
        this.cont = 0;
    }  
    
    public void act()
    {
        //this.setLocation( this.getX() , this.getY() + velocidad);
        //this.mueveLlave();
        this.tocoLLave();
    }
    
    /**
     * Metodo para mover en diversas posisciones la llave
     */
    public void mueveLlave()
    {
      if(this.cont == this.lim) {
              this.velocidad = this.velocidad * -1;
              this.cont = 0;
        }else {
            this.cont++;
        }  
    }
   
    /**
     * metodo para checar si alguno de los jugadores toco la llave
     */
    public void tocoLLave()
    {
        WorldTreasure mundo=(WorldTreasure)getWorld();
        if( isTouching(Cyndaquil.class) || isTouching(Squirtle.class)) 
        {
            mundo.setLevel(mundo.getLevel()+1);
            mundo.removeObject(this);
            mundo.setExisteLlave(false);
        }
    }
}