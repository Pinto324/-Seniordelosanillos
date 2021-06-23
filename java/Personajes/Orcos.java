
package Personajes;

public class Orcos extends Bestia {
        
    public Orcos(String Nombre, int Vida, int defensa, int Ataque, String Cuerpo) {
        super(Nombre, Vida, defensa, Ataque, Cuerpo);    
    }
    public void AsignarVida(){
        this.setVida(300);
    }
}
