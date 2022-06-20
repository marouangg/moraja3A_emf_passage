package com.example.moraja3a_emf_passage;

public class Societe {

    int id ;
    String nom;
    String secteur_act;
    double nb_employe;

    public Societe(){}
    public Societe(int id, String nom, String secteur_act, double nb_employe) {
        this.id = id;
        this.nom = nom;
        this.secteur_act = secteur_act;
        this.nb_employe = nb_employe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNom(){
        return  nom;
    }
    public  void setNom(String nom){
        this.nom=nom;
    }

    public String getSecteur_act(){return secteur_act;}
    public void setSecteur_act(String secteur_act){this.secteur_act=secteur_act;}

    public double getNb_employe(){return nb_employe;}
    public void setNb_employe(double nb_employe){this.nb_employe=nb_employe;}
}
