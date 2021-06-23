
package Interfaz;

public class MenuPrincipal {
    IngresarDatos I = new IngresarDatos();
    public void MenuImpreso(){
        System.out.println("-----------Bienvenido al juego del senior de los anillo-----------");
        System.out.println("1) Jugar");
        System.out.println("0) salir");
        int O = I.IngresarEnteros("Eliga la opción que desea:");
        do{
        switch(O){
            case 1:
                break;
            case 0:
                break;
            default:
                break;
        }    
        }while(O == 0);
    }
}
