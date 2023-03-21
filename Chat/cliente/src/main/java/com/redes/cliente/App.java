package com.redes.cliente;

/**
 *
 * @author Jonas Dias
 */
public class App {
    
    public static void main(String[] args) {
        TelaChat telaChat = new TelaChat();
        telaChat.setVisible(true);
        telaChat.inicarChat();
        telaChat.aguardarMensagens();
    }
    
}
