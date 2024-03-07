/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonato;

import java.util.ArrayList;
import modelos.config.Usuario;
import modelos.deporte.Equipo;

/**
 *
 * @author ssqua
 */
public class CControl {

    String descripcionCampeonato;  //fecha del campeonato
    ArrayList<Equipo> equipos;
    ArrayList<Usuario> usuarios;
    boolean configRuta;
    int paginado;
    String id;

    public CControl() {
        this.descripcionCampeonato = "";
        this.equipos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.paginado = 10;
        this.configRuta = false;
        this.id = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public boolean isConfigRuta() {
        return configRuta;
    }

    public void setConfigRuta(boolean configRuta) {
        this.configRuta = configRuta;
    }

    public int getPaginado() {
        return paginado;
    }

    public void setPaginado(int paginado) {
        this.paginado = paginado;
    }

    public String getDescripcionCampeonato() {
        return descripcionCampeonato;
    }

    public void setDescripcionCampeonato(String descripcionCampeonato) {
        this.descripcionCampeonato = descripcionCampeonato;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

     public void AddUsuario(Usuario us) {
        usuarios.add(us);
    }
    
    public boolean TextoVacio(String texto) {
        int contEspacio = 0;
        if (texto.equals("") || texto.equals(" ")) {
            return true;
        }
        for (int i = 0; i < texto.length(); i++) {
            if (String.valueOf(texto.charAt(i)).equals(" ")) {
                contEspacio++;
            }
        }
        if (contEspacio == texto.length()) {
            return true;
        }
        return false;
    }

    public boolean esNumero(String cadena) {
        if (!esEntero(cadena)) {
            if (cadena.contains(".")) {
                cadena = cadena.replace(".", "/");
                String arre[] = cadena.split("/");
                if (arre.length == 2) {
                    if (esNumero(arre[0]) && esNumero(arre[1])) {
                        return true;
                    }
                } else if (arre.length == 1) {
                    if (esEntero(arre[0])) {
                        return true;
                    }
                }
            }
        } else if (esEntero(cadena)) {
            return true;
        }
        return false;
    }

    public boolean esEntero(String cadena) {
        int cant = 0;
        char[] arr = cadena.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                cant++;
            }
            if (arr[i] == '1') {
                cant++;
            }
            if (arr[i] == '2') {
                cant++;
            }
            if (arr[i] == '3') {
                cant++;
            }
            if (arr[i] == '4') {
                cant++;
            }
            if (arr[i] == '5') {
                cant++;
            }
            if (arr[i] == '6') {
                cant++;
            }
            if (arr[i] == '7') {
                cant++;
            }
            if (arr[i] == '8') {
                cant++;
            }
            if (arr[i] == '9') {
                cant++;
            }
        }
        if (cant != cadena.length()) {
            return false;
        }
        return true;
    }
    
     public boolean existeUsuario(Usuario u) {
        for (Usuario usuario : usuarios) {
            if (usuario.user.equals(u.user)) {
                return true;
            }
        }
        return false;
    }

    public boolean LogearUsuario(Usuario u) {
        for (Usuario usuario : usuarios) {
            if (usuario.user.equals(u.user)) {
                if (usuario.password.equals(u.password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void EliminarUsuario(int pos) {
        usuarios.remove(pos);
    }
}
