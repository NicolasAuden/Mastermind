package main.java;

public abstract class Error {


    // Message affiché si une entrée clavier ne correspond à aucun choix proposé
    public static void errorChoix() {
        System.out.println("\nVeuillez choisir parmi les propositions.");
    }

    public static void errorNombre() {
        System.out.println("\nVeuillez entrer un nombre à " + MenuMode.longueurNombreMystere + " chiffres.");
    }
}

