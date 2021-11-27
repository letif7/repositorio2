package py.una.server.tcp;

import py.una.entidad.Persona;
import py.una.entidad.PersonaJSON;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class TCPServerHilo extends Thread {

    private Socket socket = null;

    TCPMultiServer servidor;
    
    public TCPServerHilo(Socket socket, TCPMultiServer servidor ) {
        super("TCPServerHilo");
        this.socket = socket;
        this.servidor = servidor;
    }

    public void run() {
        System.out.println("funcion run");
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            out.println("Bienvenido!");
            String outputLine = null;
            Persona inputLine = new Persona();

            while ( inputLine != null ) {
                System.out.println("Mensaje recibido: " + inputLine);
                inputLine = PersonaJSON.stringObjeto(in.readLine());
                System.out.println("se recibio tipo de operacion: "+inputLine.getTipo_operacion()+" cedula: "+inputLine.getCedula()+" nombre: "+inputLine.getNombre());

                //out.println(inputLine);
                
                //to-do: utilizar json
                if ( inputLine.getTipo_operacion() == 3 ) {
                    servidor.listening = false;
                    outputLine = "Usted apago todo";
                    break;
                    
                }else if ( inputLine.getTipo_operacion() == 1) {
                    outputLine = "Lista de usuarios: " ;
                    ArrayList<Persona> ax = new ArrayList<Persona>();
                    outputLine= PersonaJSON.list_toJsonPersona(servidor.usuarios.listarDAO());

                }else if( inputLine.getTipo_operacion() ==  2) {
                    servidor.usuarios.setVehiculo(inputLine);
                    outputLine = "Usuario/a "+inputLine.getCedula()+" agregado";
                }
                
                
                out.println(outputLine);
            }
            out.close();
            in.close();
            socket.close();
            System.out.println("Finalizando Hilo");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
