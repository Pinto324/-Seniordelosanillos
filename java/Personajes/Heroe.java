
package Personajes;

public class Heroe extends SerVivo {

    public Heroe(String Nombre,int Vida, int defensa, int Ataque, String Cuerpo) {
        super(Nombre, Vida, defensa, Ataque, Cuerpo);
    }
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
