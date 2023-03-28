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

    private final DefaultListModel listaPortas;
    
    public ServidorTela() {
        listaPortas = new DefaultListModel();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void mostar(String msg) {
        listaPortas.addElement(msg);
    }
    
    public void servidor(int porta) {
        new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket servidor = new ServerSocket(porta);

                    while(true) {
                        Socket cliente = servidor.accept();
                        listaPortas.addElement("Cliente: " + cliente.getRemoteSocketAddress());
                        new Thread(new GerenciarServidor(cliente)).start();
                    }            

                } catch (IOException erro) {
                    JOptionPane.showMessageDialog(null, erro.getMessage(), 
                            "Erro ao iniciar o servidor:", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }.start();  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlContainer = new javax.swing.JPanel();
        txtPorta = new javax.swing.JTextField();
        btnPorta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPotas = new javax.swing.JList<>();
        lblPorta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(460, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlContainer.setPreferredSize(new java.awt.Dimension(460, 500));
        pnlContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlContainer.add(txtPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 200, 30));

        btnPorta.setBackground(new java.awt.Color(102, 102, 255));
        btnPorta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPorta.setForeground(new java.awt.Color(255, 255, 255));
        btnPorta.setText("Inciar Servidor");
        btnPorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortaActionPerformed(evt);
            }
        });
        pnlContainer.add(btnPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, 30));

        lstPotas.setModel(listaPortas);
        jScrollPane1.setViewportView(lstPotas);

        pnlContainer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 370, 230));

        lblPorta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPorta.setText("Porta:");
        pnlContainer.add(lblPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Servidor Socket");
        pnlContainer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 412;
        gridBagConstraints.ipady = 342;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(pnlContainer, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortaActionPerformed
        int portinha = Integer.parseInt(txtPorta.getText().trim());
        servidor(portinha);
    }//GEN-LAST:event_btnPortaActionPerformed

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
    private javax.swing.JButton btnPorta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPorta;
    private javax.swing.JList<String> lstPotas;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JTextField txtPorta;
    // End of variables declaration//GEN-END:variables
}
