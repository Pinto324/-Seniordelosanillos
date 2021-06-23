
package Personajes;
public class Trasgos extends Bestia{
    
    public Trasgos(String Nombre, int Vida, int defensa, int Ataque, String Cuerpo) {
        super(Nombre, Vida, defensa, Ataque, Cuerpo);    
    }
    public void AsignarVida(){
        this.setVida(325);
    }
}
