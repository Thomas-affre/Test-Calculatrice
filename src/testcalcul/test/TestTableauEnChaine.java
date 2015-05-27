/*
 * TestTableauEnChaine.java								27 mai 2015
 * IUT INFO 2014-2015 
 */
package testcalcul.test;

import java.util.Arrays;

/** 
 * TODO commenter la responsabilit� de la classe
 * @author thomas.affre
 *
 */
public class TestTableauEnChaine {
    
    /**
     * Convertit un tableau de cha�ne de caract�res en cha�ne de caract�res o�
     * chaque �l�ment est s�par� par un espace
     * @param formule Tableau contenant la formule
     * @return formule en cha�ne de caract�re
     */
    private static String tableauEnChaine(String[] formule) {
        StringBuilder aRetourner = new StringBuilder();
        
        for (int i = 0; i < formule.length; i++) {
            aRetourner.append(formule[i] + " ");
        }
        return aRetourner.toString();
    }


    /**
     * TODO commenter le role de la methode
     * @param args
     */
    public static void main(String[] args) {
        
        String[][] aTester = {{"INIT","A2","10"},{"FORM","A1"},
                              {"9","+","8","/","(","9 ","-","15",")"}};
        
     // Test avec des chaines incorrecte
        System.out.println("\n\n");
        for(int i = 0 ; i < aTester.length ; i++){
            System.out.println(Arrays.toString(aTester[i]) + "\t|\t" 
                    + tableauEnChaine(aTester[i]));
        }

    }

}
