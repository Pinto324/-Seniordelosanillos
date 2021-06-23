
package Personajes;

public class Bestia extends SerVivo {

    public Bestia(String Nombre,int Vida, int defensa, int Ataque, String Cuerpo) {
        super(Nombre, Vida, defensa, Ataque, Cuerpo);
    }
    public void CalcularAtaque(){
        int no = (int)(Math. random()*90);
         setAtaque(no);
    }
}
