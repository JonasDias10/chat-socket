package com.redes.cliente;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaio
 */
public class TelaChat extends javax.swing.JFrame {
    
    private Socket cliente;
    private DataInputStream leitor;
    private DataOutputStream escritor;
    private final DefaultListModel modelMensagens;
    private final DefaultListModel modelUsuarios;
    
    public TelaChat() {
        modelMensagens = new DefaultListModel();
        modelUsuarios = new DefaultListModel();
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void inicarChat() {
        try {
            cliente = new Socket(InetAddress.getByName("localhost"), 5050);
            leitor = new DataInputStream(cliente.getInputStream());
            escritor = new DataOutputStream(cliente.getOutputStream());
            
            String nome = JOptionPane.showInputDialog(null, leitor.readUTF(), 
                    "Bem-vindo ao chat!", JOptionPane.INFORMATION_MESSAGE);
            escritor.writeUTF(nome);
            
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(),
                    "Erro ao iniciar chat.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void aguardarMensagens() {
         while(true) {
                try {
                    String msg = leitor.readUTF();
                    
                    if (msg.equalsIgnoreCase("cmd::online")) {
                        preencherUsuarios( leitor.readUTF());
                    } else {
                        preencherMensagens(msg);
                    }                    
                    
                } catch (IOException erro) {
                    JOptionPane.showMessageDialog(null, erro.getMessage(),
                    "Erro ao ler mensagem.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
    }
    
    private void preencherUsuarios(String usuarios) {
        modelUsuarios.clear();
        String[] usuariosOnline = usuarios.split(",");
        
        for (String nome : usuariosOnline) {
            modelUsuarios.addElement(nome);
        }
        
    }
    
    private void preencherMensagens(String msg) {
        modelMensagens.addElement(msg);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMensagem = new javax.swing.JLabel();
        lblOnline = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstUsuariosOnline = new javax.swing.JList<>();
        txtChat = new javax.swing.JTextField();
        btnDesconectar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMensagens = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMensagem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMensagem.setText("Mensagens");

        lblOnline.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOnline.setText("Online");

        lstUsuariosOnline.setForeground(new java.awt.Color(102, 255, 102));
        lstUsuariosOnline.setModel(modelUsuarios);
        jScrollPane3.setViewportView(lstUsuariosOnline);

        txtChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatKeyPressed(evt);
            }
        });

        btnDesconectar.setBackground(new java.awt.Color(255, 51, 51));
        btnDesconectar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDesconectar.setForeground(new java.awt.Color(0, 0, 0));
        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });

        btnEnviar.setBackground(new java.awt.Color(102, 102, 255));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(0, 0, 0));
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lstMensagens.setModel(modelMensagens);
        jScrollPane2.setViewportView(lstMensagens);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Chat Socket");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblMensagem))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblOnline)
                                        .addGap(23, 23, 23))))
                            .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensagem)
                    .addComponent(lblOnline))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtChat))
                .addGap(18, 18, 18)
                .addComponent(btnDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (txtChat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mensagem está vázia!",
                    "Digite uma mensagem.", JOptionPane.ERROR_MESSAGE);
                    return;
        }
        try {
            escritor.writeUTF(txtChat.getText().trim());
            txtChat.setText("");
        } catch (IOException erro) {
             JOptionPane.showMessageDialog(null, erro.getMessage(),
                    "Erro ao enviar mensagem.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        try {
            escritor.writeUTF("cmd::sair");
            System.exit(0);
        } catch (IOException erro) {
             JOptionPane.showMessageDialog(null, erro.getMessage(),
                    "Erro ao sair do chat.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void txtChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtChat.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mensagem está vázia!",
                        "Digite uma mensagem.", JOptionPane.ERROR_MESSAGE);
                        return;
            }
            try {
                escritor.writeUTF(txtChat.getText().trim());
                txtChat.setText("");
            } catch (IOException erro) {
                 JOptionPane.showMessageDialog(null, erro.getMessage(),
                        "Erro ao enviar mensagem.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtChatKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblOnline;
    private javax.swing.JList<String> lstMensagens;
    private javax.swing.JList<String> lstUsuariosOnline;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables
}
