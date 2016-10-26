/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import logic.*;
import Data.*;
import java.util.Scanner;

/**
 *
 * @author johanr98 jsromerod@unal.edu.co
 */
public class ContactsBookUI {

    public static String ingreso_String() {
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner(System.in);
        entradaTeclado = entradaEscaner.nextLine();
        return entradaTeclado;
    }

    public static int ingresoInt() {
        int entradaTeclado;
        Scanner entradaEscaner = new Scanner(System.in);
        entradaTeclado = entradaEscaner.nextInt();
        return entradaTeclado;
    }

    public static long ingresoLong() {
        long entradaTeclado;
        Scanner entradaEscaner = new Scanner(System.in);
        entradaTeclado = entradaEscaner.nextLong();
        return entradaTeclado;
    }

    public static void printString(String a) {
        System.out.println(a);
    }

    public static void printContact(Contact a) {
        System.out.println(a);
    }

    public static void printInfoAddContact() {
        System.out.println("Adicione el nuevo contacto: ");
    }

    public static void printWelcome() {
        System.out.println(" LIBRETA DE CONTACTOS ");
        System.out.println(" LIBRETA DE CONTACTOS ");
    }
    public static void printMethodOptions() {
        System.out.println("Seleccione una opcion: ");
        System.out.println("[1]- Adicionar contacto");
        System.out.println("[2]- Eliminar contacto");
        System.out.println("[3]- Actualizar contacto");
        System.out.println("[4]- Visualizar todos los contactos");
        System.out.println("[5]- Visualizar un Contacto");
        System.out.println("[6]- Salir");
        
        
        
    }
    

}
