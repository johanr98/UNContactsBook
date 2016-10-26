/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.*;
import UI.ContactsBookUI;
import java.util.ArrayList;
import javax.sound.midi.SysexMessage;
import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class ContactsBook implements NewInterface {

    private ArrayList<Contact> contactos;
    private Scanner lector;

    public ContactsBook(ArrayList<Contact> contactos) {
        this.contactos = contactos;
        lector = new Scanner(System.in);
    }

    @Override
    public void addContact(Contact contact) {
        contactos.add(contact);
    }

    @Override
    public void printAllContacts() {
        for (int i = 0; i < contactos.size(); i++) {
            ContactsBookUI.printContact(contactos.get(i));
        }
    }

    @Override
    public int printContactsKeys() {

        for (int i = 0; i < contactos.size(); i++) {
            ContactsBookUI.printString((i + 1) + contactos.get(i).getNombre() + "\n");
        }
        //por si las moscas
        int x = Integer.parseInt(lector.nextLine());
        ContactsBookUI.printContact(contactos.get(x - 1));
        return x;
    }

    @Override
    public String removeContact(Contact contact) {
        if (contactos.remove(contact)) {
            return "Se removio el contacto";
        } else {
            return "No se encuentra el contacto en específico";
        }

    }

    @Override
    public void updateContact() {

        int x = printContactsKeys();
        int y = ContactsBookUI.printMenuAtributos();

        switch (y) {

            // MANEJO DE ERRORES DE ENTRADA
            // MANEJO DE ERRORES DE ENTRADA
            // MANEJO DE ERRORES DE ENTRADA
            // MANEJO DE ERRORES DE ENTRADA
            case 1:
                // se ingresa un string valido
                contactos.get(x - 1).setNombre(lector.nextLine());
                break;
            case 2:
                // se ingresa un string valido
                contactos.get(x - 1).setApellido(lector.nextLine());
                break;
            case 3:
                boolean b = true;
                ArrayList<String> correos = new ArrayList();
                ContactsBookUI.printString("Puede ingresar multiples correos"
                        + " electronicos, cuando desee terminar ingrese 0");
                while (b) {
                    String correo = lector.nextLine();
                    if (correo == "0") {
                        b = false;
                    } else {
                        correos.add(correo);
                    }
                }
                String[] a = new String[correos.size()];
                contactos.get(x - 1).setCorreosElectronicos(correos.toArray(a));
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }

    }

    public static void main(String args[]) {

        int opc;
        do {
            ContactsBookUI.printMethodOptions();
            opc = ContactsBookUI.ingreso_int();
            switch (opc) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;

            }
            ContactsBookUI.printRepeat();
        } while (opc == 6);

    }
}
