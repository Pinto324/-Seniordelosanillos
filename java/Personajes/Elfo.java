
package Personajes;

public class Elfo extends Heroe {

    public Elfo(String Nombre, int Vida, int defensa, int Ataque, String Cuerpo) {
        super(Nombre, Vida, defensa, Ataque, Cuerpo);
    }
        
    public void AsignarVida(){
        this.setVida(180);
    }
}
