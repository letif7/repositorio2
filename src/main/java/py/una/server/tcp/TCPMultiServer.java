package py.una.server.tcp;

import py.una.bd.DAO;

import java.net.*;
import java.util.ArrayList;
import java.io.*;



public class TCPMultiServer {

	//variables compartidas
	boolean listening = true;
	ArrayList<TCPServerHilo> hilosClientes; //almacenar los hilos (no se utiliza en el ejemplo, se deja para que el alumno lo utilice)
	DAO usuarios; //almacenar una lista de usuarios (no se utiliza, se deja para que el alumno lo utilice)

    public void ejecutar() throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("No se puede abrir el puerto: 4444.");
            System.exit(1);
        }
        System.out.println("Puerto abierto: 4444.");

        while (listening) {
        	System.out.println("creando hilo");
        	TCPServerHilo hilo = new TCPServerHilo(serverSocket.accept(), this);
            System.out.println("Añadiendo hilo a hilosClientes");
            hilosClientes.add(hilo);
            System.out.println("correr hilo");
            hilo.run();

        }

        serverSocket.close();
    }
    
    public static void main(String[] args) throws IOException {
    	
    	TCPMultiServer tms = new TCPMultiServer();
    	
    	tms.hilosClientes = new ArrayList<TCPServerHilo>();
    	tms.usuarios = new DAO();
    	
    	tms.ejecutar();
    	
    }
}
