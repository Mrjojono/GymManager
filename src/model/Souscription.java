
package model;


public class Souscription {
    private int id ;
    private int id_abonne;
    private int id_abonnement;
    private String date_debut;

    
    /**
     * 
     * @param id
     * @param id_abonne
     * @param id_abonnement 
     */
    public Souscription(int id,int id_abonne, int id_abonnement, String date) {
        this.id = id;
        this.id_abonne = id_abonne;
        this.id_abonnement = id_abonnement;
        this.date_debut = date;
    }

    public int getId() {
        return id;
    }

    public int getId_abonne() {
        return id_abonne;
    }

    public int getId_abonnement() {
        return id_abonnement;
    }
    public String getDateDebut(){
        return date_debut;
    }
    
    
    
    @Override
      public String toString() {
        return "Abonne{" +
                "id=" + id +
                "id_abonne'" +id_abonne+ '\'' +
                "id_abonnement" + id_abonnement +
                '}';
    }
      
      
      
}
