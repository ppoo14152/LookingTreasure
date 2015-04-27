import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Button extends Actor
{    
    private int numBoton;
    
    public Button(int unTipo)
    {
        this.numBoton=unTipo;
    }
    
    public void act()
    {
        WorldTreasure mundito=(WorldTreasure)getWorld();
        
        if(Greenfoot.mouseClicked(this))
        {
            mundito.eliminaBotones();
            switch(this.numBoton)
            {
                case 1:
                        mundito.setLevel(1);
                        mundito.prepararMundo();
                break;
                case 2:
                        mundito.ayudaP();
                break;
                case 3:
                        mundito.creditosP();
                break;
                case 4:
                        mundito.menu();
                        //mundito.eliminaRecords();
                break;
                case 5:
                        mundito.recordsP();
            }
        }
    }
}
