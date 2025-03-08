package view;

import DAO.AbonneDao;
import DAO.SoubscriptionDao;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import model.Abonnement;

public class AbonneDataSee extends javax.swing.JPanel {

    AbonneDao dao = new AbonneDao();
    SoubscriptionDao soub = new SoubscriptionDao();
    private Souscription abonne;
    private int id;

    public AbonneDataSee() {
        initComponents();
    }

    /*  public AbonneDataSee(Souscription abonne) {
        AbonnementData ab = new AbonnementData();
        this.abonne = abonne;
        initComponents();
       
    }*/
    public void setId(int id) {
        this.id = id;
    }

    public void setjNom(String jNom) {
        this.jNom.setText(String.valueOf(jNom));
    }

    public void setjNumero(String jNumero) {
        this.jNumero.setText(String.valueOf(jNumero));
    }

    public void setjPrenom(String jPrenom) {
        this.jPrenom.setText(String.valueOf(jPrenom));
    }

    public void setjStatus(String jStatus) {
        if (jStatus == null) {
            this.jStatus.setText("0");
            return;
        }

        if ("ACTIFS".equalsIgnoreCase(jStatus)) {
            this.jStatus.setText("1");
        } else if ("NOACTIFS".equalsIgnoreCase(jStatus)) {
            this.jStatus.setText("0");
        } else {
            this.jStatus.setText(jStatus);
        }
    }

    public String getjNom() {
        return jNom.getText();
    }

    public String getjNumero() {
        return jNumero.getText();
    }

    public String getjPrenom() {
        return jPrenom.getText();
    }

    public String getjStatus() {
        return jStatus.getText();
    }

    private void subscription() {
        try {
            int abonneId = dao.createAbonne(getjNom(), getjPrenom(), getjNumero(), getjStatus());

            if (abonneId != -1) {

                Object selectedId = tableSubscription1.getSelectedId();

                if (selectedId == null) {
                    JOptionPane.showMessageDialog(this, "Veuillez sélectionner un abonnement !");
                    return;
                }

                int abonnementId;
                try {
                    abonnementId = (int) selectedId;
                } catch (ClassCastException e) {
                    JOptionPane.showMessageDialog(this, "ID de l'abonnement invalide !");
                    return;
                }

                soub.createSouscribtion(abonneId, abonnementId);
                JOptionPane.showMessageDialog(this, "Abonné ajouté avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'insertion de l'abonné.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbonneDataSee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update() {
        try {
            int status = "ACTIFS".equalsIgnoreCase(getjStatus()) ? 1 : 0;
            System.out.println(this.id);
            dao.updateAbonne(this.id, getjNom(), getjPrenom(), getjNumero(), status);
            JOptionPane.showMessageDialog(this, " abonne modifier avec succes !");
        } catch (SQLException ex) {
            Logger.getLogger(AbonneDataSee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTransparente1 = new LIB.JPanelTransparente();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jNom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPrenom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jStatus = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        tableSubscription1 = new view.TableAbonnement();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanelTransparente1.setBackground(new java.awt.Color(102, 0, 0));
        jPanelTransparente1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTransparente1.setColorPrimario(new java.awt.Color(204, 0, 0));
        jPanelTransparente1.setColorSecundario(new java.awt.Color(0, 0, 0));
        jPanelTransparente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Abonne");
        jPanelTransparente1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 196, 69));
        jPanelTransparente1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 1008, 9));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nom");
        jPanelTransparente1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 102, 77, 42));

        jNom.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jNom.setForeground(new java.awt.Color(255, 255, 255));
        jNom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNom.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanelTransparente1.add(jNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 102, 260, 42));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Prenom");
        jPanelTransparente1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 183, 59, 42));

        jPrenom.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jPrenom.setForeground(new java.awt.Color(255, 255, 255));
        jPrenom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPrenom.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanelTransparente1.add(jPrenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 184, 260, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Numero ");
        jPanelTransparente1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 281, 69, 37));

        jNumero.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jNumero.setForeground(new java.awt.Color(255, 255, 255));
        jNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNumero.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanelTransparente1.add(jNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 281, 260, 37));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status");
        jPanelTransparente1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 369, 50, 37));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 410, 50));

        jStatus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jStatus.setForeground(new java.awt.Color(255, 255, 255));
        jStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStatusActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(jStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 369, 260, 37));
        jPanelTransparente1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 430, 980, 17));

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("souscrire ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 480, 440, 50));

        tableSubscription1.setBackground(new java.awt.Color(0, 0, 0));
        tableSubscription1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTransparente1.add(tableSubscription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 580, 310));

        add(jPanelTransparente1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        subscription();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStatusActionPerformed

    }//GEN-LAST:event_jStatusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        update();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jNom;
    private javax.swing.JTextField jNumero;
    private LIB.JPanelTransparente jPanelTransparente1;
    private javax.swing.JTextField jPrenom;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jStatus;
    private view.TableAbonnement tableSubscription1;
    // End of variables declaration//GEN-END:variables
}
