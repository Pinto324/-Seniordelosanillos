
package Personajes;

public class Elfo extends Heroe {

    public Elfo(String Nombre, int Vida, int defensa, int Ataque, String Cuerpo) {
        super(Nombre, Vida, defensa, Ataque, Cuerpo);
    }
        
    public void AsignarVida(){
        this.setVida(180);
    }
    @Override
    public void CalcularAtaque(){
        int no1 = (int)(Math. random()*100);
        int no2 = (int)(Math. random()*100);
        if(no1 > no2){
            setAtaque(no1);
        }else{
            setAtaque(no2);
        }
    }
}
