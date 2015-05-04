import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Bonus
{
    /**
     * Act - do whatever the Llave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage imagen = new GreenfootImage("llave1.png");
    private int velocidad;
    private int lim;
    private int cont;
    
    public Key() 
    {
        imagen.scale(imagen.getWidth()/4,imagen.getHeight()/4);
        setImage(imagen);
        velocidad = 2;
        lim = 100;
        cont = 0;
    }  
    
    public void act()
    {
        this.setLocation( this.getX() , this.getY() + velocidad);
        this.mueveLlave();
    }
    
    public void mueveLlave()
    {
      if(cont == lim) {
              this.velocidad = velocidad * -1;
              cont = 0;
        }else {
            cont++;
        }  
    }
}
