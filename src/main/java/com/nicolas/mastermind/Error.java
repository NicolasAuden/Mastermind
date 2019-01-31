package com.nicolas.mastermind;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public abstract class Error {

    private static Logger log = LogManager.getLogger(Main.class.getName());

    // Message affiché si une entrée clavier ne correspond à aucun choix proposé
    public static void errorChoix() {
        System.out.println("\nVeuillez choisir parmi les propositions.");
        log.error("Le choix entré n'existe pas parmi les propositions");
    }

    public static void errorNombre() {
        System.out.println("\nVeuillez entrer un nombre à " + MenuMode.longueurNombreMystere + " chiffres.");
        log.error("La longueur du nombre proposé ne correspond pas au paramètre défini dans config.properties");
    }
}

