package main.java;

import java.util.Scanner;

public class Humain extends Joueur {


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
    }
}