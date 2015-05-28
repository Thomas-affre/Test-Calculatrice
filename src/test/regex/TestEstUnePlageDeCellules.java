/*
 * TestEstUnePlageDeCellules.java				12 mai 2015
 * IUT INFO 2014-2015 
 */
package test.regex;

import java.util.regex.Pattern;

/** 
 * Test unitaire de la méthode estUnePlageDeCellule
 * @author Thomas Affre
 * @author Clément Zeghmati
 * @author Thibaut Méjane
 * @author Florian Louargant
 *
 */
public class TestEstUnePlageDeCellules {
    
    /** Regex représentant les coordonnées d'une cellule sans blocage */
    public static final String REGEX_CELLULE = 
            "[A-Z]{1}(([1-9])|(1[0-9]{1})|20)";
    
    /** Regex représentant une plage de cellules */
    public static final String REGEX_PLAGE_CELLULES = 
            REGEX_CELLULE +  "\\.\\." + REGEX_CELLULE;
    
    /**
     * Contrôle si une chaine de caractères est une plage de cellules
     * @param aTester Chaine à tester
     * @return true si la chaine est une plage de cellules, false sinon
     */
    private static boolean estUnePlageDeCellules(String aTester) {
        return Pattern.compile(REGEX_PLAGE_CELLULES).matcher(aTester).matches();
    }

    /**
     * Test des chaines de 6 caractères représentant des éventuelles plages
     * de cellule
     * @param args unused
     */
    public static void main(String[] args) {
        
        String[] chaineCorrecte = {
                "A1..E5" , "G10..R10" , "Z1..Z20" , "A1..A1" 
        };

        String[] chaineIncorrecte = {
                "A..E" , "A0..T1" , "A200..B31" , "P21..P21"
        };
        
        // Test avec des chaines correcte
        System.out.println("\nChaines correctes :\n");
        for(int i = 0 ; i < chaineCorrecte.length ; i++){
            System.out.println(chaineCorrecte[i] + "\t|\t" 
                    + estUnePlageDeCellules(chaineCorrecte[i]));
        }

        // Test avec des chaines incorrecte
        System.out.println("\nChaines incorrectes :\n");
        for(int i = 0 ; i < chaineIncorrecte.length ; i++){
            System.out.println(chaineIncorrecte[i] + "\t|\t" 
                    + estUnePlageDeCellules(chaineIncorrecte[i]));
        }

    }

}
