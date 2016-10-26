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
    public void printContactsKeys() {

        for (int i = 0; i < contactos.size(); i++) {
            ContactsBookUI.printString((i + 1) + contactos.get(i).getNombre() + "\n");
        }

        ContactsBookUI.printContact(contactos.get(lector.nextInt() - 1));

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
    public void updatecontact() {

        printContactsKeys();
        ContactsBookUI.printMenuAtributos();

    }

    public static void main(String args[]) {
        ContactsBookUI.printWelcome();
        int opc;
        do{
        ContactsBookUI.printMethodOptions();
        opc = ContactsBookUI.ingresoInt();
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
        }while(opc==6);
    }
}
