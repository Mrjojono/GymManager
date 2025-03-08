package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author joan
 */
public class Database {

    // Informations de connexion à la base de données
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mybd";

    // Identifiants de connexion
    static final String USER = "root";
    static final String PASS = "";

    Connection conn = null;
    Statement stmt = null;

    public Database() {
        connect();
    }

    public void connect() {
        try {
            // Étape 1 : Charger le pilote JDBC
            Class.forName(JDBC_DRIVER);

            // Étape 2 : Établir la connexion
            System.out.println("Connexion à la base de données...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Vérifier si la connexion est réussie
            if (conn != null) {
                System.out.println("Connexion réussie !");
            } else {
                System.out.println("Échec de la connexion.");
            }

        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Method to query the databas  
}
