package com.redes.cliente;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
    
    public boolean inicarChat(String endereco, int porta, String nome) {
        try {
            cliente = new Socket(endereco, porta);
            leitor = new DataInputStream(cliente.getInputStream());
            escritor = new DataOutputStream(cliente.getOutputStream());
  
            escritor.writeUTF(nome);
            
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(),
                    "Erro ao iniciar chat.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public void aguardarMensagens() {
        new Thread() {
            @Override
            public void run() {
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
        }.start();
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
        java.awt.GridBagConstraints gridBagConstraints;

        pnlContainer = new javax.swing.JPanel();
        btnEnviar = new javax.swing.JButton();
        lblMensagem = new javax.swing.JLabel();
        lblOnline = new javax.swing.JLabel();
        scrScrollUsuarios = new javax.swing.JScrollPane();
        lstUsuariosOnline = new javax.swing.JList<>();
        btnDesconectar = new javax.swing.JButton();
        scrScrollMensagens = new javax.swing.JScrollPane();
        lstMensagens = new javax.swing.JList<>();
        lblChatSocket = new javax.swing.JLabel();
        txtChat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(460, 500));
        setPreferredSize(new java.awt.Dimension(460, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEnviar.setBackground(new java.awt.Color(255, 255, 255));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(0, 0, 0));
        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/enviar-icon.png"))); // NOI18N
        btnEnviar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEnviar.setMinimumSize(new java.awt.Dimension(34, 34));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        pnlContainer.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 40, -1));

        lblMensagem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMensagem.setText("Mensagens");
        pnlContainer.add(lblMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lblOnline.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOnline.setText("Online");
        pnlContainer.add(lblOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        lstUsuariosOnline.setForeground(new java.awt.Color(0, 153, 0));
        lstUsuariosOnline.setModel(modelUsuarios);
        scrScrollUsuarios.setViewportView(lstUsuariosOnline);

        pnlContainer.add(scrScrollUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 80, 271));

        btnDesconectar.setBackground(new java.awt.Color(255, 51, 51));
        btnDesconectar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDesconectar.setForeground(new java.awt.Color(0, 0, 0));
        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });
        pnlContainer.add(btnDesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 118, 30));

        lstMensagens.setForeground(new java.awt.Color(0, 0, 0));
        lstMensagens.setModel(modelMensagens);
        scrScrollMensagens.setViewportView(lstMensagens);

        pnlContainer.add(scrScrollMensagens, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 272, 271));

        lblChatSocket.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblChatSocket.setText("Chat Socket");
        pnlContainer.add(lblChatSocket, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 6, -1, -1));

        txtChat.setPreferredSize(new java.awt.Dimension(64, 32));
        txtChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatKeyPressed(evt);
            }
        });
        pnlContainer.add(txtChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 370, 40));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 7);
        getContentPane().add(pnlContainer, gridBagConstraints);

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
    private javax.swing.JLabel lblChatSocket;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblOnline;
    private javax.swing.JList<String> lstMensagens;
    private javax.swing.JList<String> lstUsuariosOnline;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JScrollPane scrScrollMensagens;
    private javax.swing.JScrollPane scrScrollUsuarios;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables
}
