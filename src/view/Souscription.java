package view;

import DAO.SoubscriptionDao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author joan
 */
public class Souscription extends javax.swing.JPanel {

    SoubscriptionDao souscriptionDao = new SoubscriptionDao();

    public Souscription() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            abonneTable2 = new view.abonneTable();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tableSousciption1 = new view.TableSousciption();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(101, 18, 30));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton1.setText("Resilier");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 930, 50));

        jButton2.setBackground(new java.awt.Color(88, 149, 231));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Renouveler");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 930, 50));
        add(tableSousciption1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 960, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Object objIdAbonne = tableSousciption1.getSelectedId();
      
        try {
            int id = (int) objIdAbonne;
          

            boolean success = souscriptionDao.renouvelerAbonnement(id);

            if (success) {
                System.out.println("L'abonnement renouveler avec succès.");
                this.refreshTable();
            } else {
                System.out.println("Acucun abonnement trouvé pour résilier.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Erreur de conversion en entier : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur lors de la résiliation de l'abonnement : " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Object objIdAbonne = tableSousciption1.getSelectedId();
       

        try {
            int id = (int) objIdAbonne;
            

            boolean success = souscriptionDao.resilierSouscription(id);

            if (success) {
                 JOptionPane.showMessageDialog(this, "L'abonnement a été résilié avec succès.");
                this.refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Acucun abonnement trouvé pour résilier");
            }
        } catch (NumberFormatException e) {
            System.err.println("Erreur de conversion en entier : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur lors de la résiliation de l'abonnement : " + e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

     public void refreshTable() throws SQLException {
    tableSousciption1.updateUI(); 
    tableSousciption1.addData();
}
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.abonneTable abonneTable2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private view.TableSousciption tableSousciption1;
    // End of variables declaration//GEN-END:variables
}
