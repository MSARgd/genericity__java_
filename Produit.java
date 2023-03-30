package Code.Genericite;

import java.io.Serializable;

public class Produit implements Serializable {
    private int id;
    private String nom;
    private String marque;
    private float prix;
    private String description;
    private int nbStocke;

    public Produit() {
    }

    public Produit(int id, String nom, String marque, float prix, String description, int nbStocke) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbStocke = nbStocke;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbStocke() {
        return nbStocke;
    }

    public void setNbStocke(int nbStocke) {
        this.nbStocke = nbStocke;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + this.id +
                ", nom='" + this.nom + '\'' +
                ", marque='" + this.marque + '\'' +
                ", prix=" + this.prix +
                ", description='" + this.description + '\'' +
                ", nbStocke=" + this.nbStocke +
                '}';
    }
}
