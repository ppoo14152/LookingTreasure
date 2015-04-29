import greenfoot.*;

/**
 * Write a description of class Disparo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disparo extends Actor
{
    /**
     * Act - do whatever the Disparo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage imagen;
    private int direccion;
    public Disparo(GreenfootImage unaImagen,int unaPosicion)
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
    }
}
