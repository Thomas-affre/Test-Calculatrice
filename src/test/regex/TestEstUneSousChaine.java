/*
 * TestEstUneSousChaine.java								27 mai 2015
 * IUT INFO 2014-2015 
 */
package test.regex;

import java.util.regex.Pattern;

import minicalcul.programme.commandes.ConsoleCalculSimple;

/** 
 * Test unitaire de la méthode estUneSousChaine
 * @author Thomas Affre
 * @author Clément Zeghmati
 * @author Thibaut Méjane
 * @author Florian Louargant
 *
 */
public class TestEstUneSousChaine {

    /** Regex d'un réel */
    public static final String REGEX_DOUBLE = 
            "(\\-{0,1})([0-9]{1,13})(\\.[0-9]+)?";

    /**
     * Teste si une chaine de caractère est un réel
     * @param aTester Chaine à tester
     * @return true s'il s'agit d'un entier, false sinon
     */
    public static boolean estUnDouble(String aTester) {
        return Pattern.compile(REGEX_DOUBLE).matcher(aTester).matches();
    }

    /** Regex représentant une zone mémoire */
    public static final String REGEX_ZONE_MEMOIRE = "[A-Z]{1}";

    /**
     * Teste si une chaine de caractères correspond à une mémoire existante et 
     * acceptée par la console
     * @param aTester Chaine à tester
     * @return true s'il s'agit d'une mémoire acceptée par la console,
     *         false sinon
     */
    public static boolean estUneMemoire(String aTester) {
        return Pattern.compile(REGEX_ZONE_MEMOIRE).matcher(aTester).matches();
    }
    
    /**
     * Teste si une chaine de caractère est un caractère valide, c'est-à-dire
     * ( ) + - * / =
     * @param aTester Chaine à tester
     * @return true si la chaine correspond à un caractère spécial d'une 
     *         opération, false sinon          
     */
    public static boolean estUnCaractereValide(String aTester) {

        return aTester.length() == 1 &&
                (aTester.charAt(0) == '('
                || aTester.charAt(0) == ')'
                || aTester.charAt(0) == '='
                || ConsoleCalculSimple.estUnOperateur(aTester));
    }

    /**
     * Teste si une chaîne est un élément d'une opération (réel, opérateur,
     * mémoire ou parenthèse)
     * @param aTester Chaîne à tester
     * @return true s'il s'agit d'un élément, false sinon
     */
    public static boolean estUneSousChaine(String aTester) {
        return (estUnDouble(aTester)
                || estUnCaractereValide(aTester)
                || estUneMemoire(aTester));
    }
    


    /**
     * Teste plusieurs chaine de un ou plusieurs caractère 
     * @param args unused
     */
    public static void main(String[] args) {
        String[] correcte = { "(" , ")" , "+" , "=" , "-" , "/" , "*"  ,
                              "0.0" , "1.52" , "20.0" , "642" , "5157064",
                              "A" , "G" , "Z" , "P" };

        String[] incorrecte = { "" , " " , "()" , "87 54" , "AE" , "+ ",
                                "deux" , " 1" , "1 " , "1 0" ,
                                "- 1" , "-." , " " , "30..2" };

        System.out.println("\nChaines correctes :\n");
        for( int i = 0 ; i < correcte.length ; i++ ){

            System.out.println( correcte[i] + "\t" 
                    + estUneSousChaine(correcte[i]));

        }
        
        System.out.println("\nChaines incorrectes :\n");
        for( int i = 0 ; i < incorrecte.length ; i++ ){

            System.out.println( incorrecte[i] + "\t" 
                    + estUneSousChaine(incorrecte[i]));

        }

    }

}
