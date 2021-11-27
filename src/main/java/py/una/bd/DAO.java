package py.una.bd;

import py.una.entidad.Persona;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    ArrayList<Persona> lista ;


    public DAO(){
        lista = new ArrayList<Persona>();
    }

    public List<Persona> getVehiculos() {
        return lista;
    }

    public void setVehiculo(Persona p) {
        lista.add(p);
    }

    public DAO testDAO() {

        DAO pdao = new DAO();

        return pdao;
    }

    public ArrayList<Persona> listarDAO(){
        /*DAO pdao = new DAO();
        for (Persona p: pdao.lista){
            System.out.println(p.getCedula() + " " + p.getNombre() + " " + p.getApellido()+ " " + p.getChapa() + " " + p.getMarca());
        }*/
        return lista;
    }

    }

}