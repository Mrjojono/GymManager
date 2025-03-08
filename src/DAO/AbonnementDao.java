/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import model.Abonnement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joan
 */
public class AbonnementDao {

    private Database db;
    private Statement stmt;

    public AbonnementDao() {
        db = new Database();
    }

    /**
     *
     * @param libelle
     * @param duree
     * @param prix
     * @return
     * @throws SQLException
     */
    public boolean createAbonnement(String libelle, int duree, double prix) throws SQLException {
        String sql = "INSERT INTO abonnement(libelle, duree_mois, prix_mensuel) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setString(1, libelle);
            pstmt.setInt(2, duree);
            pstmt.setDouble(3, prix);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    /**
     *
     * @param id
     * @param libelle
     * @param duree
     * @param prix
     * @return
     * @throws SQLException
     */

    public boolean updateAbonnement(int id, String libelle, String duree, String prix) throws SQLException {
        String sql = "UPDATE abonnement SET libelle = ?, duree_mois = ?, prix_mensuel = ? WHERE id = ?";

        System.out.println("id a modifier" + id);
        System.out.println("nouveau libelle" + libelle);

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setString(1, libelle);
            pstmt.setString(2, duree);
            pstmt.setString(3, prix);
            pstmt.setInt(4, id);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean deleteAbonnement(int id) throws SQLException {
        String sql = "DELETE FROM abonnement WHERE id = ?";

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

    /**
     *
     * @return List
     * @throws SQLException
     */
    public List<Abonnement> getAllAbonnements() throws SQLException {
        List<Abonnement> abonnements = new ArrayList<>();
        String sql = "SELECT id, libelle, duree_mois, prix_mensuel FROM abonnement";

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Abonnement abonnement = new Abonnement(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getInt("duree_mois"),
                        rs.getDouble("prix_mensuel")
                );
                abonnements.add(abonnement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return abonnements;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Abonnement getAbonnementById(int id) throws SQLException {
        String sql = "SELECT * FROM abonnement WHERE id = ?";
        Abonnement abonnement = null;

        try (PreparedStatement pstmt = db.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    abonnement = new Abonnement(
                            rs.getInt("id"),
                            rs.getString("libelle"),
                            rs.getInt("duree_mois"),
                            rs.getDouble("prix_mensuel")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return abonnement;
    }

}
