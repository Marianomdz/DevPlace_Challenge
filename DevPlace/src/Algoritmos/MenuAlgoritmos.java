package Algoritmos;

import java.util.Scanner;

/*
 * @author Mariano_mdz 
 */
public class MenuAlgoritmos {

    public void menuAlgoritmos() {
        int operacion = 0;
        ServiceAlgoritmos s = new ServiceAlgoritmos();
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        while (operacion != 5) {
            System.out.println("\033[33m\tMENU");
            System.out.println("1. Numeros Primos");
            System.out.println("2. Sumar y Guardar en Array");
            System.out.println("3. Piedra, Papel o Tijera");
            System.out.println("4. Salario de Personas");
            System.out.println("5. Numeros Aleatorios");
            System.out.println("6. SALIR");
            operacion = Integer.valueOf(sc.nextLine());
            if (operacion == 1) {
                s.IngresarRango();
            }
            if (operacion == 2) {
                s.cargarArray();
            }
            if (operacion == 3) {
                juego.nuevoJuego();
            }
            if (operacion == 4) {
                s.salarioPersonas();
            }
            if (operacion == 5) {
                s.numerosAleatorios();
            }
            if (operacion == 6) {
                return;
            }
            if (operacion != 1 && operacion != 2 && operacion != 3 && operacion != 4 && operacion != 5 && operacion != 6) {
                System.out.println("ERROR ------ Digito fuera del rango 1-5");
            }
        }
    }

}
