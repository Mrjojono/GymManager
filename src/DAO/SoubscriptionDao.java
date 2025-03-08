/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Souscription;

/**
 *
 * @author joan
 */
public class SoubscriptionDao {

    private Database db;

    public SoubscriptionDao() {
        db = new Database();
    }

    public boolean createSouscribtion(int id_abonne, int id_abonnement) throws SQLException {
        String sql = "INSERT INTO souscription(id_abonne, id_abonnement) VALUES (?, ?)";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_abonne);
            pstmt.setInt(2, id_abonnement);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Souscription> getAllSouscriptions() throws SQLException {
        List<Souscription> souscriptions = new ArrayList<>();
        String sql = "SELECT * FROM souscription";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int id_abonne = rs.getInt("id_abonne");
                int id_abonnement = rs.getInt("id_abonnement");
                String date = rs.getString("date_debut");
                souscriptions.add(new Souscription(id, id_abonne, id_abonnement, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return souscriptions;
    }

    public boolean resilierSouscription(int id) throws SQLException {
        String sql = "DELETE FROM souscription WHERE id =?";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean renouvelerSouscription(int id_abonne, int id_abonnement, Date nouvelleDateFin) throws SQLException {
        String sql = "UPDATE souscription SET date_fin = ? WHERE id_abonne = ? AND id_abonnement = ?";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setDate(1, nouvelleDateFin);
            pstmt.setInt(2, id_abonne);
            pstmt.setInt(3, id_abonnement);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public double getChiffreAffaire() throws SQLException {
        String sql = "SELECT SUM(a.prix_mensuel) AS chiffre_affaire "
                + "FROM souscription s "
                + "JOIN abonnement a ON s.id_abonnement = a.id";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("chiffre_affaire");
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            throw e;
        }

        return 0;
    }

    public boolean renouvelerAbonnement(int id) throws SQLException {
        String sql = "UPDATE souscription SET date_debut = CURRENT_TIMESTAMP WHERE id = ?";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
        

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Abonnement renouvelé : " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors du renouvellement : " + e.getMessage());
            throw e;
        }
    }

}
