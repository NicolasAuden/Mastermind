package com.nicolas.mastermind;

public class Mastermind extends MenuMode {

    public Mastermind() {
        super("\n*****MASTERMIND*****");
        longueurNombreMystere = Integer.valueOf(prop.getProperty("longueurMastermind"));
        coupsMax = Integer.valueOf(prop.getProperty("coupsMax"));
    }

}
