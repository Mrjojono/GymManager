package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Abonne;

/**
 *
 * @author joan
 */
public class AbonneDao {

    private Database db;

    public AbonneDao() {
        db = new Database();
    }

    public int createAbonne(String nom, String prenom, String numero, String status) throws SQLException {
        String sql = "INSERT INTO abonne(nom, prenom, numero_telephone, statut_souscription) VALUES (?, ?, ?, ?)";
        int generatedId = -1;

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, numero);
            pstmt.setString(4, status);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);

            if (rowsAffected > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                        System.out.println("Generated ID: " + generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return generatedId;
    }

    public boolean updateAbonne(int id, String nom, String prenom, String numero, int status) throws SQLException {
        String sql = "UPDATE abonne SET nom = ?, prenom = ?, numero_telephone = ?, statut_souscription = ? WHERE id = ?";

        System.out.println("id à modifier: " + id);
        System.out.println("Nouveau prénom: " + prenom);
        System.out.println("Nouveau numéro: " + numero);

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, numero);
            pstmt.setInt(4, status);
            pstmt.setInt(5, id);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Abonne> getAllAbonnes() throws SQLException {
        List<Abonne> abonnes = new ArrayList<>();
        String sql = "SELECT id, nom, prenom, numero_telephone, statut_souscription FROM abonne";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Abonne abonne = new Abonne(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("numero_telephone"),
                        rs.getString("statut_souscription")
                );

                abonnes.add(abonne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return abonnes;
    }

    public Abonne getAbonneById(int id) throws SQLException {
        String sql = "SELECT * FROM Abonne WHERE id = ?";
        Abonne abonne = null;

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    abonne = new Abonne(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("numero_telephone"),
                            rs.getString("statut_souscription")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return abonne;
    }

    public boolean deleteAbonne(int id) throws SQLException {
        String sql = "DELETE FROM abonne WHERE id = ?";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("row delete succefully");

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

   public int getNumberActifs() {
    String sql = "SELECT COUNT(*) FROM abonne WHERE statut_souscription = 1";
    
    try (PreparedStatement pstmt = db.conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        System.err.println("Erreur SQL : " + e.getMessage());
    }
    
    return 0; 
}

}
