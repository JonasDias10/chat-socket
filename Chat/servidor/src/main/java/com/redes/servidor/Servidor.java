package com.redes.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Jonas Dias
 */
public class Servidor {
  
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5050);
            
            while(true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente: " + cliente.getRemoteSocketAddress());
                
                new Thread(new GerenciarServidor(cliente)).start();
            }            
            
        } catch (IOException erro) {
            System.out.println("Erro ao iniciar o servidor: " + erro.getMessage());
        }
    }
}