import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yanmega here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yanmega extends Enemy
{
    /**
     * Act - do whatever the Yanmega wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private GreenfootImage[] arrYan;
   
   public Yanmega()
   {
      super();
        arrYan=new GreenfootImage[14];
        for(int i = 0; i < arrYan.length; i++)
        {
            arrYan[i]=new GreenfootImage("Yi"+(i+1)+".png");
        }
        this.setImage(arrYan[0]); 
   }
   
   public void act()
    {
        moveEnemy();
    }
    
    public void moveEnemy()
    {  
       setLocation(getX()-3,getY());
        switch(super.getNum()){
            case 0:
                   super.cambiaImagen(this.arrYan[0],1);
            break;
            case 1:
                   super.cambiaImagen(this.arrYan[1],2);
            break;
            case 2:
                   super.cambiaImagen(this.arrYan[2],3);
            break;
            case 3: 
                  super.cambiaImagen(this.arrYan[3],4);
            break;
            case 4:
                  super.cambiaImagen(this.arrYan[4],5);
            break;
            case 5: 
                  super.cambiaImagen(this.arrYan[5],6);
            break;
            case 6: 
                  super.cambiaImagen(this.arrYan[6],7);
            break;
            case 7: 
                  super.cambiaImagen(this.arrYan[7],8);
            break;
            case 8: 
                  super.cambiaImagen(this.arrYan[8],9);
            break;
            case 9: 
                  super.cambiaImagen(this.arrYan[9],10);
            break;
            case 10: 
                  super.cambiaImagen(this.arrYan[10],11);
            break;
            case 11: 
                  super.cambiaImagen(this.arrYan[11],12);
            break;
            case 12: 
                  super.cambiaImagen(this.arrYan[12],13);
            break;
            case 13: 
                  super.cambiaImagen(this.arrYan[13],0);
            break;
        }
        
    }
    
}
