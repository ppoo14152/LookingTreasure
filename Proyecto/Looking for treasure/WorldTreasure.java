import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
import java.awt.Color;

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
    Key llave;

    private SimpleTimer time;
    private SimpleTimer livesT;
    private SimpleTimer pointsT;
    private Counter msjClock;
    private Counter msjLives;
    private Counter msjPoints;

    private LinkedList<Floor> listaF;
    private Button[] arrBotones;

    private int level;
    private boolean estaJuego;
    private boolean perdio;
    private int numEnemy;
    private boolean existeLlave;
    private ScoreBoard record;
    private GreenfootSound intro;
    private GreenfootSound sonido;
    
    private boolean levelUno;
    private boolean levelDos;
    private boolean levelTres;
    
    
    public WorldTreasure()
    {    
        super(TAM_X,TAM_Y, 1,false);
        setActOrder(Floor.class,FloorTwo.class,Key.class,Treasure.class,Cyndaquil.class,Squirtle.class,Arbok.class,Bala.class);
        
        cyndaquil = new Cyndaquil();
        squirtle = new Squirtle();
        
        record = new ScoreBoard(400,200);
        this.listaF=new LinkedList<Floor>();
        this.existeLlave=false;
        
        this.level=0;
        this.time=new SimpleTimer();
        this.msjClock=new Counter("Tiempo:  ");
        this.msjClock.setValue(0);

        this.livesT=new SimpleTimer();
        this.msjLives=new Counter("Vidas:  ");
        this.msjLives.setValue(10);

        this.pointsT=new SimpleTimer();
        this.msjPoints=new Counter("Puntos:  ");
        this.msjPoints.setValue(0);
        
        boolean levelUno = false;
        boolean levelDos = false;
        boolean levelTres = false;
    
    
        this.sonido = new GreenfootSound("The Rival.mp3");
        this.intro=new GreenfootSound("intro.mp3");
        this.estaJuego=false;
        this.perdio=false;
        this.creaMenu();
    }
    
    public Counter getTime()
    {
        return msjClock;
    }
    
    /**
     * metodo para actualizar los records de los jugadores
     */
    public void actualizaRecord()
    {
        if (UserInfo.isStorageAvailable()) 
        {
           UserInfo myInfo = UserInfo.getMyInfo();
           if (this.getPoints().getValue() > myInfo.getScore()) 
           {
               myInfo.setScore(this.getPoints().getValue());
               myInfo.store();  
           }
        }
    }
    
    /**
     * metodo para deter el sonido
     */
    public void stopped()
    {
        super.stopped();
        sonido.pause();
    }
    
    /**
     * metodo para crear una llave dependiendo el numero de puntos
     */
    public void apareceLlave()
    {
        if(this.msjPoints.getValue() == 100 && !this.getExisteLlave()) 
        {
            this.llave=new Key();
            this.addObject(this.llave,200,300);
            this.setExisteLlave(true);
        }
        else if(this.msjPoints.getValue() == 800 && !this.getExisteLlave()) 
        {
            this.llave=new Key();
            this.addObject(this.llave,200,300);
            this.setExisteLlave(true);
        }
        else if(this.msjPoints.getValue() == 1000 )//&& !this.getExisteLlave()) 
        {
            
            //this.llave=new Key();
            //this.addObject(this.llave,200,300);
            //this.setExisteLlave(true);
        }
    }
    
    /**
     * metodo para cambiar el estado de la llave si esciste o no
     * @param true o false 
     */
    public void setExisteLlave(boolean unaBan)
    {
        this.existeLlave=unaBan;
    }

    /**
     * metodo para saber si existe o no la llave
     * @return true o false respectivamente
     */
    public boolean getExisteLlave()
    {
        return this.existeLlave;
    }
    
    /**
     * regresa la cantidad de puntos
     * @return numero de puntos
     */
    public Counter getPoints()
    {
        return msjPoints;
    }
    
    /**
     * metodo para modificar los puntos
     */
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
    
    /**
     * metodo para modificar los valores de las vidas
     */
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
        else 
        {
            if(this.msjPoints.getValue() == 1000)
            {
                this.setBackground("winner.png");
            }
              
            if(this.msjLives.getValue() <= 0) 
            {
                this.setBackground("gameover.png");
                sonido.stop();//the rival
                
                this.removeObjects(this.getObjects(Animal.class));
                this.removeObjects(this.getObjects(Counter.class));
                this.removeObjects(this.getObjects(Signboard.class));
                this.removeObjects(this.getObjects(FondoImagenes.class));
                this.remueveObjetos();
                this.listaF.clear();
                this.addObject(this.arrBotones[4],730,530);
                this.setLevel(0);
                
                if(this.arrBotones[4].getSedioclick()) 
                {
                    this.arrBotones[4].setSedioclick(false);
                    this.getCyndaquil().setBanTesoro(false);//resetear baderas del tesoro
                    this.getSquirtle().setBanTesoro(false);//resetear banderas el tesoro
                    this.msjLives.setValue(10);
                    this.msjPoints.setValue(0);
                    this.pintaMenu();
                    this.estaJuego=false;
                }
            }
            this.apareceLlave();
            this.tiempo();
            this.creaEnemigos();
            
            if(this.getLives().getValue() > 0 && this.getLevel() >= 1 ) 
            {
                this.mueveScroll();
            }
            
            if(this.getLives().getValue()==0 || this.getLevel()==3)
            {
                this.actualizaRecord();  
            }
            
        }
    }
    
    /**
     * remueve todos los personajes asi como los letreros 
     * e imagenes correspondientes del nivel actual al nivel
     * inicial
     */
    public void remueveObjetos()
    {
        this.removeObjects(this.getObjects(Animal.class));
        this.removeObjects(this.getObjects(Counter.class));
        this.removeObjects(this.getObjects(Signboard.class));
        this.removeObjects(this.getObjects(FondoImagenes.class));   
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
        addObject(new Treasure(),200,550);
        for(int i=0,xPos=TAM_XFLOOR-10; i < 3; i++, xPos += TAM_XFLOOR) 
        {
            pisito=new Floor();
            listaF.add(pisito);
            addObject(pisito, xPos, TAM_YFLOOR);
        }

        this.sonido.playLoop(); 
        if(this.getLevel()== 1) 
       {
            addObject(cyndaquil, 25, 200);
            addObject(squirtle, 116, 200);
            addObject(msjLives,100,30);
            addObject(msjClock,220,30);
            addObject(msjPoints,340,30); 
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
        this.addObject(this.record,400,200);
        this.addObject(this.arrBotones[4],700,500);
        if(this.arrBotones[4].getSedioclick())
        {
            this.removeObject(this.record);
        }
    }

    /**
     * Metodo para desplegar eliminar el menu 
     */
    public void eliminaMenu()
    {
        for(int i = 0;i < arrBotones.length-1; i++) 
        {
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
        for(int i = 0;i < arrBotones.length; i++)
        {
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
        for(int i = 0; i < this.arrBotones.length; i++) 
        {
            if(this.arrBotones[i].getSedioclick())
            {
                this.arrBotones[i].setSedioclick(false); 
                this.eliminaMenu();
                switch(i) 
                {
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
                            this.removeObjects(this.getObjects(ScoreBoard.class));
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
        for(int i = 0,y=100;i < arrBotones.length-1; i++,y+=100)
        {
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
    
    /**
     * metodo para cambiar de nivel
     * @param el numero del nivel
     */
    public void setLevel(int unLevel)
    {
        this.level = unLevel;
    }

    /**
     * metodo para mostrar el tiempo
     */
    public void tiempo()
    {
        if(time.millisElapsed()>=1000) 
        {
            this.time.mark();
            this.msjClock.add(+1);
        }
    }
    
    /**
     * metodo para crear enemigos aleatoriamente dependiendo del nivel
     */
    public void creaEnemigos()
    {
        numEnemy = Greenfoot.getRandomNumber(80);
        if(this.getLevel() == 1)
        {
            
            if(this.levelUno == false) {
                this.addObject(new Signboard("Level: 1"),650,30);
                this.levelUno = true;
            }
            
            switch(numEnemy) 
            {
                case 10:
                    addObject(new Growlithe(), getWidth(),getHeight()-50);
                break;
            }
        }
        else if(this.getLevel() == 2)
        {
            this.setBackground("2.jpg");
            
             if(this.levelDos == false) {
                this.addObject(new Signboard("Level: 2"),650,30);
                this.levelDos = true;
            }
            
            switch(numEnemy) 
            {
                case 10:
                    addObject(new Growlithe(), getWidth(),getHeight()-50); 
                break;
                case 20:
                    addObject(new Arbok(),getWidth(),getHeight()-50);
                break;
            }
        } 
        else if(this.getLevel() == 3) 
        {
            this.setBackground("3.jpg");
            
             if(this.levelTres == false) {
                this.addObject(new Signboard("Level: 3"),650,30);
                this.levelTres = true;
            }
            switch(numEnemy) 
            {
                case 10:
                    addObject(new Arbok(),getWidth(),getHeight()-50);
                break;
                case 20:
                    addObject(new Growlithe(), getWidth(),getHeight()-50); 
                break;
                case 30:
                    addObject(new Yanmega(),getWidth(),200);
                break;
            }
        }
    }
    
    /**
     * metodo para mover la parte del scrool
     */
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
    
    /**
     * Regresa el personaje para poder ingresar a sus variables
     * @return personaje usado
     */
    public Cyndaquil getCyndaquil()
    {
       return cyndaquil;
    }
    
     /**
     * Regresa el personaje para poder ingresar a sus variables
     * @return el personaje usado
     */
    public Squirtle getSquirtle()
    {
        return squirtle;
    }
}