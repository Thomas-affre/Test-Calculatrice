/* 
 * TestRegexZoneMem.java                            29 avr. 2015
 * IUT info1 Groupe 3 2014-2015
 */
package test.regex;

import java.util.regex.Pattern;

/**
 * Test unitaire pour la REGEX_ZONE_MEMOIRE
 * @author Thomas Affre
 * @version 0.1
 */
public class TestRegexZoneMem{

    /** Regex représentant une zone mémoire */
    public static final String REGEX_ZONE_MEMOIRE = "[A-Z]{1}";

    /**
     * TODO commenter le role de la methode
     * @param aTester
     * @return true
     */
    public static boolean estUneMemoire(String aTester) {
        return Pattern.compile(REGEX_ZONE_MEMOIRE).matcher(aTester).matches();
    }

    /**
     * TODO commenter le role de la methode
     * @param args
     */
    public static void main(String[] args) {

        String[] chaineCorrecte = {
                "A" , "G" , "Z" , "P" 
        };

        String[] chaineIncorrecte = {
                "AE" , "A0" , "A200" , "P21"
        };

        // Test avec des chaines correcte
        System.out.println("\nChaines correctes :\n");
        for(int i = 0 ; i < chaineCorrecte.length ; i++){
            System.out.println(chaineCorrecte[i] + "\t|\t" 
                    + estUneMemoire(chaineCorrecte[i]));
        }

        // Test avec des chaines incorrecte
        System.out.println("\nChaines incorrectes :\n");
        for(int i = 0 ; i < chaineIncorrecte.length ; i++){
            System.out.println(chaineIncorrecte[i] + "\t|\t" 
                    + estUneMemoire(chaineIncorrecte[i]));
        }

    }
}
