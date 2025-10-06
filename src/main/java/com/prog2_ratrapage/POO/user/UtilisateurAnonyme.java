package com.prog2_ratrapage.POO.user;


public class UtilisateurAnonyme extends Utilisateur {
    public UtilisateurAnonyme(String id) {
        super(id);
    }

    @Override
    public String getDescription() {
        return "Anonyme #" + id;
    }
}
