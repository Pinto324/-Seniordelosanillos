
package Utilidades;

import Interfaz.IngresarDatos;
import Personajes.*;


public class Ejercito {
    private IngresarDatos I = new IngresarDatos();
    private int NoEjercito = 4;
    private Heroe[] Heroes = new Heroe[NoEjercito];
    private int ContadorHeroes = 0;
    private Bestia[] Bestias = new Bestia[NoEjercito];
    private int ContadorBestias = 0;
    private int ContadorTurno = 1;

    public Ejercito() {
        LlenarEjercitos();
    }

    public int getNoEjercito() {
        return NoEjercito;
    }

    public void setNoEjercito(int NoEjercito) {
        this.NoEjercito = NoEjercito;
    }

    public SerVivo[] getHeroes() {
        return Heroes;
    }

    public void setHeroes(Heroe[] Heroes) {
        this.Heroes = Heroes;
    }

    public int getContadorHeroes() {
        return ContadorHeroes;
    }

    public void setContadorHeroes(int ContadorHeroes) {
        this.ContadorHeroes = ContadorHeroes;
    }

    public SerVivo[] getBestias() {
        return Bestias;
    }

    public void setBestias(Bestia[] Bestias) {
        this.Bestias = Bestias;
    }

    public int getContadorBestias() {
        return ContadorBestias;
    }

    public void setContadorBestias(int ContadorBestias) {
        this.ContadorBestias = ContadorBestias;
    }
    public int getContadorTurno() {
        return ContadorTurno;
    }

    public void setContadorTurno(int ContadorTurno) {
        this.ContadorTurno = ContadorTurno;
    }
    
