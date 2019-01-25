package main.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class Main {

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;
        OutputStream output = null;

        try {

            input = new FileInputStream("config.properties");

            // Chargement du fichier config
            prop.load(input);
        } catch (IOException ex) {
            try {
                // En cas d'erreur, on créé un nouveau fichier config
                output = new FileOutputStream("config.properties");

                // Valeurs par défaut
                prop.setProperty("longueurPlusOuMoins", "5");
                prop.setProperty("couleurs", "10");
                prop.setProperty("coupsMax", "15");
                // Config sauvegardée à la racine du projet
                prop.store(output, null);

            } catch (IOException io) {
                io.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (input != null) {
                            try {
                                input.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        // On lance le menu pour choisir le jeu
        Menu menu = new Menu();
    }
}
