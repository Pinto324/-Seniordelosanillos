
package Personajes;

public class Hobbits extends Heroe{
    
    public Hobbits(String Nombre, int Vida, int defensa, int Ataque, String Cuerpo) {
        super(Nombre, Vida, defensa, Ataque, Cuerpo);    
    }
    public void AsignarVida(){
        this.setVida(200);
    }
}
