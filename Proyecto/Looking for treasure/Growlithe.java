import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase Growlithe uno de los enemigos del bosque que quita vida cada que se acerca a atacar.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
public class Growlithe extends Enemy
{
    private int vida;
    
    /**
     * Constructor de Growlithe.
     */
    public Growlithe()
    {
        super(4,0);
        vida=0;
        for(int i = 0; i < 4;i++)
        {
            super.insertaIma(i,"Gd");
        }
    }
    
    /**
     * Actua de Growlithe
     */
    public void act()
    {
        this.quitaVida();
        this.movimiento();
    }
    
    /**
     * Método para animar al enemigo
     */
    public void movimiento()
    {  
       super.setIzq(true);
       this.setLocation(this.getX()-5,this.getY());
       super.animar();
    } 
    
    /**
     * Método para restar vidas al jugador
     */
    public void quitaVida()
    {
        if(isTouching(Cyndaquil.class) || isTouching(Squirtle.class)) 
        {
            if(vida == 0)
            {
                if(((WorldTreasure)getWorld()).getLives().getValue() >= 0)
                      ((WorldTreasure)getWorld()).setLives();
                 vida++;
           }
        }
    }
}