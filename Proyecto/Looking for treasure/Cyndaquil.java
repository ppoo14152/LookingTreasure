import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cyndaquil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cyndaquil extends Player
{
    private GreenfootImage[] arrCynda;

    public Cyndaquil()
    {
        super();
        arrCynda=new GreenfootImage[12];
        
        for(int i = 0,cont=1; i < arrCynda.length/2; i++)
        {
            arrCynda[i]=new GreenfootImage("Cd"+(i+1)+".png");
            arrCynda[i+6]=new GreenfootImage("Cd"+(i+1)+".png");
            arrCynda[i+6].mirrorHorizontally();
        }
        this.setImage(arrCynda[0]);
    }
    
    public void act()
    {
        this.movePlayer();
        super.caida();
    }
    
    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("right"))
        { 
            if(this.getX()+10 < getWorld().getWidth()/2){
                setLocation(getX()+super.getVelJugador(),getY());
            }
                switch(super.getNumImagen())
                {
                    case 0:
                            super.cambiaImagen(this.arrCynda[0],1);
                    break;
                    case 1:
                            super.cambiaImagen(this.arrCynda[1],2);
                    break;
                    case 2:
                            super.cambiaImagen(this.arrCynda[2],3);
                    break;
                    case 3:
                            super.cambiaImagen(this.arrCynda[3],4);
                    break;
                    case 4:
                            super.cambiaImagen(this.arrCynda[4],5);
                    break;
                    case 5:
                            super.cambiaImagen(this.arrCynda[5],0);
                    break;
                }
            }
 
            if(Greenfoot.isKeyDown("left"))
            {
                if(this.getX()+10 > 0){
                    setLocation(getX()-super.getVelJugador(),getY());
                }
                switch(super.getNumImagen())
                {
                    case 0:
                            super.cambiaImagen(this.arrCynda[6],1);
                    break;
                    case 1:
                            super.cambiaImagen(this.arrCynda[7],2);
                    break;
                    case 2:   
                            super.cambiaImagen(this.arrCynda[8],3);
                    break;
                    case 3:
                            super.cambiaImagen(this.arrCynda[9],4);
                    break;
                    case 4:
                            super.cambiaImagen(this.arrCynda[10],5);
                    break;
                    case 5:
                            super.cambiaImagen(this.arrCynda[11],0);
                    break;
                }
            }
        
            if(Greenfoot.isKeyDown("up"))
            { 
                saltar();
            }
    }
    
    public int getPosX()
    {
        return this.getX();
    }
}
