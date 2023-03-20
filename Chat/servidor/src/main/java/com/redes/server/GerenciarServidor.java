package com.redes.server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas Dias
 */
public class GerenciarServidor implements Runnable {
    
    private static final List<Cliente> clientes = new ArrayList<>();
    private final Cliente cliente;
    
    public GerenciarServidor(Socket cliente) {
        this.cliente = new Cliente(cliente);
    }
    
    @Override
    public void run() {
        try {
            cliente.getEscritor().writeUTF("Entre com seu nome: ");
            cliente.setNomeUsuario(cliente.getLeitor().readUTF());
            clientes.add(cliente);
            
            while(true) {
                String msg = cliente.getLeitor().readUTF();
                
                if (msg.equalsIgnoreCase("cmd::online")) {
                    
                    enviarUsuariosConectados();
                    
                } else if (msg.equalsIgnoreCase("cmd::sair")) {
                    
                    cliente.getCliente().close();
                    
                } else {
                    
                    enviarMensagem(cliente, msg);
                    
                }
                
            }
            
         } catch (IOException erro) {
            System.err.println("A conexão com " + cliente.getNomeUsuario() + " foi fechada.");
            clientes.remove(cliente);
        }
    }    
    
    private void enviarUsuariosConectados() {
        StringBuilder str = new StringBuilder();
        
        clientes.forEach(item -> {
            str.append(item.getNomeUsuario());
            str.append("\n -------------------- \n");
        });
        
        try {
            cliente.getEscritor().writeUTF(str.toString());
        } catch (IOException erro) {
            System.err.println("Erro: " + erro.getMessage());
        }
        
    }
    
    private void enviarMensagem(Cliente cliente, String msg) {
        clientes.forEach(item -> {
            try {
                item.getEscritor().writeUTF(cliente.getNomeUsuario() + ": " + msg);
            } catch (IOException erro) {
                System.err.println("Erro: " + erro.getMessage());
            }
        });
    }
    
}