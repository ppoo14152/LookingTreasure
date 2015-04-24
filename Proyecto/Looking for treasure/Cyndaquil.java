import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cyndaquil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cyndaquil extends Player
{
    /**
     * Act - do whatever the Cyndaquil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //derecha---------------
    GreenfootImage imagenCd1;
    GreenfootImage imagenCd2;
    GreenfootImage imagenCd3;
    GreenfootImage imagenCd4;
    GreenfootImage imagenCd5;
    GreenfootImage imagenCd6;
    //izquierda-------------
    GreenfootImage imagenCi1;
    GreenfootImage imagenCi2;
    GreenfootImage imagenCi3;
    GreenfootImage imagenCi4;
    GreenfootImage imagenCi5;
    GreenfootImage imagenCi6;
    //velocidad-------------
    private int velocidad;
    
    public Cyndaquil()
    {
        super();
        //derecha--------------------------------
        imagenCd1 = new GreenfootImage("Cd1.png");
        imagenCd2 = new GreenfootImage("Cd2.png");
        imagenCd3 = new GreenfootImage("Cd3.png");
        imagenCd4 = new GreenfootImage("Cd4.png");
        imagenCi5 = new GreenfootImage("Cd5.png");
        imagenCi6 = new GreenfootImage("Cd6.png");
        //izquierda------------------------------
        imagenCi1 = new GreenfootImage("Cd1.png");
        imagenCi2 = new GreenfootImage("Cd2.png");
        imagenCi3 = new GreenfootImage("Cd3.png");
        imagenCi4 = new GreenfootImage("Cd4.png");
        imagenCi5 = new GreenfootImage("Cd5.png");
        imagenCi6 = new GreenfootImage("Cd6.png");
        
        imagenCi1.mirrorHorizontally();
        imagenCi2.mirrorHorizontally();
        imagenCi3.mirrorHorizontally();
        imagenCi4.mirrorHorizontally();
        imagenCi5.mirrorHorizontally();
        imagenCi6.mirrorHorizontally();
        
        //--------------------------
        
        velocidad = 3;
        setImage(imagenCd1);
    }
    
    public void act()
    {
        movePlayer();
        checkFall();
    }
    
    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+velocidad,getY());
             switch(super.getNumImagen())
             {
                case 0:
                        super.cambiaImagen(this.imagenCd1,1);
                break;
                
                case 1:
                        super.cambiaImagen(this.imagenCd2,2);
                break;
                
                case 2:
                        super.cambiaImagen(this.imagenCd3,3);
                break;
                
                case 3:
                        super.cambiaImagen(this.imagenCd4,0);
                break;
                
                case 4:
                        super.cambiaImagen(this.imagenCd5,0);
                break;
                
                case 5:
                        super.cambiaImagen(this.imagenCd6,0);
                break;
             }
        
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-velocidad,getY());
             switch(super.getNumImagen())
             {
                case 0:
                        super.cambiaImagen(this.imagenCi1,1);
                break;
                
                case 1:
                        super.cambiaImagen(this.imagenCi2,2);
                break;
                
                case 2:   
                        super.cambiaImagen(this.imagenCi3,3);
                break;
                
                case 3:
                        super.cambiaImagen(this.imagenCi4,4);
                break;
                
                case 4:
                        super.cambiaImagen(this.imagenCi5,5);
                break;
                
                case 5:
                        super.cambiaImagen(this.imagenCi6,0);
                break;
             }
        
        }
        
        if(Greenfoot.isKeyDown("up"))
        { 
           saltar();
        }
    }
}
