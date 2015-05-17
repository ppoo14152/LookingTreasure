import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase Arbok uno de los enemigos del bosque tiene el poder de disparar veneno.
 * @author DYaraH
 * @author YairTerronezQ
 * @version 18-05-2015
 */
public class Arbok extends Enemy
{
    private int cont;

    public Arbok()
    {
        super(6,2);
        this.cont = 0;
        for(int i = 0; i < 8; i++)
        {
            super.insertaIma(i,"Ad");
        }
    }

    /**
     * Actua del enemigo arbok
     */
    public void act()
    {
        this.movimiento();
    }

    /**
     * Método para animar el movimiento de arbok
     */
    public void movimiento()
    {  
        super.setIzq(true);
        this.setLocation(getX()-2,getY());
        this.animar();
        if(this.cont == 80) 
        {
            super.setBandAtaca(true);
            for(int i=0; i < super.getnumAtaca(); i++)
            {
                super.animar();
            }
            super.disparar(3,this.getX(),this.getY());
            super.setBandAtaca(false);
            this.cont=0;
        }
        this.cont++;
    }
}