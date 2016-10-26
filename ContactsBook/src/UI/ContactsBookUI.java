/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import logic .*;
import Data .*;
import java.util.Scanner;
/**
 *
 * @author johanr98 jsromerod@unal.edu.co
 */
public class ContactsBookUI {
    public static String ingreso_String(){
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in);
        entradaTeclado = entradaEscaner.nextLine ();
        return entradaTeclado;
    }
    public static int ingreso_int(){
        int entradaTeclado;
        Scanner entradaEscaner = new Scanner (System.in);
        entradaTeclado = entradaEscaner.nextInt();
        return entradaTeclado;
    }
    
    public static void printString(String a){
        System.out.println(a);
    }
    
    public static void printContact(Contact a){
        System.out.println(a);
    }
     
    public static void printInfoAddConrtact (){
        System.out.println("Adicione el nuevo contacto: ");        
    }
    
}
