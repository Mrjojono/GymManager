/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import DAO.AbonneDao;
import DAO.AbonnementDao;
import DAO.SoubscriptionDao;
import model.Souscription;
import com.formdev.flatlaf.FlatClientProperties;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author joan
 */
public class TableSousciption extends javax.swing.JPanel {

   private Object selectedId = null;
   private Object  selecteAbonne = null;
   private Object selecteAbonnement = null;
   private Object selectedprix = null;
   
    SoubscriptionDao dao = new SoubscriptionDao();
    AbonneDao ab = new AbonneDao();
    AbonnementDao abn = new AbonnementDao();
    private int id;
    public TableSousciption() {
        initComponents();
        
        
         getSelected();
        
        try {
            addData();
        } catch (SQLException ex) {
            Logger.getLogger(TableAbonnement.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        jTable1.setDefaultRenderer(Object.class, (TableCellRenderer) new TableGradientCell());
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        jTable1.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        jScrollPane1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        jScrollPane1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
        //testData();
    }
     
        
      

        public void getSelected(){
             //partie de recuperation des infos selectionner 
             
            jTable1.getSelectionModel().addListSelectionListener(event -> {
              if (!event.getValueIsAdjusting()) { 
                  int selectedRow = jTable1.getSelectedRow(); 
                  if (selectedRow != -1) { 
                      selectedId = jTable1.getValueAt(selectedRow, 0); 
                      selecteAbonne = jTable1.getValueAt(selectedRow, 1);
                      selecteAbonnement =  jTable1.getValueAt(selectedRow, 2);
                  
                     
                      /*
                      cette partie est ecris juste pour deboguer
                      */
                      Object id = jTable1.getValueAt(selectedRow, 0); 
                      Object abonne = jTable1.getValueAt(selectedRow, 1); 
                      Object abonnement = jTable1.getValueAt(selectedRow, 2); 
                     
                        
                      // Affichage des données récupérées pour test 
                      System.out.println("id:" + id);
                      System.out.println("abonne:" + abonne);
                      System.out.println("abonnement: " +abonnement );
                     
                  }
              }
          });        
    }
        
          public void addData() throws SQLException{
            List<model.Souscription> souscriptions = dao.getAllSouscriptions();
              DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            for (model.Souscription sb : souscriptions) {
                model.addRow(new Object[]{ sb.getId(),ab.getAbonneById(sb.getId_abonne()).getNom(),abn.getAbonnementById(sb.getId_abonnement()).getLibelle(),
                    abn.getAbonnementById(sb.getId_abonnement()).getDureeMois(),sb.getDateDebut() 
                });
                System.out.println(sb);
            }
        }

    public Object getSelectedId() {
        return selectedId;
    }

    public Object getSelecteAbonne() {
        return selecteAbonne;
    }

    public Object getSelecteAbonnement() {
        return selecteAbonnement;
    }

    public Object getSelectedprix() {
        return selectedprix;
    }

    public int getId() {
        return id;
    }
          
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "abonne", "abonnement", "Durée(mois)", "DateDebut"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
