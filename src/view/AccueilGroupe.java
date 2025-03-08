/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import DAO.AbonneDao;
import DAO.CardModel;
import DAO.SoubscriptionDao;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AccueilGroupe extends javax.swing.JPanel {

    AbonneDao ab = new AbonneDao();
    SoubscriptionDao sb = new SoubscriptionDao();

    public AccueilGroupe() {
        try {
            initComponents();

            Icon total = new ImageIcon(getClass().getResource("/image/status-update.png"));
            Icon statistique = new ImageIcon(getClass().getResource("/image/money-bag.png"));

            int actifs = ab.getNumberActifs();
            int chiffre = (int) sb.getChiffreAffaire();

            CardModel card11 = new CardModel(total, "Total Abonné Actifs", actifs, "");
            CardModel stat = new CardModel(statistique, "Chiffre d'affaire mensuel", chiffre, "");

            card2.setData(card11);
            card3.setData(stat);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur SQL lors du chargement des données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void viewModify(model.Abonne aThis) {
        java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);

        AbonneDataSee view = new AbonneDataSee();
        System.out.println(abonneTable1.getSelectedId());

        Object nom = abonneTable1.getSelecteNom();
        Object prenom = abonneTable1.getSelectePrenom();
        Object status = abonneTable1.getSelectedStatut();
        Object numero = abonneTable1.getSelectedNumero();
        Object id = abonneTable1.getSelectedId();
        System.out.println("debog nom" + nom);

        view.setjNom((String) nom);
        view.setjPrenom((String) prenom);
        view.setjStatus((String) status);
        view.setjNumero((String) numero);
        view.setId((int) id);

        this.setLayout(new BorderLayout());

        this.removeAll();
        this.add(view, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            abonneTable2 = new view.abonneTable();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        jLayeredPane1 = new javax.swing.JLayeredPane();
        card2 = new view.Card();
        card3 = new view.Card();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        try {
            abonneTable1 = new view.abonneTable();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }

        setBackground(new java.awt.Color(0, 0, 0));
        setOpaque(false);

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));

        card3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton1.setText("View");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        abonneTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        abonneTable1.setForeground(new java.awt.Color(255, 255, 255));
        abonneTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(abonneTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(abonneTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(card2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(card3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       
        
        if(abonneTable1.getSelectedId() == null){
            JOptionPane.showMessageDialog(this, "Please select a subscriber.");
        } else{
             int selectedId = (int) abonneTable1.getSelectedId();
             if (selectedId != -1) {

            new SwingWorker<model.Abonne, Void>() {
                @Override
                protected model.Abonne doInBackground() throws SQLException {
                    return ab.getAbonneById(selectedId);
                }

                @Override
                protected void done() {
                    try {
                        model.Abonne selectedAbonne = get();
                        if (selectedAbonne != null) {
                            viewModify(selectedAbonne);
                        } else {
                            JOptionPane.showMessageDialog(AccueilGroupe.this, "No subscribers found with this ID.");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(AccueilGroupe.this, "Error retrieving information.");
                        Logger.getLogger(AccueilGroupe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.execute();
        }
        }
        
        


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        if(abonneTable1.getSelectedId() == null){
              JOptionPane.showMessageDialog(this, "Please select a subscriber.");
        }
        else{
              int confirmation = JOptionPane.showConfirmDialog(
                this, 
                "Do you really want to delete this subscriber?", 
                "Confirmation of deletion", 
                JOptionPane.YES_NO_OPTION 
        );

        if (confirmation == JOptionPane.YES_OPTION) {
            try {

                int selectedId = (int) abonneTable1.getSelectedId();
                ab.deleteAbonne(selectedId);
                refreshTable();

                JOptionPane.showMessageDialog(
                        this,
                        "  subscriber delete.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error deleting subscriber: " + ex.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
                Logger.getLogger(AccueilGroupe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
      

    }//GEN-LAST:event_jButton2ActionPerformed

    public void refreshTable() throws SQLException {
        abonneTable1.updateUI();
        abonneTable1.addData();
    }

    public void search(String text) {
        abonneTable1.search(text);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.abonneTable abonneTable1;
    private view.abonneTable abonneTable2;
    private view.Card card2;
    private view.Card card3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
