/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import model.Abonne;
/**
 *
 * @author joan
 */
public class UserDao {
    
    private Database db;
    private Statement stmt;
   
    public UserDao(){
         db = new  Database();
    }
    
    /**
     * @param String login , String password, String nom , String email
     * function d'insertion d'un utilisateur
    */
    public boolean createUser(String login, String password, String nom, String email) throws SQLException {
        
        String sql = "INSERT INTO administrateur(login,password,nom,email) VALUES ( ?, ?, ?, ?)";
        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
         
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, nom);
            pstmt.setString(4, email);
            
            System.out.println(nom);
            System.out.println(password);

          
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("Rows inserted: " + rowsAffected);
            
            return true;
        } catch (SQLException e) {
            
            e.printStackTrace();
            return false;
        }
}
    /**
     * @param  function qui prend en parametre le nom et le password pour v authentification
     * cette function est une function booleene 
    */
    
    public boolean authenticateUser(String login, String password) {
    String sql = "SELECT * FROM administrateur WHERE login = ? AND password = ?";
    
    try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
       
        pstmt.setString(1, login);
        pstmt.setString(2, password);
        
        ResultSet rs = pstmt.executeQuery();
        
      
        if (rs.next()) {
            System.out.println("Authentication successful for user: " + login);
            return true;
        } else {
            System.out.println("Authentication failed for user: " + login);
            return false;
        }
    } catch (SQLException e) {
    
        e.printStackTrace();
        return false;
    }
}
    
    
    public void souscrireAbonnement(int abonneId, int abonnementId) throws Exception{
        
        try {
            Abonne abonne ;
            AbonneDao abd = new AbonneDao();
            abonne  = abd.getAbonneById(abonneId);
            if(abonne == null){
                 System.out.println("Abonne avec " + abonneId+"nom trouver");
            }
            
            
            
        }catch(Exception e){
            
        }
    }

   

}
