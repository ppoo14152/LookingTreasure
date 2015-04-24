import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Squirtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Squirtle extends Player
{
    private GreenfootImage[] arrSqui;
    
    public Squirtle()
    {
        super();
        arrSqui=new GreenfootImage[8];
        
        for(int i = 0; i < arrSqui.length/2; i++)
        {
            arrSqui[i]=new GreenfootImage("Sd"+(i+1)+".png");
            arrSqui[i+4]=new GreenfootImage("Sd"+(i+1)+".png");
            arrSqui[i+4].mirrorHorizontally();
        }
        this.setImage(arrSqui[0]);
    }
    
    public void act()
    {
        movePlayer();
        super.caida();
    }
    
    public void movePlayer()
    {   
            if(Greenfoot.isKeyDown("x")) {
                if(this.getX() < getWorld().getWidth()/2){           
                    setLocation(getX()+super.getVelJugador(),getY());
                }
                
                switch(super.getNumImagen()) {
                    case 0:
                            super.cambiaImagen(this.arrSqui[0],1);
                    break;
                    case 1: 
                            super.cambiaImagen(this.arrSqui[1],2);
                    break;
                    case 2:     
                            super.cambiaImagen(this.arrSqui[2],3);
                    break;
                    case 3: 
                            super.cambiaImagen(this.arrSqui[3],0);
                    break;
                }
           }
        
            if(Greenfoot.isKeyDown("z")) {
                if(this.getX()+10 > 0){
                    setLocation(getX()-super.getVelJugador(),getY());
                }
                switch(super.getNumImagen()) {
                    case 0: 
                            super.cambiaImagen(this.arrSqui[4],1); 
                    break;
                    case 1:
                            super.cambiaImagen(this.arrSqui[5],2);
                    break;
                    case 2: 
                            super.cambiaImagen(this.arrSqui[6],3);
                    break;
                    case 3:
                            super.cambiaImagen(this.arrSqui[7],0);
                    break;
                }
            }
        
            if(Greenfoot.isKeyDown("q")) {
                saltar();
            }
    } 
}