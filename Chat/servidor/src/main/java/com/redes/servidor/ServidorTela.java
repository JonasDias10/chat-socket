package com.redes.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author Kaio
 */
public class ServidorTela extends javax.swing.JFrame {

    private final DefaultListModel modelMensagens;
    private ServerSocket servidor;
    
    public ServidorTela() {
        modelMensagens = new DefaultListModel();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void inicarServidor(int porta) {
        try {
            servidor = new ServerSocket(porta);
            modelMensagens.addElement("Servidor iniciado na porta: " + porta);
            aguardarConexoes();
            btnIniciarServidor.setEnabled(false);
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), 
                            "Erro ao iniciar o servidor.", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void aguardarConexoes() {
        new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {
                        Socket cliente = servidor.accept();
                        
                        new Thread(new GerenciarServidor(cliente, modelMensagens)).start();
                    }            
                } catch (IOException erro) {
                    JOptionPane.showMessageDialog(null, erro.getMessage(), 
                            "Erro ao aceitar conexões.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }.start();  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        button1 = new java.awt.Button();
        pnlContainer = new javax.swing.JPanel();
        txtPorta = new javax.swing.JTextField();
        btnIniciarServidor = new javax.swing.JButton();
        scrMensagens = new javax.swing.JScrollPane();
        lstMensagens = new javax.swing.JList<>();
        lblPorta = new javax.swing.JLabel();
        lblServidorSocket = new javax.swing.JLabel();

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor Socket");
        setMaximumSize(new java.awt.Dimension(460, 500));
        setMinimumSize(new java.awt.Dimension(460, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlContainer.setBackground(new java.awt.Color(148, 247, 186));
        pnlContainer.setMaximumSize(new java.awt.Dimension(460, 500));
        pnlContainer.setMinimumSize(new java.awt.Dimension(460, 500));
        pnlContainer.setNextFocusableComponent(this);
        pnlContainer.setPreferredSize(new java.awt.Dimension(460, 500));
        pnlContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPorta.setBackground(new java.awt.Color(255, 255, 255));
        txtPorta.setForeground(new java.awt.Color(0, 0, 0));
        pnlContainer.add(txtPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 100, 40));

        btnIniciarServidor.setBackground(new java.awt.Color(102, 102, 255));
        btnIniciarServidor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIniciarServidor.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarServidor.setText("Inciar Servidor");
        btnIniciarServidor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnIniciarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarServidorActionPerformed(evt);
            }
        });
        pnlContainer.add(btnIniciarServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 120, 40));

        lstMensagens.setBackground(new java.awt.Color(255, 255, 255));
        lstMensagens.setForeground(new java.awt.Color(0, 0, 0));
        lstMensagens.setModel(modelMensagens);
        scrMensagens.setViewportView(lstMensagens);

        pnlContainer.add(scrMensagens, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 380, 230));

        lblPorta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPorta.setForeground(new java.awt.Color(0, 0, 0));
        lblPorta.setText("Porta:");
        pnlContainer.add(lblPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        lblServidorSocket.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblServidorSocket.setForeground(new java.awt.Color(0, 0, 0));
        lblServidorSocket.setText("Servidor Socket");
        pnlContainer.add(lblServidorSocket, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(pnlContainer, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarServidorActionPerformed
        int porta = Integer.parseInt(txtPorta.getText().trim());
        inicarServidor(porta);
    }//GEN-LAST:event_btnIniciarServidorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServidorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServidorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServidorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServidorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarServidor;
    private java.awt.Button button1;
    private javax.swing.JLabel lblPorta;
    private javax.swing.JLabel lblServidorSocket;
    private javax.swing.JList<String> lstMensagens;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JScrollPane scrMensagens;
    private javax.swing.JTextField txtPorta;
    // End of variables declaration//GEN-END:variables
}
