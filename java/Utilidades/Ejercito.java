
package Utilidades;

import Personajes.*;


public class Ejercito {
    int NoEjercito = 0;
    SerVivo[] Heroes = new SerVivo[NoEjercito];
    int ContadorHeroes = 0;
    SerVivo[] Bestias = new SerVivo[NoEjercito];
    int ContadorBestias = 0;
    public void LlenarEjercitos(){
        for (int x = 0; x < NoEjercito; x++) {          
            int No = (int)(Math. random()*30);
            if(No <= 10){
                Heroes[ContadorHeroes] = new Elfo("",0,0,0,"");
            }else if(No <= 20 && No > 10){
                Heroes[ContadorHeroes] = new Humanos("",0,0,0,"");
            }else{
                Heroes[ContadorHeroes] = new Hobbits("",0,0,0,"");
            }
            if(No <= 15){
                Bestias[ContadorBestias] = new Orcos("",0,0,0,"");
            }else{
                Bestias[ContadorBestias] = new Trasgos("",0,0,0,"");
            }
            ContadorHeroes++;
            ContadorBestias++;
        }
    }
    
}
