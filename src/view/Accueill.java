package view;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.SwingUtilities;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Accueill extends javax.swing.JFrame {

    private Login login;
    private Abonnement subscription;
    private Accueill accueil;
    private Souscription abonne;
    private AbonneDataSee absee;

    public void setLogin() {
        this.dispose();

        Main main = new Main();
        main.setVisible(true);
        if (login == null) {
            login = new Login(this);
        }
        jPanel2.removeAll();
        jPanel2.add(login);
        SwingUtilities.updateComponentTreeUI(jPanel2);
    }

    public void setSubscription() {
        if (subscription == null) {
            subscription = new Abonnement();
        }

        jPanel2.removeAll();
        jPanel2.add(subscription);
        jPanel2.revalidate();
        jPanel2.repaint();
        SwingUtilities.updateComponentTreeUI(jPanel2);
    }

    public void setMemeber() throws SQLException {
        if (abonne == null) {
            abonne = new Souscription();
        }

        jPanel2.removeAll();
        jPanel2.add(abonne);
        SwingUtilities.updateComponentTreeUI(jPanel2);
    }

    public void setAccueill() throws SQLException {
        if (accueil == null) {
            accueil = new Accueill();
        }
        this.dispose();
        accueil.setVisible(true);
    }

  public Accueill() throws SQLException {
    initComponents();
    setLocationRelativeTo(null);

    header2.setOnSearchListener(new Header.OnSearchListener() {
        @Override
        public void onSearch(String text) {
            accueilGroupe2.search(text);
        }
    });
}


    public void setModify() {
        if (absee == null) {
            absee = new AbonneDataSee();
        }
        jPanel2.removeAll();
        jPanel2.add(absee);
        SwingUtilities.updateComponentTreeUI(jPanel2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSubscription = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sb = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        header2 = new view.Header();
        accueilGroupe2 = new view.AccueilGroupe();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1363, 750));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(86, 28, 28));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/group-chat.png"))); // NOI18N
        jButton2.setText("Subscription");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jButton4.setBackground(new java.awt.Color(86, 28, 28));
        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add (1).png"))); // NOI18N
        jButton4.setText("     Add");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 340, 70));

        jSubscription.setBackground(new java.awt.Color(86, 28, 28));
        jSubscription.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jSubscription.setForeground(new java.awt.Color(255, 255, 255));
        jSubscription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/subscription.png"))); // NOI18N
        jSubscription.setText("Abonnement");
        jSubscription.setBorderPainted(false);
        jSubscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubscriptionActionPerformed(evt);
            }
        });
        jPanel1.add(jSubscription, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 340, 80));

        jButton6.setBackground(new java.awt.Color(86, 28, 28));
        jButton6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings.png"))); // NOI18N
        jButton6.setText("Settings");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 340, 50));

        logOut.setBackground(new java.awt.Color(54, 44, 44));
        logOut.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        logOut.setForeground(new java.awt.Color(255, 255, 255));
        logOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        logOut.setText("Log out");
        logOut.setBorderPainted(false);
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        jPanel1.add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 340, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gym dumbbells.jpeg"))); // NOI18N
        jLabel3.setText("jLabel2");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 680));

        sb.setBackground(new java.awt.Color(0, 0, 0));
        sb.setOpaque(false);
        jPanel1.add(sb, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jButton1.setBackground(new java.awt.Color(86, 28, 28));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboard (1).png"))); // NOI18N
        jButton1.setText("  Dashbord ");
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 60));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jScrollPane1, java.awt.BorderLayout.PAGE_END);

        header2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                header2KeyTyped(evt);
            }
        });
        jPanel2.add(header2, java.awt.BorderLayout.PAGE_START);
        jPanel2.add(accueilGroupe2, java.awt.BorderLayout.CENTER);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
        setLogin();
    }//GEN-LAST:event_logOutActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jSubscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubscriptionActionPerformed
        // TODO add your handling code here:
        setSubscription();
    }//GEN-LAST:event_jSubscriptionActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setModify();
    }//GEN-LAST:event_jButton4ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            setMemeber();
        } catch (SQLException ex) {
            Logger.getLogger(Accueill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            setAccueill();
        } catch (SQLException ex) {
            Logger.getLogger(Accueill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered

    }//GEN-LAST:event_jButton1MouseEntered

    private void header2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_header2KeyTyped

    }//GEN-LAST:event_header2KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Accueill().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Accueill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.AccueilGroupe accueilGroupe2;
    private view.Header header2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSubscription;
    private javax.swing.JButton logOut;
    private javax.swing.JScrollPane sb;
    // End of variables declaration//GEN-END:variables
}
