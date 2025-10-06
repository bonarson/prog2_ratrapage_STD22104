package com.prog2_ratrapage.POO.publication;


import com.prog2_ratrapage.POO.message.Messge;
import com.prog2_ratrapage.POO.user.Utilisateur;


import java.util.ArrayList;
import java.util.List;

public class Publication {
    private String idPub;
    private Utilisateur utilisateur;
    private List<Messge> messages;

    public Publication(String idPub, Utilisateur utilisateur) {
        this.idPub = idPub;
        this.utilisateur = utilisateur;
        this.messages = new ArrayList<>();
    }

    public void ajouterMessage(Messge m) {
        messages.add(m);
    }

    //ajouter aussi dans le teste le teste pour ce deux methode dans la classe publication
    public void afficherPublication() {
        System.out.println("Publication de " + utilisateur.getDescription());
        for (Messge m : messages) {
            System.out.println("  - " + m.getDescription());
        }
    }

    public void afficherUserSendMessagePublication() {
        System.out.println("Publication de " + utilisateur.getDescription());
        for (Messge m : messages) {
            System.out.println("  - " + m.getUserSendMessage());
        }
    }

    public String getIdPub() {
        return idPub;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public List<Messge> getMessages() {
        return messages;
    }

}
