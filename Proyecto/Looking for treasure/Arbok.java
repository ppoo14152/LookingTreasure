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
    private GreenfootImage[] arrArb;
    private Cyndaquil cindaquil;
    private Squirtle squirtle;
   
    public Arbok(Cyndaquil c, Squirtle s)
    {
        super();
        arrArb=new GreenfootImage[12];
        cindaquil=c;
        squirtle=s;
        
        for(int i = 0; i < arrArb.length/2; i++)
        {
            arrArb[i]=new GreenfootImage("Ad"+(i+1)+".png");
            arrArb[i+4]=new GreenfootImage("Ad"+(i+1)+".png");
            arrArb[i+4].mirrorHorizontally();
        }
        this.setImage(arrArb[0]);
    }
    
    public void act()
    {
        moveEnemy();
    }
    
    public void moveEnemy()
    {  
       if(cindaquil.getPosX() > this.getX() ) {
            setLocation(getX()+3,getY());
           switch(super.getNum()){
                case 0:
                        super.cambiaImagen(this.arrArb[0],1);
                break;
                case 1:
                        super.cambiaImagen(this.arrArb[1],2);
                break;
                case 2:
                        super.cambiaImagen(this.arrArb[2],3);
                break;
                case 3: 
                        super.cambiaImagen(this.arrArb[3],4);
                break;
                case 4:
                        super.cambiaImagen(this.arrArb[4],5);
                break;
                case 5: 
                        super.cambiaImagen(this.arrArb[5],0);
                break;
             }
        }
        
        if(cindaquil.getPosX() < this.getX() ) {
            setLocation(getX()-3,getY());
           switch(super.getNum()){
                case 0:
                        super.cambiaImagen(this.arrArb[6],1);
                break;
                case 1:
                        super.cambiaImagen(this.arrArb[7],2);
                break;
                case 2:
                        super.cambiaImagen(this.arrArb[8],3);
                break;
                case 3: 
                        super.cambiaImagen(this.arrArb[9],4);
                break;
                case 4:
                        super.cambiaImagen(this.arrArb[10],5);
                break;
                case 5: 
                        super.cambiaImagen(this.arrArb[11],0);
                break;
             }
        }
    }

}