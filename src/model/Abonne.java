/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joan
 */
public class Abonne {
    private int id;
    private String nom;
    private String prenom;
    private String numero;
    private String status;

    public Abonne(int id,String nom, String prenom, String numero, String status) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.status = status;
    }   
    
    public int getId() { return id; }
    public String getNom() {  return nom;}
    public String getPrenom() {  return prenom; }
    public String getNumero() { return numero;}
    public String getStatus() { return status;}

    
    @Override
    public String toString() {
        return "Abonne{" +
                "id=" + id +
                ", nom='" + nom+ '\'' +
                ", prenom=" + prenom +
                ", numero=" + numero +
                ",status="+ status +
                '}';
    }
}
