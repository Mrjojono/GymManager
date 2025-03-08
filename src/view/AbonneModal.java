package view;

import DAO.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AbonneModal extends javax.swing.JDialog {

    private AbonnementDao ab;
    private Abonnement parent;
    private int id;

    public AbonneModal(java.awt.Frame parent, boolean modal, Abonnement mainParent, int id) {
        this.id = id;
        ab = new AbonnementDao();
        super(parent, modal);
        this.parent = mainParent;
        initComponents();
        jModifier.setVisible(false);
        setModifierB();
    }

    public AbonneModal(java.awt.Frame parent, boolean modal, Abonnement mainParent) {
        ab = new AbonnementDao();
        super(parent, modal);
        this.parent = mainParent;
        initComponents();
        jModifier.setVisible(false);
        setModifierB();
    }

    private AbonneModal(JFrame jFrame, boolean b) {

    }

    public void setModifierB() {
        // Vérifie si au moins un champ n'est pas vide
        if (!Duree.getText().trim().isEmpty()
                || !libelle.getText().trim().isEmpty()
                || !prix.getText().trim().isEmpty()) {
            jModifier.setVisible(false);  // Affiche le bouton si au moins un champ est rempli
        } else {
            jModifier.setVisible(true);  // Cache le bouton si tous les champs sont vides
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fadeEffect1 = new LIB.FadeEffect();
        fadeEffect2 = new LIB.FadeEffect();
        gradientPanel1 = new view.GradientPanel();
        gradientPanel2 = new view.GradientPanel();
        jSeparator4 = new javax.swing.JSeparator();
        libelle = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        Duree = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        prix = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jModifier = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        gradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        gradientPanel1.setForeground(new java.awt.Color(255, 255, 255));

        gradientPanel2.setBackground(new java.awt.Color(204, 204, 204));
        gradientPanel2.setForeground(new java.awt.Color(255, 255, 255));

        libelle.setBackground(new java.awt.Color(0, 0, 0));
        libelle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        libelle.setForeground(new java.awt.Color(255, 255, 255));
        libelle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        libelle.setOpaque(false);
        libelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libelleActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Libelle");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Duree (mois)");

        Duree.setBackground(new java.awt.Color(0, 0, 0));
        Duree.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Duree.setForeground(new java.awt.Color(255, 255, 255));
        Duree.setBorder(null);
        Duree.setOpaque(false);
        Duree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DureeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Prix (FCFA)");

        prix.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        prix.setForeground(new java.awt.Color(255, 255, 255));
        prix.setBorder(null);
        prix.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Exit");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Valider");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jModifier.setBackground(new java.awt.Color(0, 0, 0));
        jModifier.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jModifier.setForeground(new java.awt.Color(255, 255, 255));
        jModifier.setText("Modidifer");
        jModifier.setBorderPainted(false);
        jModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModifierActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ajout Abonnement");

        javax.swing.GroupLayout gradientPanel2Layout = new javax.swing.GroupLayout(gradientPanel2);
        gradientPanel2.setLayout(gradientPanel2Layout);
        gradientPanel2Layout.setHorizontalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gradientPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Duree, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(gradientPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5)
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(prix, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(libelle, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gradientPanel2Layout.setVerticalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libelle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Duree, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prix, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jModifier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(gradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addComponent(gradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(gradientPanel1, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void libelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libelleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libelleActionPerformed

    private void DureeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DureeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DureeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (libelle.getText().isEmpty() || Duree.getText().isEmpty() || prix.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "fields are empty !");
        } else {
            try {

                int duree = Integer.parseInt(Duree.getText());
                double prixValue = Double.parseDouble(prix.getText());
                if (duree > 12) {
                    JOptionPane.showMessageDialog(this, "The duration must not exceed 12 months!", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(prixValue < 0){
                    JOptionPane.showMessageDialog(this, "The price must not be of negative value!", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                ab.createAbonnement(libelle.getText(), duree, prixValue);
                JOptionPane.showMessageDialog(this, "success !");
                libelle.setText("");
                Duree.setText("");
                prix.setText("");
                if (parent != null) {
                    parent.refreshTable();
                }
                this.dispose();
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this, "Please enter valid values ​​for duration and price.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {

                Logger.getLogger(AbonneModal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error !");
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModifierActionPerformed

        if (this.id == 0) {
            JOptionPane.showMessageDialog(this, "No subscription selected!");
            return;
        }

        System.out.println("ID en cours de modification: " + this.id);

        try {

            System.out.println("Duree: " + Duree.getText());
            System.out.println("Prix: " + prix.getText());

            boolean success = ab.updateAbonnement(this.id, libelle.getText(), Duree.getText(), prix.getText());
            if (success) {
                JOptionPane.showMessageDialog(this, "Update successful!");
                if (parent != null) {
                    parent.refreshTable();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Update faill!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbonneModal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jModifierActionPerformed

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
            java.util.logging.Logger.getLogger(AbonneModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbonneModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbonneModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbonneModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AbonneModal dialog = new AbonneModal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Duree;
    private LIB.FadeEffect fadeEffect1;
    private LIB.FadeEffect fadeEffect2;
    private view.GradientPanel gradientPanel1;
    private view.GradientPanel gradientPanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jModifier;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField libelle;
    private javax.swing.JTextField prix;
    // End of variables declaration//GEN-END:variables

    /*public void setDuree(javax.swing.JTextField Duree) {
        this.Duree = Duree;
    }

    public void setLibelle(javax.swing.JTextField libelle) {
        this.libelle = libelle;
    }

    public void setPrix(javax.swing.JTextField prix) {
        this.prix = prix;
    }
     */
    public void setDuree(int duree) {
        this.Duree.setText(String.valueOf(duree));
    }

    public void setLibelle(String libelle) {
        this.libelle.setText(libelle);
    }

    public void setPrix(Double prix) {
        this.prix.setText(String.valueOf(prix));
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("ID défini: " + this.id);
    }

}
