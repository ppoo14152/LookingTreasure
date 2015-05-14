import greenfoot.*;

/**
 * Write a description of class Disparo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    private int tipo;
    private boolean banDir;
    private int cont;
    private int pause;
    
    public Bala(int unTipo,boolean unaDir)
    {
        this.pause = 10;
        this.tipo=unTipo;
        this.setBanDir(unaDir);
        this.quienFue();
        this.cont=0;
    }
    
    public void setBanDir(boolean unaDir)
    {
        this.banDir=unaDir;
    }
    
    public boolean getBanDir()
    {
        return this.banDir;
    }
    
    public void quienFue()
    {
        switch(this.tipo)
        {
            case 1://squirtle
                    this.setImage(new GreenfootImage("ataca1.png"));
                    this.getImage().scale(this.getImage().getWidth()/3,this.getImage().getHeight()/3);
            break;
            case 2://cyndaquil
                    this.setImage(new GreenfootImage("ataca2.png"));
                    this.getImage().scale(this.getImage().getWidth()/3,this.getImage().getHeight()/3);
            break;
            case 3://arbok
                    this.setImage(new GreenfootImage("ataca3.png"));
                    this.getImage().scale(this.getImage().getWidth()/3,this.getImage().getHeight()/3);
            break;
            case 4://yanmega
                    this.setImage(new GreenfootImage("ataca4.png"));
                    this.getImage().scale(this.getImage().getWidth()/3,this.getImage().getHeight()/3);
            break;
        }
        if(this.getBanDir())
        {
            this.getImage().mirrorHorizontally();
        }
    }
    
    public void mueveBala()
    {
        switch(this.tipo)
        {
            case 1:
            case 2:
            case 3:
                   this.setLocation(getX()+ (!this.getBanDir() ? 10 : -10),getY());
            break;
            case 4:
                   this.setLocation(getX(),getY()+5);
            break;
        }
    }
    
    public void aquienToque()
    {
        Actor aux;
        WorldTreasure mundo=(WorldTreasure)getWorld();
        
        switch(this.tipo)
        {
            case 1:
            case 2: this.aquienElimino();
                    mundo.setPoints();                    
            break;
            case 3:
                    aux=this.getOneObjectAtOffset(!this.getBanDir() ? 100 : -100,0,Player.class);
                    if(aux != null)
                    {
                           if(((WorldTreasure)getWorld()).getLives().getValue() > 0)
                           {
                               ((WorldTreasure)getWorld()).setLives();
                               ((WorldTreasure)getWorld()).removeObject(this);
                           }
                    }
            break;    
            case 4:
                   aux=this.getOneObjectAtOffset(0,100,Player.class);
                   if(aux != null)
                   {
                       if(((WorldTreasure)getWorld()).getLives().getValue() > 0)
                       {
                           ((WorldTreasure)getWorld()).setLives();
                           ((WorldTreasure)getWorld()).removeObject(this);
                       }
                   } 
            break;
        }
    }
    
    public void aquienElimino()
    {
        Actor aux;
        Xplosive mancha;
        WorldTreasure mundo=(WorldTreasure)getWorld();
        
        aux=this.getOneObjectAtOffset(!this.getBanDir() ? 100 : -100,0,Enemy.class);
        if(aux != null)
        {
            mundo.removeObject(aux);
            if(aux instanceof Growlithe)
            {
                mancha=new Xplosive("ManchaNaranja.png");
                mundo.addObject(mancha,this.getX(),this.getY());
            }        
            else if(aux instanceof Arbok)
            {
                mancha=new Xplosive("ManchaPurpura.png");
                mundo.addObject(mancha,this.getX(),this.getY());
            }        
            else if(aux instanceof Yanmega)
            {
                mancha=new Xplosive("ManchaVerde.png");
                mundo.addObject(mancha,this.getX(),this.getY());
            }
            
            
        }
    }
    
    public void act() 
    {
        this.mueveBala();
        this.aquienToque();
        
    }
}