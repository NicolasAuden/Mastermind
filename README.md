# Matermind
Projet du jeu Mastermind et d'un jeu de réflexion +/-


### Règles des jeux :

# Mastermind
Le but : découvrir la combinaison à x chiffres/couleurs de l'adversaire (le défenseur). Pour ce faire, l'attaquant fait une proposition. Le défenseur indique pour chaque proposition le nombre de chiffre de la proposition qui apparaissent à la bonne place et à la mauvaise place dans la combinaison secrète.

L'attaquant doit deviner la combinaison secrète en un nombre limité d'essais.

# Recherche +/-
Le but : découvrir la combinaison à x chiffres de l'adversaire (le défenseur). Pour ce faire, l'attaquant fait une proposition. Le défenseur indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c'est le bon chiffre (=).

L'attaquant doit deviner la combinaison secrète en un nombre limité d'essais.


### Pour chaque jeu, 3 Modes différents :

# Mode challenger :

Dans ce mode de jeu, c'est à vous de découvrir la combinaison secrète générée par le programme.

# Mode défenseur :

Dans ce mode de jeu, c'est à l'ordinateur de trouver la combinaison secrète que vous aurez choisie.

# Mode duel :

Dans ce mode de jeu, l'ordinateur et vous jouez tour à tour, après avoir l'un et l'autre décidé d'une combinaison secrète. Le premier à trouver la combinaison secrète de l'autre a gagné.


### Compilation du programme :

La compilation de l'application se réalise à partir le la classe Main située dans les dossiers src/main/java.


### Configuration du jeu :

Vous pouvez changer les paramètres du jeu (nombre d'essais, longueur du chiffre mystère, mode développeur) en modifiant le fichier config.properties situé à la racine du projet.


### Mode Développeur :
Il est possible de lancer l'application dans un mode "développeur". Dans ce mode la solution est affichée dès le début. Pour celà, modifier le fichier config.properties situé à la racine du projet, et passer le paramètre modeDeveloppeur de 0 à 1.

