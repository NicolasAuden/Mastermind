package main.java;

import java.util.Random;


public class Machine extends Joueur {

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
    }
}
