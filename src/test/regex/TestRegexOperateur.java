/*
 * TestRegexEntier.java								28 avr. 2015
 * IUT INFO 2014-2015 
 */
package test.regex;

import java.util.regex.Pattern;



/** 
 * Test unitaire pour la REGEX_OPERATEUR
 * @author Thomas Affre
 * @author Cl�ment Zeghmati
 * @author Thibaut M�jane
 * @author Florian Louargant
 *
 */
public class TestRegexOperateur {

    /** Regex d'un op�rateur */
    public static final String REGEX_OPERATEUR = "[+*/-]{1}";

    /**
     * V�rifie si une chaine est un op�rateur
     * @param aTester Chaine � tester
     * @return true si aTester est un op�rateur, false sinon
     */
    public static boolean estUnOperateur(String aTester) {
        return Pattern.compile(REGEX_OPERATEUR).matcher(aTester).matches();        
    }

    /**
     * Test plusieurs chaines de caract�res
     * @param args unused
     */
    public static void main(String[] args) {

        String[] chaineCorrecte = {
                "+" , "-" , "*" , "/"
        };

        String[] chaineIncorrecte = {
                "deux" , "plus" , "564" ,
                "-+" , "" , "- 1.0" , "-." ,
                " " 
        };

        // Test avec des chaines correcte
        System.out.println("\nChaine correcte:\n");
        for(int i = 0 ; i < chaineCorrecte.length ; i++){
            System.out.println(chaineCorrecte[i] + "\t|\t" 
                    + estUnOperateur(chaineCorrecte[i]));
        }

        // Test avec des chaines incorrecte
        System.out.println("\nChaine incorrecte:\n");
        for(int i = 0 ; i < chaineIncorrecte.length ; i++){
            System.out.println(chaineIncorrecte[i] + "\t|\t" 
                    + estUnOperateur(chaineIncorrecte[i]));
        }


    }
}
