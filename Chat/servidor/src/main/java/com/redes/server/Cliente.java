package com.redes.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Jonas Dias
 */
public class Cliente {
    
    private Socket cliente;
    private String nomeUsuario;
    private DataInputStream leitor;
    private DataOutputStream escritor;

    public Cliente(Socket cliente) {
        this.cliente = cliente;
        try {
            escritor = new DataOutputStream(cliente.getOutputStream());
            leitor = new DataInputStream(cliente.getInputStream());
        } catch (IOException erro) {
            System.err.println("Erro: " + erro.getMessage());
        }
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public DataInputStream getLeitor() {
        return leitor;
    }

    public void setLeitor(DataInputStream leitor) {
        this.leitor = leitor;
    }

    public DataOutputStream getEscritor() {
        return escritor;
    }

    public void setEscritor(DataOutputStream escritor) {
        this.escritor = escritor;
    }
    
}