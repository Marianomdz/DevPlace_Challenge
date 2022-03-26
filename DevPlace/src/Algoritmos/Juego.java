package Algoritmos;

import java.util.Scanner;

/*
 * @author Mariano_mdz 
 */
public class Juego {

    public void nuevoJuego() {
        System.out.println("***********************************");
        System.out.println("* Juguemos Piedra, Papel o Tijera *");
        System.out.println("***********************************");
        Scanner leer = new Scanner(System.in);

        int Computadora = (int) (Math.random() * 3) + 1;
        System.out.println("La computadora ya eligió su opción...");

        System.out.print("Seleccione una opción [P=Piedra, A=Papel o T=Tijera]: ");
        String Usuario = leer.nextLine().toUpperCase();

        System.out.print("La Computadora había elegido: ");
        switch (Computadora) {
            case 1:
                System.out.println("Piedra");
                switch (Usuario) {
                    case "P":
                        System.out.println("Empate!");
                        break;
                    case "A":
                        System.out.println("Usted ganó!");
                        break;
                    case "T":
                        System.out.println("La computadora ganó!");
                        break;
                    default:
                        System.out.println("Selección no válida");
                }
                break;

            case 2:
                System.out.println("Papel");
                switch (Usuario) {
                    case "P":
                        System.out.println("La computadora ganó!");
                        break;
                    case "A":
                        System.out.println("Empate!");
                        break;
                    case "T":
                        System.out.println("Usted ganó!");
                        break;
                    default:
                        System.out.println("Selección no válida");
                }
                break;

            case 3:
                System.out.println("Tijera");
                switch (Usuario) {
                    case "P":
                        System.out.println("Usted ganó!");
                        break;
                    case "A":
                        System.out.println("La computadora ganó!");
                        break;
                    case "T":
                        System.out.println("Empate!");
                        break;
                    default:
                        System.out.println("Selección no válida");
                }
                break;

        }
    }
}
