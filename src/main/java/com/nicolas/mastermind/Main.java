package com.nicolas.mastermind;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

    private static Logger log = LogManager.getLogger(Main.class.getName());
    public static int modDev;
    public static boolean argument;

    public static void main(String[] args) {

        log.info("Le jeu est lancé !");

        Properties prop = new Properties();
        InputStream input = null;
        OutputStream output = null;

        try {

            input = new FileInputStream("config.properties");

            // Chargement du fichier de configuration
            prop.load(input);
            log.info("Chargement du fichier config.properties");
        } catch (IOException ex) {
            try {
                // En cas d'erreur, on créé un nouveau fichier config
                output = new FileOutputStream("config.properties");
                log.error("Fichier de configuration non trouvé");

                // Valeurs par défaut
                prop.setProperty("longueurPlusOuMoins", "2");
                prop.setProperty("longueurMastermind", "2");
                prop.setProperty("couleurs", "10");
                prop.setProperty("coupsMax", "15");
                prop.setProperty("modeDeveloppeur", "0");
                log.info("Fichier configuration par défaut créé");
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

        if (args.length > 0)
            modDev = Integer.parseInt(args[0]);
        else
            modDev = Integer.valueOf(prop.getProperty("modeDeveloppeur"));

        // On lance le menu pour choisir le jeu
        Menu menu = new Menu();
    }
}
