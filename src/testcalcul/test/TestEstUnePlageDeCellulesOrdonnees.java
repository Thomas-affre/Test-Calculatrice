/*
 * TestEstUnePlageDeCellulesOrdonnees.java								12 mai 2015
 * IUT INFO 2014-2015 
 */
package testcalcul.test;

import java.util.regex.Pattern;


/** 
 * TODO commenter la responsabilit� de la classe
 * @author thomas.affre
 *
 */
public class TestEstUnePlageDeCellulesOrdonnees {
    
    /** Regex repr�sentant les coordonn�es d'une cellule sans blocage */
    public static final String REGEX_CELLULE = 
            "[A-Z]{1}(([1-9])|(1[0-9]{1})|20)";
    
    /** Regex repr�sentant une plage de cellules */
    public static final String REGEX_PLAGE_CELLULES = 
            REGEX_CELLULE +  "\\.\\." + REGEX_CELLULE;
    
    /**
     * Contr�le si une chaine de caract�res est une plage de cellules
     * @param aTester Chaine � tester
     * @return true si la chaine est une plage de cellules, false sinon
     */
    private static boolean estUnePlageDeCellules(String aTester) {
        return Pattern.compile(REGEX_PLAGE_CELLULES).matcher(aTester).matches();
    }
    
    /**
     * Convertit une cellule sous la forme de chaine de caract�re (ex : A1) en
     * coordonn�es du tableur (ex : A1 --> [0,0] et Z20 --> [19,25]) 
     * @param aConvertir Chaine � convertir
     * @return Tableau de coordonn�es de la cellule
     */
    public static int[] conversionChaineEnCoordonnees(String aConvertir) {
        
        int[] aRetourner = new int[2];
        
        // On r�cup�re l'indice du chiffre et on enleve 1
        aRetourner[0] = (aConvertir.length() == 2 
                ? Integer.parseInt(aConvertir.substring(1, 2))
                : Integer.parseInt(aConvertir.substring(1, 3))) - 1;  
        
        // On recupere l'indice correspondant � la lettre A=65..Z=90
        aRetourner[1] = new Character(aConvertir.charAt(0)).hashCode() - 65;
        
        return aRetourner;
    }
    
    /**
     * R�cup�re les coordonn�es d'une plage de cellules correcte
     * @param plage de cellule � convertir
     * @return tableau repr�sentant les coordon�es (0 : d�but, 1 : fin)
     */
    public static int[][] coordonneesPlageCorrecte(String plage) {
        int[][] aRetourner = new int[2][];
        
        // On d�coupe la plage
        String[] coordonnes = plage.split("\\."); // resultat : [debut, , fin]
        
        aRetourner[0] = conversionChaineEnCoordonnees(coordonnes[0]); // debut
        aRetourner[1] = conversionChaineEnCoordonnees(coordonnes[2]); // fin
        
        return aRetourner;
    }
    
    /**
     * Contr�le si une chaine de caract�res est une plage de cellules ordonn�es
     * @param aTester Chaine � tester
     * @return true si la chaine est une plage de cellules, false sinon
     */
    public static boolean estUnePlageDeCellulesOrdonnees(String aTester) {
        
        if (estUnePlageDeCellules(aTester)) {
            int[][] coordonnees = coordonneesPlageCorrecte(aTester);
            
            return (coordonnees[0][0] < coordonnees[1][0]
                    || (coordonnees[0][0] == coordonnees[1][0]
                            && coordonnees[0][1] < coordonnees[1][1]));
        }
        return false;
    }

    /**
     * TODO commenter le role de la methode
     * @param args
     */
    public static void main(String[] args) {
        
        String[] chaineCorrecte = {
                "A1..E5" , "G10..R10" , "Z1..I20" , "A1..A1" 
        };

        String[] chaineIncorrecte = {
                "A20..E15" , "Z15..T10" , "A2..B1" , "P20..P1"
        };
        
        // Test avec des chaines correcte
        System.out.println("\nChaines correctes :\n");
        for(int i = 0 ; i < chaineCorrecte.length ; i++){
            System.out.println(chaineCorrecte[i] + "\t|\t" 
                    + estUnePlageDeCellulesOrdonnees(chaineCorrecte[i]));
        }

        // Test avec des chaines incorrecte
        System.out.println("\nChaines incorrectes :\n");
        for(int i = 0 ; i < chaineIncorrecte.length ; i++){
            System.out.println(chaineIncorrecte[i] + "\t|\t" 
                    + estUnePlageDeCellulesOrdonnees(chaineIncorrecte[i]));
        }

    }

}
