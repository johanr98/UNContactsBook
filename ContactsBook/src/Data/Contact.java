/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author johanr98 jsromerod@unal.edu.co
 */
public class Contact {

    private String nombre;
    private String apellido;
    private String[] correosElectronicos;
    private int telefonoFijo;
    private long telefonoMovil;
    private String direccion;

    public String toString() {
        return "Nombre : " + this.nombre + "\n"
                + "Apellido : " + this.apellido + "\n"
                + "Correos elecronicos : " + this.emailList() + "\n"
                + "Telefono fijo : "+this.telefonoFijo+"\n"
                + "Telefono movil : "+this.telefonoMovil+"\n"
                + "Direccion : "+this.direccion;
    }

    private String emailList() {
        String r = "";
        for (int i = 0; i < correosElectronicos.length; i++) {
            if (i == correosElectronicos.length - 2) {
                r += correosElectronicos[i];
            } else {
                r += correosElectronicos[i] + ", ";
            }
        }
        return r;
    }
    
}
