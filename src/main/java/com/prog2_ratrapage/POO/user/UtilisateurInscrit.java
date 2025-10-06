package com.prog2_ratrapage.POO.user;


public class UtilisateurInscrit extends Utilisateur {
    private String prenom;
    private String nom;
    private String email;

    public UtilisateurInscrit(String id, String prenom, String nom, String email) {
        super(id);
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    @Override
    public String getDescription() {
        return prenom + " " + nom + " (" + email + ")";
    }
}
