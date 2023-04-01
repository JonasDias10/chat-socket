package com.redes.servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jonas Dias
 */
public class GerenciarServidor implements Runnable {
    
    private static List<Cliente> clientes = new ArrayList<>();
    private final Cliente cliente;
    private final DefaultListModel modelMensagens;
    
    public GerenciarServidor(Socket cliente, DefaultListModel modelMensagens) {
        this.cliente = new Cliente(cliente);
        this.modelMensagens = modelMensagens;
    }
    
    @Override
    public void run() {
        try {
            cliente.setNomeUsuario(cliente.getLeitor().readUTF());
            clientes.add(cliente);
            
            modelMensagens.addElement(cliente.getNomeUsuario() + 
                    " concectou ao servidor: " + cliente.getClienteSocket().getRemoteSocketAddress());
                        
            enviarUsuariosConectados();
            enviarEntradaSaida(cliente.getNomeUsuario() + " entrou no chat.");
            
            while(true) {
                String msg = cliente.getLeitor().readUTF();
                
                if (msg.equalsIgnoreCase("cmd::sair")) {
                    clientes.remove(cliente);
                    enviarEntradaSaida(cliente.getNomeUsuario() + " saiu do chat.");
                    enviarUsuariosConectados();
                    cliente.getClienteSocket().close();
                } else {
                    enviarMensagem(cliente, msg);
                }
            }
         } catch (IOException erro) {
             modelMensagens.addElement("A conexão com " + cliente.getNomeUsuario() + " foi fechada.");
        }
    }    
    
    private void enviarUsuariosConectados() {
        StringBuilder str = new StringBuilder();
        
        clientes.forEach(item -> {
            str.append(item.getNomeUsuario());
            str.append(",");
        });
        
        try {
            for (Cliente item : clientes) {
                item.getEscritor().writeUTF("cmd::online");
                item.getEscritor().writeUTF(str.toString());
            }
        } catch (IOException erro) {
            System.err.println("Erro: " + erro.getMessage());
        }
        
    }
    
    private void enviarEntradaSaida(String msg) {
        clientes.forEach(item -> {
            try {
                if (item.getClienteSocket() != cliente.getClienteSocket()) {
                    item.getEscritor().writeUTF(msg);
                }
            } catch (IOException erro) {
                System.err.println("Erro: " + erro.getMessage());
            }
        });
    }
    
    private void enviarMensagem(Cliente cliente, String msg) {
        clientes.forEach(item -> {
            try {
                if (item == cliente) {
                    item.getEscritor().writeUTF("Eu: " + msg);
                } else {
                    item.getEscritor().writeUTF(cliente.getNomeUsuario() + ": " + msg);
                }
            } catch (IOException erro) {
                System.err.println("Erro: " + erro.getMessage());
            }
        });
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(List<Cliente> clientes) {
        GerenciarServidor.clientes = clientes;
    }
    
}