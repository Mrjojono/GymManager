/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author joan
 */
public class Table extends javax.swing.JPanel {

   
    public Table() {
        initComponents();
        
        
     
table.getSelectionModel().addListSelectionListener(event -> {
    if (!event.getValueIsAdjusting()) { 
        int selectedRow = table.getSelectedRow(); 
        if (selectedRow != -1) { 
            Object nom = table.getValueAt(selectedRow, 0); 
            Object email = table.getValueAt(selectedRow, 1); 
            Object adresse = table.getValueAt(selectedRow, 2); 
            Object poste = table.getValueAt(selectedRow, 3); 
            
            // Affichage des données récupérées
            System.out.println("Nom: " + nom);
            System.out.println("Email: " + email);
            System.out.println("Adresse: " + adresse);
            System.out.println("Poste: " + poste);
        }
    }
});
        
         table.setDefaultRenderer(Object.class, (TableCellRenderer) new TableGradientCell());
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        scroll.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
        testData();
    }
        private void testData(){
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        
        model.addRow(new Object[]{ "John Smith", "john.smith@example.com", "123 Main St, City", "Manager"});
        model.addRow(new Object[]{ "Sarah Jones", "sarah.jones@example.com", "456 Elm St, Town", "Salesperson"});
        model.addRow(new Object[]{ "David Brown", "david.b@example.com", "789 Oak St, Village", "Technician"});
        model.addRow(new Object[]{ "Lisa Davis", "lisa.d@example.com", "101 Pine St, Town", "Receptionist"});
        model.addRow(new Object[]{ "Mark Wilson", "mark.w@example.com", "555 Cedar St, City", "Accountant"});
        model.addRow(new Object[]{"Alice Johnson", "alice.j@example.com", "222 Elm St, Village", "Marketing"});
    }

    
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nom", "prenom", "Date insctiption", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(table);

        add(scroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
