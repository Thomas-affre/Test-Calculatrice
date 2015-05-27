/*
 * TestEstUnCaractère.java								12 mai 2015
 * IUT INFO 2014-2015 
 */
package testcalcul.test;

import minicalcul.programme.commandes.ConsoleCalculSimple;

/** 
 * Test unitaire pour la méthode estUnCaractère
 * @author thomas.affre
 *
 */
public class TestEstUnCaractère {

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
     * TODO commenter le role de la methode
     * @param args
     */
    public static void main(String[] args){
        String[] correcte = { "(" , ")" , "+" , "=" , "-" , "/" , "*" };

        String[] incorrecte = { "" , " " , "()" , "845" , "A" , "+ " };

        System.out.println("\nChaines correctes :\n");
        for( int i = 0 ; i < correcte.length ; i++ ){

            System.out.println( correcte[i] + "\t" 
                    + estUnCaractereValide(correcte[i]));

        }
        
        System.out.println("\nChaines incorrectes :\n");
        for( int i = 0 ; i < incorrecte.length ; i++ ){

            System.out.println( incorrecte[i] + "\t" 
                    + estUnCaractereValide(incorrecte[i]));

        }
    }

}
