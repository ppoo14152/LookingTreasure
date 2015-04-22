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
        imagenCi1 = new GreenfootImage("Ci1.png");
        imagenCi2 = new GreenfootImage("Ci2.png");
        imagenCi3 = new GreenfootImage("Ci3.png");
        imagenCi4 = new GreenfootImage("Ci4.png");
        imagenCi5 = new GreenfootImage("Ci5.png");
        imagenCi6 = new GreenfootImage("Ci6.png");
        
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
             switch(super.getNumImagenD())
             {
                case 0:
                        super.cambiaImagenD(this.imagenCd1,1);
                break;
                
                case 1:
                        super.cambiaImagenD(this.imagenCd2,2);
                break;
                
                case 2:
                        super.cambiaImagenD(this.imagenCd3,3);
                break;
                
                case 3:
                        super.cambiaImagenD(this.imagenCd4,0);
                break;
                
                case 4:
                        super.cambiaImagenD(this.imagenCd5,0);
                break;
                
                case 5:
                        super.cambiaImagenD(this.imagenCd6,0);
                break;
             }
        
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-velocidad,getY());
             switch(super.getNumImagenI())
             {
                case 0:
                        super.cambiaImagenI(this.imagenCi1,1);
                break;
                
                case 1:
                        super.cambiaImagenI(this.imagenCi2,2);
                break;
                
                case 2:   
                        super.cambiaImagenI(this.imagenCi3,3);
                break;
                
                case 3:
                        super.cambiaImagenI(this.imagenCi4,0);
                break;
                
                case 4:
                        super.cambiaImagenI(this.imagenCi4,0);
                break;
                
                case 5:
                        super.cambiaImagenI(this.imagenCi4,0);
                break;
             }
        
        }
        
        if(Greenfoot.isKeyDown("up"))
        { 
           saltar();
        }
    }
}
