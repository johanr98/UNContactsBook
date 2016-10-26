/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.*;
import UI.ContactsBookUI;
import com.sun.org.apache.bcel.internal.generic.GOTO;
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

    private ContactsBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addContact() {
        ContactsBookUI.printString("Ingrese los valores del nuevo Contacto");
        ContactsBookUI.printString("Nombre: ");
        String nombre = ContactsBookUI.ingresoString();
        ContactsBookUI.printString("Apellido: ");
        String apellido = ContactsBookUI.ingresoString();
        ContactsBookUI.printString("Correos: ");
        //Correos

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
        String[] correo = new String[correos.size()];
        correos.toArray(correo);
        //fin correos
        ContactsBookUI.printString("Telefono Fijo: ");
        int telefonoFijo = ContactsBookUI.ingresoInt();
        ContactsBookUI.printString("Telefono Movil: ");
        long telefonoMovil = ContactsBookUI.ingresoLong();
        ContactsBookUI.printString("Direccion: ");
        String direccion = ContactsBookUI.ingresoString();
        Contact contact = new Contact(nombre, apellido, correo, telefonoFijo,
                telefonoMovil, direccion);
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
    public String removeContact() {

        this.printContactsKeys();
        
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

                try {
                    contactos.get(x - 1).setTelefonoFijo(ContactsBookUI.ingresoInt());
                    ContactsBookUI.printString("Operación exitosa!!");
                } catch (Exception e) {
                    ContactsBookUI.printString("Error, por favor ingrese de nuevo"
                            + " el valor");
                    //REPETIR
                }

                break;
            case 5:
                try {
                    contactos.get(x - 1).setTelefonoMovil(ContactsBookUI.ingresoLong());
                    ContactsBookUI.printString("Operación exitosa!!");
                } catch (Exception e) {
                    ContactsBookUI.printString("Error, por favor ingrese de nuevo"
                            + " el valor");
                    //REPETIR
                }
                break;
            case 6:
                try {
                    contactos.get(x - 1).setDireccion(ContactsBookUI.ingresoString());
                    ContactsBookUI.printString("Operación exitosa!!");
                } catch (Exception e) {
                    ContactsBookUI.printString("Error, por favor ingrese de nuevo"
                            + " el valor");
                    //REPETIR
                }
                break;
            default:
                ContactsBookUI.printString("Error, por favor ingrese de nuevo"
                        + " el valor");
                updateContact();
                break;
        }
    }

    public static void main(String[] args) {
        ContactsBook contactsBook = new ContactsBook();
        int opc;
        do {
            ContactsBookUI.printMethodOptions();
            opc = ContactsBookUI.ingresoInt();
            switch (opc) {
                case 1:
                    contactsBook.addContact();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    ContactsBookUI.printString("Ingrese de nuevo su opción");
                    opc = 1;
                    break;
            }
            ContactsBookUI.printRepeat();;
            opc = ContactsBookUI.ingresoInt();

        } while (opc == 6);

    }
}
