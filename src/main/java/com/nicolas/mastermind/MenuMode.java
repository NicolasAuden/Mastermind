package com.nicolas.mastermind;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public abstract class MenuMode {

    Joueur joueur1;
    Joueur joueur2;
    String nomDuJeu;
    static String resultat;
    static int longueurNombreMystere;
    static int nombreUtilises[];
    static int compteur;
    static int coupsMax;
    static String nombreMystere = "";
    Properties prop = new Properties();
    InputStream input = null;

    public MenuMode(String nomDuJeu) {

        try {

            input = new FileInputStream("config.properties");

            // Chargement du fichier config
            prop.load(input);

            longueurNombreMystere = Integer.valueOf(prop.getProperty("longueurPlusOuMoins"));
            coupsMax = Integer.valueOf(prop.getProperty("coupsMax"));
            nombreUtilises = new int[Integer.valueOf(prop.getProperty("couleurs"))];
            for (int i = 0; i < Integer.valueOf(prop.getProperty("couleurs")); i++) {
                nombreUtilises[i] = i;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        this.nomDuJeu = nomDuJeu;
        byte choix = 0;

        System.out.println(afficherNom());
        do {
            System.out.println("Game mode");

            System.out.println("1 - challenger");

            System.out.println("2 - défenseur");

            System.out.println("3 - duel");

            System.out.print("4 - quitter");

            Scanner sc = new Scanner(System.in);

            // Si l'entrée clavier n'est pas un byte
            if (!sc.hasNextByte()) {
                sc.next();
                continue;
            }
            choix = sc.nextByte();

            switch (choix) {

                case 1:
                    this.challenger();
                    System.out.println("Vous avez choisi comme mode de jeu : challenger");
                    break;

                case 2:
                    this.defenseur();
                    System.out.println("Vous avez choisi comme mode de jeu : défenseur");
                    break;

                case 3:
                    this.duel();
                    System.out.println("Vous avez choisi comme mode de jeu : duel");
                    break;

                case 4:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Vous n'avez choisi aucun mode de jeu parmi les choix proposés");
                    break;
            }
        } while (choix != 1 && choix != 2 && choix != 3 && choix != 4);
    }

    // Méthodes

    public void challenger() {

    }

    public void defenseur() {

    }

    public void duel() {

    }

    // Génération du nombre mystère
    public void genererNombreMystere() {
        nombreMystere = "";
        Random random = new Random();

        int chiffreNombreMystere[] = new int[longueurNombreMystere];

        for (int i = 0; i < longueurNombreMystere; i++) {// On génère un chiffre aléatoire jusqu'à atteindre la longueur
            // définie dans longueurNombreMystere
            chiffreNombreMystere[i] = random.nextInt(9 + 1);

            nombreMystere += chiffreNombreMystere[i];
        }
    }

    // Retourner le nom du jeu sélectionné
    public String afficherNom() {
        return this.nomDuJeu;
    }

    // Comparer la proposition du joueur au nombre mystère
    public void comparerNombres(Joueur joueur) {

        String sProposition = String.valueOf(Joueur.proposition);// On met la valeur de proposition dans un String
        resultat = "";

        for (int i = 0; i < longueurNombreMystere; i++) {
            int chiffrePropose = Character.getNumericValue(sProposition.charAt(i));
            int chiffreNombreMystere = Character.getNumericValue(nombreMystere.charAt(i));

            if (chiffrePropose > chiffreNombreMystere)
                resultat += "-";
            else if (chiffrePropose < chiffreNombreMystere)
                resultat += "+";
            else if (chiffrePropose == chiffreNombreMystere)
                resultat += "=";
        }
        System.out.println("Résultat : " + resultat + "\n\n--------\n");
    }

    public void finPartie(String vainqueur) {
        if (compteur >= coupsMax && !Joueur.proposition.equals(nombreMystere))
            System.out.println(
                    "Vous avez atteint la limite de coups (" + coupsMax + ") ! Le nombre mystère était : " + nombreMystere + ".");
        else
            System.out.println("Bravo ! " + vainqueur + " trouvé le nombre mystère en " + (compteur - 1) + " coups ! Le nombre mystère était : " + nombreMystere + "\n");
    }

    public void initCompteur() {
        compteur = 1;
    }

    public void afficherCompteur() {
        System.out.println("Coup n°" + (compteur));
    }

}
