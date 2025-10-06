package com.prog2_ratrapage.POO;


import com.prog2_ratrapage.POO.message.Messge;
import com.prog2_ratrapage.POO.publication.Publication;
import com.prog2_ratrapage.POO.user.UtilisateurAnonyme;
import com.prog2_ratrapage.POO.user.UtilisateurInscrit;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PooApplication {

	public static void main(String[] args) {
		UtilisateurInscrit u1 = new UtilisateurInscrit("001", "Jean", "Rakoto", "jean@email.com");
		UtilisateurAnonyme anon = new UtilisateurAnonyme("X45");
		Publication pub = new Publication("PUB001", u1);

		pub.ajouterMessage(new Messge("salut",false,anon));
		pub.ajouterMessage(new Messge("Message privé",true,u1));
		pub.ajouterMessage(new Messge("Bon courage !", false, anon));

		pub.afficherPublication();
		System.out.println("list users send message in publication");
		pub.afficherUserSendMessagePublication();

	}

}
