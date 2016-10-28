/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.*;
import UI.ContactsBookUI;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class ContactsBook implements NewInterface {

    /**
     *
     */
    private ArrayList<Contact> contactos;

    /**
     * Constructor con parametros de la clase
     *
     * @param contactos - Arreglo de la clase Contact
     */
    public ContactsBook(ArrayList<Contact> contactos) {
        this.contactos = contactos;

    }

    /**
     * Constructor por defecto de la clase
     */
    private ContactsBook() {
        contactos = new ArrayList<>();
    }

    /**
     *
     */
    @Override
    public void addContact() {
        ContactsBookUI.printString("Ingrese los valores del nuevo Contacto");
        ContactsBookUI.printString("Nombre: ");
        //validación nombre
        String nombre = ContactsBookUI.ingresoString();
        while (true) {
            if (nombre.length() >= 3 && nombre.length() <= 10) {
                if (nombre.matches(".*\\d.*")) {
                    ContactsBookUI.printString("Ingrese el nombre sin números!!");
                    nombre = ContactsBookUI.ingresoString();
                } else {
                    break;
                }
            } else {
                ContactsBookUI.printString("El valor minimo son 3 letras y máximo "
                        + "10!!");
                nombre = ContactsBookUI.ingresoString();
            }

        }
        //fin validación nombre
        ContactsBookUI.printString("Apellido: ");
        String apellido = ContactsBookUI.ingresoString();
        //validación apellido
        while (true) {
            if (apellido.length() >= 3 && apellido.length() <= 10) {
                if (apellido.matches(".*\\d.*")) {
                    ContactsBookUI.printString("Ingrese el apellido sin números!!");
                    apellido = ContactsBookUI.ingresoString();
                } else {
                    break;
                }

            } else {
                ContactsBookUI.printString("El valor minimo son 3 letras y máximo "
                        + "10!!");
                apellido = ContactsBookUI.ingresoString();
            }
        }

        ContactsBookUI.printString("Correos: ");
        //validación correos
        ArrayList<String> correos = new ArrayList();
        ContactsBookUI.printString("Puede ingresar multiples correos"
                + " electronicos, cuando desee terminar ingrese 0");

        while (true) {
            String correo = ContactsBookUI.ingresoString();
            if (correo.equals("0")) {
                if (correos.size() >= 1) {
                    break;
                } else {
                    ContactsBookUI.printString("Ingrese al menos un correo!");
                }
            }
            while (true) {
                if (correo.length() >= 11 && correo.length() <= 25) {
                    if (correo.indexOf("@") == correo.lastIndexOf("@")
                            && correo.contains(".") && correo.indexOf("@") > -1) {

                        correos.add(correo);
                        ContactsBookUI.printString("Ingrese el siguiente correo!!");
                        break;

                    } else {
                        ContactsBookUI.printString("El correo debe contener  "
                                + " un @ y al menos un punto (.) ");
                        correo = ContactsBookUI.ingresoString();
                    }

                } else {
                    ContactsBookUI.printString("El valor minimo son 11 letras y máximo "
                            + "25!!");
                    correo = ContactsBookUI.ingresoString();
                }
            }

        }

        String[] correo = new String[correos.size()];
        correos.toArray(correo);
        //fin entrada de correos electrónicos 

        //Validación telefono fijo
        ContactsBookUI.printString("Telefono Fijo: ");
        int telefonoFijo = ContactsBookUI.ingresoInt();
        while (true) {
            if (telefonoFijo >= 1000000 && telefonoFijo <= 10000000) {
                break;
            } else {
                ContactsBookUI.printString("El número debe tener 7 digitos!");
                telefonoFijo = ContactsBookUI.ingresoInt();
            }
        }

        //Fin validación
        //Validación telefono movil
        ContactsBookUI.printString("Telefono Movil: ");

        long telefonoMovil = ContactsBookUI.ingresoLong();

        while (true) {
            if (telefonoMovil >= 1000000000 && telefonoMovil < 10000000000l) {
                break;
            } else {
                ContactsBookUI.printString("El número debe tener 10 digitos!");
                telefonoMovil = ContactsBookUI.ingresoLong();

            }
        }

        ContactsBookUI.printString("Direccion: ");
        String direccion = ContactsBookUI.ingresoString();

        // validacion direccion
        while (true) {
            if (direccion.length() >= 10 && direccion.length() <= 30) {
                break;
            } else {
                ContactsBookUI.printString("El valor minimo son 10 letras y máximo "
                        + "30!!");
                direccion = ContactsBookUI.ingresoString();
            }
        }

        //fin validacion
        // validacion contacto
        try {

            Contact contact = new Contact(nombre, apellido, correo, telefonoFijo,
                    telefonoMovil, direccion);
            contactos.add(contact);
        } catch (Exception e) {
            e.printStackTrace();
            ContactsBookUI.printString("Verifique e ingrese de nuevo, los datos"
                    + " del contacto");
            addContact();
        }

    }

    @Override
    public void printAllContacts() {
        if (contactos.size() == 0) {
            ContactsBookUI.printString("No existen contactos aún");
        } else {

            try {
                for (int i = 0; i < contactos.size(); i++) {
                    ContactsBookUI.printContact(contactos.get(i));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                ContactsBookUI.printString("No se han añadido contactos!!, por favor"
                        + " agregue uno antes de ingresar a esta opción");
            }
        }
    }

    @Override
    public int printContactsKeys() {
        if (contactos.size() == 0) {
            ContactsBookUI.printString("No existen contactos aún!!");
            return 0;
        } else {

            for (int i = 0; i < contactos.size(); i++) {
                ContactsBookUI.printString((i + 1) + ". " + contactos.get(i).getNombre() + "\n");
            }
            //por si las moscas

            ContactsBookUI.printString("Que contacto desea ver?");
            int x = Integer.parseInt(ContactsBookUI.ingresoString());
            while (true) {

                try {
                    ContactsBookUI.printContact(contactos.get(x - 1));
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    ContactsBookUI.printString("Ingrese un valor valido");
                }
            }
            return x;
        }
    }

    @Override
    public void removeContact() {

        if (contactos.size() == 0) {
            ContactsBookUI.printString("Todavía no existe ningún contacto");
        } else {

            for (int i = 0; i < contactos.size(); i++) {
                ContactsBookUI.printString((i + 1) + ". " + contactos.get(i).getNombre() + "\n");
            }

            ContactsBookUI.printString("Que contacto desea remover");
            int y = ContactsBookUI.ingresoInt(); // identificador contacto

            while (true) {
                try {
                    contactos.remove(y - 1);
                    ContactsBookUI.printString("Exito removiendo contacto");
                    break;
                } catch (IndexOutOfBoundsException e) {
                    ContactsBookUI.printString("Ingrese un número valido!");
                    y = ContactsBookUI.ingresoInt();

                }
            }

        }
//alñsdkfjasklñdf
    }

    @Override
    public void updateContact() {

        if (contactos.size() == 0) {
            ContactsBookUI.printString("No existen contactos aún");
        } else {

            int x = printContactsKeys();
            int y = ContactsBookUI.printMenuAtributos();

            if (x == 0) {
                ContactsBookUI.printString("No se puede realizar este metodo");
            } else {

                switch (y) {

                    case 1:
                        // se ingresa un string valido
                        String nombre = ContactsBookUI.ingresoString();
                        while (true) {
                            if (nombre.length() >= 3 && nombre.length() <= 10) {
                                if (nombre.matches(".*\\d.*")) {
                                    ContactsBookUI.printString("Ingrese el nombre sin números!!");
                                    nombre = ContactsBookUI.ingresoString();
                                } else {
                                    break;
                                }
                            } else {
                                ContactsBookUI.printString("El valor minimo son 3 letras y máximo "
                                        + "10!!");
                                nombre = ContactsBookUI.ingresoString();
                            }

                        }

                        contactos.get(x - 1).setNombre(nombre);
                        break;
                    case 2:
                        // se ingresa un string valido
                        String apellido = ContactsBookUI.ingresoString();
                        while (true) {
                            if (apellido.length() >= 3 && apellido.length() <= 10) {
                                if (apellido.matches(".*\\d.*")) {
                                    ContactsBookUI.printString("Ingrese el apellido sin números!!");
                                    apellido = ContactsBookUI.ingresoString();
                                } else {
                                    break;
                                }

                            } else {
                                ContactsBookUI.printString("El valor minimo son 3 letras y máximo "
                                        + "10!!");
                                apellido = ContactsBookUI.ingresoString();
                            }
                        }

                        contactos.get(x - 1).setApellido(apellido);
                        break;
                    case 3:
                        ArrayList<String> correos = new ArrayList();
                        ContactsBookUI.printString("Puede ingresar multiples correos"
                                + " electronicos, cuando desee terminar ingrese 0");

                        while (true) {
                            String correo = ContactsBookUI.ingresoString();
                            if (correo.equals("0")) {
                                if (correos.size() >= 1) {
                                    break;
                                } else {
                                    ContactsBookUI.printString("Ingrese al menos un correo!");
                                }
                            }
                            while (true) {
                                if (correo.length() >= 11 && correo.length() <= 25) {
                                    if (correo.indexOf("@") == correo.lastIndexOf("@")
                                            && correo.contains(".") && correo.indexOf("@") > -1) {

                                        correos.add(correo);
                                        ContactsBookUI.printString("Ingrese el siguiente correo!!");
                                        break;

                                    } else {
                                        ContactsBookUI.printString("El correo debe contener  "
                                                + " un @ y al menos un punto (.) ");
                                        correo = ContactsBookUI.ingresoString();
                                    }

                                } else {
                                    ContactsBookUI.printString("El valor minimo son 11 letras y máximo "
                                            + "25!!");
                                    correo = ContactsBookUI.ingresoString();
                                }
                            }

                        }
                        String[] a = new String[correos.size()];
                        contactos.get(x - 1).setCorreosElectronicos(correos.toArray(a));
                        break;
                    case 4:

                        int telefonoFijo = ContactsBookUI.ingresoInt();
                        while (true) {
                            try {

                                if (telefonoFijo >= 1000000 && telefonoFijo <= 10000000) {
                                    break;
                                } else {
                                    ContactsBookUI.printString("El número debe tener 7 digitos!");
                                    telefonoFijo = ContactsBookUI.ingresoInt();
                                }

                            } catch (NumberFormatException e) {
                                ContactsBookUI.printString("Ingrese un número dentro"
                                        + " de los limites (7)");
                                telefonoFijo = ContactsBookUI.ingresoInt();
                            }

                        }
                        contactos.get(x - 1).setTelefonoFijo(telefonoFijo);
                        break;
                    case 5:

                        long telefonoMovil = ContactsBookUI.ingresoLong();
                        while (true) {
                            if (telefonoMovil >= 1000000000 && telefonoMovil < 10000000000l) {
                                break;
                            } else {
                                ContactsBookUI.printString("El número debe tener 10 digitos!");
                                telefonoMovil = ContactsBookUI.ingresoLong();

                            }
                        }
                        contactos.get(x - 1).setTelefonoMovil(telefonoMovil);
                        break;
                    case 6:

                        String direccion = ContactsBookUI.ingresoString();
                        while (true) {
                            if (direccion.length() >= 10 && direccion.length() <= 30) {
                                break;

                            } else {
                                ContactsBookUI.printString("El valor minimo son 10 letras y máximo "
                                        + "30!!");
                                direccion = ContactsBookUI.ingresoString();
                            }
                        }
                        contactos.get(x - 1).setDireccion(direccion);
                        break;
                    default:
                        ContactsBookUI.printString("Error, por favor ingrese de nuevo"
                                + " el valor");
                        updateContact();
                        break;
                }
            }
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
                    contactsBook.removeContact();
                    break;
                case 3:
                    contactsBook.updateContact();
                    break;
                case 4:
                    contactsBook.printAllContacts();
                    break;
                case 5:
                    contactsBook.printContactsKeys();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    ContactsBookUI.printString("Ingrese de nuevo su opción");
                    opc = 1;
                    continue;
            }
            ContactsBookUI.printRepeat();

            if (opc == 6) {
                break;
            }

        } while (true);

    }

}
