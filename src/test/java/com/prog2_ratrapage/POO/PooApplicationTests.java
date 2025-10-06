package com.prog2_ratrapage.POO;

import com.prog2_ratrapage.POO.message.Messge;
import com.prog2_ratrapage.POO.publication.Publication;
import com.prog2_ratrapage.POO.user.UtilisateurAnonyme;
import com.prog2_ratrapage.POO.user.UtilisateurInscrit;
import org.apache.logging.log4j.message.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PooApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testCreationPublicationUtilisateurInscrit() {

		UtilisateurInscrit user = new UtilisateurInscrit("002", "Marie", "Rasoanaivo", "marie@email.com");


		assertNotNull(user);
		assertEquals("002", user.getId());
		assertEquals("Marie Rasoanaivo (marie@email.com)", user.getDescription());


		Publication publication = new Publication("PUB002", user);


		assertNotNull(publication);


		Messge msg = new Messge("Hello from Marie!", false, user);
		publication.ajouterMessage(msg);


		assertNotNull(msg);
		assertTrue(msg.getDescription().contains("Hello from Marie!"));
		assertTrue(msg.getDescription().contains("Marie Rasoanaivo"));


		assertDoesNotThrow(() -> publication.afficherPublication());
	}

	@Test
	void testCreationUtilisateurAnonyme() {

		UtilisateurAnonyme anon = new UtilisateurAnonyme("X45");

		assertNotNull(anon);
		assertEquals("X45", anon.getId());
		assertEquals("Anonyme #X45", anon.getDescription());


		Messge msgAnonyme = new Messge("Message anonyme", true, anon);
		assertNotNull(msgAnonyme);
		assertTrue(msgAnonyme.getDescription().contains("Confidentiel"));
	}

	@Test
	void testAfficherPublicationEtUserSendMessagePublication() {
		// Préparation
		UtilisateurInscrit user = new UtilisateurInscrit("002", "Marie", "Rasoanaivo", "marie@email.com");
		Publication publication = new Publication("PUB002", user);

		Messge msg1 = new Messge("Hello!", false, user);
		Messge msg2 = new Messge("Bienvenue!", true, user);
		publication.ajouterMessage(msg1);
		publication.ajouterMessage(msg2);


		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));


		publication.afficherPublication();
		String affichagePublication = outContent.toString();

		outContent.reset();
		publication.afficherUserSendMessagePublication();
		String affichageUserSendMessage = outContent.toString();

		System.setOut(originalOut);


		assertTrue(affichagePublication.contains("Publication de Marie Rasoanaivo (marie@email.com)"));
		assertTrue(affichagePublication.contains("Hello!"));
		assertTrue(affichagePublication.contains("Bienvenue!"));

		assertTrue(affichageUserSendMessage.contains("Marie Rasoanaivo (marie@email.com)"));

		assertTrue(
				affichageUserSendMessage.chars()
						.mapToObj(c -> (char) c)
						.filter(c -> c.equals('M'))
						.count() >= 2
		);
	}
}
