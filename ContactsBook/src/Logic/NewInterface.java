/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Contact;

/**
 *
 * @author Juan
 */
public interface NewInterface {

    public abstract void addContact();

    public abstract void removeContact();

    public abstract void updateContact();

    public abstract void printAllContacts();

    public abstract int printContactsKeys();

}
