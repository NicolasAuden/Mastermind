package main.java;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Menu {

    Properties prop = new Properties();
    InputStream input = null;

    /**
     * Display all games choices
     */
    public Menu() {

        byte choix = 0;

        System.out.println("-------------  Bienvenue dans l'application MasterMind !  -------------\n\n");
        System.out.println("Merci de sélectionner le jeu de votre choix. Have fun !\n");

        do {

            System.out.println("Choix jeu :");
            System.out.println("1 - Mastermind");
            System.out.println("2 - Recherche +/-");
            System.out.println("3 - Exit");
            System.out.println("À quel jeu souhaitez-vous jouer ?");

            Scanner sc = new Scanner(System.in);

            // Si l'entrée clavier n'est pas un byte
            if (!sc.hasNextByte()) {
                Erreur.erreurChoix();
                sc.next();
                continue;
            }
            choix = sc.nextByte();
            switch (choix) {

                /*case 1:
                    Mastermind mastermind = new Mastermind();// Mastermind
                    choix = 0;
                    System.out.println("Vous avez choisi comme jeu : Mastermind");
                    break;*/
                case 2:
                    PlusOuMoins plusOuMoins = new PlusOuMoins();
                    choix = 0;
                    System.out.println("Vous avez choisi comme jeu : Recherche +/-");
                    break;
                case 3:
                    System.out.println("À bientôt !");
                    break;
                default:
                    Erreur.erreurChoix();
                    System.out.println("Vous n'avez choisi aucun jeu parmi les choix proposés");
                    break;
            }
            }
            while (choix != 1 && choix != 2 && choix != 3 && choix != 4) ;
        }
    }

