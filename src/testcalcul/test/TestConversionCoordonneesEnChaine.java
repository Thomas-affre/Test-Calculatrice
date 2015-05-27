/*
 * TestConversionCoordonneesEnChaine.java								19 mai 2015
 * IUT INFO 2014-2015 
 */
package testcalcul.test;

import java.util.Arrays;

/** 
 * TODO commenter la responsabilit� de la classe
 * @author thomas.Affre
 *
 */
public class TestConversionCoordonneesEnChaine {

    /**
     * Convertit les coordonn�es d'une cellule en chaine de caract�res
     * @param coordonnees Coordonn�es de la cellule � convertir
     * @return Chaine de caract�re repr�sentant la cellule (ex : A1)
     */
    public static String conversionCoordonneesEnChaine(int[] coordonnees) {
        StringBuilder aRetourner = new StringBuilder("");

        // La lettre
        aRetourner.append(new Character((char) (coordonnees[1] + 65)).
                toString());

        // Le chiffre
        aRetourner.append(Integer.toString(coordonnees[0] + 1));

        return aRetourner.toString();
    }

    /**
     * TODO commenter le role de la methode
     * @param args
     */
    public static void main(String[] args) {

        int[][] Coordonn�e = { {00,00},{19,25},{8,05},{12,10}};

        String[] correcte = { "A1" , "Z20" , "F9" , "K13"};
        
        String[] incorrecte = { "B1" , "Z19" , "H5" , "K3"};

        //Chaine Correcte
        System.out.println("\nChaines correctes :\n");
        for(int i = 0 ; i < correcte.length ; i++ ){
            System.out.println(Arrays.toString(Coordonn�e[i]) + "\t" 
                    + conversionCoordonneesEnChaine(Coordonn�e[i])+ "\t" 
            + conversionCoordonneesEnChaine(Coordonn�e[i]).equals(correcte[i]));
        }

        //Chaine Correcte
        System.out.println("\nChaines incorrectes :\n");
        for(int i = 0 ; i < incorrecte.length ; i++ ){
            System.out.println(Arrays.toString(Coordonn�e[i]) + "\t" 
                    + conversionCoordonneesEnChaine(Coordonn�e[i]) + "\t"
            + conversionCoordonneesEnChaine(Coordonn�e[i]).equals(incorrecte[i]));
        }

    }

}
