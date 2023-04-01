package com.redes.cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author Jonas Dias
 */
public class TelaConectar extends javax.swing.JFrame {

    public TelaConectar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlContainer = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtPorta = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        lblPorta = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(460, 500));
        setMinimumSize(new java.awt.Dimension(460, 500));
        setName("Conectar no Chat"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlContainer.setBackground(new java.awt.Color(141, 181, 247));
        pnlContainer.setToolTipText("");
        pnlContainer.setMaximumSize(new java.awt.Dimension(460, 500));
        pnlContainer.setMinimumSize(new java.awt.Dimension(460, 500));
        pnlContainer.setPreferredSize(new java.awt.Dimension(460, 500));
        pnlContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBemVindo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(0, 0, 0));
        lblBemVindo.setText("Bem-vindo(a) ao Chat Socket");
        pnlContainer.add(lblBemVindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        txtEndereco.setBackground(new java.awt.Color(255, 255, 255));
        txtEndereco.setForeground(new java.awt.Color(0, 0, 0));
        txtEndereco.setText("localhost");
        txtEndereco.setMaximumSize(new java.awt.Dimension(240, 40));
        txtEndereco.setMinimumSize(new java.awt.Dimension(240, 40));
        txtEndereco.setPreferredSize(new java.awt.Dimension(240, 40));
        pnlContainer.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));
        txtEndereco.getAccessibleContext().setAccessibleName("");

        txtPorta.setBackground(new java.awt.Color(255, 255, 255));
        txtPorta.setForeground(new java.awt.Color(0, 0, 0));
        txtPorta.setMaximumSize(new java.awt.Dimension(80, 40));
        txtPorta.setMinimumSize(new java.awt.Dimension(80, 40));
        txtPorta.setPreferredSize(new java.awt.Dimension(80, 40));
        pnlContainer.add(txtPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.setMaximumSize(new java.awt.Dimension(240, 40));
        txtNome.setMinimumSize(new java.awt.Dimension(240, 40));
        txtNome.setPreferredSize(new java.awt.Dimension(240, 40));
        pnlContainer.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(0, 0, 0));
        lblEndereco.setText("Endereço do servidor:");
        pnlContainer.add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        lblPorta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPorta.setForeground(new java.awt.Color(0, 0, 0));
        lblPorta.setText("Porta:");
        pnlContainer.add(lblPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(0, 0, 0));
        lblNome.setText("Nome do usuário:");
        pnlContainer.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        btnConectar.setBackground(new java.awt.Color(102, 102, 255));
        btnConectar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConectar.setForeground(new java.awt.Color(255, 255, 255));
        btnConectar.setText("Conectar");
        btnConectar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });
        pnlContainer.add(btnConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 193, 46));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(pnlContainer, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        if (txtPorta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porta está vazia!",
                    "Campo vazio.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtEndereco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Endereço está vazio!",
                    "Campo vazio.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome está vazio!",
                    "Campo vazio.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String endereco = txtEndereco.getText().trim();
        String nome = txtNome.getText().trim();
        int porta = Integer.parseInt(txtPorta.getText());
        
        TelaChat telaChat = new TelaChat();
        
        if (telaChat.inicarChat(endereco, porta, nome)) {
            telaChat.aguardarMensagens();
            this.setVisible(false);
            telaChat.setVisible(true);
        } 
    }//GEN-LAST:event_btnConectarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConectar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPorta;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPorta;
    // End of variables declaration//GEN-END:variables
}
