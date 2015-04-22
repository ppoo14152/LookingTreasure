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
   private int dir;
   GreenfootImage imagenYi1;
   
   public Yanmega()
   {
       imagenYi1 = new GreenfootImage("Yi1.png");
       setImage(imagenYi1);
       this.dir=0;
   }
   
   public void moveEnemy()
   {
       
   }
}
