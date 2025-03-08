/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joan
 */
public class Abonnement {
    private int id;
    private String libelle;
    private int dureeMois;
    private double prixMensuel;

    public Abonnement(int id, String libelle, int dureeMois, double prixMensuel) {
        this.id = id;
        this.libelle = libelle;
        this.dureeMois = dureeMois;
        this.prixMensuel = prixMensuel;
    }

    // Getters et Setters
    public int getId() { return id; }
    public String getLibelle() { return libelle; }
    public int getDureeMois() { return dureeMois; }
    public double getPrixMensuel() { return prixMensuel; }

    @Override
    public String toString() {
        return "Abonnement{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", dureeMois=" + dureeMois +
                ", prixMensuel=" + prixMensuel +
                '}';
    }
    


}
