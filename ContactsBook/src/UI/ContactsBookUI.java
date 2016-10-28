/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data.*;
import java.util.Scanner;

/**
 *
 * @author johanr98 jsromerod@unal.edu.co
 */
public class ContactsBookUI {
    
    public static String ingresoString() {
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner(System.in);
        try {
            entradaTeclado = entradaEscaner.nextLine();
        } catch (Exception e) {
            printString("Ingrese bien la linea");
            ingresoString();
        }
        return entradaTeclado;
    }
    
    public static int ingresoInt() {
        int r = 0;
        try {
            r = Integer.parseInt(ingresoString());
        } catch (Exception e) {
            printString("Ingrese bien la linea");
            ingresoInt();
        }
        return r;
    }
    
    public static long ingresoLong() {
        long r = 0;
        
        try {
            r = Long.parseLong(ingresoString());
        } catch (Exception e) {
            printString("Ingrese bien la linea");
            ingresoInt();
        }
        return r;
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
    }
    
    public static void printMethodOptions() {
        System.out.println("Seleccione una opcion: ");
        System.out.println("[1]- Adicionar contacto.");
        System.out.println("[2]- Eliminar contacto.");
        System.out.println("[3]- Actualizar contacto.");
        System.out.println("[4]- Visualizar todos los contactos.");
        System.out.println("[5]- Visualizar un contacto.");
        System.out.println("[6]- Salir.");
    }
    
    public static int printMenuAtributos() {
        System.out.println("Seleccione la opcion que desea editar: ");
        System.out.println("[1]- Nombre.");
        System.out.println("[2]- Apellido.");
        System.out.println("[3]- Correos Electronicos.");
        System.out.println("[4]- Telefono fijo.");
        System.out.println("[5]- Telefono móvil.");
        System.out.println("[6]- Dirección.");
        System.out.println("¡¡ Para regresar al menu anterior ingrese [0] !!");
        int a = ingresoInt();
        return a;
    }
    
    public static void printRepeat() {
        System.out.println("De vuelta al menu");
        System.out.println("------------------------------");
        
    }
}
