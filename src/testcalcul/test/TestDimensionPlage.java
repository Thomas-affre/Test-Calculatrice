/*
 * TestDimensionPlage.java								27 mai 2015
 * IUT INFO 2014-2015 
 */
package testcalcul.test;

import java.util.Arrays;

/** 
 * TODO commenter la responsabilité de la classe
 * @author thomas.affre
 *
 */
public class TestDimensionPlage {
    
    /**
     * Calcule la dimension d'une plage de cellule CORRECTE
     * @param plageCellules Plage à tester
     * @return dimension dans un tableau
     *          0 : longueur
     *          1 : hauteur
     */
    private static int[] dimensionPlage(int[][] plageCellules) {
        return new int[]{
                plageCellules[1][1] - plageCellules[0][1] + 1,
                plageCellules[1][0] - plageCellules[0][0] + 1
        };
    }

    /**
     * TODO commenter le role de la methode
     * @param args
     */
    public static void main(String[] args) {
        
        int[][] resultat;
        
        int[][][] correcte = {{{0,0},{19,25}},{{8,5},{12,10}}};
        
        System.out.println("\nChaines correctes :\n\n"
                           +"    Plages\t\t Dimension");
        for( int i = 0 ; i < correcte.length ; i++ ){
            
            resultat = new int [][]{dimensionPlage(correcte[i])};
           
            System.out.println( Arrays.toString(correcte[i][0]) + "\t" 
                    + Arrays.toString(correcte[i][1]) + "\t" 
                    + Arrays.toString(resultat[0]));

        }

    }

}
