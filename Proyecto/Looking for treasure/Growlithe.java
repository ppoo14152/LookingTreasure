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
    private GreenfootImage[] arrGro;
    private Cyndaquil cindaquil;
    private Squirtle squirtle; 
    
    public Growlithe(Cyndaquil c, Squirtle s)
    {
        super();
        arrGro = new GreenfootImage[8];
        cindaquil=c;
        squirtle=s;
        
        for(int i = 0; i < arrGro.length/2; i++)
        {
            arrGro[i]=new GreenfootImage("Gd"+(i+1)+".png");
            arrGro[i+4]=new GreenfootImage("Gd"+(i+1)+".png");
            arrGro[i+4].mirrorHorizontally();
        }
        this.setImage(arrGro[0]);
    }
    
    public void act()
    {
        this.moveEnemy();
    }
    
   public void moveEnemy()
    {    
        if(cindaquil.getPosX() > this.getX()){
            this.setLocation(this.getX()+3,this.getY());
             switch(super.getNum())
             {
                case 0:
                        this.setImage(this.arrGro[0]);
                        super.setNum(1);
                break;
                case 1:
                        this.setImage(this.arrGro[1]);
                        super.setNum(2);
                break;
                case 2:
                        this.setImage(this.arrGro[2]);
                        super.setNum(3);
                break;
                case 3:
                        this.setImage(arrGro[3]);
                        super.setNum(0);
                break;
             }
        
        }
        
        if(cindaquil.getPosX() < this.getX()){
            this.setLocation(this.getX()-3,this.getY());
             switch(super.getNum())
             {
                case 0:
                        this.setImage(this.arrGro[4]);
                        super.setNum(1);
                break;
                case 1:
                        this.setImage(this.arrGro[5]);
                        super.setNum(2);
                break;
                case 2:
                        this.setImage(this.arrGro[6]);
                        super.setNum(3);
                break;
                case 3:
                        this.setImage(arrGro[7]);
                        super.setNum(0);
                break;
             }
        
        }
    
    } 
}
