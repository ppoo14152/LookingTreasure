import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Growlithe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Growlithe extends Enemy
{
    /**
     * Act - do whatever the Growlithe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     //derecha---------------
    GreenfootImage imagenGd1;
    GreenfootImage imagenGd2;
    GreenfootImage imagenGd3;
    GreenfootImage imagenGd4;
    //izquierda-------------
    GreenfootImage imagenGi1;
    GreenfootImage imagenGi2;
    GreenfootImage imagenGi3;
    GreenfootImage imagenGi4;
    //----------------------
    
    public Growlithe()
    {
        //derecha--------------------------------
        imagenGd1 = new GreenfootImage("Gd1.png");
        imagenGd2 = new GreenfootImage("Gd2.png");
        imagenGd3 = new GreenfootImage("Gd3.png");
        imagenGd4 = new GreenfootImage("Gd4.png");
        //izquierda------------------------------
        imagenGi1 = new GreenfootImage("Gi1.png");
        imagenGi2 = new GreenfootImage("Gi2.png");
        imagenGi3 = new GreenfootImage("Gi3.png");
        imagenGi4 = new GreenfootImage("Gi4.png");
        //----------------------------------------
        setImage(imagenGd1);
    }
    
    public void act()
    {
        this.moveEnemy();
    }
    
    public void moveEnemy()
    {    
        if(Greenfoot.isKeyDown("left"))
        {
            this.setLocation(this.getX()+3,this.getY());
             switch(super.getNumD())
             {
                case 0:
                        this.setImage(this.imagenGd1);
                        super.setNumD(1);
                break;
                case 1:
                        this.setImage(this.imagenGd2);
                        super.setNumD(2);
                break;
                case 2:
                        this.setImage(this.imagenGd3);
                        super.setNumD(3);
                break;
                case 3:
                        this.setImage(this.imagenGd4);
                        super.setNumD(0);
                break;
             }
        
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            this.setLocation(this.getX()-3,this.getY());
            switch(super.getNumI())
            {
                case 0:
                        this.setImage(this.imagenGi1);
                        super.setNumI(1);
                break;
                case 1:
                        this.setImage(this.imagenGi2);
                        super.setNumI(2);
                break;
                case 2:
                        this.setImage(this.imagenGi3);
                        super.setNumI(3);
                break;
                case 3:
                        this.setImage(this.imagenGi4);
                        super.setNumI(0);
                break;
             }
        }
    } 
}
