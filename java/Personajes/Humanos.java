
package Personajes;

public class Humanos extends Heroe {
    public Humanos(String Nombre, int Vida, int defensa, int Ataque, String Cuerpo) {
        super(Nombre, Vida, defensa, Ataque, Cuerpo);    
    }
    public void AsignarVida(){
        this.setVida(180);
    }
}
