package main.java;

import java.util.Scanner;

public class Menu {

    /**
     * Display all games choices
     */
    public void displayAvailableGame() {
        System.out.println("Choix jeu");
        System.out.println("1 - Mastermind");
        System.out.println("2 - Recherche +/-");
        System.out.println("À quel jeu souhaitez-vous jouer ?");
    }

    /**
     * Display a game selected
     * @param nbGame The selected game
     */
    public void displaySelectedGame (int nbGame) {
        switch (nbGame) {
            case 1:
                System.out.println("Vous avez choisi comme jeu : Mastermind");
                break;
            case 2:
                System.out.println("Vous avez choisi comme jeu : Recheche +/-");
                break;
                default:
                    System.out.println("Vous n'avez choisi aucun jeu parmi les choix proposés");
                    break;
        }
    }

    /**
     * Run asking process for a game
     */
    public void runGame () {
        this.displayAvailableGame();
        Scanner sc = new Scanner(System.in);
        int nbGame = sc.nextInt();
        this.displaySelectedGame(nbGame);
        switch (nbGame) {
            case 1:
                displayAvailableSide(true);
                int nbSide = sc.nextInt();
                displaySelectedSide(nbSide, true);
                break;
            case 2:
                displayAvailableSide(true);
                nbSide = sc.nextInt();
                displaySelectedSide(nbSide, true);
                break;
            case 3:
                displayAvailableSide(false);
                nbSide = sc.nextInt();
                displaySelectedSide(nbSide, false);
                break;
        }
    }

    /**
     * Display all avalaible sides depending on all sides enable or not
     * All sides = challenger, défenseur and duel
     * No all sides = challenger or duel for example
     * @param allSideEnable enable display for all side or not
     */
    public void displayAvailableSide (boolean allSideEnable) {
        System.out.println("Choix du mode de jeu");
        if (allSideEnable) {
            System.out.println("1 - challenger");
            System.out.println("2 - défenseur");
            System.out.println("3 - duel");
        } else {
            System.out.println("1 - Vous n'avez choisi aucun jeu parmi les choix proposés");
        }
        System.out.println("Quel mode de jeu souhaitez-vous sélectionner ?");
    }

    /**
     * Display a selected side depending on all sides enable or not
     * All sides = challenger, défenseur and duel
     * No all sides = challenger or duel for example
     * @param nbSide the selected Side
     * @param allSidesEnable enable display for all side or not
     */
    public void displaySelectedSide (int nbSide, boolean allSidesEnable) {
        if (allSidesEnable) {
            switch (nbSide) {
                case 1:
                    System.out.println("Vous avez choisi comme mode de jeu : challenger");
                    break;
                case 2:
                    System.out.println("Vous avez choisi comme mode de jeu : défenseur");
                    break;
                case 3:
                    System.out.println("Vous avez choisi comme mode de jeu : duel");
                    break;
                    default:
                        System.out.println("Vous n'avez choisi aucun mode de jeu parmi les choix proposés");
                        break;
            }
        }
    }

}
