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
    
    Cyndaquil cyndaquil;
    Squirtle squirtle; 

    private SimpleTimer time;
    private SimpleTimer livesT;
    private SimpleTimer pointsT;
    private Counter msjClock;
    private Counter msjLives;
    private Counter msjPoints;

    private LinkedList<Floor> listaF;
    private Button[] arrBotones;

    private int level;
    private boolean LevelCero;
    private boolean LevelUno;
    private boolean LevelDos;
    private boolean LevelTres;
    //private int numObjeto;

    private boolean estaJuego;
    private boolean perdio;
    private int numActor;
    private GreenfootSound intro;
    private GreenfootSound sonido;

    public WorldTreasure()
    {    
        super(TAM_X,TAM_Y, 1,false);
        setActOrder(Floor.class,FloorTwo.class,Cyndaquil.class,Arbok.class,Disparo.class);
        
        cyndaquil = new Cyndaquil();//-----------------
        squirtle = new Squirtle();//-----------------

        this.listaF=new LinkedList<Floor>();
        this.level=0;
        this.LevelUno=false;
        this.LevelCero=true;

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
        this.intro=new GreenfootSound("intro.mp3");
        this.estaJuego=false;
        this.perdio=false;
        this.creaMenu();
    }

    /**
     * regresa la cantidad de puntos
     * @return numero de puntos
     */

    public Counter getPoints()
    {
        return msjPoints;
    }
    
    public void setPoints()
    {
        msjPoints.add(100);
    }

    /**
     * metodo para regresar las vidas restantes
     * @return numero de vidas
     */
    public Counter getLives()
    {
        return msjLives;
    }
    
    //------------------------------------------
    public void setLives()
    {
        this.msjLives.add(-1);
    }

    /**
     * Metodo donde interactua el mundo con todos los personajes
     */
    public void act()
    { 
        if(!estaJuego) {  
            this.checaBotones();
        }  
        else {    
            this.tiempo();
            this.apareceLlave();
            this.mueveScroll();
            this.creaEnemigos();
        }
        
    }

    /**
     * Metodo donde se inicializan los objetos principales
     */
    public void prepararMundo()
    {
        this.intro.stop();
        Floor pisito;
        FloorTwo piso1=new FloorTwo();
        this.estaJuego=true;

        this.setBackground("1.jpg"); 
        addObject(piso1,getWidth()/2,getHeight()-20);
        addObject(new Treasure(),100,300);
        for(int i=0,xPos=TAM_XFLOOR-10; i < 3; i++, xPos += TAM_XFLOOR) {
            pisito=new Floor();
            listaF.add(pisito);
            addObject(pisito, xPos, TAM_YFLOOR);
        }

        this.sonido.playLoop(); 
       if(this.getLevel()== 1 && this.LevelUno == false) {
            addObject(cyndaquil, 25, 200);
            addObject(squirtle, 116, 200);
            addObject(new Arbok(cyndaquil,squirtle),getWidth()/2,getHeight()-50); 
            addObject(new Growlithe(cyndaquil,squirtle), getWidth(),getHeight()-50); 

            addObject(new Yanmega(cyndaquil,squirtle),getWidth(),200);
            //addObject(new Yanmega(cyndaquil,squirtle),getWidth(),90);

            addObject(msjLives,100,30);
            addObject(msjClock,220,30);
            addObject(msjPoints,340,30); 
            this.LevelUno = true;
        }
    }
    
    /**
    * Metodo para desplegar el boton de ayuda
    */
    public void ayudaP()
    {
        this.setBackground("ayuda.png");
        this.addObject(this.arrBotones[4],60,500);
    }
    
    
    /**
     * Metodo para desplegar el boton de creditos
     */
    public void creditosP()
    {
        super.setBackground("creditos.png");
        this.addObject(this.arrBotones[4],60,400);
    }
    
    /**
     * Metodo para desplegar el boton de records
     */
    public void recordsP()
    {
        super.setBackground("records.png");
        this.addObject(this.arrBotones[4],700,500);
    }

    /**
     * Metodo para desplegar eliminar el menu 
     */
    public void eliminaMenu()
    {
        for(int i = 0;i < arrBotones.length-1; i++) {
            this.removeObject(this.arrBotones[i]);
        }
    }
    
    /**
     * Metodo para desplegar todos los botones
     */
    public void creaMenu()
    {
        this.creaBotones();
    }
    
    /**
     * Metodo para crear los botones
     */
    public void creaBotones()
    {
        this.arrBotones=new Button[5];
        for(int i = 0;i < arrBotones.length; i++) {
            this.arrBotones[i]=new Button(i);
        }
        this.pintaMenu();
    }
    
    /**
     * metodo para checar que botones se seleccionan
     */
    public void checaBotones()
    {
        this.intro.playLoop(); 
        for(int i = 0; i < this.arrBotones.length; i++) {
            if(this.arrBotones[i].getSedioclick()) {
                this.arrBotones[i].setSedioclick(false); 
                this.eliminaMenu();
                switch(i) {
                    case 0:
                    this.setLevel(1);
                    this.estaJuego=true;
                    this.prepararMundo();
                    break;
                    case 1:
                    this.ayudaP();
                    break;
                    case 2:
                    this.recordsP();        
                    break;
                    case 3:
                    this.creditosP();
                    break;
                    case 4: 
                    this.pintaMenu();
                    break;        
                }
            }
        }
    }
    
    /**
     * Metodo para pintar el menu con fondo y los botones
     */
    public void pintaMenu()
    {
        this.setBackground("portada.png");
        this.removeObject(arrBotones[4]);
        for(int i = 0,y=100;i < arrBotones.length-1; i++,y+=100) {
            this.addObject(this.arrBotones[i],this.getWidth()/2,y);  
        }   
    }

    /**
     * Metodo que devuelve el numero actual de nivel
     * @return numero de nivel en que se encuentra
     */
    public int getLevel()
    {
        return this.level;
    }
    
    public void setLevel(int unLevel)
    {
        this.level = unLevel;
    }

    public void apareceLlave()
    {
        if(this.msjClock.getValue() == 10) {
            this.addObject(new Key(),200,300);
        }
    }

    public void tiempo()
    {
        if(time.millisElapsed()>=1000) {
            this.time.mark();
            this.msjClock.add(+1);
        }
    }
    
     public int getPosXs()
    {
       return squirtle.getX();
    }
    
    public int getPosXc()
    {
       return cyndaquil.getX();
    }

    public void creaEnemigos()
    {
        numActor = Greenfoot.getRandomNumber(200);
        switch(numActor) {
            case 10:
            addObject(new Arbok(cyndaquil,squirtle),getWidth(),getHeight()-50);
            break;
            case 20:
            addObject(new Growlithe(cyndaquil,squirtle), getWidth(),getHeight()-50); 
            break;
            case 30:
            addObject(new Yanmega(cyndaquil,squirtle),getWidth(),200);
            break;
        }  
    }
    
    public void mueveScroll()
    {
       Floor inicial=listaF.getFirst();
        Floor fin=listaF.getLast();
        Floor piso;

        if(inicial.getX()+(inicial.getImage().getWidth()/2) <= 0) {
            removeObject(inicial);
            listaF.removeFirst();
        }

        if(fin.getX()+(fin.getImage().getWidth()/2) <= this.getWidth()) {
            piso=new Floor();
            addObject(piso,this.getWidth()+(piso.getImage().getWidth()/2),508);
            listaF.add(piso);
        } 
    }
}