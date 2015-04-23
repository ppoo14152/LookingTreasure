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
    GreenfootImage imagenAd1;
    GreenfootImage imagenAd2;
    GreenfootImage imagenAd3;
    GreenfootImage imagenAd4;
    GreenfootImage imagenAd5;
    GreenfootImage imagenAd6;
    //izquierda-------------
    GreenfootImage imagenAi1;
    GreenfootImage imagenAi2;
    GreenfootImage imagenAi3;
    GreenfootImage imagenAi4;
    GreenfootImage imagenAi5;
    GreenfootImage imagenAi6;
    //---------------------
    
    public Arbok()
    {
        //derecha--------------------------------
        imagenAd1 = new GreenfootImage("Ad1.png");
        imagenAd2 = new GreenfootImage("Ad2.png");
        imagenAd3 = new GreenfootImage("Ad3.png");
        imagenAd4 = new GreenfootImage("Ad4.png");
        imagenAi5 = new GreenfootImage("Ad5.png");
        imagenAi6 = new GreenfootImage("Ad6.png");
        //izquierda------------------------------
        imagenAi1 = new GreenfootImage("Ai1.png");
        imagenAi2 = new GreenfootImage("Ai2.png");
        imagenAi3 = new GreenfootImage("Ai3.png");
        imagenAi4 = new GreenfootImage("Ai4.png");
        imagenAi5 = new GreenfootImage("Ai5.png");
        imagenAi6 = new GreenfootImage("Ai6.png");
        //----------------------------------------
        setImage(imagenAd1);
    }
    
    public void act()
    {
        moveEnemy();
        //super.act();
    }
    
    public void moveEnemy()
    {    
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()+3,getY());
            switch(super.getNumD())
            {
                case 0:
                        super.cambiaImagen(imagenAd1,1);
                break;
                case 1:
                        super.cambiaImagen(imagenAd2,2);
                break;
                case 2:
                        super.cambiaImagen(imagenAd3,3);
                break;
                case 3: 
                        super.cambiaImagen(imagenAd4,0);
                break;
                case 4:
                        super.cambiaImagen(imagenAd5,0);
                break;
                case 5: 
                        super.cambiaImagen(imagenAd6,0);
                break;
             }
        
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()-3,getY());
            switch(super.getNumI())
            {
                case 0:
                        this.setImage(this.imagenAi1);
                        super.setNumI(1);
                break;
                case 1:
                        this.setImage(this.imagenAi2);
                        super.setNumI(2);
                break;
                case 2:
                        this.setImage(this.imagenAi3);
                        super.setNumI(3);
                break;
                case 3:
                        this.setImage(this.imagenAi4);
                        super.setNumI(0);
                break;
                case 4:
                        this.setImage(this.imagenAd4);
                        super.setNumI(0);
                break;
                case 5:
                        this.setImage(this.imagenAd4);
                        super.setNumI(0);
                break;
             }
        
        }
    }

}