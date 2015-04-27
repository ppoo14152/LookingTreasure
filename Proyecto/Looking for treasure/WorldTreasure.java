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
    public static final int TAM_X=800;
    public static final int TAM_Y=600;
    public static final int TAM_YFLOOR=508;
    public static final int TAM_XFLOOR=216;

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
    
    private boolean estaJuego;
    private boolean estaAyuda;
    private boolean estaCreditos;
    private boolean perdio;
    private boolean estaRecords;
    private Button inicio;
    private Button help;
    private Button credits;
    private Button records;
    private Button atras;
    private int opcionmenu;
    private GreenfootImage fondo;
    private GreenfootImage imaInicio;
    private GreenfootImage imaAyuda;
    private GreenfootImage imaCreditos;
    private GreenfootImage imaRecords;
    private GreenfootImage imaAtras;
    private GreenfootSound intro;

    public WorldTreasure()
    {    
        super(TAM_X,TAM_Y, 1,false);
        setActOrder(Floor.class,FloorTwo.class,Cyndaquil.class);
        
        this.listaF=new LinkedList<Floor>();
        this.level=0;
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
        
        this.estaJuego=false;
        this.estaAyuda=false;
        this.estaCreditos=false;
        this.perdio=false;
        this.estaRecords=false;
        this.fondo=new GreenfootImage("portada.png");
        this.setBackground(fondo); 
        
        inicio = new Button(1);
        this.help = new Button(2); 
        this.credits = new Button(3);
        this.atras = new Button(4);
        this.records = new Button(5);
        imaInicio = new GreenfootImage("boton0.png");
        imaAtras = new GreenfootImage("back.png");
        imaAyuda = new GreenfootImage("boton1.png");
        imaRecords = new GreenfootImage("boton2.png");
        imaCreditos = new GreenfootImage("boton3.png");
         this.intro=new GreenfootSound("intro.mp3");
         
        imaInicio.scale(imaInicio.getWidth()/3,imaInicio.getHeight()/3);
        this.inicio.setImage(imaInicio);
        imaAtras.scale(imaAtras.getWidth()/5,imaAtras.getHeight()/5);
        this.atras.setImage(imaAtras);
        imaAyuda.scale(imaAyuda.getWidth()/3,imaAyuda.getHeight()/3);
        this.help.setImage(imaAyuda);;
        imaRecords.scale(imaRecords.getWidth()/3,imaRecords.getHeight()/3);
        this.records.setImage(imaRecords);
        imaCreditos.scale(imaCreditos.getWidth()/3,imaCreditos.getHeight()/3);
        this.credits.setImage(imaCreditos);
        this.opcionmenu=0;
        //prepararMundo();
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
        if(!estaJuego)
        {  
            if(!estaAyuda)
                if(!estaCreditos)
                    if(!estaRecords)
                        this.menu();
        }  
        else
        {   
            if(this.estaJuego)
            {
                this.prepararMundo();
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
    }
 
    public void prepararMundo()
    {
        this.intro.stop();
        Floor pisito;
        FloorTwo piso1=new FloorTwo();
        this.estaJuego=true;
         
        addObject(piso1,getWidth()/2,getHeight()-20);
        addObject(new Treasure(),100,300);
        for(int i=0,xPos=TAM_XFLOOR-10; i < 3; i++, xPos += TAM_XFLOOR)
        {
            pisito=new Floor();
            listaF.add(pisito);
            addObject(pisito, xPos, TAM_YFLOOR);
        }
        
        this.numObjeto = Greenfoot.getRandomNumber(8);
        this.sonido.playLoop(); 
        Floor inicial=listaF.getFirst();
        Floor fin=listaF.getLast();
        Floor piso;
            
        if(this.getLevel()== 1 && this.LevelUno == false)
        {
            Cyndaquil cyndaquil = new Cyndaquil();
            Squirtle squirtle = new Squirtle();
            addObject(cyndaquil, 25, 200);
            addObject(squirtle, 116, 200);
            addObject(new Arbok(cyndaquil,squirtle),getWidth()/2,getHeight()-50); 
            addObject(new Growlithe(cyndaquil,squirtle), getWidth(),getHeight()-50); 
          
            addObject(new Yanmega(),getWidth(),200);
            addObject(new Yanmega(),getWidth(),90);
            
            addObject(msjLives,100,30);
            addObject(msjClock,220,30);
            addObject(msjPoints,340,30); 
            this.LevelUno = true;
        }

        if(inicial.getX()+(inicial.getImage().getWidth()/2) <= 0) 
        {
            removeObject(inicial);
            listaF.removeFirst();
        }
        
        if(fin.getX()+(fin.getImage().getWidth()/2) <= this.getWidth())
        {
            piso=new Floor();
            addObject(piso,this.getWidth()+(piso.getImage().getWidth()/2),508);
            listaF.add(piso);
        }
    }
    
    public void ayudaP()
    {
        this.estaAyuda=true;
        this.setBackground("ayuda.png");
        super.addObject(this.atras,60,500);
    }
    
    public void creditosP()
    {
        this.estaCreditos=true;
        super.setBackground("creditos.png");
        super.addObject(this.atras,60,400);
    }
    
    public void recordsP()
    {
        this.estaRecords=true;
        super.setBackground("records.png");
        super.addObject(this.atras,700,500);
    }
    
    public void eliminaBotones()
    {
        this.removeObject(inicio);
        this.removeObject(help);
        this.removeObject(records);
        this.removeObject(credits);
        this.removeObject(atras);
    }
    
    public void menu()
    {
        setBackground(fondo);
        this.intro.playLoop();
        super.addObject(inicio,this.getWidth()/2,100);
        super.addObject(help,this.getWidth()/2,200);
        super.addObject(records,this.getWidth()/2,300);
        super.addObject(credits,this.getWidth()/2,400);     
    }
    
    public int getLevel()
    {
        return this.level;
    }

    public void setLevel(int unLevel)
    {
        this.level = unLevel;
    }
}