package com.nicolas.mastermind;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PlusOuMoins extends MenuMode {

    private static Logger log = LogManager.getLogger(Main.class.getName());

    public PlusOuMoins() {

        super("\n*****PLUS OU MOINS*****");
        log.info("Mastermind lancé");
        longueurNombreMystere = Integer.valueOf(prop.getProperty("longueurPlusOuMoins"));
        coupsMax = Integer.valueOf(prop.getProperty("coupsMax"));

        log.info("Longueur du nombre mystère et nombre de coups max autorisés chargés depuis config.properties");
    }

    public void challenger() {
        log.info("Mode challenger lancé");
        System.out.println("********MODE CHALLENGER********");
        initCompteur();
        genererNombreMystere();
        humain = new Humain();
        log.info("Joueur 1 défini comme humain");
        // On boucle tant que le nombre mystère n'est pas trouvé
        do {
            devMode();
            afficherCompteur();
            humain.proposerNombre();
            comparerNombres(humain);
            compteur++;
        } while (!String.valueOf(Joueur.proposition).equals(nombreMystere) && compteur < coupsMax + 1);
        finPartie("Vous avez");
    }

    public void defenseur() {
        log.info("Mode défenseur lancé");
        System.out.println("********MODE DEFENSEUR********");
        initCompteur();
        humain = new Humain();
        log.info("Joueur 1 défini comme humain");
        machine = new Machine();
        log.info("Joueur 2 défini comme machine");

        humain.proposerNombre();// L'utilisateur entre la combinaison à deviner
        nombreMystere = Joueur.proposition;
        System.out.println("Le nombre mystère est " + nombreMystere + ".\n");
        do {
            devMode();
            afficherCompteur();
            machine.proposerNombre();
            comparerNombres(machine);
            machine.resultatPrecedent = resultat;
            compteur++;
        } while (!String.valueOf(Joueur.proposition).equals(nombreMystere) && compteur < coupsMax + 1);
        finPartie("L'ordinateur a");
    }

    public void duel() {
        log.info("Mode duel lancé");
        System.out.println("********MODE DUEL********");
        String combinaisonhumain, combinaisonmachine;
        initCompteur();
        genererNombreMystere();
        combinaisonhumain = nombreMystere;// On stocke le nombre à deviner par le joueur dans une variable
        humain = new Humain();
        log.info("Joueur 1 défini comme humain");
        humain.proposerNombre();// L'utilisateur entre la combinaison à deviner pour l'ordinateur
        combinaisonmachine = Joueur.proposition;// Cette combinaison est stockée ici
        machine = new Machine();
        log.info("Joueur 2 défini comme machine");

        do {
            nombreMystere = combinaisonhumain;
            devMode();
            afficherCompteur();
            System.out.println("À vous : ");
            humain.proposerNombre();
            comparerNombres(humain);
            if (String.valueOf(Joueur.proposition).equals(nombreMystere)) {
                compteur++;
                break;
            }

            nombreMystere = combinaisonmachine;
            devMode();
            System.out.println("À l'ordinateur :");
            machine.proposerNombre();
            comparerNombres(machine);
            machine.resultatPrecedent = resultat;
            compteur++;
        } while (!String.valueOf(Joueur.proposition).equals(nombreMystere));
        if (nombreMystere == combinaisonhumain)
            finPartie("Vous avez");
        else if (nombreMystere == combinaisonmachine)
            finPartie("L'ordinateur a");
    }
}

