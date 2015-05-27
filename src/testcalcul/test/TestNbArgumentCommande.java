/*
 * TestNbArgumentCommande.java								12 mai 2015
 * IUT INFO 2014-2015 
 */
package testcalcul.test;

/** 
 * Test unitaire de la méthode nbArgumentCommande
 * @author thomas.affre
 *
 */
public class TestNbArgumentCommande {
    
    /**
     * @param instructions 
     * @return Chaine de caractères représenatnt le nombre d'arguments
     *          attendus pour la commande saisie par l'utilisateur
     */
    public static String nbArgumentsCommande(String instructions) {

        switch (instructions.toString()) {
        case "CONT" :
        case "RAZ" :
            // La commande et la plage (facultatif) 
            return "0 ou 1";
        case "INIT" :       
            // La commande, la plage (facultatif) et la valeur
            return "1 ou 2";
        case "FORM" :
            // La commande et la plage
            return "1";
        case "COPIER" :
        case "COPVAL" :
            // La commande et deux plages
            return "2";
        }
        throw new IllegalArgumentException("Passage impossible");
    }

    /**
     * TODO commenter le role de la methode
     * @param args
     */
    public static void main(String[] args) {

        String[] correcte = { "CONT" , "RAZ" , "INIT" , "FORM" , "COPIER" , "COPVAL" };

        String[] incorrecte = { "raz" , "546" , "()" , "" , "A" , " " };
        
        //Chaine Correcte
        System.out.println("\nChaines correctes :\n");
        for(int i = 0 ; i < correcte.length ; i++ ){
             System.out.println(correcte[i] + "\t" 
                         + nbArgumentsCommande(correcte[i]));
        }
        
        //Chaine Correcte
        System.out.println("\nChaines incorrectes :\n");
        for(int i = 0 ; i < incorrecte.length ; i++ ){
             System.out.println(incorrecte[i] + "\t" 
                         + nbArgumentsCommande(incorrecte[i]));
        }

    }

}
