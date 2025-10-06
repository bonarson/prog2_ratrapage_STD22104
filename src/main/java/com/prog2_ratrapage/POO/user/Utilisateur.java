package com.prog2_ratrapage.POO.user;


public abstract class Utilisateur {
    protected String id;

    public Utilisateur(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract String getDescription();
}
