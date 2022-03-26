package Algoritmos;

import java.util.Arrays;

import java.util.Random;
import java.util.Scanner;


/*
 * @author Mariano_mdz 
 */
public class ServiceAlgoritmos {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    // Comienza numeros Primos
    public void IngresarRango() {
        System.out.println("Ingrese un número:");
        Integer numero1 = leer.nextInt();
        System.out.println("Ingrese un número:");
        Integer numero2 = leer.nextInt();
        int contador = 0;
        for (int i = numero1; i <= numero2; i++) {

            if (esnumPrimo(i)) {
                contador++;
                System.out.println(String.valueOf(i) + " es primo, ");
            } else {
                System.out.println(String.valueOf(i) + " No es primo, ");
            }
        }
    }

    public static boolean esnumPrimo(int numero) {
        // Verifico si es numero 0, 1 y 4, si lo son los decarto, ya que no son primos
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            // Si el numero es divisible por cualquiera de estos números, no es primo

            if (numero % x == 0) {
                return false;
            }
        }
        // Si lo pude dividir por ninguno de los numeros anteriores, es numero primo
        return true;
    }

    int[] numeros = new int[5];
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    int sumatoria = 0;
    MenuAlgoritmos m = new MenuAlgoritmos();

    // Termina numeros Primos
    // Comienza el punto 2 arreglo con 5 numeros
    public void cargarArray() {
        for (int i = 0; i < numeros.length; i++) {

            System.out.println((i + 1) + ". " + "Ingrese un número:");
            int numero1 = sc.nextInt();
            numeros[i] = numero1;
            // llamamos a la funcion suma
            suma(numero1);
        }

        // una vez terminado el for, llamamos a la funcion mostrar
        mostrar(numeros);
        ordenarArray(numeros);

    }

    public int suma(int numero1) {

        sumatoria = sumatoria + numero1;
        return sumatoria;
    }

    public void mostrar(int[] numeros) {

        System.out.println("\nLa Suma de los números ingresados es: " + sumatoria);

        //Recorro el arreglo en forma inversa para mostrar los numeros en forma inversa.       
        System.out.println("\n=====\nImprimiendo números invertido\n=====");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);

        }
    }

    public void ordenarArray(int[] numeros) {

        //Usamos el metodo Sort para invertir el arreglo.
        System.out.println("\n=====\nImprimiendo números ordenado de menor a mayor\n=====");

        Arrays.sort(numeros);
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);

        }
        mostrarRepetidos(numeros);
    }

    static int[] lista;

    public void mostrarRepetidos(int[] numeros) {

        lista = new int[numeros.length];
        Arrays.sort(numeros);
        for (int i = 0; i < numeros.length; i++) {
            int cont = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == (numeros[j])) {
                    cont++;
                    if (verificar(numeros[i])) {
                        lista[i] = numeros[i];
                    }
                }

            }
            if (lista[i] != 0) {
                if(cont > 1){
                System.out.println("El número " + lista[i] + " se repite " + cont + " veces");
                }
            }

        }
    }

    static boolean verificar(int numero) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == numero) {
                return false;
            }
        }
        return true;
    }

    // Termina el punto 2 y 3 arreglo con 5 numeros
    // Comienza el punto 5 Salario de personas
    public void salarioPersonas() {
        System.out.println("Ingrese el Nombre de la Persona:");
        String nombre = leer.next();
        System.out.println("Ingrese la Edad:");
        Integer edad = leer.nextInt();
        System.out.println("Ingrese el Salario:");
        Float salario = leer.nextFloat();

        float calculoSalario = 0;
        if (edad < 16) {
            System.out.println(nombre + " no tiene edad para Trabajar");

        } else {

            if (edad >= 16 && edad <= 50) {

                calculoSalario = salario + ((salario * 5) / 100);
                System.out.println("El salario de " + nombre + " es: " + calculoSalario);
            } else {
                if (edad >= 51 && edad <= 60) {

                    calculoSalario = salario + ((salario * 10) / 100);
                    System.out.println("El salario de " + nombre + " es: " + calculoSalario);
                } else {
                    calculoSalario = salario + ((salario * 15) / 100);
                    System.out.println("El salario de " + nombre + " es: " + calculoSalario);
                }
            }
        }
    }

    // Termina el punto 5 Salario de personas
    // Comienza el punto 6 ramdom
    public void numerosAleatorios() {
        // Instanciamos la clase Random
        Random random = new Random();
        int numero1 = 0;
        int numero2 = 0;
        int numero3 = 0;
        int i = 0;

        while (verificarPares(numero1, numero2, numero3) == false) {          //Condición trivial: siempre cierta
            i++;
            System.out.println("Intento " + i + " Presione una tecla para volver a intentar:");
            String continuar = leer.nextLine();
            numero1 = random.nextInt(1000);
            numero2 = random.nextInt(1000);
            numero3 = random.nextInt(1000);

            if (i == 100) {
                break;
            }
        }

        if (numero1 % 2 == 0) {
            System.out.println("número 1: " + numero1 +" (par)");
        }
        if (numero2 % 2 == 0) {
            System.out.println("número 2: " + numero2 +" (par)");
        }
        if (numero3 % 2 != 0) {
            System.out.println("número 3: " + numero3 +" (impar)");
        }

        System.out.println("Número de ensayos realizados: " + i);
    }

    public boolean verificarPares(int numero1, int numero2, int numero3) {
        if (numero1 % 2 != 0) {

            return false;
        }

        if (numero2 % 2 != 0) {

            return false;
        }

        if (numero3 % 2 != 0) {
            // System.out.println("El número es impar");

        } else {
            return false;
        }

        return true;
    }
}
