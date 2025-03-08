/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import DAO.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class abonneTable extends javax.swing.JPanel {

    
   private Object selectedId = null;
   private Object selecteNom = null;
   private Object selectePrenom = null;
   private Object selectedStatut = null;
   private Object selectedNumero = null;
    
    
    
    AbonneDao dao =  new AbonneDao();
    private TableRowSorter<DefaultTableModel> sorter; 
    
    public abonneTable() throws SQLException {
        initComponents();
        addData();
        getSelected();
        
         tableAb.setDefaultRenderer(Object.class, (TableCellRenderer) new TableGradientCell());
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tableAb.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        jScrollPane1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        jScrollPane1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
                 //testData();
                 
        sorter = new TableRowSorter<>((DefaultTableModel) tableAb.getModel());
        tableAb.setRowSorter(sorter);
    }
    
    
     private void testData(){
        DefaultTableModel model=(DefaultTableModel)tableAb.getModel(); 
        model.addRow(new Object[]{ "John Smith", "john.smith@example.com", "123 Main St, City", "Manager"});
        model.addRow(new Object[]{ "Sarah Jones", "sarah.jones@example.com", "456 Elm St, Town", "Salesperson"});
        model.addRow(new Object[]{ "David Brown", "david.b@example.com", "789 Oak St, Village", "Technician"});
        model.addRow(new Object[]{ "Lisa Davis", "lisa.d@example.com", "101 Pine St, Town", "Receptionist"});
        model.addRow(new Object[]{ "Mark Wilson", "mark.w@example.com", "555 Cedar St, City", "Accountant"});
        model.addRow(new Object[]{"Alice Johnson", "alice.j@example.com", "222 Elm St, Village", "Marketing"});
    }
     
      public void getSelected(){
             //partie de recuperation des infos selectionner 
             
           tableAb.getSelectionModel().addListSelectionListener(event -> {
              if (!event.getValueIsAdjusting()) { 
                  int selectedRow = tableAb.getSelectedRow(); 
                  if (selectedRow != -1) { 
                      selectedId = tableAb.getValueAt(selectedRow, 0); 
                      selecteNom = tableAb.getValueAt(selectedRow, 1);
                      selectePrenom = tableAb.getValueAt(selectedRow, 2);
                      selectedStatut = tableAb.getValueAt(selectedRow, 3);
                      selectedNumero =  tableAb.getValueAt(selectedRow, 4);
                      
                      /*
                      cette partie est ecris juste pour deboguer
                      */
                        Object id = tableAb.getValueAt(selectedRow, 0); 
                        Object nomm = tableAb.getValueAt(selectedRow, 1); 
                        Object prenom = tableAb.getValueAt(selectedRow, 2); 
                        Object statut = tableAb.getValueAt(selectedRow, 3); 
            
                         // Affichage des données récupérées
                        System.out.println("id: " + id);
                        System.out.println("nom: " + nomm);
                        System.out.println("prenom: " + prenom);
                        System.out.println("statut: " + statut);
                     
                  }
              }
          });
       
        }
      
      
    /**
     * 
     * @param text 
     */
    public void search(String text) {
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null); 
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
    
    
    public void addData() throws SQLException {
    List<model.Abonne> abonnes = dao.getAllAbonnes();
    DefaultTableModel model = (DefaultTableModel) tableAb.getModel();
    model.setRowCount(0); 
    

    // Ajout des données dans le tableau
    for (model.Abonne ab : abonnes) {
        model.addRow(new Object[]{ ab.getId(), ab.getNom(), ab.getPrenom(), setStatus(ab.getStatus()) , ab.getNumero()});
        System.out.println(ab);
    }
}
    
    public String setStatus(String status){
        if("1".equals(status)){
            return "ACTIFS";
        }else{
            return "NOACTIFS";
        }
    }
    

    public Object getSelectedId() {
        return selectedId;
    }

    public Object getSelecteNom() {
        return selecteNom;
    }

    public Object getSelectePrenom() {
        return selectePrenom;
    }

    public Object getSelectedStatut() {
        return selectedStatut;
    }
    public Object getSelectedNumero() {
        return selectedNumero;
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAb = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.BorderLayout());

        tableAb.setBackground(new java.awt.Color(0, 0, 0));
        tableAb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        tableAb.setForeground(new java.awt.Color(255, 255, 255));
        tableAb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nom", "prenom ", "statut", "numero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAb);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAb;
    // End of variables declaration//GEN-END:variables
}
