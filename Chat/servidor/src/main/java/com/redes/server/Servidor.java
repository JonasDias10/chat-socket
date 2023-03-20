package com.redes.server;

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
            // Criando o servidor na porta: 5050.
            ServerSocket servidor = new ServerSocket(5050);
            
            while(true) {
                // Aceita novas conexões de clientes.
                Socket cliente = servidor.accept();
                System.out.println("Cliente: " + cliente.getRemoteSocketAddress());
                
                // Executa uma nova thread da classe que gerenciará o cliente.
                new Thread(new GerenciarServidor(cliente)).start();
            }            
            
        } catch (IOException erro) {
            System.out.println("Erro ao iniciar o servidor: " + erro.getMessage());
        }
    }
}