import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;

/**
 * Write a description of class WorldTreasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldTreasure extends World
{

    /**
     * Constructor for objects of class WorldTreasure.
     * 
     */
    //medidas del mundo---------------
    public static final int TAM_X=1000;
    public static final int TAM_Y=600;
    public static final int TAM_YFLOOR=508;
    public static final int TAM_XFLOOR=216;

    private boolean estaJugando;
    private SimpleTimer time;
    private SimpleTimer livesT;
    private SimpleTimer pointsT;
    private Counter msjClock;
    private Counter msjLives;
    private Counter msjPoints;
    private GreenfootSound sonido;

    private LinkedList<Floor> listaF;
    private Button[] arrBotones;

    private int level;
    private boolean LevelCero;
    private boolean LevelUno;
    private boolean LevelDos;
    private boolean LevelTres;
    private int numObjeto;

    public WorldTreasure()
    {    
        super(TAM_X,TAM_Y, 1,false);
        setActOrder(Floor.class,FloorTwo.class,Cyndaquil.class);
        
        /*arrBotones=new Button[4];
        for (int i = 0; i < 4; i++)
        {
            arrBotones[i]=new Button(i);
        }*/
        this.listaF=new LinkedList<Floor>();
        this.estaJugando=false;
        this.level=1;
        this.LevelCero=false;
        this.LevelUno=false;
        this.LevelDos=false;
        this.LevelTres=false;

        this.time=new SimpleTimer();
        this.msjClock=new Counter("Tiempo:  ");
        this.msjClock.setValue(0);

        this.livesT=new SimpleTimer();
        this.msjLives=new Counter("Vidas:  ");
        this.msjLives.setValue(10);

        this.pointsT=new SimpleTimer();
        this.msjPoints=new Counter("Puntos:  ");
        this.msjPoints.setValue(0);
        this.sonido = new GreenfootSound("The Rival.mp3");
        
        prepararMundo();
        //prepararMenu();
    }

    public Counter getPoints()
    {
        return msjPoints;
    }

    public Counter getLives()
    {
        return msjLives;
    }

    public void act()
    { 
        this.numObjeto = Greenfoot.getRandomNumber(8);
        this.sonido.playLoop(); 
        Floor inicial=listaF.getFirst();
        Floor fin=listaF.getLast();
        Floor pisito;

        if(this.level == 1 && this.LevelUno == false)
        {
            addObject(new Cyndaquil(), 25, 200);
            addObject(new Squirtle(), 116, 200);
            addObject(new Arbok(), getWidth()/2,getHeight()-50); 
            addObject(new Growlithe(), getWidth(),getHeight()-50); 
            
            addObject(new Yanmega(),getWidth(),200);
            addObject(new Yanmega(),getWidth(),90);
            //---------------------------------------------------------
            addObject(msjLives,100,30);
            addObject(msjClock,220,30);
            addObject(msjPoints,340,30); 
            //----------------------------------------------------------
            this.LevelUno = true;
        }

        if(inicial.getX()+(inicial.getImage().getWidth()/2) <= 0) {
            removeObject(inicial);
            listaF.removeFirst();
        }
        
        if(fin.getX()+(fin.getImage().getWidth()/2) <= this.getWidth())
        {
            pisito=new Floor();
            addObject(pisito,this.getWidth()+(pisito.getImage().getWidth()/2),508);
            listaF.add(pisito);
        }
        
        if(time.millisElapsed()>=1000)
        {
            this.time.mark();
            this.msjClock.add(+1);
        }
        if(this.msjClock.getValue() == 10)
        {
            addObject(new Key(),200,300);
        }
    }

   /* public void prepararMenu()
    {
        this.setBackground("sand.jpg");

        for (int i = 0,x=this.getWidth()/2,y=25; i < 4; i++,y+=50)
        {
            //this.addObject(arrBotones.get(i), x, y);
            this.addObject(arrBotones[i],x,y);
        }
    }*/
       
    public void prepararMundo()
    {
        Floor pisito;
        FloorTwo piso1=new FloorTwo();
            
        addObject(piso1,getWidth()/2,getHeight()-20);
        addObject(new Treasure(),100,300);
        for(int i=0,xPos=TAM_XFLOOR-10; i < 4; i++, xPos += TAM_XFLOOR)
        {
            pisito=new Floor();
            listaF.add(pisito);
            addObject(pisito, xPos, TAM_YFLOOR);
        }
    }

    public void menu(int unBoton)
    {
        switch(unBoton)
        {
            case 0: 
                    this.estaJugando=true;
            break;
            case 1: 
                    this.setBackground("");    
            break;              
            case 2: 
                    this.setBackground("");    
            break;              
            case 3: 
                    this.setBackground(""); 
            break; 
        }
    }
}
