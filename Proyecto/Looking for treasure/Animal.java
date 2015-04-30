import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Pokemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Animal extends Actor
{
    private GreenfootImage[] arrIma;
    private boolean izq;
    private int numImagenes;
    private int numImagenesAtack;
    private int imaActual;
    private int imaActualDisparo;

    public Animal(int unTam,int numImaAtack)//unTamAtack--parametro cantidad de imagenes de ataque
    {
        this.arrIma=null;
        this.izq=false;
        this.numImagenes=unTam;
        this.imaActual=0;
        this.numImagenesAtack=numImaAtack;//
        this.imaActualDisparo=(unTam*2);//
        this.creaArregloIma(unTam);
    }

    public void setIzq(boolean unaDir)
    {
        this.izq=unaDir;
    }

    public boolean getIzq()
    {
        return this.izq;
    }

    public void setActual(int unaActual)
    {
        this.imaActual=unaActual;
    }

    public int getActual()
    {
        return this.imaActual;
    }

    public void setNumIma(int unNum)
    {
        this.numImagenes=unNum;
    }

    public int getNumIma()
    {
        return this.numImagenes;
    }

    public void creaArregloIma(int unTam)
    {
        this.arrIma=new GreenfootImage[(unTam + this.numImagenesAtack) * 2];
    }

    public void insertaIma(int unaI,String unaCad)
    {
        if(unaI < 8) {
            this.arrIma[unaI]=new GreenfootImage(unaCad+(unaI+1)+".png");
            this.arrIma[unaI+this.numImagenes]=new GreenfootImage(this.arrIma[unaI]);
            this.arrIma[unaI+this.numImagenes].mirrorHorizontally();
        }else{
            this.arrIma[unaI]=new GreenfootImage(unaCad+(unaI+1)+".png");
            this.arrIma[unaI+this.numImagenesAtack]=new GreenfootImage(this.arrIma[unaI]);
            this.arrIma[unaI+this.numImagenesAtack].mirrorHorizontally();
        }
    }   

    abstract public void movimiento();

    public void animar()
    {
        if(this.izq)
            this.setImage(arrIma[this.imaActual+this.numImagenes]);
        else
            setImage(arrIma[this.imaActual]);

        if(this.imaActual >= this.numImagenes-1)
            this.imaActual=0;
        else
            this.imaActual++;
    }

    public void animarDisparo()
    {
        int i=0;
        
        if(this.izq) {
            
         switch(i) {
            case 0:
                this.setImage(arrIma[this.imaActualDisparo]);
                this.imaActualDisparo++;
                i = 1;
            break;
                case 1:this.setImage(arrIma[this.imaActualDisparo]);
                i = 0;
            break;
         }
        this.imaActualDisparo=(this.numImagenes*2);
      }else{
          
          switch(i) {
            case 0:
                this.setImage(arrIma[this.imaActualDisparo + this.numImagenesAtack]);
                this.imaActualDisparo++;
                i = 1;
            break;
                case 1:this.setImage(arrIma[this.imaActualDisparo + this.numImagenesAtack]);
                i = 0;
            break;
         }
        this.imaActualDisparo=(this.numImagenes*2);
        }
    }
    
    public void disparaEnemy(GreenfootImage unaImagen,int unaPosicion,int x,int y)
    {
        Disparo disparoE = new Disparo(unaImagen,unaPosicion);
        getWorld().addObject(disparoE,x,y);
    }
    
    public void disparaPlayer(GreenfootImage unaImagen,int unaPosicion,int x,int y)
    {
        BalaJugador disparoJ = new BalaJugador(unaImagen,unaPosicion);
        getWorld().addObject(disparoJ,x,y);
    }
    
    public GreenfootImage[] getIimagenArr()
    {
      return arrIma;
    }
}