package com.nicolas.mastermind;

import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Mastermind extends MenuMode {

    private static Logger log = LogManager.getLogger(Main.class.getName());

    HashSet liste; // Set qui contiendra toutes les solutions possibles sans doublon
    byte bienPlaces = 0;
    byte presents = 0;
    int resultatOK = 0;
    int resultatNOK = 0;
    ArrayList aListe; // ArrayList identique à HashSet liste, mais plus modulable pour supprimer les propositions erronées en cours de partie

    public Mastermind() {
        super("\n*****MASTERMIND*****");
        log.info("Mastermind lancé");
        longueurNombreMystere = Integer.valueOf(prop.getProperty("longueurMastermind"));
        coupsMax = Integer.valueOf(prop.getProperty("coupsMax"));
        log.info("Longueur du nombre mystère et nombre de coups max autorisés chargés depuis config.properties");
    }

    public void challenger() {
        log.info("Mode challenger lancé");
        System.out.println("********MODE CHALLENGER********");
        initCompteur();
        genererListeSolutions();
        genererNombreMystere();
        joueur1 = new Humain();
        log.info("Joueur 1 défini comme humain");
        // On boucle tant que le nombre myst�re n'est pas trouv�
        do {
            devMode();
            resetIndices();
            afficherCompteur();
            joueur1.proposerNombre();
            comparerNombres(joueur1);
            afficherResultat();
            compteur++;
        } while (bienPlaces < nombreMystere.length()&& compteur < coupsMax + 1);
        finPartie("Vous avez");
    }


    public void genererListeSolutions() {

        liste = new HashSet();
        int maximumPossible;

        maximumPossible = nombreUtilises.length - 1;// On récupère le nombre maximum à être utilisé dans nombreUtilises

        Random random = new Random();

        int chiffreNombreMystere[] = new int[longueurNombreMystere];

        do {
            for (int i = 0; i < longueurNombreMystere; i++) {// On génère un chiffre aléatoire jusqu'à atteindre la longueur
                // définie dans longueurNombreMystere
                chiffreNombreMystere[i] = random.nextInt(maximumPossible + 1);

                nombreMystere += chiffreNombreMystere[i];
            }
            liste.add(nombreMystere);
            nombreMystere = "";
        } while (liste.size() < Math.pow(nombreUtilises.length, longueurNombreMystere));// Tant que liste ne contient pas
        // toutes les solutions possibles
        // (nombre de chiffres puissance
        // longueur du nombre)

        aListe = new ArrayList(liste);
        log.info("Liste des solutions possibles générée");
    }

    public void comparerNombres(Joueur joueur) {

        String sProposition = String.valueOf(joueur.proposition);// On met la valeur de proposition dans un String

        for (int i = 0; i < longueurNombreMystere; i++) {
            int chiffrePropose = Character.getNumericValue(sProposition.charAt(i));
            int chiffreNombreMystere = Character.getNumericValue(nombreMystere.charAt(i));

            if (chiffrePropose == chiffreNombreMystere)
                bienPlaces++;
            else if (nombreMystere.contains(String.valueOf(chiffrePropose)))
                presents++;
            else
                ;
        }
        log.info("Comparaison de la proposition de "+joueur+" ("+joueur.proposition+") avec le nombre mystère ("+nombreMystere+")");
    }

    public void afficherResultat() {
        if (presents >= nombreMystere.length())
            presents -= bienPlaces;
        if (presents < 0)
            presents = 0;
        if (bienPlaces == nombreMystere.length())
            presents = 0;
        System.out.println(presents + " présents et " + bienPlaces + " bien placé.\n\n--------\n");
        log.info(presents + " présents et " +bienPlaces+ " bien placés");
        if (bienPlaces == nombreMystere.length() && bienPlaces > 1)
            System.out.println(presents + " présents et " + bienPlaces + " bien placés.\n\n--------\n");

    }

    public void genererNombreMystere() {
        Random random = new Random();
        int index = random.nextInt(aListe.size());
        nombreMystere = (String) aListe.get(index);
        log.info("Nombre mystère choisi parmi la liste de solutions");
    }

    public void resetIndices() {
        presents = 0;
        bienPlaces = 0;
        log.info("Indices remis à zéro");
    }

    public void clean() { // Cette méthode élimine de la liste toutes les combinaisons qui ne correspondent pas à la proposition de l'ordinateur
        aListe.remove(Joueur.proposition);

        for (int i = 0; i < aListe.size(); i++) {// Tant que la liste complète n'est pas parcourue

            String sNombre = String.valueOf(aListe.get(i));

            for (int n = 0; n < longueurNombreMystere; n++) {
                int chiffreNombreMystere = Character.getNumericValue(nombreMystere.charAt(n));
                int chiffreSolutionPotentielle = Character.getNumericValue(sNombre.charAt(n));

                if (chiffreSolutionPotentielle == chiffreNombreMystere)
                    bienPlaces++;
                else if (nombreMystere.contains(String.valueOf(chiffreSolutionPotentielle)))
                    presents++;
                else
                    ;
            }
            if (bienPlaces <= resultatOK) {
                aListe.remove(aListe.get(i));
                resetIndices();
                if (!aListe.contains(nombreMystere))
                    aListe.add(nombreMystere);
            }

            else
                resetIndices();
        }
        log.info("Combinaisons erronées retirées de la liste de solutions");
    }

    public void enregistrerResultat() {
        resultatOK = bienPlaces;
        resultatNOK = presents;
    }
}

