package com.nicolas.mastermind;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Humain extends Joueur {

    private static Logger log = LogManager.getLogger(Main.class.getName());

    public void proposerNombre() {
        System.out.print("Proposition : ");
        do {
            Scanner sc = new Scanner(System.in);

            proposition = sc.nextLine();

            longueurProposition = String.valueOf(proposition).length();// longueurProposition est égal à la longueur (nombre
            // de chiffres) dans proposition

            if (!proposition.matches("[0-9]+") || longueurProposition != MenuMode.longueurNombreMystere)
                Error.errorNombre();

        } while (longueurProposition != MenuMode.longueurNombreMystere || !proposition.matches("[0-9]+"));// Boucle tant que la
        // proposition n'a pas le même nombre de chiffres que le paramètre longueurNombreMystere
        log.info("Nombre proposé : "+proposition);
    }
}