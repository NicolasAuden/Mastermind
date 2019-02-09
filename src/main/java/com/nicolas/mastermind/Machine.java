package com.nicolas.mastermind;

import java.util.ArrayList;
import java.util.Random;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Machine extends Joueur {

    private static Logger log = LogManager.getLogger(Main.class.getName());
    String tourPrecedent = "";

    public void proposerNombre() { // Méthode
        System.out.print("Proposition : ");

        if (MenuMode.compteur == 1) {
            proposition = "";
            Random random = new Random();

            int chiffreNombreMystere[] = new int[MenuMode.longueurNombreMystere];

            for (int i = 0; i < MenuMode.longueurNombreMystere; i++) {// On génère un chiffre aléatoire jusqu'à atteindre la
                // longueur définie dans longueurNombreMystere
                chiffreNombreMystere[i] = random.nextInt(9 + 1);

                proposition += chiffreNombreMystere[i];
            }
            tourPrecedent = proposition;
            System.out.println(proposition);
        } else {
            int chiffreNombreMystere[] = new int[MenuMode.longueurNombreMystere];

            for (int i = 0; i < MenuMode.longueurNombreMystere; i++) {
                if (resultatPrecedent.charAt(i) == '+') {
                    chiffreNombreMystere[i] = Character.getNumericValue(tourPrecedent.charAt(i));
                    chiffreNombreMystere[i]++;
                } else if (resultatPrecedent.charAt(i) == '-') {
                    chiffreNombreMystere[i] = Character.getNumericValue(tourPrecedent.charAt(i));
                    chiffreNombreMystere[i]--;
                } else if (resultatPrecedent.charAt(i) == '=')
                    chiffreNombreMystere[i] = Character.getNumericValue(MenuMode.nombreMystere.charAt(i));

                proposition += chiffreNombreMystere[i];
            }
            proposition = proposition.substring(MenuMode.longueurNombreMystere, proposition.length());
            tourPrecedent = proposition;
            System.out.println(proposition);
        }
        log.info("Nombre proposé : "+proposition);
    }

    public void piocherDansListe(ArrayList liste) { // Méthode utilisée dans Mastermind
        Random random = new Random();
        int index = random.nextInt(liste.size());
        proposition = (String) liste.get(index);
        log.info("Nombre proposé parmi la liste de solutions : "+proposition);
    }
}
