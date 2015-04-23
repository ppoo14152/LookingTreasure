import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Squirtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Squirtle extends Player
{
    /**
     * Act - do whatever the Cyndaquil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //derecha---------------
    GreenfootImage imagenSd1;
    GreenfootImage imagenSd2;
    GreenfootImage imagenSd3;
    GreenfootImage imagenSd4;
    //izquierda-------------
    GreenfootImage imagenSi1;
    GreenfootImage imagenSi2;
    GreenfootImage imagenSi3;
    GreenfootImage imagenSi4;
    
    private int velocidad;
    
    public Squirtle()
    {
        //derecha--------------------------------
        imagenSd1 = new GreenfootImage("Sd1.png");
        imagenSd2 = new GreenfootImage("Sd2.png");
        imagenSd3 = new GreenfootImage("Sd3.png");
        imagenSd4 = new GreenfootImage("Sd4.png");
        //izquierda------------------------------
        imagenSi1 = new GreenfootImage("Si1.png");
        imagenSi2 = new GreenfootImage("Si2.png");
        imagenSi3 = new GreenfootImage("Si3.png");
        imagenSi4 = new GreenfootImage("Si4.png");
        //---------------------------------------
        velocidad = 3;
        setImage(imagenSd1);
    }
    
    public void act()
    {
        movePlayer();
        checkFall();
    }
    
    public void movePlayer()
    {    
        if(Greenfoot.isKeyDown("x")) {
            setLocation(getX()+velocidad,getY());
            switch(super.getNumImagenD()) {
                case 0:
                        super.cambiaImagenD(this.imagenSd1,1);
                break;
                
                case 1: 
                        super.cambiaImagenD(this.imagenSd2,2);
                break;
                
                case 2:     
                        super.cambiaImagenD(this.imagenSd3,3);
                break;
                
                case 3: 
                        super.cambiaImagenD(this.imagenSd4,0);
                break;
            }
        
        }
        
        if(Greenfoot.isKeyDown("z")) { 
            
            setLocation(getX()-velocidad,getY());
            
            switch(super.getNumImagenI()) {
                case 0: 
                        super.cambiaImagenI(this.imagenSd1,1); 
                break;
                case 1:
                        super.cambiaImagenI(this.imagenSd2,2);
                break;
                case 2: 
                        super.cambiaImagenI(this.imagenSd3,3);
                break;
                case 3:
                        super.cambiaImagenI(this.imagenSd4,0);
                break;
             }
        
        }
        
        if(Greenfoot.isKeyDown("q")) {
           saltar();
        }
    }
    
    
}