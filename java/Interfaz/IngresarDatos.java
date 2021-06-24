
package Interfaz;

import java.util.Scanner;

public class IngresarDatos {
    Scanner C = new Scanner(System.in);
    public IngresarDatos() {
    }
    
    public int IngresarEnteros(String mensajeDesplegar){
        System.out.println(mensajeDesplegar + " ");
        int number =  C.nextInt();
        return number;
    }
    public void Enter(String mensajeDesplegar){
        System.out.println("\nPresione enter para "+mensajeDesplegar);
        String number =  C.nextLine();
        C.reset();
    }
    public String IngresarString(String mensajeDesplegar){
        System.out.println(mensajeDesplegar + " ");
        String dato = C.next();
        return dato;
    }    
}
