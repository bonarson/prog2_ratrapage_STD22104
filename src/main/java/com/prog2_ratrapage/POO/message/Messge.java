package com.prog2_ratrapage.POO.message;


import com.prog2_ratrapage.POO.user.Utilisateur;

import java.util.Date;

public class Messge {
    private String texte;
    private Date dateHeure;
    private boolean confidentiel;
    private Utilisateur auteur;

    public Messge(String texte, boolean confidentiel, Utilisateur auteur) {
        this.texte = texte;
        this.confidentiel = confidentiel;
        this.auteur = auteur;
        this.dateHeure = new Date();
    }

    public String getDescription() {
        return "[" + dateHeure + "] " + (confidentiel ? "(Confidentiel) " : "") +
                auteur.getDescription() + " : " + texte;
    }

    public String getUserSendMessage() {
        return "[" + dateHeure + "] " + (confidentiel ? "(Confidentiel) " : "") +
                auteur.getDescription();
    }
}
