import greenfoot.*;

/**
 * Write a description of class BalaJugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaJugador extends Actor
{
    /**
     * Act - do whatever the BalaJugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagen;
    private int direccion;
    public BalaJugador(GreenfootImage unaImagen,int unaPosicion)
    {
        this.imagen = new GreenfootImage(unaImagen);
        this.imagen.scale(imagen.getWidth()/3,imagen.getHeight()/3);
        this.direccion = unaPosicion;
        this.setImage(imagen);
    }
    
    public void act() 
    {
        if(direccion == 1) {
            this.setLocation(getX()-10,getY());
        }    
        
        if(direccion == 0) {
            this.setLocation(getX()+10,getY());
       }
       
       if( isTouching(Arbok.class) || isTouching(Growlithe.class)  || isTouching(Yanmega.class) ) {
           ((WorldTreasure)getWorld()).removeObject(this);
        }
    }
}
