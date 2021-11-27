package py.una.server.tcp;


import py.una.entidad.Persona;
import py.una.entidad.PersonaJSON;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class TCPClient {

    public static void main(String[] args) throws Exception {

        Socket unSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            unSocket = new Socket("localhost", 4444);

            // enviamos nosotros
            out = new PrintWriter(unSocket.getOutputStream(), true);
            //viene del servidor
            in = new BufferedReader(new InputStreamReader(unSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Host desconocido");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error de I/O en la conexion al host");
            System.exit(1);
        }

        
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;
        Long operacion = 1L;
        String StringJSON = null;

        while ((fromServer = in.readLine()) != null) {

            System.out.println("Servidor: " + fromServer);
            if (fromServer.equals("Bye")) {
                break;
            }
            System.out.println("Elige el tipo de operacion:\n1. Registrar datos\n2. Lista de vehiculos\n3. Para salir");
            fromUser = stdIn.readLine();
            if (fromUser != null) {

                System.out.println("Operacion: " + fromUser);
                if( Long.parseLong(fromUser) == 2){
                    System.out.println("operacion 2 listar");
                    Persona p = new Persona(null,null,null,null,null,Long.parseLong(fromUser));
                    StringJSON = PersonaJSON.objetoString(p);

                }else if ( Long.parseLong(fromUser) == 1 ){
                    System.out.println("operacion 1 registrar");
                    System.out.println("Ingrese su cedula: ");
                    Long cedula = Long.parseLong(stdIn.readLine());
                    System.out.println("Ingrese su nombre: ");
                    String nombre = stdIn.readLine();
                    System.out.println("Ingrese el apellido: ");
                    String apellido = stdIn.readLine();
                    System.out.println("Ingrese la chapa: ");
                    String chapa = stdIn.readLine();
                    System.out.println("Ingrese la marca: ");
                    String marca = stdIn.readLine();
                    Long op=Long.parseLong(fromUser);
                    Persona p = new Persona(cedula,nombre,apellido,chapa,marca,op);
                    System.out.println("cedula: "+cedula+" tipo de operacion: "+op);
                    StringJSON = PersonaJSON.objetoString(p);

                }else if ( Long.parseLong(fromUser) == 3 ){
                    System.out.println("operacion 3 salir");
                    Persona p = new Persona(null,null,null,null,null,Long.parseLong(fromUser));
                    StringJSON = PersonaJSON.objetoString(p);
                }

                //escribimos al servidor
                out.println(StringJSON);
            }
        }
        System.out.println("close");
        out.close();
        in.close();
        stdIn.close();
        unSocket.close();
    }

    public static void listarEmpresas(ArrayList<Empresa> lista){
        System.out.println("Lista de Empresas");
        for (Empresa p: lista){
            System.out.println("\nruc: "+p.getRuc() + " razonSocial: "+p.getRazonSocial() + " ciudad: " + p.getCiudad() + " pais: " + p.getPais() );
        }
    }
}