    public void LlenarEjercitos(){
        for (int x = 0; x < NoEjercito; x++) {          
            int No = (int)(Math. random()*30);
            if(No <= 10){
                Heroes[ContadorHeroes] = new Elfo("",250,0,0,"");
            }else if(No <= 20 && No > 10){
                Heroes[ContadorHeroes] = new Humanos("",180,0,0,"");
            }else{
                Heroes[ContadorHeroes] = new Hobbits("",200,0,0,"");
            }
            if(No <= 15){
                Bestias[ContadorBestias] = new Orcos("",300,0,0,"");
            }else{
                Bestias[ContadorBestias] = new Trasgos("",325,0,0,"");
            }
                Heroes[ContadorHeroes].setDefensa(Heroes[ContadorHeroes].CalcularDefensa());
                Bestias[ContadorBestias].setDefensa(Bestias[ContadorBestias].CalcularDefensa());
            ContadorHeroes++;
            ContadorBestias++;
        }
    }
    public void IngresarNombres(){
        System.out.println("\nIngrese el nombre de los integrandes del ejercito de heroes");
        for (int x = 0; x < ContadorHeroes; x++) {     
            if(Heroes[x] instanceof Elfo){
                Heroes[x].setNombre(I.IngresarString("\nIngrese el nombre del elfo el cual ocupa el espacio del ejercito numero: "+(x+1)));
            }else if(Heroes[x] instanceof Humanos){
                Heroes[x].setNombre(I.IngresarString("\nIngrese el nombre del humano el cual ocupa el espacio del ejercito numero: "+(x+1)));
            }else{
                Heroes[x].setNombre(I.IngresarString("\nIngrese el nombre del hobbit el cual ocupa el espacio del ejercito numero: "+(x+1)));
            }
        }
        System.out.println("\nIngrese el nombre de los integrandes del ejercito de Bestias");
        for (int x = 0; x < ContadorBestias; x++) {     
            if(Bestias[x] instanceof Trasgos){
                Bestias[x].setNombre(I.IngresarString("\nIngrese el nombre del Trasgo el cual ocupa el espacio del ejercito numero: "+x));
            }else{
                Bestias[x].setNombre(I.IngresarString("\nIngrese el nombre del Orco el cual ocupa el espacio del ejercito numero: "+x));
            }
        }
    }
    public void jugar() {
        do {
            System.out.println("\nTurno numero "+ContadorTurno);
            I.Enter("avanzar el turno");
            if(ContadorBestias < ContadorHeroes ){
                for (int x = 0; x < ContadorBestias; x++) {
                    System.out.println("==================================================================================");
                    ataque(x, 1);
                    RevisarVida(x);
                    I.Enter("avanzar al siguiente combate");
                    System.out.println("==================================================================================");
                    System.out.println("\n\n");
                }
            }else{
                for (int x = 0; x < ContadorHeroes; x++) {
                    System.out.println("==================================================================================");
                    ataque(x, 1);
                    RevisarVida(x);
                    I.Enter("avanzar al siguiente combate");
                    System.out.println("==================================================================================");
                    System.out.println("\n\n");
                }
            }
            if (ContadorBestias==0) {
                System.out.println("\nLOS HEROES HAN GANADO!!! ");  
                I.IngresarString("Fin del juego");
                break;
            }
            if(ContadorBestias < ContadorHeroes ){
                for (int x = 0; x < ContadorBestias; x++) {
                    System.out.println("==================================================================================");
                    ataque(x, 2);
                    RevisarVida(x);
                    I.Enter("avanzar al siguiente combate");
                    System.out.println("==================================================================================");
                    System.out.println("\n\n");
                }
            }else{
                for (int x = 0; x < ContadorHeroes; x++) {
                    System.out.println("==================================================================================");
                    ataque(x, 2);
                    RevisarVida(x);
                    I.Enter("avanzar al siguiente combate");
                    System.out.println("==================================================================================");
                    System.out.println("\n\n");
                }
            }
            ContadorTurno++;
            } while (!(ContadorHeroes==0||ContadorBestias==0));
                if (ContadorBestias==0) {
                    System.out.println("\nLOS HEROES HAN GANADO!!! ");  
                    I.IngresarString("Presione enter para volver al menu");
                }else{
                    System.out.println("\nLAS BESTIAS HAN GANADO!!! ");     
                    I.Enter("volver al menu");
                }
    }
    public void ataque(int x, int Confirmacion){
        if(Confirmacion == 1){
            System.out.println("\n"+Heroes[x].getNombre()+" con vida de ["+Heroes[x].getVida()+"] Atacó a "+Bestias[x].getNombre()+" con una vida de ["+Bestias[x].getVida()+"]");
            Heroes[x].CalcularAtaque();
            if(Heroes[x] instanceof Elfo&&Bestias[x] instanceof Orcos){
                if(!(Heroes[x].Atacar(Bestias[x].getVida(), Bestias[x].getDefensa(), Heroes[x].getAtaque()+10)==0)){
                    System.out.println("\nLos elfos tienen odio a los orcos, la rabia en el ataque aumenta el daño");
                Bestias[x].setVida(Heroes[x].Atacar(Bestias[x].getVida(), Bestias[x].getDefensa(), Heroes[x].getAtaque()+10));
                System.out.println("\nEl ataque fue efectivo y con rabia, la vida actual de "+Bestias[x].getNombre()+ " es de "+Bestias[x].getVida());
                }else{
                    System.out.println("\nEl ataque de "+Heroes[x].getNombre()+" aún con rabia no penetró la armadura de "+Bestias[x].getNombre() );
                }
            }else if(Heroes[x] instanceof Hobbits&&Bestias[x] instanceof Trasgos){
                if(!(Heroes[x].Atacar(Bestias[x].getVida(), Bestias[x].getDefensa(), Heroes[x].getAtaque()-5)==0)){
                    System.out.println("\nLos hobbits le temen a los trasgos");
                Bestias[x].setVida(Heroes[x].Atacar(Bestias[x].getVida(), Bestias[x].getDefensa(), Heroes[x].getAtaque()-5));
                System.out.println("\nEl ataque acesto el golpe pero fue debilitado por el miedo, la vida actual de "+Bestias[x].getNombre()+ " es de "+Bestias[x].getVida());
                }else{
                    System.out.println("\nEl ataque de "+Heroes[x].getNombre()+" con miedo no penetró la armadura de "+Bestias[x].getNombre() );
                }    
            }else{                
                if(!(Heroes[x].Atacar(Bestias[x].getVida(), Bestias[x].getDefensa(), Heroes[x].getAtaque())==0)){
                Bestias[x].setVida(Heroes[x].Atacar(Bestias[x].getVida(), Bestias[x].getDefensa(), Heroes[x].getAtaque()));
                System.out.println("\nEl ataque fue efectivo, la vida actual de "+Bestias[x].getNombre()+ " es de "+Bestias[x].getVida());
                }else{
                    System.out.println("\nEl ataque de "+Heroes[x].getNombre()+" no penetró la armadura de "+Bestias[x].getNombre() );
                }
            }
        }else{
            System.out.println(Bestias[x].getNombre()+" con vida de ["+Bestias[x].getVida()+"] Atacó a "+Heroes[x].getNombre()+" con una vida de ["+Heroes[x].getVida()+"]");
            Bestias[x].CalcularAtaque();
            if(Bestias[x] instanceof Orcos){
                if(!(Bestias[x].Atacar(Heroes[x].getVida(), Heroes[x].getDefensa(), (int) (Bestias[x].getAtaque()+(Heroes[x].getDefensa()*0.10)))==0)){
                    System.out.println("\nLos orcos bajan la defensa de sus enemigos");
                    Heroes[x].setVida(Bestias[x].Atacar(Heroes[x].getVida(), Heroes[x].getDefensa(), (int) (Bestias[x].getAtaque()+(Heroes[x].getDefensa()*0.10))));
                System.out.println("\nEl ataque fue efectivo,  la vida actual de "+Heroes[x].getNombre()+ " es de "+Heroes[x].getVida());
                }else{
                    System.out.println("\nEl ataque de "+Bestias[x].getNombre()+" no penetró la armadura de "+Heroes[x].getNombre() );
                }
            }else{
                if(!(Bestias[x].Atacar(Heroes[x].getVida(), Heroes[x].getDefensa(), Bestias[x].getAtaque())==0)){
                Heroes[x].setVida(Bestias[x].Atacar(Heroes[x].getVida(), Heroes[x].getDefensa(), Bestias[x].getAtaque()));
                System.out.println("\nEl ataque fue efectivo, la vida actual de "+Heroes[x].getNombre()+ " es de "+Heroes[x].getVida());
                }else{
                    System.out.println("\nEl ataque de "+Bestias[x].getNombre()+" no penetró la armadura de "+Heroes[x].getNombre() );
                }
            }
        }        
    }
    public void RevisarVida(int x){
        if(Heroes[x].getVida()<= 0){
            if(!(Heroes[ContadorHeroes-1].getNombre().equals(Heroes[x].getNombre()))){
            System.out.println("\nA muerto "+Heroes[x].getNombre()+", "+Heroes[ContadorHeroes-1].getNombre()+" a tomado su lugar en el ejercito");
            Heroe A = Heroes[x];
            Heroes[x] = Heroes[ContadorHeroes-1];
            Heroes[ContadorHeroes-1] = A;
            ContadorHeroes--;
            }else{
                System.out.println("\nA muerto "+Heroes[x].getNombre());
                Heroe A = Heroes[x];
                Heroes[x] = Heroes[ContadorHeroes-1];
                Heroes[ContadorHeroes-1] = A;
                ContadorBestias--;
            }
        }else if(Bestias[x].getVida()<= 0){
            if(!(Bestias[ContadorBestias-1].getNombre().equals(Bestias[x].getNombre()))){
            System.out.println("\nA muerto "+Bestias[x].getNombre()+", "+Bestias[ContadorBestias-1].getNombre()+" a tomado su lugar en el ejercito");
            Bestia B = Bestias[x];
            Bestias[x] = Bestias[ContadorBestias-1];
            Bestias[ContadorBestias-1]= B;
            ContadorBestias--;
            }else{
                System.out.println("\nA muerto "+Bestias[x].getNombre());
                Bestia B = Bestias[x];
                Bestias[x] = Bestias[ContadorBestias-1];
                Bestias[ContadorBestias-1]= B;
                ContadorBestias--;
            }
        }
    }
}
