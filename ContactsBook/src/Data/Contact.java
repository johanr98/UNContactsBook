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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreosElectronicos(String[] correosElectronicos) {
        this.correosElectronicos = correosElectronicos;
    }

    public void setTelefonoFijo(int telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public void setTelefonoMovil(long telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String[] getCorreosElectronicos() {
        return correosElectronicos;
    }

    public int getTelefonoFijo() {
        return telefonoFijo;
    }

    public long getTelefonoMovil() {
        return telefonoMovil;
    }

    public String getDireccion() {
        return direccion;
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
    
    public Contact(String nombre, String apellido, String[] correosElectronicos, int telefonoFijo, long telefonoMovil, String direccion ){
        this.nombre= nombre;
        this.apellido=apellido;
        this.correosElectronicos=correosElectronicos;
        this.telefonoFijo=telefonoFijo;
        this.telefonoMovil=telefonoMovil;
        this.direccion=direccion;
    }
    
}
