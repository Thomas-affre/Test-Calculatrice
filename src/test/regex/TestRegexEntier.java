/*
 * TestRegexEntier.java								28 avr. 2015
 * IUT INFO 2014-2015 
 */
package test.regex;

import java.util.regex.Pattern;



/** 
 * Test unitaire pour la REGEX_ENTIER
 * @author thomas.affre
 *
 */
public class TestRegexEntier {

    /** Regex d'un int */
    public static final String REGEX_ENTIER =
            "(\\-{0,1})([0-9]+)(\\.[0]+){0,1}";

    /**
     * Teste si une chaine de caractère est un entier
     * @param aTester Chaine à tester
     * @return true s'il s'agit d'un entier, false sinon
     */
    public static boolean estUnEntier(String aTester) {
        return Pattern.compile(REGEX_ENTIER).matcher(aTester).matches();
    }

    /**
     * TODO commenter le role de la methode
     * @param args unused
     */
    public static void main(String[] args) {

        String[] chaineCorrecte = {
                "0" , "1" , "20.0" , "642" , "5157064" ,
                "-1" , "-50" , "-254020" , "30" , "9999999"
        };

        String[] chaineIncorrecte = {
                "0.5" , "deux" , " 1" , "1 " , "1 0" ,
                "- 1" , "-." , " " , "30..2" , "OUI", 
                "50.4004" , "1,2" , "5.", ""
        };
        
        // Test avec des chaines correcte
        System.out.println("\nChaine correcte:\n");
        for(int i = 0 ; i < chaineCorrecte.length ; i++){
            System.out.println(chaineCorrecte[i] + "\t|\t" 
                    + estUnEntier(chaineCorrecte[i]));
        }

        // Test avec des chaines incorrecte
        System.out.println("\nChaine incorrecte:\n");
        for(int i = 0 ; i < chaineIncorrecte.length ; i++){
            System.out.println(chaineIncorrecte[i] + "\t|\t" 
                    + estUnEntier(chaineIncorrecte[i]));
        }


    }
}
