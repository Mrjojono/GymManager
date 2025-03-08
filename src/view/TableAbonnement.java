package view;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.Abonnement;
import DAO.AbonnementDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableAbonnement extends javax.swing.JPanel {

   private Object selectedId = null;
   private Object selectedDuree = null;
   private Object selectelibelle = null;
   private Object selectedprix = null;
   
    AbonnementDao dao = new AbonnementDao();
    private int id;
    public TableAbonnement(){ 
        
        initComponents();
        getSelected();
        
        try {
            addData();
        } catch (SQLException ex) {
            Logger.getLogger(TableAbonnement.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         tablesub.setDefaultRenderer(Object.class, (TableCellRenderer) new TableGradientCell());
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tablesub.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        jScrollPane1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        jScrollPane1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
        //testData();
    }
        private void testData(){
        DefaultTableModel model=(DefaultTableModel)tablesub.getModel();
        
        model.addRow(new Object[]{ "John Smith", "john.smith@example.com", "123 Main St, City", "Manager"});
        model.addRow(new Object[]{ "Sarah Jones", "sarah.jones@example.com", "456 Elm St, Town", "Salesperson"});
       
        }
        
        public void addData() throws SQLException{
            List<Abonnement> abonnements = dao.getAllAbonnements();
              DefaultTableModel model =(DefaultTableModel)tablesub.getModel();
            model.setRowCount(0);

       // Ajout des données dans le tableau
            for (Abonnement ab : abonnements) {
                model.addRow(new Object[]{ ab.getId(), ab.getLibelle(), ab.getDureeMois(), ab.getPrixMensuel() });
                System.out.println(ab);
            }
        }

        public void getSelected(){
             //partie de recuperation des infos selectionner 
             
            tablesub.getSelectionModel().addListSelectionListener(event -> {
              if (!event.getValueIsAdjusting()) { 
                  int selectedRow = tablesub.getSelectedRow(); 
                  if (selectedRow != -1) { 
                      selectedId = tablesub.getValueAt(selectedRow, 0); 
                      selectelibelle = tablesub.getValueAt(selectedRow, 1);
                      selectedDuree =  tablesub.getValueAt(selectedRow, 2);
                      selectedprix = tablesub.getValueAt(selectedRow, 3);
                      
                      this.setId((int) selectedId);
                      /*
                      cette partie est ecris juste pour deboguer
                      */
                      Object id = tablesub.getValueAt(selectedRow, 0); 
                      Object libelle = tablesub.getValueAt(selectedRow, 1); 
                      Object duree = tablesub.getValueAt(selectedRow, 2); 
                      Object  prix = tablesub.getValueAt(selectedRow, 3); 
                      
                        
                      // Affichage des données récupérées pour test 
                      System.out.println("id " + id);
                      System.out.println("libelle " + libelle);
                      System.out.println("duree " + duree);
                      System.out.println("Prix " + prix);
                  }
              }
          });
       
        }
        
    public Object getSelectedId() {
      return selectedId;
    }

    public Object getSelectedDuree() {
        return selectedDuree;
    }

    public Object getSelectelibelle() {
        return selectelibelle;
    }

    public Object getSelectedprix() {
        return selectedprix;
    }
 
   public void setId(int id) {
    this.id = id;
    System.out.println("ID défini: " + this.id);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablesub = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        tablesub.setBackground(new java.awt.Color(0, 0, 0));
        tablesub.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        tablesub.setForeground(new java.awt.Color(255, 255, 255));
        tablesub.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "libelle", "duree(mois)", "prix(dollars)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablesub);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablesub;
    // End of variables declaration//GEN-END:variables
}
