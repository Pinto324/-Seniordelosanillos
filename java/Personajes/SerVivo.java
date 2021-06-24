
package Personajes;

public class SerVivo {
    private String Nombre;
    private int Vida;
    private int defensa;
    private int Ataque;
    private String Cuerpo;
    
    public SerVivo(String Nombre, int Vida, int defensa, int Ataque, String Cuerpo) {
        this.Nombre = Nombre;
        this.Vida = Vida;
        this.defensa = CalcularDefensa();
        this.Ataque = Ataque;
        this.Cuerpo = Cuerpo;
    }
    
    //Get y set

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return Ataque;
    }

    public void setAtaque(int Ataque) {
        this.Ataque = Ataque;
    }


    public String getCuerpo() {
        return Cuerpo;
    }

    public void setCuerpo(String Cuerpo) {
        this.Cuerpo = Cuerpo;
    }
    
    public int Atacar(int VidaA, int DefensaA, int Ataque){
        if(Ataque > DefensaA){
        VidaA = VidaA - (Ataque-DefensaA);
        return VidaA;
        }
        return 0;
    }
    public int CalcularDefensa(){
        do{
        int numero = (int)(Math. random()*70+50);
        if(numero > 49&& 71 > numero){
            return numero;
        }
        }while(true);
    }

    @Override
    public String toString() {
        return "SerVivo{" + "Nombre=" + Nombre + ", Vida=" + Vida + ", defensa=" + defensa + ", Ataque=" + Ataque + ", Cuerpo=" + Cuerpo + '}';
    }
    
}
